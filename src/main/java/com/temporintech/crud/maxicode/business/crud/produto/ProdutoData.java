package com.temporintech.crud.maxicode.business.crud.produto;

import br.com.maxicode.core.BaseData;
import br.com.visualmix.generico.validator.field;
import br.com.visualmix.generico.validator.index;

public class ProdutoData  extends BaseData {

	@index
	private int ID =  1;
	
	@field
	private String NOME_PRODUTO = "";
	
	@field
	private double PRECO = 0.1;
	
	@field
	private int QUANTIDADE = 0;
	
	@field
	private String DESCRICAO = "";
	
	@field
	private int CATEGORIA_ID =  1;
	
	@field
	private int FORNECEDOR_ID =  1;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNOME_PRODUTO() {
		return NOME_PRODUTO;
	}

	public void setNOME_PRODUTO(String nOME) {
		NOME_PRODUTO = nOME;
	}
	
	public double getPRECO() {
		return PRECO;
	}

	public void setPRECO(double pRECO) {
		PRECO = pRECO;
	}

	public int getQUANTIDADE() {
		return QUANTIDADE;
	}

	public void setQUANTIDADE(int qUANTIDADE) {
		QUANTIDADE = qUANTIDADE;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}	
	public int getFORNECEDOR_ID() {
		return FORNECEDOR_ID;
	}

	public void setFORNECEDOR_ID(int fORNECEDOR_ID) {
		FORNECEDOR_ID = fORNECEDOR_ID;
	}

	public int getCATEGORIA_ID() {
		return CATEGORIA_ID;
	}

	public void setCATEGORIA_ID(int cATEGORIA_ID) {
		CATEGORIA_ID = cATEGORIA_ID;
	}
}
