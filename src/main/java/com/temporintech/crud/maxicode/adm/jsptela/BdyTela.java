package com.temporintech.crud.maxicode.adm.jsptela;

import br.com.maxicode.html.Body;
import br.com.maxicode.html.Button;
import br.com.maxicode.html.ComboBox;
import br.com.maxicode.html.DataGrid;
import br.com.maxicode.html.Form;
import br.com.maxicode.html.Header;
import br.com.maxicode.html.ItemMenu;
import br.com.maxicode.html.Label;
import br.com.maxicode.html.Layout;
import br.com.maxicode.html.Line;
import br.com.maxicode.html.TabStrip;
import br.com.maxicode.html.TabStripItem;
import br.com.maxicode.html.TextBox;
import br.com.visualmix.generico.utils.ViewBody;

//CauaneTemporin
public class BdyTela extends Body {
	
		//Instancia��o do elementos da tela
		public Header header = new Header("CRUD");	
		public Form frmTela = new Form("frmTela");
		
		
		//Cria itens do menu
		public ItemMenu itmEncerrar 				= new ItemMenu(frmTela, "itmEncerrar", "Encerrar");
		public ItemMenu itmCrud 					= new ItemMenu(frmTela, "itemCrud", "CRUD");
		
		//Cria abas
		public TabStrip tab = new TabStrip(frmTela, "Abas");
		public TabStripItem tabItemCategoria = new TabStripItem("tabItemCategoria", "Categorias");
		public TabStripItem tabItemFornecedor = new TabStripItem("tabItemCategoria", "Fornecedores");
		public TabStripItem tabItemProduto = new TabStripItem("tabItemProduto", "Produto");
		
		//Cria campos
		public Label lblVazia						= new Label(frmTela, "lblVazia", 1,"					");

		
		public Label lblCategoriaCodigo				= new Label(frmTela, "lblCategoriaCodigo", 1,"C�digo: ");
		public TextBox txtCategoriaCodigo			= new TextBox(frmTela, "txtCategoriaCodigo");
		public Label lblCategoria					= new Label(frmTela, "lblCategoria", 1,"Categoria: ");
		public TextBox txtCategoria					= new TextBox(frmTela, "txtCategoria");
		
		public Label lblFornecedorCodigo			= new Label(frmTela, "lblFornecedorCodigo", 1,"C�digo: ");
		public TextBox txtFornecedorCodigo			= new TextBox(frmTela, "txtFornecedorCodigo");
		public Label lblFornecedor					= new Label(frmTela, "lblFornecedor", 1,"Fornecedor: ");
		public TextBox txtFornecedor				= new TextBox(frmTela, "txtFornecedor");
		public Label lblLocalizacao					= new Label(frmTela, "lblLocalizacao", 1,"Origem: ");
		public TextBox txtLocalizaco				= new TextBox(frmTela, "txtLocalizaco");
		public Label lblContato 					= new Label(frmTela, "lblContato", 1, "Contato:");
		public TextBox txtContato					= new TextBox(frmTela, "txtContato");
		
		public Label lblProdutoCodigo				= new Label(frmTela, "lblProdutoCodigo", 1,"C�digo: ");
		public TextBox txtProdutoCodigo				= new TextBox(frmTela, "txtProdutoCodigo");
		public Label lblProduto						= new Label(frmTela, "lblNome", 1,"Produto: ");
		public TextBox txtProduto					= new TextBox(frmTela, "txtNome");
		public Label lblPreco						= new Label(frmTela, "lblPreco", 1,"Pre�o: ");
		public TextBox txtPreco						= new TextBox(frmTela, "txtPreco");
		public Label lblDescricao					= new Label(frmTela, "lblDescricao", 1,"Descri��o: ");
		public TextBox txtDescricao					= new TextBox(frmTela, "txtDescricao");
		public Label lblQuantidade					= new Label(frmTela, "lblPreco", 1,"Quantidade: ");
		public TextBox txtQuantidade				= new TextBox(frmTela, "txtQuantidade");
		public Label lblValidade				= new Label(frmTela, "lblValidade", 1,"Validade: ");
		public TextBox txtValidade				= new TextBox(frmTela, "txtValidade");
		
		public Label lblCmbCategoria				= new Label(frmTela, "lblCmbCategoria", 1,"Categorias: ");
		public ComboBox cmbCategoria                = new ComboBox(frmTela, "cmbCategoria");
		public Label lblCmbFornecedores				= new Label(frmTela, "lblCmbFornecedores", 1,"Fornecedores: ");
		public ComboBox cmbFornecedores             = new ComboBox(frmTela, "cmbFornecedores");

		
		//BOT�O CRUD
		public Button btnSalvarCategoria			= new Button(frmTela, "btnSalvarCategoria","Salvar");
		public Button btnExcluirCategoria			= new Button(frmTela, "btnExcluirCategoria","Deletar");
		public Button btnLimpaCategoria				= new Button(frmTela, "btnLimpaCategoria","Limpar");
		
		public Button btnSalvarFornecedor			= new Button(frmTela, "btnSalvarFornecedor","Salvar");
		public Button btnExcluirFornecedor			= new Button(frmTela, "btnExcluirFornecedor","Deletar");
		public Button btnLimpaFornecedor			= new Button(frmTela, "btnLimpaFornecedor","Limpar");
		
		public Button btnSalvarProduto				= new Button(frmTela, "btnSalvarProduto","Salvar");
		public Button btnExcluirProduto				= new Button(frmTela, "btnExcluirProduto","Deletar");
		public Button btnLimpaProduto				= new Button(frmTela, "btnLimpaProduto","Limpar");
		
