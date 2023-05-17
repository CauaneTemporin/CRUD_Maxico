package com.temporintech.crud.maxicode.business.crud.produto;

import br.com.maxicode.core.Conexao;
import br.com.maxicode.core.SQLCreator;
import br.com.maxicode.db.IRecordSet;
import br.com.visualmix.generico.validator.ValidatorCRUD;

public class Produto extends ValidatorCRUD{

	public ProdutoData data = new ProdutoData();
	
	public Produto(Conexao banco) {
		super.setConexao(banco);
		super.values = data;
		tabela = "PRODUTO";
		
	}
	
	@Override
	public void initValues() {
		data = new ProdutoData();
		values = data;
	}
	
	public int salvar() {
		return super.salvar();
	}
	
	public void editar() {
		super.editar();
	}
	
	public void excluir(int id) {
		data.setID(id);
		super.excluir();
	}
	
	//Gera o ID increment
	public String geraCodigo() {
		//Obj que consegue conter as informações da query
		IRecordSet rst;

		SQLCreator objSqlCreator = new SQLCreator(tabela);
		objSqlCreator.addCampo("MAX(ID) as id");
		rst = getRecordSet(objSqlCreator.getSelect());

		if (rst.next()) {
			if (rst.getInt("id") > 0) {
				return String.valueOf(rst.getInt("id") + 1);
			}
		}

		return "1";
	}
	
	//Método que busca no banco todos os campos da tabela
	public IRecordSet getAllProdutos() {
		IRecordSet rst;
		SQLCreator objSqlCreator = new SQLCreator("PRODUTO P inner join FORNECEDOR F on p.FORNECEDOR_id = F.id inner join CATEGORIA C on P.CATEGORIA_id = C.id");
		objSqlCreator.addCampo("*");
		rst = getRecordSet(objSqlCreator.getSelect());
		return rst;
	}
	
	public IRecordSet getProduto(int id) {
		IRecordSet rst;
		SQLCreator objSqlCreator = new SQLCreator(tabela);
		objSqlCreator.addCampo("*");
		objSqlCreator.addCampo("ID", toString(id),true);
		
		rst = getRecordSet(objSqlCreator.getSelect());
		return rst;
	}
	
	//Método que exclui ID da tabela
	public IRecordSet excluirProduto(int id) {
		IRecordSet rst;
		SQLCreator objSqlCreator = new SQLCreator(tabela);
		objSqlCreator.addCampo("ID", toString(id),true);
		rst = getRecordSet(objSqlCreator.getDelete());
		return rst;
	}

}

