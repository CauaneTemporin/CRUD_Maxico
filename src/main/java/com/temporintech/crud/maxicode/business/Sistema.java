package com.temporintech.crud.maxicode.business;

import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.maxicode.util.UtilDate;
import br.com.visualmix.generico.validator.ISistema;

public class Sistema implements ISistema {
	
	public final static String SISTEMA_NOME = "Crud";
	public final static int SISTEMA_CODIGO = 100;
	public final static Date DATA_COMPILACAO = UtilDate.strToDate("11/05/2023", "dd/MM/yyyy");
	public final static int VERSAO_APP = 10000;
	
	public static void main(String[] args) {
	    JOptionPane.showMessageDialog(null, "Versão: " + formataVersaoSistema(VERSAO_APP));
	}
	
	public static String formataVersaoSistema(int versao){
		
		String formatado = "";
		DecimalFormat  formatador  = new DecimalFormat("0,00");
		if (versao > 9999){
			formatado = formatador.format(versao);
			//Caso as duas ultimas for zero não exibe
			if (formatado.substring(formatado.length() - 2, formatado.length()).equals("00")){
				formatado = formatado.substring(0, formatado.length() - 3);
			}
		}else{
			formatado = formatador.format(versao);
		}
		
		return formatado;
	}

	
	public byte getId() {
		return SISTEMA_CODIGO;
	}

	
	public String getNome() {
		return SISTEMA_NOME;
	}

	
	public int getVersao() {
		return VERSAO_APP;
	}

	

	public static void className(String nomeClass){
		
		br.com.maxicode.log.GravaLogExecucao.getInstance().write(nomeClass + " - " + Thread.currentThread().getStackTrace()[2].getMethodName());
		
	}

}
