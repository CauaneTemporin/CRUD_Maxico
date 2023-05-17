package com.temporintech.crud.maxicode.business.utils;

import java.util.Date;

import br.com.maxicode.util.Funcoes;

public class DataKey {

	private int loja = 0;
	private Date data = Funcoes.strtodate("01/01/1980", "dd/MM/yyyy");
	private int num_pdv = 0;
	private int num_cupom = 0;
	private int transacaoOper = 0;
	private int transacao = 0;
	private String operador = "";
	private int nsu = 0;
	private byte finalizadora = 0;
	private double dominio = 0;
	private int contador = 0;
	private String complemento = "";
	private String nomeComputador = "";
	private int nsuInicial = 0;
	private byte tipoConf = 0;
	
	public int getLoja() {
		return loja;
	}
	
	public void setLoja(int loja) {
		this.loja = loja;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getNum_pdv() {
		return num_pdv;
	}
	
	public void setNum_pdv(int num_pdv) {
		this.num_pdv = num_pdv;
	}
	
	public int getNum_cupom() {
		return num_cupom;
	}
	
	public void setNum_cupom(int num_cupom) {
		this.num_cupom = num_cupom;
	}
	
	public int getTransacaoOper() {
		return transacaoOper;
	}
	
	public void setTransacaoOper(int transacaoOper) {
		this.transacaoOper = transacaoOper;
	}
	
	public int getTransacao() {
		return transacao;
	}
	
	public void setTransacao(int transacao) {
		this.transacao = transacao;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public int getNsu() {
		return nsu;
	}
	public void setNsu(int nsu) {
		this.nsu = nsu;
	}
	public byte getFinalizadora() {
		return finalizadora;
	}
	public void setFinalizadora(byte finalizadora) {
		this.finalizadora = finalizadora;
	}
	public double getDominio() {
		return dominio;
	}
	public void setDominio(double dominio) {
		this.dominio = dominio;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getNomeComputador() {
		return nomeComputador;
	}

	public void setNomeComputador(String nomeComputador) {
		this.nomeComputador = nomeComputador;
	}

	public int getNsuInicial() {
		return nsuInicial;
	}
	public void setNsuInicial(int nsuInicial) {
		this.nsuInicial = nsuInicial;
	}

	public String[] getParametro(){
		String texto =  loja + "|" + data + "|" + num_pdv + "|" + num_cupom + "|" + transacaoOper + "|" + 
							transacao + "|" + operador + "|" + nsu + "|" + finalizadora + "|" + 
							dominio + "|" + contador + "|0|0|0|0|0|" + complemento;
		String[] retorno = texto.split("|");
		return retorno;
	}

	public void setTipoConf(byte tipoConf) {
		this.tipoConf = tipoConf;
	}

	public byte getTipoConf() {
		return tipoConf;
	}

}
