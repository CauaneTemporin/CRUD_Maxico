package com.temporintech.crud.maxicode.business.crud.fornecedor;

import br.com.maxicode.core.BaseData;
import br.com.visualmix.generico.validator.field;
import br.com.visualmix.generico.validator.index;

public class FornecedorData extends BaseData{

	@index
	private int ID =  1;
	
	@field
	private String NOME_FORNECEDOR = "";
	
	@field
	private String LOCALIZACAO = "";
	
	@field
	private String  CONTATO = "";

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNOME_FORNECEDOR() {
		return NOME_FORNECEDOR;
	}

	public void setNOME_FORNECEDOR(String nOME) {
		NOME_FORNECEDOR = nOME;
	}

	public String getLOCALIZACAO() {
		return LOCALIZACAO;
	}

	public void setLOCALIZACAO(String lOCALIZACAO) {
		LOCALIZACAO = lOCALIZACAO;
	}

	public String getCONTATO() {
		return CONTATO;
	}

	public void setCONTATO(String cONTATO) {
		CONTATO = cONTATO;
	}

}