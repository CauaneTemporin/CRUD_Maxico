package com.temporintech.crud.maxicode.adm.jsptela;

import br.com.maxicode.db.IRecordSet;
import br.com.maxicode.html.Folder;
import com.temporintech.crud.maxicode.business.crud.produto.Produto;
import com.temporintech.crud.maxicode.business.crud.fornecedor.Fornecedor;
import com.temporintech.crud.maxicode.business.crud.categoria.Categoria;

import br.com.visualmix.generico.forms.frmMsgBox;

//CauaneTemporin
public class Tela extends Folder {

	private Produto objProduto;
	private Fornecedor objFornecedor;
	private Categoria objCategoria;
	private IRecordSet rst;

	private BdyTela tela = new BdyTela();
	private frmMsgBox msgBox = new frmMsgBox();

	String[] dtgHeaderCategoria = { "C�digo", "Categoria" };
	String[] dtgHeaderFornecedor = { "C�digo", "Fornecedor", "Localiza��o", "Contato" };
	String[] dtgHeaderProduto = { "C�digo", "Produto", "Descri��o", "Pre�o", "Quantidade", "Categoria", "Fornecedor",
			"Origem", "Contato" };

	public Tela() {
		setTitle("CRUD Produto");
		additem(tela);
		additem(msgBox);
		Show(0);
	}

	public void initialize() {
		super.Show(0);
		objProduto = new Produto(getConexao());
		objCategoria = new Categoria(getConexao());
		objFornecedor = new Fornecedor(getConexao());
		carregarCodigo();
		setarEventos();
		carregarCombosProduto();
		carregarDataGridCategoria();
		carregarDataGridFornecedor();
		carregarDataGridProduto();
	}

	// Desabilitar campo
	public void carregarTela() {
		tela.txtCategoriaCodigo.setEnabled(false);
		tela.txtFornecedorCodigo.setEnabled(false);
		tela.txtProdutoCodigo.setEnabled(false);

	}

	// Gera o ID
	public void carregarCodigo() {
		tela.txtCategoriaCodigo.setText(objCategoria.geraCodigo());
		tela.txtFornecedorCodigo.setText(objFornecedor.geraCodigo());
		tela.txtProdutoCodigo.setText(objProduto.geraCodigo());
	}

	// Inicializa Eventos
	private void setarEventos() {
		tela.itmEncerrar.onclick.setServer("encerrar");
		tela.btnSalvarCategoria.onclick.setServer("salvarCategoria");
		tela.btnSalvarFornecedor.onclick.setServer("salvarFornecedor");
		tela.btnSalvarProduto.onclick.setServer("salvarProduto");
		tela.btnExcluirCategoria.onclick.setServer("deletarCategoria");
		tela.btnExcluirFornecedor.onclick.setServer("deletarFornecedor");
		tela.btnExcluirProduto.onclick.setServer("deletarProduto");
		tela.dtgPesquisarCategoria.onclick.setServer("atualizarCategoria");
		tela.dtgPesquisarFornecedor.onclick.setServer("atualizarFornecedor");
		tela.dtgPesquisarProduto.onclick.setServer("atualizarProduto");
		tela.btnLimpaCategoria.onclick.setServer("limparCampos");
		tela.btnLimpaFornecedor.onclick.setServer("limparCampos");
		tela.btnLimpaProduto.onclick.setServer("limparCampos");
	}

	// Fun��o para carregar os dados docombox
	public void carregarCombosProduto() {
		rst = objCategoria.getAllCategoria();
		while (rst.next()) {
			tela.cmbCategoria.additem(String.valueOf(rst.getInt("ID")), rst.getString("CATEGORIA"));
		}
		rst = objFornecedor.getAllFornecedor();
		while (rst.next()) {
			tela.cmbFornecedores.additem(String.valueOf(rst.getInt("ID")), rst.getString("NOME_FORNECEDOR"));
		}
	}

	// Salva as informa��es da tabelaCategoria
	public void salvarCategoria() {
		objCategoria.data.setID(Integer.parseInt(tela.txtCategoriaCodigo.getText()));
		if (objCategoria.existe())
			objCategoria.data.setEdicao();
		else
			objCategoria.data.setInclusao();
		objCategoria.data.setCATEGORIA(tela.txtCategoria.getText());
		objCategoria.salvar();
		msgBox.Mensagem("Informa��es salvas com sucesso!");
		Show(msgBox);
		limparCampos();
		carregarDataGridCategoria();
		carregarDataGridProduto();
	}

	// Salva as informa��es da tabela Fornecedor
	public void salvarFornecedor() {
		objFornecedor.data.setID(Integer.parseInt(tela.txtFornecedorCodigo.getText()));
		if (objFornecedor.existe())
			objFornecedor.data.setEdicao();
		else
			objFornecedor.data.setInclusao();
		objFornecedor.data.setNOME_FORNECEDOR(tela.txtFornecedor.getText());
		objFornecedor.data.setLOCALIZACAO(tela.txtLocalizaco.getText());
		objFornecedor.data.setCONTATO(tela.txtContato.getText());
		objFornecedor.salvar();
		msgBox.Mensagem("Informa��es salvas com sucesso!");
		Show(msgBox);
		limparCampos();
		carregarDataGridFornecedor();
		carregarDataGridProduto();
	}

