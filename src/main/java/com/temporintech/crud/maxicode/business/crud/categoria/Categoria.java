package com.temporintech.crud.maxicode.business.crud.categoria;

import br.com.maxicode.core.Conexao;
import br.com.maxicode.core.SQLCreator;
import br.com.maxicode.db.IRecordSet;
import br.com.visualmix.generico.validator.ValidatorCRUD;

public class Categoria extends ValidatorCRUD {
	
	public CategoriaData data = new CategoriaData();

		public Categoria(Conexao banco) {
		super.setConexao(banco);
		super.values = data;
		tabela = "CATEGORIA";
	}
	
	@Override
	public void initValues() {
		data = new CategoriaData();
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
	public IRecordSet getAllCategoria() {
		IRecordSet rst;
		SQLCreator objSqlCreator = new SQLCreator(tabela);
		objSqlCreator.addCampo("*");
		rst = getRecordSet(objSqlCreator.getSelect());
		return rst;	
	}
	
	//Método que que busca no banco e recebe um parâmentro
	public String getDescricaoCategoria(int id) {
		IRecordSet rst;
		SQLCreator objSqlCreator = new SQLCreator(tabela);
		objSqlCreator.addCampo("CATEGORIA");
		objSqlCreator.addCampo("ID", toString(id), true);
		rst = getRecordSet(objSqlCreator.getSelect());
		
		if(rst.next()) {
			return rst.getString("CATEGORIA");
		}
		
		return "Categoria inválida";
	}
	
	//Método que exclui ID da tabela
	public IRecordSet excluirCategoria(int id) {
		IRecordSet rst;
		SQLCreator objSqlCreator = new SQLCreator(tabela);
		objSqlCreator.addCampo("ID", toString(id),true);
		rst = getRecordSet(objSqlCreator.getDelete());
		return rst;
	}
	
	
}
