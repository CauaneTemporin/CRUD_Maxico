package com.temporintech.crud.maxicode.adm.jsppesquisa;

import br.com.maxicode.html.Body;
import br.com.maxicode.html.DataGrid;
import br.com.maxicode.html.Form;
import br.com.maxicode.html.Header;
import br.com.maxicode.html.ItemMenu;
import br.com.maxicode.html.Label;
import br.com.maxicode.html.Layout;
import br.com.maxicode.html.Line;
import br.com.visualmix.generico.utils.ViewBody;


//Tela para exibir produtos.
public class BdyTela extends Body {

	//Cria header e formularios
	public Header header													 = new Header("Loja");	
	public Form frmTela														 = new Form("frmTela");	

	//Cria itens do menu
	public ItemMenu itmEncerrar												 = new ItemMenu(frmTela, "itmEncerrar", "Encerrar");
	public ItemMenu itmCrud													 = new ItemMenu(frmTela, "itemCrud", "CRUD");
	
	//Campos
	public Label lblTitulo													 = new Label(frmTela, "lblTitulo", 1,"Produtos dispon�veis");
	
	//Pesquisa
	public DataGrid dtgPesquisa												 = new DataGrid(frmTela, "dtgPesquisa");
	
	public BdyTela() {
		// Fun��o respons�vel por determinar os atributos de cada objeto da tela
		setAtributoObjetos();

		//Fun��o respons�vel por adicionar os itens criados ao Body
		setObjetosBody();
	}
	
	private void setAtributoObjetos() {
		//Defini��o dos atributos do elementos na tela
		lblTitulo.setWidth("700px");
		lblTitulo.setStyle("100");
		dtgPesquisa.setHeight("300px");
		}
	
	private void setObjetosBody() {
		//Distribui��o dos elementos na tela

		Layout layout 														 = new Layout(frmTela);
		Line line;
		
		//Associa todos os items ao Body
		additem(header);
		additem(frmTela);
		
		//Associa todos os items ao header
		header.additem(itmCrud);
		header.additem(itmEncerrar);
		
		//Associa todos os items ao formulario
		frmTela.additem(layout);
		
		//Criar linha, associa ao layout e adiciona os objetos
		
		line = new Line(frmTela);
		layout.additem(line);
		line.additem(lblTitulo);
		line = layout.addLine();
		line.additem(dtgPesquisa);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ViewBody view = new ViewBody(new BdyTela());
	}
}