	// Salva as informa��es da tabela Produto
	public void salvarProduto() {
		objProduto.data.setID(Integer.parseInt(tela.txtProdutoCodigo.getText()));
		if (objProduto.existe())
			objProduto.data.setEdicao();
		else
			objProduto.data.setInclusao();
		objProduto.data.setNOME_PRODUTO(tela.txtProduto.getText());
		objProduto.data.setDESCRICAO(tela.txtDescricao.getText());
		objProduto.data.setPRECO(Double.parseDouble(tela.txtPreco.getText()));
		objProduto.data.setQUANTIDADE(Integer.parseInt(tela.txtQuantidade.getText()));
		objProduto.data.setCATEGORIA_ID(Integer.parseInt(tela.cmbCategoria.getValue()));
		objProduto.data.setFORNECEDOR_ID(Integer.parseInt(tela.cmbFornecedores.getValue()));
		objProduto.salvar();
		msgBox.Mensagem("Informa��es salvas com sucesso!");
		Show(msgBox);
		limparCampos();
		carregarDataGridProduto();
	}

	// Deleta as informa��es da tabela Categoria
	public void deletarCategoria() {
		objCategoria.excluirCategoria(Integer.parseInt(tela.dtgPesquisarCategoria.selectedline.values[0]));
		msgBox.Mensagem("Informa��es deletas com sucesso!");
		Show(msgBox);
		limparCampos();
		carregarDataGridCategoria();
	}

	// Deleta as informa��es da tabela Fornecedor
	public void deletarFornecedor() {
		objFornecedor.excluirFornecedor(Integer.parseInt(tela.dtgPesquisarFornecedor.selectedline.values[0]));
		msgBox.Mensagem("Informa��es deletas com sucesso!");
		Show(msgBox);
		limparCampos();
		carregarDataGridFornecedor();
	}

	// Deleta as informa��es da tabela Produto
	public void deletarProduto() {
		objProduto.excluirProduto(Integer.parseInt(tela.dtgPesquisarProduto.selectedline.values[0]));
		msgBox.Mensagem("Informa��es deletas com sucesso!");
		Show(msgBox);
		limparCampos();
		carregarDataGridProduto();
	}

	// Atualiza as informa��es da tabela Categoria
	public void atualizarCategoria() {
		if (getEventIndex() == null) {
			return;
		}
		tela.dtgPesquisarCategoria.getline(getEventIndex());
		tela.txtCategoriaCodigo.setText(tela.dtgPesquisarCategoria.selectedline.values[0]);
		tela.txtCategoria.setText(tela.dtgPesquisarCategoria.selectedline.values[1]);
	}

	// Atualiza as informa��es da tabela Fornecedor
	public void atualizarFornecedor() {
		if (getEventIndex() == null) {
			return;
		}
		tela.dtgPesquisarFornecedor.getline(getEventIndex());
		tela.txtFornecedorCodigo.setText(tela.dtgPesquisarFornecedor.selectedline.values[0]);
		tela.txtFornecedor.setText(tela.dtgPesquisarFornecedor.selectedline.values[1]);
		tela.txtLocalizaco.setText(tela.dtgPesquisarFornecedor.selectedline.values[2]);
		tela.txtContato.setText(tela.dtgPesquisarFornecedor.selectedline.values[3]);
	}

	// Atualiza as informa��es da tabela Produto
	public void atualizarProduto() {
		int categoria_id = 0; 
		int fornecedor_id = 0; 
		
		if (getEventIndex() == null) {
			return;
		}

		tela.dtgPesquisarProduto.getline(getEventIndex());		
		rst = objProduto.getProduto(Integer.parseInt(tela.dtgPesquisarProduto.selectedline.values[0]));
		
		if (rst.next()){
			categoria_id = rst.getInt("CATEGORIA_ID");
			fornecedor_id =rst.getInt("FORNECEDOR_ID");
		}
		
		tela.txtProdutoCodigo.setText(tela.dtgPesquisarProduto.selectedline.values[0]);
		tela.txtProduto.setText(tela.dtgPesquisarProduto.selectedline.values[1]);
		tela.txtDescricao.setText(tela.dtgPesquisarProduto.selectedline.values[2]);
		tela.txtPreco.setText(tela.dtgPesquisarProduto.selectedline.values[3]);
		tela.txtQuantidade.setText(tela.dtgPesquisarProduto.selectedline.values[4]);
		tela.cmbCategoria.selectValue(categoria_id);   
		tela.cmbFornecedores.selectValue(fornecedor_id);
		tela.txtLocalizaco.setText(tela.dtgPesquisarProduto.selectedline.values[7]);
		tela.txtContato.setText(tela.dtgPesquisarProduto.selectedline.values[8]);
	}

