package com.temporintech.crud.maxicode.business.crud.categoria;

import br.com.maxicode.core.BaseData;
import br.com.visualmix.generico.validator.field;
import br.com.visualmix.generico.validator.index;

public class CategoriaData extends BaseData{

	@index
	private int ID = 1;
	
	@field
	private String CATEGORIA = "";

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCATEGORIA() {
		return CATEGORIA;
	}

	public void setCATEGORIA(String cATEGORIA) {
		CATEGORIA = cATEGORIA;
	}
}