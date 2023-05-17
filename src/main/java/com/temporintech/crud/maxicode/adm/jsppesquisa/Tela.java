package com.temporintech.crud.maxicode.adm.jsppesquisa;

import com.temporintech.crud.maxicode.business.crud.categoria.Categoria;
import com.temporintech.crud.maxicode.business.crud.fornecedor.Fornecedor;
import com.temporintech.crud.maxicode.business.crud.produto.Produto;

import br.com.maxicode.db.IRecordSet;
import br.com.maxicode.html.Folder;
import br.com.maxicode.log.LogExecucaoSistema;
import br.com.maxicode.util.Funcoes;
import br.com.visualmix.generico.forms.frmMsgBox;

//Classe de Manipula��o da tela de produtos
public class Tela extends Folder {

	private Produto objProduto;
	private IRecordSet rst;

	private BdyTela tela = new BdyTela();
	private frmMsgBox msgBox = new frmMsgBox();

	String[] dtgHeader = { "C�digo", "Produto", "Descri��o", "Pre�o", "Quantidade", "Categoria", "Fornecedor", "Origem",
			"Contato" };

	public Tela() {

		LogExecucaoSistema l = new LogExecucaoSistema("ConferenciaCaixa",
				Funcoes.getParametro("GERAL.PATHCENTRAL", "C") + "\\Vmix\\log\\ConferenciaCaixa", "conferencia", true);
		br.com.maxicode.log.GravaLogExecucao.parametrizaLog(l);

		setTitle("CRUD Produto");
		additem(tela);
		additem(msgBox);
		Show(0);
	}

	@Override
	public void Initialize() {
		super.Show(0);
		objProduto = new Produto(getConexao());
		new Categoria(getConexao());
		new Fornecedor(getConexao());
		setarEventos();
		carregarDataGridProduto();
	}

	private void setarEventos() {
		// Inicializa Eventos
		tela.pressEnter.setServer("Pesquisar");
		tela.itmEncerrar.onclick.setServer("logout");
		tela.dtgPesquisa.onclick.setServer("EditarData");
		tela.itmCrud.onclick.setServer("chamaCrud");

	}

	// Funçãoo para carregar os dados no DataGrid Produto
	public void carregarDataGridProduto() {

		rst = objProduto.getAllProdutos();

		tela.dtgPesquisa.clear();
		tela.dtgPesquisa.lines.clear();

		for (int x = 0; x < dtgHeader.length; x++) {
			if(dtgHeader.equals("C�digo")) 
				tela.dtgPesquisa.header.selectedcolumn.minwidth = "52px";
			else if(dtgHeader.equals("Descri��o")) 
				tela.dtgPesquisa.header.selectedcolumn.minwidth = "160px";
			else {
				tela.dtgPesquisa.header.addcolumn(dtgHeader[x], 1, 1);
				tela.dtgPesquisa.header.selectedcolumn.tag = dtgHeader[x];
				tela.dtgPesquisa.header.selectedcolumn.minwidth = "140px";
			}
		}

		while (rst.next()) {
			tela.dtgPesquisa.addline();
			tela.dtgPesquisa.selectedline.values[0] = String.valueOf(rst.getInt("ID"));
			tela.dtgPesquisa.selectedline.values[1] = rst.getString("NOME_PRODUTO");
			tela.dtgPesquisa.selectedline.values[2] = rst.getString("DESCRICAO");
			tela.dtgPesquisa.selectedline.values[3] = String.valueOf(rst.getDouble("PRECO"));
			tela.dtgPesquisa.selectedline.values[4] = String.valueOf(rst.getInt("QUANTIDADE"));
			tela.dtgPesquisa.selectedline.values[5] = rst.getString("CATEGORIA");
			tela.dtgPesquisa.selectedline.values[6] = rst.getString("NOME_FORNECEDOR");
			tela.dtgPesquisa.selectedline.values[7] = rst.getString("LOCALIZACAO");
			tela.dtgPesquisa.selectedline.values[8] = rst.getString("CONTATO");
		}
	}

	public void chamaCrud() {
		callFolder("br.com.visualmix.conferenciacaixa.crud.produtos.Tela", "carregarTela", "");
	}

	public void logout() {
        super.callFolder("br.com.visualmix.generico.acesso.jsplogin.Tela", "logout");
	}
}