	// Limpa os campos ap�s adicionado
	public void limparCampos() {
		tela.txtCategoria.setText("");

		tela.txtFornecedor.setText("");
		tela.txtLocalizaco.setText("");
		tela.txtContato.setText("");

		tela.txtProduto.setText("");
		tela.txtPreco.setText("");
		tela.txtDescricao.setText("");
		tela.txtQuantidade.setText("");

		tela.cmbCategoria.selectitem(-1);
		tela.cmbFornecedores.selectitem(-1);
		carregarCodigo();
	}
	
	// Fun��o para carregar os dados no DataGrid Produto
	public void carregarDataGridCategoria() {

		rst = objCategoria.getAllCategoria();

		tela.dtgPesquisarCategoria.clear();
		tela.dtgPesquisarCategoria.lines.clear();
		for (int x = 0; x < dtgHeaderCategoria.length; x++) {
			tela.dtgPesquisarCategoria.header.addcolumn(dtgHeaderCategoria[x], 1, 1);
			tela.dtgPesquisarCategoria.header.selectedcolumn.tag = dtgHeaderCategoria[x];
			tela.dtgPesquisarCategoria.header.selectedcolumn.minwidth = "147px";
		}

		while (rst.next()) {
			tela.dtgPesquisarCategoria.addline();
			tela.dtgPesquisarCategoria.selectedline.values[0] = String.valueOf(rst.getInt("ID"));
			tela.dtgPesquisarCategoria.selectedline.values[1] = rst.getString("CATEGORIA");
		}
	}

	// Fun��o para carregar os dados no DataGrid Fornecedor
	public void carregarDataGridFornecedor() {
		rst = objFornecedor.getAllFornecedor();

		tela.dtgPesquisarFornecedor.clear();
		tela.dtgPesquisarFornecedor.lines.clear();

		for (int x = 0; x < dtgHeaderFornecedor.length; x++) {
			tela.dtgPesquisarFornecedor.header.addcolumn(dtgHeaderFornecedor[x], 1, 1);
			tela.dtgPesquisarFornecedor.header.selectedcolumn.tag = dtgHeaderFornecedor[x];
			tela.dtgPesquisarFornecedor.header.selectedcolumn.minwidth = "147px";
		}

		while (rst.next()) {
			tela.dtgPesquisarFornecedor.addline();
			tela.dtgPesquisarFornecedor.selectedline.values[0] = String.valueOf(rst.getInt("ID"));
			tela.dtgPesquisarFornecedor.selectedline.values[1] = rst.getString("NOME_FORNECEDOR");
			tela.dtgPesquisarFornecedor.selectedline.values[2] = rst.getString("LOCALIZACAO");
			tela.dtgPesquisarFornecedor.selectedline.values[3] = rst.getString("CONTATO");
		}

	}

	// Fun��o para carregar os dados no DataGrid Produto
	public void carregarDataGridProduto() {

		rst = objProduto.getAllProdutos();

		tela.dtgPesquisarProduto.clear();
		tela.dtgPesquisarProduto.lines.clear();

		for (int x = 0; x < dtgHeaderProduto.length; x++) {
			if(dtgHeaderProduto.equals("C�digo")) 
				tela.dtgPesquisarProduto.header.selectedcolumn.minwidth = "52px";
			else if(dtgHeaderProduto.equals("Descri��o")) 
				tela.dtgPesquisarProduto.header.selectedcolumn.minwidth = "160px";
			else {
				tela.dtgPesquisarProduto.header.addcolumn(dtgHeaderProduto[x], 1, 1);
				tela.dtgPesquisarProduto.header.selectedcolumn.tag = dtgHeaderProduto[x];
				tela.dtgPesquisarProduto.header.selectedcolumn.minwidth = "140px";
			}
		}

		while (rst.next()) {
			tela.dtgPesquisarProduto.addline();
			tela.dtgPesquisarProduto.selectedline.values[0] = String.valueOf(rst.getInt("ID"));
			tela.dtgPesquisarProduto.selectedline.values[1] = rst.getString("NOME_PRODUTO");
			tela.dtgPesquisarProduto.selectedline.values[2] = rst.getString("DESCRICAO");
			tela.dtgPesquisarProduto.selectedline.values[3] = String.valueOf(rst.getDouble("PRECO"));
			tela.dtgPesquisarProduto.selectedline.values[4] = String.valueOf(rst.getInt("QUANTIDADE"));
			tela.dtgPesquisarProduto.selectedline.values[5] = rst.getString("CATEGORIA");
			tela.dtgPesquisarProduto.selectedline.values[6] = rst.getString("NOME_FORNECEDOR");
			tela.dtgPesquisarProduto.selectedline.values[7] = rst.getString("LOCALIZACAO");
			tela.dtgPesquisarProduto.selectedline.values[8] = rst.getString("CONTATO");
		}
	}

	public void encerrar() {
		super.callFolder("br.com.visualmix.conferenciacaixa.crud.jsppesquisa.Tela", "logout");
	}

}