		// PESQUISA
		public DataGrid dtgPesquisarCategoria  	= new DataGrid(frmTela, "dtgPesquisarCategoria");
		public DataGrid dtgPesquisarFornecedor  	= new DataGrid(frmTela, "dtgPesquisarFornecedor");
		public DataGrid dtgPesquisarProduto  	= new DataGrid(frmTela, "dtgPesquisarProduto");
		
		
		//Construtor
		public BdyTela() {
			//Fun��o respos�vel por determinar os atributos de cada objeto em tela 
			setObjetosBody();
			//Fun��o respos�vel por adicionar os itens criados no Body
			setAtributoObjeto();
		}

		private void setAtributoObjeto() {
			//Defini��o dos atributos do elementos na tela
			
			txtCategoriaCodigo.setWidth("260px");
			txtCategoria.setWidth("260px");
			
			txtFornecedorCodigo.setWidth("260px");
			txtFornecedor.setWidth("260px");
			txtLocalizaco.setWidth("260px");
			txtContato.setWidth("260px");
			
			txtProdutoCodigo.setWidth("250px");
			txtProduto.setWidth("250px");
			txtDescricao.setWidth("250px");
			txtPreco.setWidth("250px");
			txtQuantidade.setWidth("250px");
			txtValidade.setWidth("250px");
			
			cmbCategoria.setWidth("250px");
			cmbFornecedores.setWidth("250px");
			
			btnSalvarCategoria.setWidth("110px");
			btnExcluirCategoria.setWidth("110px");
			btnLimpaCategoria.setWidth("110px");
			
			btnSalvarFornecedor.setWidth("110px");
			btnExcluirFornecedor.setWidth("110px");
			btnLimpaFornecedor.setWidth("110px");
			
			btnSalvarProduto.setWidth("110px");
			btnExcluirProduto.setWidth("110px");
			btnLimpaProduto.setWidth("110px");
			
			dtgPesquisarCategoria.setSelection(true);;
			dtgPesquisarCategoria.setHeight("300px");
			
			dtgPesquisarFornecedor.setSelection(true);
			dtgPesquisarFornecedor.setHeight("300px");
			
			dtgPesquisarProduto.setSelection(true);
			dtgPesquisarProduto.setHeight("300px");
		}
		
		private void setObjetosBody() {
			//Distribui��o dos elementos na tela

			
			//Cria layout
			Layout layoutCategoria  				= new Layout(frmTela);
			Layout layoutForncedor 					= new Layout(frmTela);
			Layout layoutProduto 					= new Layout(frmTela);
			
			//Cria linha
			Line line;
			
			additem(header);
			additem(frmTela);

			//Exibe menu
			header.additem(itmCrud);
			header.additem(itmEncerrar);

			//Exibe abas
			frmTela.additem(tab); 
			tab.additem(tabItemCategoria);
			tab.additem(tabItemFornecedor);
			tab.additem(tabItemProduto);
			tabItemCategoria.additem(layoutCategoria);
			tabItemFornecedor.additem(layoutForncedor);
			tabItemProduto.additem(layoutProduto);
			
			
			//Criar linha, associa ao layout e adiciona os objetos
			line = new Line(frmTela);
			layoutCategoria.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutCategoria.additem(line);
			line.additem(lblCategoriaCodigo);
			line.additem(txtCategoriaCodigo);
			line.additem(lblCategoria);
			line.additem(txtCategoria);
			line = new Line(frmTela);
			layoutCategoria.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutCategoria.additem(line);
			line.additem(btnSalvarCategoria);
			line.additem(btnLimpaCategoria);
			line.additem(btnExcluirCategoria);
			line = new Line(frmTela);
			layoutCategoria.additem(line);
			line.additem(lblVazia);
			layoutForncedor.additem(line);
			line = layoutCategoria.addLine(1);
			line.additem(dtgPesquisarCategoria);
			
			line = new Line(frmTela);
			layoutForncedor.additem(line);
			line.additem(lblFornecedorCodigo);
			line.additem(txtFornecedorCodigo);
			line.additem(lblFornecedor);
			line.additem(txtFornecedor);
			line = new Line(frmTela);
			layoutForncedor.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutForncedor.additem(line);
			line.additem(lblLocalizacao);
			line.additem(txtLocalizaco);
			line.additem(lblContato);
			line.additem(txtContato);
			line = new Line(frmTela);
			layoutForncedor.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutForncedor.additem(line);
			line.additem(btnSalvarFornecedor);
			line.additem(btnLimpaFornecedor);
			line.additem(btnExcluirFornecedor);
			line = new Line(frmTela);
			layoutForncedor.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutForncedor.additem(line);
			line = layoutForncedor.addLine(1);
			line.additem(dtgPesquisarFornecedor);
			
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblProdutoCodigo);
			line.additem(txtProdutoCodigo);
			line.additem(lblProduto);
			line.additem(txtProduto);
			line.additem(lblPreco);
			line.additem(txtPreco);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblDescricao);
			line.additem(txtDescricao);
			line.additem(lblQuantidade);
			line.additem(txtQuantidade);
			line.additem(lblValidade);
			line.additem(txtValidade);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblCmbFornecedores);
			line.additem(cmbFornecedores);
			line.additem(lblCmbCategoria);
			line.additem(cmbCategoria);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblVazia);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(btnSalvarProduto);
			line.additem(btnLimpaProduto);
			line.additem(btnExcluirProduto);
			line = new Line(frmTela);
			layoutProduto.additem(line);
			line.additem(lblVazia);
			line = layoutProduto.addLine(1);
			line.additem(dtgPesquisarProduto);
			
		}
		
		public static void main(String[] args) {
			new ViewBody(new BdyTela());
		}
}
