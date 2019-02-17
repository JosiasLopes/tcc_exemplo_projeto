package application;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.callback.Callback;
import javax.swing.JOptionPane;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import webservices.ClienteViaCepWS;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	//paineis de conteudo das subcenas
	static AnchorPane pmenu_principal_lateral_esquerdo;
	static AnchorPane pmenu_principal_empresas;
	static AnchorPane pmenu_principal_funcionarios;
	static AnchorPane pmenu_principal_cargos;
	static AnchorPane pmenu_principal_setores;
	static AnchorPane pmenu_principal_riscos;
	static AnchorPane pmenu_principal_ipi;
	static AnchorPane pmenu_principal_ppra;
	static String retorno;
	
	
	//painel cadastro da empresa
	static AnchorPane fundocinzaempresas,fundocinzafuncionario,fundocinzacargod,ptelacadastrodecargos,fundocinzarisco,fundocinzasetor,fundocinzaeditarsetor,fundocinzadelempresa,fundocinzacadastracargo;
	static AnchorPane subpainelcena2,subpainelcena3,subpainelcena4,subpainelcena5,subpainelcena6,subpainelcena7,subpainelcena8,fundorouxoempresa,fundorouxofuncionario,fundorouxosetores,fundorouxorisco,fundorouxosetor
	,fundorouxodelempresa,fundorouxocadastrafuncionario,fundocinzacadastrafuncionario,fundorouxocadastracargo;
	static AnchorPane fundorouxoeditarsetor;
	static Subcenas subcenas_menu_lateral_esquerdo,subcenas_empresas,subcenas_funcionarios,cenadelempresa,subcenas_cargos,cenacadempresa,cadelempresa,cenacadsetor,cenacadfuncionario,cenacadrisco,cenaeditarsetor;
	static Subcenas subcenas_setores, subcenas_riscos,subcenas_ipi,subcenas_ppra,cenacadastrarcargo;
	AnchorPane root ;
	public static fxLabel textomenu, textomenu2,textomenu3,textomenu4,textomenu5,textomenu6,textomenu7,textomenu8,textomenu9,textomenu10;
	public static fxLabel txtempresa1, txtempresa2,txtempresa3,txtempresa4,txtempresa5,txtempresa6;
	public static fxLabel txtfuncionario1,txtfuncionario2,txtfuncionario3,txtfuncionario4,txtfuncionario5;
	public static fxLabel txtcargo1,txtcargo2,txtcargo3,txtcargo4,txtcargo5;
	public static fxLabel txtsetor1,txtsetor2,txtsetor3,txtsetor4,txtsetor5;
	public static fxLabel txtrisco1,txtrisco2,txtrisco3,txtrisco4,txtrisco5;
	public static fxLabel txtipi1,txtipi2,txtipi3,txtipi4,txtipi5;
	public static fxLabel txtppra1,txtppra2,txtppra3,txtppra4,txtppra5;
	public static fxLabel tipo,subtipo,descricao,fatorrisco,fontegeradora,transmissao,cadastrarnovofator,cadnofontegeradora,cadnovatransmissao;
	public static fxComboBox tipos,subtipos,fatoresrisco,fontesgeradora,viastransmissao,estados,estadosfu,sugestoessetor;
	public static Subcenas confirmacao;
	public static Parent pconfirmacao;
	public static TableView<Setor> tbeditsetor;
	public static TableColumn<Setor,String> coluna;
	public static TableCell celula;
	
	public static fxLabel titulocadempresa,titulocadfuncionario,titulocadsetor;
	static List<String> opc;
	
	//labels  e inputtext para a tela de cadastro de empresas
	public static fxLabel cnpj,rzsocial,nmfantasia,fone,email,endereco,num,bairro,cidade,estado,cnae1,cnae2,senha,confirmasenha,cancelar,cadastrar,cancelarrisco1,cadastrarrisco1;
	public static fxLabel cadastrarsetor,cancelarsetor,setordescricao,setoratribuicao,edtsetordescricao,edtsetoratribuicao,cadedtsetor,canceledtsetor;
	
	public static fxLabel cpf,nome,ctps,admissao,fonefu,pis,rg,enderecofu,bairrofu,cidadefu,nascimento,estadofu,cep,cadastrarfuncionario,cancelarfuncionario;
	public static fxTextField tcpf,tnome,tctps,tfonefu,tenderecofu,tpis,trg,tbairrofu,tcidadefu,testadofu,tcep;
	public static DatePicker tadmissao;
	public static DatePicker tnascimento;
	public static fxTextField txtdescricaosetor,txteditdescricaosetor,txteditatribuicaosetor;
	public static fxTextField tcnpj, trzsocial,tnmfantasia,tendereco,tnum,tcnae1,tcnae2,tsenha,tfone,temail,tcidade,testado,tbairro,tconfirmasenha;
	static Scene scene;
	public static fxTextField textoatribuicaosetor;
	@Override
	public void start(Stage primaryStage) {
		try {
			
		//	JOptionPane.showMessageDialog(null,ClienteViaCepWS.buscarCep("06867300") );
			root = new AnchorPane();
			scene = new Scene(root,400,root.getHeight());
			scene.getStylesheets().add(getClass().getResource("application.css").toString());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(false);
			primaryStage.setResizable(true);
			primaryStage.setHeight(800);
			primaryStage.setWidth(1400);
			primaryStage.setAlwaysOnTop(false);
			
			root.getStyleClass().addAll("fundo_degrade_linear_gelo");
			LoadContent();
			root.getChildren().add(subcenas_menu_lateral_esquerdo);
			root.getChildren().add(subcenas_empresas);
			root.getChildren().add(subcenas_funcionarios);
			root.getChildren().add(subcenas_cargos);
			root.getChildren().add(subcenas_setores);
			root.getChildren().add(subcenas_riscos);
			root.getChildren().add(subcenas_ipi);
			root.getChildren().add(subcenas_ppra);
			root.getChildren().add(cenacadempresa);
			root.getChildren().add(cenacadfuncionario);
			root.getChildren().add(cenacadrisco);
			root.getChildren().add(cenacadsetor);
			root.getChildren().add(cenaeditarsetor);
			root.getChildren().add(cenadelempresa);
			root.getChildren().add(cenacadastrarcargo);
			
			primaryStage.show();
			
			
			//textomenu10.setOnMouseClicked(new EventHandler<MouseEvent>(){

			//	@Override
			//	public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					//primaryStage.hide();
			//		System.exit(0);
			//	}
				
			//});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
		launch(args);
	}
	public static void LoadContent(){
		
		ArrayList<String> botao_bordas_brancas = new ArrayList<String>();
		 ArrayList<String> bt_cadcancel = new ArrayList<String>();
		 ArrayList<String> titulo_tela = new ArrayList<String>();
		 ArrayList<String> linuxStyle = new ArrayList<String>();
		 titulo_tela.add("fonte_35");
		 titulo_tela.add("texto_branco");
		 bt_cadcancel.add("fonte_19");
		 bt_cadcancel.add("texto_branco");
		 bt_cadcancel.add("fundo_verde");
		 bt_cadcancel.add("bordas_redondas_leves");
		 botao_bordas_brancas.add("fonte_32");
			botao_bordas_brancas.add("texto_branco");
			botao_bordas_brancas.add("fundo_verde");
			botao_bordas_brancas.add("bordas_redondas_leves_brancas");
			
		
pmenu_principal_lateral_esquerdo = new AnchorPane();

tbeditsetor = new TableView<>();
		
		//painel da cena 2
		pmenu_principal_empresas = new AnchorPane();
		pmenu_principal_funcionarios = new AnchorPane();
		pmenu_principal_cargos = new AnchorPane();
		pmenu_principal_setores = new AnchorPane();
		pmenu_principal_riscos = new AnchorPane();
		pmenu_principal_ipi = new AnchorPane();
		pmenu_principal_ppra = new AnchorPane();
		subpainelcena2 = new AnchorPane();
		subpainelcena3 = new AnchorPane();
		subpainelcena4 = new AnchorPane();
		subpainelcena5 = new AnchorPane();
		subpainelcena6 = new AnchorPane();
		subpainelcena7 = new AnchorPane();
		subpainelcena8 = new AnchorPane();
		
		fundorouxoempresa = new AnchorPane();
		fundorouxofuncionario = new AnchorPane();
		fundorouxocadastrafuncionario = new AnchorPane();
		fundorouxorisco = new AnchorPane();
		fundorouxosetor = new AnchorPane();
		fundorouxoeditarsetor = new AnchorPane();
		fundorouxodelempresa = new AnchorPane();
		fundorouxocadastracargo = new AnchorPane();
		
		fundocinzadelempresa = new AnchorPane();
		fundocinzaempresas = new AnchorPane();
		fundocinzafuncionario = new AnchorPane();
		fundocinzacadastrafuncionario = new AnchorPane();
		fundocinzarisco = new AnchorPane();
		fundocinzasetor = new AnchorPane();
		fundocinzaeditarsetor = new AnchorPane();
		fundocinzacadastracargo = new AnchorPane();
		
		
		
		//o tamanho do menu é baseado nos tamanhos da cena principal
				pmenu_principal_lateral_esquerdo.setPrefSize(scene.getWidth()/3, scene.getHeight());
				pmenu_principal_empresas.setPrefSize(scene.getWidth(), scene.getHeight());
				pmenu_principal_funcionarios.setPrefSize(scene.getWidth(), scene.getHeight());
				pmenu_principal_cargos.setPrefSize(scene.getWidth(), scene.getHeight());
				pmenu_principal_setores.setPrefSize(scene.getWidth(), scene.getHeight());
				pmenu_principal_riscos.setPrefSize(scene.getWidth(), scene.getHeight());
				pmenu_principal_ipi.setPrefSize(scene.getWidth(), scene.getHeight());
				pmenu_principal_ppra.setPrefSize(scene.getWidth(), scene.getHeight());
				
				//os paineis que tiverem o nome: subpainel sempre serao o fundo rouxo
				subpainelcena2.setPrefSize(500, 605);
				subpainelcena3.setPrefSize(500, 605);
				subpainelcena4.setPrefSize(500, 605);
				subpainelcena5.setPrefSize(500, 605);
				subpainelcena6.setPrefSize(500, 605);
				subpainelcena7.setPrefSize(500, 605);
				subpainelcena8.setPrefSize(500, 605);
				
				//seta o tamanho do painel e subpainel do cadastro de empresas
				fundocinzaempresas.setPrefSize(scene.getWidth(), scene.getHeight());
				fundocinzadelempresa.setPrefSize(scene.getWidth(), scene.getHeight());
				fundocinzafuncionario.setPrefSize(scene.getWidth(), scene.getHeight());
				fundocinzacadastrafuncionario.setPrefSize(scene.getWidth(), scene.getHeight());
				fundocinzarisco.setPrefSize(scene.getWidth(), scene.getHeight());
				fundocinzasetor.setPrefSize(scene.getWidth(), scene.getHeight());
				fundocinzaeditarsetor.setPrefSize(scene.getWidth(), scene.getHeight());
				fundocinzacadastracargo.setPrefSize(scene.getWidth(), scene.getHeight());
				
				fundorouxoempresa.setPrefSize(1035, 705);
				fundorouxodelempresa.setPrefSize(1035, 705);
				fundorouxofuncionario.setPrefSize(1035, 705);
				fundorouxocadastrafuncionario.setPrefSize(1035, 705);
				fundorouxorisco.setPrefSize(1035, 705);
				fundorouxosetor.setPrefSize(1035, 705);
				fundorouxoeditarsetor.setPrefSize(1035, 705);
				fundorouxocadastracargo.setPrefSize(1035, 705);
				
		
		//inicio do bloco que criar as Labels para a tela de cadastrop de empresa
				cancelar = new fxLabel("Cancelar","Cancelar","cempresa");
				titulocadempresa = new fxLabel("Cadastro de empresa");
				titulocadempresa.setDefaulStyle(titulocadempresa,titulo_tela);
				cancelar.setDefaulStyle(cancelar,bt_cadcancel);
				cadastrar = new fxLabel("Cadastrar","Cadastrar","cadempresa");
				cadastrar.setDefaulStyle(cadastrar,bt_cadcancel);
				cnpj = new fxLabel("Cnpj:");
				cnpj.setDefaulStyle(cnpj, "texto_branco_22");
				rzsocial = new fxLabel("Razão social:");
				rzsocial.setDefaulStyle(rzsocial, "texto_branco_22");
				nmfantasia = new fxLabel("Nome fantasía:");
				nmfantasia.setDefaulStyle(nmfantasia, "texto_branco_22");
				fone = new fxLabel("Telefone:");
				fone.setDefaulStyle(fone, "texto_branco_22");
				email = new fxLabel("E-mail:");
				email.setDefaulStyle(email, "texto_branco_22");
				endereco = new fxLabel("Endereço:");
				endereco.setDefaulStyle(endereco, "texto_branco_22");
				num = new fxLabel("Número:");
				num.setDefaulStyle(num, "texto_branco_22");
				bairro = new fxLabel("Bairro:");
				bairro.setDefaulStyle(bairro, "texto_branco_22");
				cidade = new fxLabel("Cidade:");
				cidade.setDefaulStyle(cidade, "texto_branco_22");
				estado = new fxLabel("Estado:");
				estado.setDefaulStyle(estado, "texto_branco_22");
				cnae1 = new fxLabel("Cnae primário:");
				cnae1.setDefaulStyle(cnae1, "texto_branco_22");
				cnae2 = new fxLabel("Cnae secundário:");
				cnae2.setDefaulStyle(cnae2, "texto_branco_22");
				senha = new fxLabel("Senha:");
				senha.setDefaulStyle(senha, "texto_branco_22");
				confirmasenha = new fxLabel("Confirma:");
				confirmasenha.setDefaulStyle(confirmasenha, "texto_branco_22");
				
		//fim do bloco que cria as labels
				
				
		//inicio do bloco que cria as caixas de texto
				//os id serão importantes para a captura de exceções
				
				tcnpj = new fxTextField();
				MaskFieldUtil.cnpjField(tcnpj);
				trzsocial = new fxTextField();
				tnmfantasia = new fxTextField();
				tfone = new fxTextField();
				MaskFieldUtil.foneField(tfone);
				temail = new fxTextField();
				tendereco = new fxTextField();
				tnum = new fxTextField(1);
				tbairro = new fxTextField();
				tcidade = new fxTextField();
				tcnae1 = new fxTextField();
				tcnae1.setDefaulStyle(tcnae1, "linux_style_text");
				tcnae2 = new fxTextField();
				
				tsenha = new fxTextField();
				tsenha.setId("senha");
				tconfirmasenha = new fxTextField();
				tconfirmasenha.setId("confirma");
				ObservableList<String> listaestados = FXCollections.observableArrayList("SP","RJ","ES","MG",
						"BA","SE","PB","PE","PI","RN","DF","CE","TO","MA","PA","AM","MT","MS","RO","RR","AC","AP","RS","SC","PR","AL"
						);
				estados = new fxComboBox(listaestados);
				
				//cria os objetos para a tela de cadastro de funcionario
				titulocadfuncionario = new fxLabel("Cadastro de funcionario");
				titulocadfuncionario.setDefaulStyle(titulocadfuncionario,titulo_tela);
				cancelarfuncionario = new fxLabel("Cancelar","Cancelar","cfuncionario");
				cadastrarfuncionario = new fxLabel("Cadastrar","Cadastrar","cadfuncionario");
				nome = new fxLabel("Nome:");
				nome.setDefaulStyle(nome, "texto_branco_22");
				cpf = new fxLabel("Cpf:");
				cpf.setDefaulStyle(cpf, "texto_branco_22");
				bairrofu = new fxLabel("Bairro");
				bairrofu.setDefaulStyle(bairrofu, "texto_branco_22");
				cidadefu = new fxLabel("Cidade:");
				cidadefu.setDefaulStyle(cidadefu, "texto_branco_22");
				enderecofu = new fxLabel("Endereço:");
				enderecofu.setDefaulStyle(enderecofu, "texto_branco_22");
				ctps = new fxLabel("Ctps:");
				ctps.setDefaulStyle(ctps, "texto_branco_22");
				pis = new fxLabel("Pis:");
				pis.setDefaulStyle(pis, "texto_branco_22");
				fonefu = new fxLabel("Telefone:");
				fonefu.setDefaulStyle(fonefu, "texto_branco_22");
				cep = new fxLabel("Cep:");
				cep.setDefaulStyle(cep, "texto_branco_22");
				
				admissao = new fxLabel("Admissão");
				admissao.setDefaulStyle(admissao, "texto_branco_22");
				rg = new fxLabel("RG:");
				rg.setDefaulStyle(rg, "texto_branco_22");
				nascimento = new fxLabel("Nascimento:");
				nascimento.setDefaulStyle(nascimento, "texto_branco_22");
				estadofu = new fxLabel("Estado:");
				estadofu.setDefaulStyle(estadofu, "texto_branco_22");
				estadosfu = new fxComboBox(listaestados);
				
				tnome = new fxTextField();
				tnome.setDefaulStyle(tnome, "linux_style_text");
				tcpf = new fxTextField();
				tcpf.setDefaulStyle(tcpf, "linux_style_text");
				tbairrofu = new fxTextField();
				tbairrofu.setDefaulStyle(tbairrofu, "linux_style_text");
				tenderecofu = new fxTextField();
				tenderecofu.setDefaulStyle(tenderecofu, "linux_style_text");
				testadofu = new fxTextField();
				testadofu.setDefaulStyle(testadofu, "linux_style_text");
				tcidadefu = new fxTextField();
				tcidadefu.setDefaulStyle(tcidadefu, "linux_style_text");
				tctps = new fxTextField();
				tctps.setDefaulStyle(tctps, "linux_style_text");
				tpis = new fxTextField();
				tpis.setDefaulStyle(tpis, "linux_style_text");
				tfonefu = new fxTextField();
				tfonefu.setDefaulStyle(tfonefu, "linux_style_text");
				tcep = new fxTextField();
				tcep.setDefaulStyle(tcep, "linux_style_text");
				tadmissao = new DatePicker();
			//	tadmissao.setDefaulStyle(tadmissao, "linux_style_text");
				trg = new fxTextField();
				trg.setDefaulStyle(trg, "linux_style_text");
				tnascimento = new DatePicker();
				
				
				//inicio do bloco que cria os labels para a telade cadastro de setor
				titulocadsetor = new fxLabel("Cadastro de empresa");
				titulocadsetor.setDefaulStyle(titulocadsetor,titulo_tela);
				setordescricao = new fxLabel("Descrição:");
				setoratribuicao = new fxLabel("Atrfibuições:");
				txtdescricaosetor = new fxTextField();
				textoatribuicaosetor = new fxTextField();
				;
				
				//bloco que cria os componentes na tela de edicao de setor
				
				edtsetordescricao = new fxLabel("Descrição:");
				edtsetoratribuicao = new fxLabel("Atrfibuições:");
				canceledtsetor = new fxLabel("Cancelar","Cancelar","canceledtsetor");
				cadedtsetor = new fxLabel("Cadastrar","Cadastrar","cadedtsetor");
				txteditdescricaosetor = new fxTextField();
				txteditatribuicaosetor = new fxTextField();
				List<String> prenchersugestao = new ArrayList<String>();
				ObservableList<String> listasetores = FXCollections.observableArrayList(prenchersugestao);
				sugestoessetor = new fxComboBox(listasetores);
				sugestoessetor.setDefaulStyle(sugestoessetor, "combo_box_padrao_verde");
				
				
		//fim do bloco que cria os textbox
				
				//inicio do bloco que criar as Labels para a tela de cadastro de risco
				cancelarrisco1 = new fxLabel("Cancelar","Cancelar","crisco");
				cadastrarrisco1 = new fxLabel("Cadastrar","Cadastrar","cadastrarrisco");
				cadastrarnovofator = new fxLabel("Cadastrar novo","Cadastrar novo");
				cadnofontegeradora = new fxLabel("Cadastrar nova fonte geradora","Cadastrar nova fonte geradora");
				cadnovatransmissao = new fxLabel("Cadastrar nova via de transmissao","Cadastrar nova via de transmissao");
				tipo = new fxLabel("Tipo:");
				subtipo = new fxLabel("Subtipo:");
				fatorrisco = new fxLabel("Fator de risco:");
				transmissao = new fxLabel("Transmissao:");
				descricao = new fxLabel("descrição:");
				fontegeradora = new fxLabel("Fonte geradora:");
				
				//posso colocar um arraylist dentro do observablelist
				opc = new ArrayList<String>();
				opc.add("Quimico");
				opc.add("QUEDA");
				ObservableList<String> tiposrisco = FXCollections.observableArrayList(opc);
				
				tipos = new fxComboBox(tiposrisco);
				tipos.setDefaulStyle(tipos, "combo_box_padrao_verde");
				subtipos = new fxComboBox(tiposrisco);
				subtipos.setDefaulStyle(subtipos, "combo_box_padrao_verde");
				fatoresrisco = new fxComboBox(tiposrisco);
				fatoresrisco.setDefaulStyle(fatoresrisco, "combo_box_padrao_verde");
				fontesgeradora = new fxComboBox(tiposrisco);
				fontesgeradora.setDefaulStyle(fontesgeradora, "combo_box_padrao_verde");
				viastransmissao = new fxComboBox(tiposrisco);
				viastransmissao.setDefaulStyle(viastransmissao, "combo_box_padrao_verde");
			
				cancelarsetor = new fxLabel("Cancelar","Cancelar","crsetor");
				cadastrarsetor = new fxLabel("Cadastrar","Cadastrar","cadsetor");
				cadastrarsetor.setDefaulStyle(cadastrarsetor,bt_cadcancel);
				cancelarsetor.setDefaulStyle(cancelarsetor,bt_cadcancel);
				
		//fim do bloco que cria os textbox
				
		//inicio do bloco que posiciona os elementos na tela de cadatro
				
				titulocadempresa.setLayoutXY(fundorouxoempresa.getMinWidth()+15,fundorouxoempresa.getMinHeight()+0);
				titulocadempresa.setPrefSize(350, 50);
				titulocadempresa.setPadding(new Insets(15, 0, 15, 15));
				
				cnpj.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+65);
				cnpj.setPrefSize(80, 50);
				cnpj.setPadding(new Insets(15, 0, 15, 15));
			
				rzsocial.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+120);
				rzsocial.setPrefSize(150, 50);
				rzsocial.setPadding(new Insets(15, 0, 15, 15));
				
				nmfantasia.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+175);
				nmfantasia.setPrefSize(180, 50);
				nmfantasia.setPadding(new Insets(15, 0, 15, 15));
				
				cnae1.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+225);
				cnae1.setPrefSize(180, 50);
				cnae1.setPadding(new Insets(15, 0, 15, 15));
				
				cnae2.setLayoutXY(fundorouxoempresa.getMinWidth()+435,fundorouxoempresa.getMinHeight()+225);
				cnae2.setPrefSize(190, 50);
				cnae2.setPadding(new Insets(15, 0, 15, 15));
				
				endereco.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+275);
				endereco.setPrefSize(190, 50);
				endereco.setPadding(new Insets(15, 0, 15, 15));
				
				num.setLayoutXY(fundorouxoempresa.getMinWidth()+435,fundorouxoempresa.getMinHeight()+275);
				num.setPrefSize(190, 50);
				num.setPadding(new Insets(15, 0, 15, 15));
				
				estado.setLayoutXY(fundorouxoempresa.getMinWidth()+610,fundorouxoempresa.getMinHeight()+275);
				estado.setPrefSize(150, 50);
				estado.setPadding(new Insets(15, 0, 15, 15));
				
				estados.setLayoutXY(fundorouxoempresa.getMinWidth()+698,fundorouxoempresa.getMinHeight()+285);
				estados.setPrefSize(110, 10);
				estados.setPadding(new Insets(1, 0, 1, 10));
				
				bairro.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+325);
				bairro.setPrefSize(190, 50);
				bairro.setPadding(new Insets(15, 0, 15, 15));
				
				cidade.setLayoutXY(fundorouxoempresa.getMinWidth()+435,fundorouxoempresa.getMinHeight()+325);
				cidade.setPrefSize(190, 50);
				cidade.setPadding(new Insets(15, 0, 15, 15));
				
				fone.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+375);
				fone.setPrefSize(190, 50);
				fone.setPadding(new Insets(15, 0, 15, 15));
				
				email.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+425);
				email.setPrefSize(190, 50);
				email.setPadding(new Insets(15, 0, 15, 15));
				
				senha.setLayoutXY(fundorouxoempresa.getMinWidth()+35,fundorouxoempresa.getMinHeight()+475);
				senha.setPrefSize(190, 50);
				senha.setPadding(new Insets(15, 0, 15, 15));
				
				confirmasenha.setLayoutXY(fundorouxoempresa.getMinWidth()+435,fundorouxoempresa.getMinHeight()+475);
				confirmasenha.setPrefSize(190, 50);
				confirmasenha.setPadding(new Insets(15, 0, 15, 15));
				
				
				
				cancelar.setLayoutXY(fundorouxoempresa.getMinWidth()+765,fundorouxoempresa.getMinHeight()+625);
				cancelar.setPrefSize(120, 50);
				cadastrar.setLayoutXY(fundorouxoempresa.getMinWidth()+895,fundorouxoempresa.getMinHeight()+625);
				//textomenu.setDefaulStyle(botao_bordas_brancas);
				cadastrar.setPrefSize(120, 50);
				cadastrar.setPadding(new Insets(15, 0, 15, 15));
				cancelar.setPadding(new Insets(15, 0, 15, 20));
				
				//posicionando os textbox(textFielf)
				
				tcnpj.setLayoutX(fundorouxoempresa.getMinWidth()+105);
				tcnpj.setLayoutY(fundorouxoempresa.getMinHeight()+70);
				tcnpj.setPrefSize(200, 30);
				tcnpj.setDefaulStyle(tcnpj, "linux_style_text");
				tcnpj.setPadding(new Insets(5, 0, 5, 5));
				
				
				
				trzsocial.setLayoutX(fundorouxoempresa.getMinWidth()+180);
				trzsocial.setLayoutY(fundorouxoempresa.getMinHeight()+135);
				trzsocial.setDefaulStyle(trzsocial, "linux_style_text");
				trzsocial.setPrefSize(350, 30);
				trzsocial.setPadding(new Insets(5, 0, 5, 5));
				
				tnmfantasia.setLayoutX(fundorouxoempresa.getMinWidth()+200);
				tnmfantasia.setLayoutY(fundorouxoempresa.getMinHeight()+190);
				tnmfantasia.setDefaulStyle(tnmfantasia, "linux_style_text");
				tnmfantasia.setPrefSize(330, 30);
				tnmfantasia.setPadding(new Insets(5, 0, 5, 5));
				
				tcnae1.setLayoutX(fundorouxoempresa.getMinWidth()+200);
				tcnae1.setLayoutY(fundorouxoempresa.getMinHeight()+240);
				tcnae1.setDefaulStyle(tcnae1, "linux_style_text");
				tcnae1.setPrefSize(220, 30);
				tcnae1.setPadding(new Insets(5, 0, 5, 5));
				
				tcnae2.setLayoutX(fundorouxoempresa.getMinWidth()+620);
				tcnae2.setLayoutY(fundorouxoempresa.getMinHeight()+240);
				tcnae2.setDefaulStyle(tcnae2, "linux_style_text");
				tcnae2.setPrefSize(190, 30);
				tcnae2.setPadding(new Insets(5, 0, 5, 5));
				
				tendereco.setLayoutX(fundorouxoempresa.getMinWidth()+150);
				tendereco.setLayoutY(fundorouxoempresa.getMinHeight()+290);
				tendereco.setDefaulStyle(tendereco, "linux_style_text");
				tendereco.setPrefSize(270, 30);
				tendereco.setPadding(new Insets(5, 0, 5, 5));
				
				tnum.setLayoutX(fundorouxoempresa.getMinWidth()+540);
				tnum.setLayoutY(fundorouxoempresa.getMinHeight()+290);
				tnum.setDefaulStyle(tnum, "linux_style_text");
				tnum.setPrefSize(75, 30);
				tnum.setPadding(new Insets(5, 0, 5, 5));
				
				tbairro.setLayoutX(fundorouxoempresa.getMinWidth()+120);
				tbairro.setLayoutY(fundorouxoempresa.getMinHeight()+340);
				tbairro.setDefaulStyle(tbairro, "linux_style_text");
				tbairro.setPrefSize(300, 30);
				tbairro.setPadding(new Insets(5, 0, 5, 5));
				
				tcidade.setLayoutX(fundorouxoempresa.getMinWidth()+535);
				tcidade.setLayoutY(fundorouxoempresa.getMinHeight()+340);
				tcidade.setDefaulStyle(tcidade, "linux_style_text");
				tcidade.setPrefSize(270, 30);
				tcidade.setPadding(new Insets(5, 0, 5, 5));
				
				tfone.setLayoutX(fundorouxoempresa.getMinWidth()+145);
				tfone.setLayoutY(fundorouxoempresa.getMinHeight()+390);
				tfone.setDefaulStyle(tfone, "linux_style_text");
				tfone.setPrefSize(275, 30);
				tfone.setPadding(new Insets(5, 0, 5, 5));
				
				temail.setLayoutX(fundorouxoempresa.getMinWidth()+125);
				temail.setLayoutY(fundorouxoempresa.getMinHeight()+440);
				temail.setDefaulStyle(temail, "linux_style_text");
				temail.setPrefSize(295, 30);
				temail.setPadding(new Insets(5, 0, 5, 5));
				
				tsenha.setLayoutX(fundorouxoempresa.getMinWidth()+125);
				tsenha.setLayoutY(fundorouxoempresa.getMinHeight()+490);
				tsenha.setDefaulStyle(tsenha, "linux_style_text");
				tsenha.setPrefSize(295, 30);
				tsenha.setPadding(new Insets(5, 0, 5, 5));
				
				tconfirmasenha.setLayoutX(fundorouxoempresa.getMinWidth()+550);
				tconfirmasenha.setLayoutY(fundorouxoempresa.getMinHeight()+490);
				tconfirmasenha.setDefaulStyle(tconfirmasenha, "linux_style_text");
				tconfirmasenha.setPrefSize(255, 30);
				tconfirmasenha.setPadding(new Insets(5, 0, 5, 5));
				
				//trecho que posiciona os itens no cadastro de funcionarios
				
				
				
		//fim do bloco da tela de cadastro de empresa(que posiciona os elementos na tela
			
				//posiciona os componentes na tela de cadastro de setor
				
				titulocadsetor.setLayoutXY(fundorouxosetor.getMinWidth()+15,fundorouxosetor.getMinHeight()+0);
				titulocadsetor.setPrefSize(400, 50);
				titulocadsetor.setPadding(new Insets(15, 0, 15, 15));
				
				setoratribuicao.setLayoutXY(fundorouxosetor.getMinWidth()+765,fundorouxosetor.getMinHeight()+625);
				setoratribuicao.setPrefSize(90, 50);
				setoratribuicao.setPadding(new Insets(15, 0, 15, 15));
				setordescricao.setLayoutXY(fundorouxosetor.getMinWidth()+765,fundorouxosetor.getMinHeight()+625);
				setordescricao.setPrefSize(120, 50);
				setordescricao.setPadding(new Insets(15, 0, 15, 15));
				
				setordescricao.setLayoutXY(fundorouxosetor.getMinWidth()+35,fundorouxosetor.getMinHeight()+80);
				setordescricao.setPrefSize(150, 50);
				setordescricao.setPadding(new Insets(15, 0, 15, 15));
				
				txtdescricaosetor.setLayoutXY(fundorouxosetor.getMinWidth()+35,fundorouxosetor.getMinHeight()+135);
				txtdescricaosetor.setPrefSize(500, 30);
				txtdescricaosetor.setPadding(new Insets(12, 0, 12, 12));
				textoatribuicaosetor.setPromptText("descriçao das funções a atribuições deste setor");
				
				
				setoratribuicao.setLayoutXY(fundorouxosetor.getMinWidth()+35,fundorouxosetor.getMinHeight()+190);
				setoratribuicao.setPrefSize(160, 50);
				setoratribuicao.setPadding(new Insets(15, 0, 15, 15));
				
				textoatribuicaosetor.setLayoutXY(fundorouxosetor.getMinWidth()+35,fundorouxosetor.getMinHeight()+245);
				textoatribuicaosetor.setPrefSize(500, 30);
				textoatribuicaosetor.setPadding(new Insets(12, 0, 12, 12));
				
				sugestoessetor.setLayoutXY(fundorouxosetor.getMinWidth()+600,fundorouxosetor.getMinHeight()+135);
				sugestoessetor.setPrefSize(350, 30);
				sugestoessetor.setPadding(new Insets(5, 0, 5, 5));
				
				//posiciona os componentes na tela de cadastro de funcionarios
				
				titulocadfuncionario.setLayoutXY(fundorouxofuncionario.getMinWidth()+15,fundorouxofuncionario.getMinHeight()+0);
				titulocadfuncionario.setPrefSize(450, 30);
				titulocadfuncionario.setPadding(new Insets(15, 0, 15, 20));
				
				nome.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+100);
				nome.setPrefSize(120, 50);
				nome.setPadding(new Insets(15, 0, 15, 20));
				
				tnome.setLayoutXY(fundorouxofuncionario.getMinWidth()+155,fundorouxofuncionario.getMinHeight()+100);
				tnome.setPrefSize(250, 30);
				tnome.setPadding(new Insets(5, 0, 5, 5));
				
				cpf.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+150);
				cpf.setPrefSize(120, 50);
				cpf.setPadding(new Insets(15, 0, 15, 20));
				
				tcpf.setLayoutXY(fundorouxofuncionario.getMinWidth()+155,fundorouxofuncionario.getMinHeight()+150);
				tcpf.setPrefSize(250, 30);
				tcpf.setPadding(new Insets(5, 0, 5, 5));
				
				rg.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+200);
				rg.setPrefSize(120, 50);
				rg.setPadding(new Insets(15, 0, 15, 20));
				
				trg.setLayoutXY(fundorouxofuncionario.getMinWidth()+155,fundorouxofuncionario.getMinHeight()+200);
				trg.setPrefSize(250, 30);
				trg.setPadding(new Insets(5, 0, 5, 5));
				
				pis.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+250);
				pis.setPrefSize(120, 50);
				pis.setPadding(new Insets(15, 0, 15, 20));
				
				tpis.setLayoutXY(fundorouxofuncionario.getMinWidth()+155,fundorouxofuncionario.getMinHeight()+250);
				tpis.setPrefSize(250, 30);
				tpis.setPadding(new Insets(5, 0, 5, 5));
				
				admissao.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+300);
				admissao.setPrefSize(170, 50);
				admissao.setPadding(new Insets(15, 0, 15, 20));
				
				tadmissao.setLayoutX(fundorouxofuncionario.getMinWidth()+200);
				tadmissao.setLayoutY(fundorouxofuncionario.getMinHeight()+300);
				tadmissao.setPrefSize(200, 30);
				tadmissao.setPadding(new Insets(5, 0, 5, 5));
				
				nascimento.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+350);
				nascimento.setPrefSize(170, 50);
				nascimento.setPadding(new Insets(15, 0, 15, 20));
				
				tnascimento.setLayoutX(fundorouxofuncionario.getMinWidth()+200);
				tnascimento.setLayoutY(fundorouxofuncionario.getMinHeight()+350);
				tnascimento.setPrefSize(200, 30);
				tnascimento.setPadding(new Insets(5, 0, 5, 5));
				
				ctps.setLayoutXY(fundorouxofuncionario.getMinWidth()+400,fundorouxofuncionario.getMinHeight()+250);
				ctps.setPrefSize(120, 50);
				ctps.setPadding(new Insets(15, 0, 15, 20));
				
				tctps.setLayoutXY(fundorouxofuncionario.getMinWidth()+500,fundorouxofuncionario.getMinHeight()+250);
				tctps.setPrefSize(350, 30);
				tctps.setPadding(new Insets(5, 0, 5, 5));
				
				cidadefu.setLayoutXY(fundorouxofuncionario.getMinWidth()+400,fundorouxofuncionario.getMinHeight()+400);
				cidadefu.setPrefSize(120, 50);
				cidadefu.setPadding(new Insets(15, 0, 15, 20));
				
				tcidadefu.setLayoutXY(fundorouxofuncionario.getMinWidth()+500,fundorouxofuncionario.getMinHeight()+400);
				tcidadefu.setPrefSize(250, 30);
				tcidadefu.setPadding(new Insets(5, 0, 5, 5));
				
				estadofu.setLayoutXY(fundorouxofuncionario.getMinWidth()+755,fundorouxofuncionario.getMinHeight()+400);
				estadofu.setPrefSize(120, 50);
				estadofu.setPadding(new Insets(15, 0, 15, 20));
				
				
				
				bairrofu.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+400);
				bairrofu.setPrefSize(120, 50);
				bairrofu.setPadding(new Insets(15, 0, 15, 20));
				
				tbairrofu.setLayoutXY(fundorouxofuncionario.getMinWidth()+155,fundorouxofuncionario.getMinHeight()+400);
				tbairrofu.setPrefSize(250, 30);
				tbairrofu.setPadding(new Insets(5, 0, 5, 5));
				
				cep.setLayoutXY(fundorouxofuncionario.getMinWidth()+400,fundorouxofuncionario.getMinHeight()+450);
				cep.setPrefSize(120, 50);
				cep.setPadding(new Insets(15, 0, 15, 20));
				
				tcep.setLayoutXY(fundorouxofuncionario.getMinWidth()+500,fundorouxofuncionario.getMinHeight()+450);
				tcep.setPrefSize(250, 30);
				tcep.setPadding(new Insets(5, 0, 5, 5));
				
				estadosfu.setLayoutXY(fundorouxofuncionario.getMinWidth()+855,fundorouxofuncionario.getMinHeight()+400);
				estadosfu.setPrefSize(120, 30);
				estadosfu.setDefaulStyle(estadosfu, "combo_box_padrao_verde");
				estadosfu.setPadding(new Insets(5, 0, 5, 5));
				
				enderecofu.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+450);
				enderecofu.setPrefSize(120, 30);
				enderecofu.setPadding(new Insets(15, 0, 15, 20));
				
				tenderecofu.setLayoutXY(fundorouxofuncionario.getMinWidth()+155,fundorouxofuncionario.getMinHeight()+450);
				tenderecofu.setPrefSize(250, 30);
				tenderecofu.setPadding(new Insets(5, 0, 5, 5));
				
				fonefu.setLayoutXY(fundorouxofuncionario.getMinWidth()+35,fundorouxofuncionario.getMinHeight()+500);
				fonefu.setPrefSize(120, 50);
				fonefu.setPadding(new Insets(15, 0, 15, 20));
				
				tfonefu.setLayoutXY(fundorouxofuncionario.getMinWidth()+155,fundorouxofuncionario.getMinHeight()+500);
				tfonefu.setPrefSize(250, 30);
				tfonefu.setPadding(new Insets(5, 0, 5, 5));
				
				
				
				cancelarfuncionario.setLayoutXY(fundorouxofuncionario.getMinWidth()+765,fundorouxofuncionario.getMinHeight()+625);
				cancelarfuncionario.setPrefSize(120, 50);
				cancelarfuncionario.setPadding(new Insets(15, 0, 15, 20));
				cadastrarfuncionario.setLayoutXY(fundorouxofuncionario.getMinWidth()+895,fundorouxofuncionario.getMinHeight()+625);
				cadastrarfuncionario.setPrefSize(120, 50);
				cadastrarfuncionario.setPadding(new Insets(15, 0, 15, 15));
				cancelarfuncionario.setDefaulStyle(cancelarfuncionario,bt_cadcancel);
				cadastrarfuncionario.setDefaulStyle(cadastrarfuncionario,bt_cadcancel);
				
				
				//posiciona elementos na tela de cadastro de riscos
				
				tipo.setLayoutXY(fundorouxorisco.getMinWidth()+35,fundorouxorisco.getMinHeight()+45);
				tipo.setPrefSize(130, 50);
				tipo.setPadding(new Insets(15, 0, 15, 15));
				
				tipos.setLayoutX(fundorouxorisco.getMinWidth()+265);
				tipos.setLayoutY(fundorouxorisco.getMinHeight()+50);
				tipos.setPrefSize(210, 25);
				tipos.setPadding(new Insets(5, 0, 5, 5));
				
				subtipos.setLayoutX(fundorouxorisco.getMinWidth()+265);
				subtipos.setLayoutY(fundorouxorisco.getMinHeight()+115);
				subtipos.setPrefSize(210, 25);
				subtipos.setPadding(new Insets(5, 0, 5, 5));
				
				fatoresrisco.setLayoutX(fundorouxorisco.getMinWidth()+265);
				fatoresrisco.setLayoutY(fundorouxorisco.getMinHeight()+180);
				fatoresrisco.setPrefSize(210, 25);
				fatoresrisco.setPadding(new Insets(5, 0, 5, 5));
				
				fontesgeradora.setLayoutX(fundorouxorisco.getMinWidth()+265);
				fontesgeradora.setLayoutY(fundorouxorisco.getMinHeight()+245);
				fontesgeradora.setPrefSize(210, 25);
				fontesgeradora.setPadding(new Insets(5, 0, 5, 5));
				
				viastransmissao.setLayoutX(fundorouxorisco.getMinWidth()+265);
				viastransmissao.setLayoutY(fundorouxorisco.getMinHeight()+310);
				viastransmissao.setPrefSize(210, 25);
				viastransmissao.setPadding(new Insets(5, 0, 5, 5));
				
				subtipo.setLayoutXY(fundorouxorisco.getMinWidth()+35,fundorouxorisco.getMinHeight()+105);
				subtipo.setPrefSize(220, 50);
				subtipo.setPadding(new Insets(15, 0, 15, 15));
				
				fatorrisco.setLayoutXY(fundorouxorisco.getMinWidth()+35,fundorouxorisco.getMinHeight()+170);
				fatorrisco.setPrefSize(220, 50);
				fatorrisco.setPadding(new Insets(15, 0, 15, 15));
				
				fontegeradora.setLayoutXY(fundorouxorisco.getMinWidth()+35,fundorouxorisco.getMinHeight()+235);
				fontegeradora.setPrefSize(220, 50);
				fontegeradora.setPadding(new Insets(15, 0, 15, 15));
				
				transmissao.setLayoutXY(fundorouxorisco.getMinWidth()+35,fundorouxorisco.getMinHeight()+300);
				transmissao.setPrefSize(220, 50);
				transmissao.setPadding(new Insets(15, 0, 15, 15));
				
				cadastrarnovofator.setLayoutXY(fundorouxorisco.getMinWidth()+480,fundorouxorisco.getMinHeight()+180);
				cadastrarnovofator.setPrefSize(430, 40);
				cadastrarnovofator.setPadding(new Insets(12, 0, 12, 12));
				
				cadnofontegeradora.setLayoutXY(fundorouxorisco.getMinWidth()+480,fundorouxorisco.getMinHeight()+245);
				cadnofontegeradora.setPrefSize(430, 40);
				cadnofontegeradora.setPadding(new Insets(12, 0, 12, 12));
				
				cadnovatransmissao.setLayoutXY(fundorouxorisco.getMinWidth()+480,fundorouxorisco.getMinHeight()+310);
				cadnovatransmissao.setPrefSize(430, 40);
				cadnovatransmissao.setPadding(new Insets(12, 0, 12, 12));
				
				cancelarrisco1.setLayoutXY(fundorouxorisco.getMinWidth()+765,fundorouxorisco.getMinHeight()+625);
				cancelarrisco1.setPrefSize(120, 50);
				cadastrarrisco1.setLayoutXY(fundorouxorisco.getMinWidth()+895,fundorouxorisco.getMinHeight()+625);
				cadastrarrisco1.setPrefSize(120, 50);
				cadastrarrisco1.setPadding(new Insets(15, 0, 15, 15));
				cancelarrisco1.setPadding(new Insets(15, 0, 15, 20));
				
				cancelarsetor.setLayoutXY(fundorouxosetor.getMinWidth()+765,fundorouxosetor.getMinHeight()+625);
				cancelarsetor.setPrefSize(120, 50);
				cadastrarsetor.setLayoutXY(fundorouxosetor.getMinWidth()+895,fundorouxosetor.getMinHeight()+625);
				cadastrarsetor.setPrefSize(120, 50);
				cadastrarsetor.setPadding(new Insets(15, 0, 15, 15));
				cancelarsetor.setPadding(new Insets(15, 0, 15, 20));
				
				canceledtsetor.setLayoutXY(fundorouxoeditarsetor.getMinWidth()+765,fundorouxoeditarsetor.getMinHeight()+625);
				canceledtsetor.setPrefSize(120, 50);
				cadedtsetor.setLayoutXY(fundorouxoeditarsetor.getMinWidth()+895,fundorouxoeditarsetor.getMinHeight()+625);
				cadedtsetor.setPrefSize(120, 50);
				cadedtsetor.setPadding(new Insets(15, 0, 15, 15));
				canceledtsetor.setPadding(new Insets(15, 0, 15, 20));
				
				
				
				//componentes da tela de edicao de setor
				
				txteditatribuicaosetor.setLayoutXY(fundorouxoeditarsetor.getMinWidth()+35,fundorouxoeditarsetor.getMinHeight()+430);
				txteditatribuicaosetor.setPrefSize(965, 30);
				txteditatribuicaosetor.setPadding(new Insets(12, 0, 12, 12));
				txteditatribuicaosetor.setPromptText("descriçao das funções a atribuições deste setor");
				
				edtsetoratribuicao.setLayoutXY(fundorouxoeditarsetor.getMinWidth()+35,fundorouxoeditarsetor.getMinHeight()+370);
				edtsetoratribuicao.setPrefSize(160, 50);
				edtsetoratribuicao.setPadding(new Insets(15, 0, 15, 15));
				
				edtsetordescricao.setLayoutXY(fundorouxoeditarsetor.getMinWidth()+35,fundorouxoeditarsetor.getMinHeight()+260);
				edtsetordescricao.setPrefSize(150, 50);
				edtsetordescricao.setPadding(new Insets(15, 0, 15, 15));
				
				txteditdescricaosetor.setLayoutXY(fundorouxosetor.getMinWidth()+35,fundorouxosetor.getMinHeight()+310);
				txteditdescricaosetor.setPrefSize(965, 30);
				txteditdescricaosetor.setPadding(new Insets(12, 0, 12, 12));
				
				
				coluna = new TableColumn<>("codigo");
				TableColumn<Setor,String> coluna2 = new TableColumn<>("descrição");
				TableColumn<Setor,String> coluna3 = new TableColumn<>("Atribuições");
				tbeditsetor.setLayoutX(fundorouxoeditarsetor.getMinWidth()+35);
				tbeditsetor.setLayoutY(fundorouxoeditarsetor.getMinHeight()+70);
				tbeditsetor.setPrefWidth(965);
				tbeditsetor.setPrefHeight(200);
				coluna.setMinWidth(320);
				coluna.setMaxWidth(320);
				coluna2.setMinWidth(320);
				coluna2.setMaxWidth(320);
				coluna3.setMinWidth(325);
				coluna3.setMaxWidth(325);
				tbeditsetor.setPadding(new Insets(0, 0, 0, 0));
				
				
				
				
				
				
				List<Setor> setores = new ArrayList<Setor>();
				setores.add(
						new Setor(1,"RH","Recursos humanos")
						);
				setores.add(
						new Setor(1,"RH kkjkl","Recursos humanos klkjlk")
						);
				
				 tbeditsetor.setItems(FXCollections.observableArrayList(setores));
			//	coluna.setCellValueFactory(new PropertyValueFactory<>("codigo"));
				//coluna.getCellData("hgh");
				coluna.setCellValueFactory(new PropertyValueFactory<>("codigo"));
				coluna2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
				coluna3.setCellValueFactory(new PropertyValueFactory<>("atribuicao"));
				
				
				tbeditsetor.setEditable(false);
				//tbeditsetor.setAccessibleText("textoacessivek");
				//o argumento do ct tem de ser um objeto do setor
				//ObservableList<String> ct = ;
				
				 tbeditsetor.getColumns().addAll(coluna,coluna2,coluna3);
				 
				 tbeditsetor.setOnMouseClicked(new EventHandler<MouseEvent>(){

					

					@Override
					public void handle(MouseEvent arg0) {
						// TODO Auto-generated method stub
						//JOptionPane.showMessageDialog(null, coluna.getCellData((int) arg0.getX()));
						txteditdescricaosetor.setText(tbeditsetor.getSelectionModel().getSelectedItem().getDescricao());
						txteditatribuicaosetor.setText(tbeditsetor.getSelectionModel().getSelectedItem().getAtribuicao());
						System.out.println(tbeditsetor.getSelectionModel().getSelectedItem().getCodigo());
					
						
						
					}

				
					 
				 });
				
				
				 
				 
		textomenu = new fxLabel("Empresa","Empresa");
		
		
		//textomenu.getStyleClass().addAll("texto_vermelho");
		textomenu.setDefaulStyle(textomenu,botao_bordas_brancas);
		textomenu.setLayoutX(5);
		textomenu.setLayoutY(5);
		textomenu.setPrefWidth(285);
		textomenu.setPrefHeight(75);
		
		//menu do item empresa
		txtempresa1 = new fxLabel("Cadastrar Empresa","Cadastrar Empresa");
		txtempresa2 = new fxLabel("Apagar Empresa","Apagar Empresa");
		txtempresa3 = new fxLabel("Editar Empresa","Editar Empresa");
		txtempresa4 = new fxLabel("Adicionar à Empresa","Adicionar à Empresa");
		txtempresa5 = new fxLabel("Pesquisar Empresas","Pesquisar Empresas");
		txtempresa6 = new fxLabel("Resumo","Resumo");
		
		//2 item do menu
		textomenu2 = new fxLabel("Funcionarios","Funcionarios");
		textomenu2.setDefaulStyle(textomenu2,botao_bordas_brancas);
		textomenu2.setLayoutX(5);
		textomenu2.setLayoutY(83);
		textomenu2.setPrefWidth(285);
		textomenu2.setPrefHeight(50);
		
		//menu do item funcionarios
		txtfuncionario1 = new fxLabel("Cadastrar Funcionarios","Cadastrar Funcionarios");
		txtfuncionario2 = new fxLabel("Editar Funcionario","Editar Funcionario");
		txtfuncionario3 = new fxLabel("Vincular a um Setor","Vincular a um Setor");
		txtfuncionario4 = new fxLabel("Adicionar ipi","Adicionar ipi");
		txtfuncionario5 = new fxLabel("Pesquisar Funcionarios","Pesquisar Funcionarios");
		//txtempresa6 = new fxLabel("Resumo","Resumo");
		
		//menu do item cargos
		txtcargo1 = new fxLabel("Cadastrar Cargos","Cadastrar Cargos");
		txtcargo2 = new fxLabel("Editar Cargo","Editar Cargo");
		txtcargo3 = new fxLabel("Vincular a um Funcionario","Vincular a um Funcionario");
		txtcargo4 = new fxLabel("Cadastrar Cbo","Cadastrar Cbo");
		txtcargo5 = new fxLabel("Editar Cbo","Editar Cbo");
		
		
		//3 item do menu
		textomenu3 = new fxLabel("Cargos","Cargos");
		textomenu3.setDefaulStyle(textomenu3,botao_bordas_brancas);
		textomenu3.setLayoutX(5);
		textomenu3.setLayoutY(158);
		textomenu3.setPrefWidth(285);
		textomenu3.setPrefHeight(50);
		//AddCSS(textomenu,"padding_texto_padrao");
		//textomenu.setAlignment(Pos.CENTER);
		
		//4 item menu
		textomenu4 = new fxLabel("Setores","Setores");
		textomenu4.setDefaulStyle(textomenu4,botao_bordas_brancas);
		textomenu4.setLayoutX(5);
		textomenu4.setLayoutY(233);
		textomenu4.setPrefWidth(285);
		textomenu4.setPrefHeight(50);
		
		//menu do item setores
		txtsetor1 = new fxLabel("Cadastrar Setor","Cadastrar Setor");
		txtsetor2 = new fxLabel("Editar Setor","Editar Setor");
		txtsetor3 = new fxLabel("Vincular a uma Empresa","Vincular a uma Empresa");
		txtsetor4 = new fxLabel("Pesquisar Setor","Pesquisar Setor");
		txtsetor5 = new fxLabel("Cadastrar Ambiente ao setor","cadastrar");
		
		//5 item menu
		textomenu5 = new fxLabel("Riscos","Riscos");
		textomenu5.setDefaulStyle(textomenu5,botao_bordas_brancas);
		textomenu5.setLayoutX(5);
		textomenu5.setLayoutY(308);
		textomenu5.setPrefWidth(285);
		textomenu5.setPrefHeight(50);
		
		txtrisco1 = new fxLabel("Cadastrar Risco","Cadastrar Risco");
		txtrisco2 = new fxLabel("Editar Risco","Editar Risco");
		txtrisco3 = new fxLabel("Vincular a um Setor","Vincular a um Setor");
		txtrisco4 = new fxLabel("Pesquisar Risco","Pesquisar Risco");
		txtrisco5 = new fxLabel("Resumo","Resumo");
		
		//6 item menu
		textomenu6 = new fxLabel("Ipi","Ipi");
		textomenu6.setDefaulStyle(textomenu6,botao_bordas_brancas);
		textomenu6.setLayoutX(5);
		textomenu6.setLayoutY(383);
		textomenu6.setPrefWidth(285);
		textomenu6.setPrefHeight(50);
		
		txtipi1 = new fxLabel("Cadastrar Ipi","Cadastrar Ipi");
		txtipi2 = new fxLabel("Editar Ipi","Editar Ipi");
		txtipi3 = new fxLabel("Apagar Ipi","Apagar Ipi");
		txtipi4 = new fxLabel("Vincular a um Setor","Vincular a um Setor");
		txtipi5 = new fxLabel("Pesquisar Ipi","Pesquisar Ipi");
		
		//7 item menu
		textomenu7 = new fxLabel("Ppra","Ppra");
		textomenu7.setDefaulStyle(textomenu7,"btn_menu_principal");
		textomenu7.setLayoutX(5);
		textomenu7.setLayoutY(459);
		textomenu7.setPrefWidth(285);
		textomenu7.setPrefHeight(50);
		
		txtppra1 = new fxLabel("Cadastrar Ppra(semi-automatico)","Cadastrar Ppra(semi-automatico)");
		txtppra2 = new fxLabel("Cadastrar Ppra(manual)","Cadastrar Ppra(manual)");
		txtppra3 = new fxLabel("Pesquisar Ppra","Pesquisar Ppra");
		txtppra4 = new fxLabel("Resumo","Resumo");
		
		
	
		
		//8 item menu
		textomenu8 = new fxLabel("Ltcat","Ltcat");
		textomenu8.setDefaulStyle(textomenu8,"btn_menu_principal");
		textomenu8.setLayoutX(5);
		textomenu8.setLayoutY(535);
		textomenu8.setPrefWidth(285);
		textomenu8.setPrefHeight(50);
		
		//9 item menu
		textomenu9 = new fxLabel("Usuarios","Usuarios");
		textomenu9.setDefaulStyle(textomenu9,"btn_menu_principal");
		textomenu9.setLayoutX(5);
		textomenu9.setLayoutY(610);
		textomenu9.setPrefWidth(285);
		textomenu9.setPrefHeight(50);
		
		txtempresa1.setPrefSize(450, 90);
		txtempresa2.setPrefSize(450, 90);
		txtempresa3.setPrefSize(450, 90);
		txtempresa4.setPrefSize(450, 90);
		txtempresa5.setPrefSize(450, 90);
		txtempresa6.setPrefSize(450, 90);
		
		
		//CRIA OS BOTOES DOS FUNCIONARIOS
		
		txtfuncionario1.setPrefSize(450, 105);
		txtfuncionario2.setPrefSize(450, 105);
		txtfuncionario3.setPrefSize(450, 105);
		txtfuncionario4.setPrefSize(450, 105);
		txtfuncionario5.setPrefSize(450, 125);
		//txtfuncionario6.setPrefSize(450, 90);
		
		//CRIA OS BOTOES DOS CARGOS
		
				txtcargo1.setPrefSize(450, 105);
				txtcargo2.setPrefSize(450, 105);
				txtcargo3.setPrefSize(450, 105);
				txtcargo4.setPrefSize(450, 105);
				txtcargo5.setPrefSize(450, 125);
				//txtfuncionario6.setPrefSize(450, 90);
				
				//CRIA OS BOTOES DOS SETORES
				
				txtsetor1.setPrefSize(450, 105);
				txtsetor2.setPrefSize(450, 105);
				txtsetor3.setPrefSize(450, 105);
				txtsetor4.setPrefSize(450, 105);
				txtsetor5.setPrefSize(450, 125);
				
				//CRIA OS BOTOES DOS RISCOS
				
				txtrisco1.setPrefSize(450, 105);
				txtrisco2.setPrefSize(450, 105);
				txtrisco3.setPrefSize(450, 105);
				txtrisco4.setPrefSize(450, 105);
				txtrisco5.setPrefSize(450, 125);
				
				//CRIA OS BOTOES DOS IPI
				
				txtipi1.setPrefSize(450, 105);
				txtipi2.setPrefSize(450, 105);
				txtipi3.setPrefSize(450, 105);
				txtipi4.setPrefSize(450, 105);
				txtipi5.setPrefSize(450, 125);
				
//CRIA OS BOTOES DOS IPI
				
				txtppra1.setPrefSize(450, 140);
				txtppra2.setPrefSize(450, 140);
				txtppra3.setPrefSize(450, 140);
				txtppra4.setPrefSize(450, 130);
				
		
		
		
		//9 item menu
				textomenu10 = new fxLabel("Sair","Sair");
				textomenu10.setDefaulStyle(textomenu10,"btn_menu_principal");
				textomenu10.setLayoutX(5);
				textomenu10.setLayoutY(685);
				textomenu10.setPrefWidth(285);
				textomenu10.setPrefHeight(30);
				
				txtempresa1.setLayoutXY((subpainelcena2.getWidth()/2)+26,subpainelcena2.getMinHeight()+20);
				
				txtempresa2.setLayoutXY((subpainelcena2.getWidth()/2)+26,subpainelcena2.getMinHeight()+115);
				
				txtempresa3.setLayoutX((subpainelcena2.getWidth()/2)+26);
				txtempresa3.setLayoutY(subpainelcena2.getMinHeight()+210);
				txtempresa4.setLayoutX((subpainelcena2.getWidth()/2)+26);
				txtempresa4.setLayoutY(subpainelcena2.getMinHeight()+305);
				txtempresa5.setLayoutX((subpainelcena2.getWidth()/2)+26);
				txtempresa5.setLayoutY(subpainelcena2.getMinHeight()+400);
				txtempresa6.setLayoutX((subpainelcena2.getWidth()/2)+26);
				txtempresa6.setLayoutY(subpainelcena2.getMinHeight()+495);
				
				txtfuncionario1.setLayoutXY((subpainelcena3.getWidth()/2)+26,subpainelcena3.getMinHeight()+20);
				
				txtfuncionario2.setLayoutXY((subpainelcena3.getWidth()/2)+26,subpainelcena3.getMinHeight()+130);
				
				txtfuncionario3.setLayoutXY((subpainelcena3.getWidth()/2)+26,subpainelcena3.getMinHeight()+240);
				
				txtfuncionario4.setLayoutXY((subpainelcena3.getWidth()/2)+26,subpainelcena3.getMinHeight()+350);
				
				txtfuncionario5.setLayoutXY((subpainelcena3.getWidth()/2)+26,subpainelcena3.getMinHeight()+460);
				
txtcargo1.setLayoutXY((subpainelcena4.getWidth()/2)+26,subpainelcena4.getMinHeight()+20);
				
txtcargo2.setLayoutXY((subpainelcena4.getWidth()/2)+26,subpainelcena4.getMinHeight()+130);
				
txtcargo3.setLayoutXY((subpainelcena4.getWidth()/2)+26,subpainelcena4.getMinHeight()+240);
				
txtcargo4.setLayoutXY((subpainelcena4.getWidth()/2)+26,subpainelcena4.getMinHeight()+350);
				
txtcargo5.setLayoutXY((subpainelcena4.getWidth()/2)+26,subpainelcena4.getMinHeight()+460);


txtsetor1.setLayoutXY((subpainelcena5.getWidth()/2)+26,subpainelcena5.getMinHeight()+20);

txtsetor2.setLayoutXY((subpainelcena5.getWidth()/2)+26,subpainelcena5.getMinHeight()+130);
				
txtsetor3.setLayoutXY((subpainelcena5.getWidth()/2)+26,subpainelcena5.getMinHeight()+240);
				
txtsetor4.setLayoutXY((subpainelcena5.getWidth()/2)+26,subpainelcena5.getMinHeight()+350);
				
txtsetor5.setLayoutXY((subpainelcena5.getWidth()/2)+26,subpainelcena5.getMinHeight()+460);

txtrisco1.setLayoutXY((subpainelcena6.getWidth()/2)+26,subpainelcena6.getMinHeight()+20);

txtrisco2.setLayoutXY((subpainelcena6.getWidth()/2)+26,subpainelcena6.getMinHeight()+130);
				
txtrisco3.setLayoutXY((subpainelcena6.getWidth()/2)+26,subpainelcena6.getMinHeight()+240);
				
txtrisco4.setLayoutXY((subpainelcena6.getWidth()/2)+26,subpainelcena6.getMinHeight()+350);
				
txtrisco5.setLayoutXY((subpainelcena6.getWidth()/2)+26,subpainelcena6.getMinHeight()+460);

txtipi1.setLayoutXY((subpainelcena7.getWidth()/2)+26,subpainelcena7.getMinHeight()+20);

txtipi2.setLayoutXY((subpainelcena7.getWidth()/2)+26,subpainelcena7.getMinHeight()+130);
				
txtipi3.setLayoutXY((subpainelcena7.getWidth()/2)+26,subpainelcena7.getMinHeight()+240);
				
txtipi4.setLayoutXY((subpainelcena7.getWidth()/2)+26,subpainelcena7.getMinHeight()+350);
				
txtipi5.setLayoutXY((subpainelcena7.getWidth()/2)+26,subpainelcena7.getMinHeight()+460);

txtppra1.setLayoutXY((subpainelcena8.getWidth()/2)+26,subpainelcena8.getMinHeight()+20);

txtppra2.setLayoutXY((subpainelcena8.getWidth()/2)+26,subpainelcena8.getMinHeight()+165);
				
txtppra3.setLayoutXY((subpainelcena8.getWidth()/2)+26,subpainelcena8.getMinHeight()+310);
				
txtppra4.setLayoutXY((subpainelcena8.getWidth()/2)+26,subpainelcena8.getMinHeight()+455);
				
		//efeito hover na tela principal
		passarMouse(textomenu10);
		passarMouse(textomenu9);
		passarMouse(textomenu8);
		passarMouse(textomenu7);
		passarMouse(textomenu6);
		passarMouse(textomenu5);
		passarMouse(textomenu4);
		passarMouse(textomenu3);
		passarMouse(textomenu2);
		passarMouse(textomenu);
		
		//efeito hover no menu principal da empresa
		passarMouse(txtempresa1);
		passarMouse(txtempresa2);
		passarMouse(txtempresa3);
		passarMouse(txtempresa4);
		passarMouse(txtempresa5);
		passarMouse(txtempresa6);
		
		//efeito hover na tela de cadastro da empresa
		
		passarMouse(tconfirmasenha);
		passarMouse(temail);
		passarMouse(tcnae1);
		passarMouse(tcnae2);
		passarMouse(tendereco);
		passarMouse(tnmfantasia);
		passarMouse(tsenha);
		passarMouse(tnum);
		passarMouse(tfone);
		passarMouse(tcnpj);
		passarMouse(trzsocial);
		passarMouse(tcidade);
		passarMouse(tendereco);
		passarMouse(tbairro);
		passarMouse(cancelar);
		passarMouse(cadastrar);
		passarMouse(estados);
		passarMouse(cancelarrisco1);
		passarMouse(cadastrarrisco1);
		
		//efeito hover no menu principal do funcionario
				passarMouse(txtfuncionario1);
				passarMouse(txtfuncionario2);
				passarMouse(txtfuncionario3);
				passarMouse(txtfuncionario4);
				passarMouse(txtfuncionario5);
				
				//efeito hover no menu principal do cargo
				passarMouse(txtcargo1);
				passarMouse(txtcargo2);
				passarMouse(txtcargo3);
				passarMouse(txtcargo4);
				passarMouse(txtcargo5);
				
				//efeito hover no menu principal do setor
				passarMouse(txtsetor1);
				passarMouse(txtsetor2);
				passarMouse(txtsetor3);
				passarMouse(txtsetor4);
				passarMouse(txtsetor5);
				
				//efeito hover no menu principal do risco
				
				passarMouse(txtrisco1);
				passarMouse(txtrisco2);
				passarMouse(txtrisco3);
				passarMouse(txtrisco4);
				passarMouse(txtrisco5);
				
				//efeito hover no menu principal do ipi
				
				passarMouse(txtipi1);
				passarMouse(txtipi2);
				passarMouse(txtipi3);
				passarMouse(txtipi4);
				passarMouse(txtipi5);
				
				//efeito hover no menu principal do ppra
				
				passarMouse(txtppra1);
				passarMouse(txtppra2);
				passarMouse(txtppra3);
				passarMouse(txtppra4);
				
				//efeito hover na tela de cadastro de risco
				passarMouse(tipos);
				passarMouse(subtipos);
				passarMouse(fatoresrisco);
				passarMouse(fontesgeradora);
				passarMouse(viastransmissao);
				passarMouse(cadastrarnovofator);
				passarMouse(cadnofontegeradora);
				passarMouse(cadnovatransmissao);
				
				//efeito hover tela de cadastro de funcionario
				
				passarMouse(trg);
				passarMouse(tnome);
				passarMouse(tctps);
				passarMouse(tpis);
				passarMouse(tcep);
				passarMouse(tfonefu);
				passarMouse(tbairrofu);
				//passarMouse(tcidadefu);
				passarMouse(estadosfu);
				passarMouse(cadastrarfuncionario);
				passarMouse(cancelarfuncionario);
				
				//efeito hover tela de cadastro de setor
				passarMouse(cadastrarsetor);
				passarMouse(cancelarsetor);
				passarMouse(textoatribuicaosetor);
				passarMouse(txtdescricaosetor);
				passarMouse(cadedtsetor);
				passarMouse(canceledtsetor);
				
				//efeito hover tela de edicao de setor
				passarMouse(txteditatribuicaosetor);
				passarMouse(txteditdescricaosetor);
			
				
				
		
		//os comandos de padding naofuncionam bem por isso e mais viavel usar o setPadding direto no elemento
		textomenu.setPadding(new Insets(15, 0, 15, 10));
		textomenu2.setPadding(new Insets(15, 0, 15, 10));
		textomenu3.setPadding(new Insets(15, 0, 15, 10));
		textomenu4.setPadding(new Insets(15, 0, 15, 10));
		textomenu5.setPadding(new Insets(15, 0, 15, 10));
		textomenu6.setPadding(new Insets(15, 0, 15, 10));
		textomenu7.setPadding(new Insets(15, 0, 15, 10));
		textomenu8.setPadding(new Insets(15, 0, 15, 10));
		textomenu9.setPadding(new Insets(15, 0, 15, 10));
		textomenu10.setPadding(new Insets(10, 0, 0, 10));
		txtempresa1.setPadding(new Insets(15, 0, 15, 10));
		txtempresa2.setPadding(new Insets(15, 0, 15, 10));
		txtempresa3.setPadding(new Insets(15, 0, 15, 10));
		txtempresa4.setPadding(new Insets(15, 0, 15, 10));
		txtempresa5.setPadding(new Insets(15, 0, 15, 10));
		txtempresa6.setPadding(new Insets(15, 0, 15, 10));
		txtfuncionario1.setPadding(new Insets(15, 0, 15, 10));
		txtfuncionario2.setPadding(new Insets(15, 0, 15, 10));
		txtfuncionario3.setPadding(new Insets(15, 0, 15, 10));
		txtfuncionario4.setPadding(new Insets(15, 0, 15, 10));
		txtfuncionario5.setPadding(new Insets(15, 0, 15, 10));
		txtcargo1.setPadding(new Insets(15, 0, 15, 10));
		txtcargo2.setPadding(new Insets(15, 0, 15, 10));
		txtcargo3.setPadding(new Insets(15, 0, 15, 10));
		txtcargo4.setPadding(new Insets(15, 0, 15, 10));
		txtcargo5.setPadding(new Insets(15, 0, 15, 10));
		txtsetor1.setPadding(new Insets(15, 0, 15, 10));
		txtsetor2.setPadding(new Insets(15, 0, 15, 10));
		txtsetor3.setPadding(new Insets(15, 0, 15, 10));
		txtsetor4.setPadding(new Insets(15, 0, 15, 10));
		txtsetor5.setPadding(new Insets(15, 0, 15, 10));
		txtrisco1.setPadding(new Insets(15, 0, 15, 10));
		txtrisco2.setPadding(new Insets(15, 0, 15, 10));
		txtrisco3.setPadding(new Insets(15, 0, 15, 10));
		txtrisco4.setPadding(new Insets(15, 0, 15, 10));
		txtrisco5.setPadding(new Insets(15, 0, 15, 10));
		txtipi1.setPadding(new Insets(15, 0, 15, 10));
		txtipi2.setPadding(new Insets(15, 0, 15, 10));
		txtipi3.setPadding(new Insets(15, 0, 15, 10));
		txtipi4.setPadding(new Insets(15, 0, 15, 10));
		txtipi5.setPadding(new Insets(15, 0, 15, 10));
		txtppra1.setPadding(new Insets(15, 0, 15, 10));
		txtppra2.setPadding(new Insets(15, 0, 15, 10));
		txtppra3.setPadding(new Insets(15, 0, 15, 10));
		txtppra4.setPadding(new Insets(15, 0, 15, 10));
		
		
		
		AddCSS(pmenu_principal_lateral_esquerdo,"borda_direita");
		
		//fundo cinza do menu principal de cada item
		AddCSS(pmenu_principal_empresas,"fundo_degrade_linear_gelo");
		AddCSS(pmenu_principal_funcionarios,"fundo_degrade_linear_gelo");
		AddCSS(pmenu_principal_cargos,"fundo_degrade_linear_gelo");
		AddCSS(pmenu_principal_setores,"fundo_degrade_linear_gelo");
		AddCSS(pmenu_principal_riscos,"fundo_degrade_linear_gelo");
		AddCSS(pmenu_principal_ipi,"fundo_degrade_linear_gelo");
		AddCSS(pmenu_principal_ppra,"fundo_degrade_linear_gelo");
		
		
		
		//
		AddCSS(subpainelcena2,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(subpainelcena2,"bordas_redondas_leves");
		AddCSS(subpainelcena3,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(subpainelcena3,"bordas_redondas_leves");
		
		AddCSS(subpainelcena4,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(subpainelcena4,"bordas_redondas_leves");
		
		AddCSS(subpainelcena5,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(subpainelcena5,"bordas_redondas_leves");
		
		AddCSS(subpainelcena6,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(subpainelcena6,"bordas_redondas_leves");
		
		AddCSS(subpainelcena7,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(subpainelcena7,"bordas_redondas_leves");
		
		AddCSS(subpainelcena8,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(subpainelcena8,"bordas_redondas_leves");
		
		//inicio do bloco que faz o formatacao da tela de cadastro da empresa
		AddCSS(fundocinzaempresas,"fundo_degrade_linear_gelo");
		AddCSS(fundocinzaempresas,"bordas_redondas_leves");
		AddCSS(fundorouxoempresa,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(fundorouxoempresa,"bordas_redondas_leves");
		
		//inicio do bloco que faz o formatacao da tela de exclusao da empresa
				AddCSS(fundocinzadelempresa,"fundo_degrade_linear_gelo");
				AddCSS(fundocinzadelempresa,"bordas_redondas_leves");
				AddCSS(fundorouxodelempresa,"fundo_degrade_linear_roxo_claro_translucido");
				AddCSS(fundorouxodelempresa,"bordas_redondas_leves");
		
		
		
		//fim do bloco acima
				
				
				//inicio do bloco que faz o formatacao da tela de cadastro da funcionario
				AddCSS(fundocinzacadastrafuncionario,"fundo_degrade_linear_gelo");
				AddCSS(fundocinzacadastrafuncionario,"bordas_redondas_leves");
				AddCSS(fundocinzacadastrafuncionario,"fundo_degrade_linear_roxo_claro_translucido");
				AddCSS(fundorouxoempresa,"bordas_redondas_leves");
		
		//inicio do bloco que faz o formatacao da tela de edicao de setor
		AddCSS(fundocinzaeditarsetor,"fundo_degrade_linear_gelo");
		AddCSS(fundocinzaeditarsetor,"bordas_redondas_leves");
		AddCSS(fundorouxoeditarsetor,"fundo_degrade_linear_roxo_claro_translucido");
		AddCSS(fundorouxoeditarsetor,"bordas_redondas_leves");
		
		//inicio do bloco que faz o formatacao da tela de edicao de setor
				AddCSS(fundocinzasetor,"fundo_degrade_linear_gelo");
				AddCSS(fundocinzasetor,"bordas_redondas_leves");
				AddCSS(fundorouxosetor,"fundo_degrade_linear_roxo_claro_translucido");
				AddCSS(fundorouxosetor,"bordas_redondas_leves");
		
		//inicio do bloco que faz o formatacao da tela de cadastro de funcionario
				AddCSS(fundocinzafuncionario,"fundo_degrade_linear_gelo");
				AddCSS(fundocinzafuncionario,"bordas_redondas_leves");
				AddCSS(fundorouxofuncionario,"fundo_degrade_linear_roxo_claro_translucido");
				AddCSS(fundorouxofuncionario,"bordas_redondas_leves");
				
				
				
				//fim do bloco acima
				
				//tela de cadastro cargo
				AddCSS(fundocinzacadastracargo,"fundo_degrade_linear_gelo");
				AddCSS(fundocinzacadastracargo,"bordas_redondas_leves");
				AddCSS(fundorouxocadastracargo,"fundo_degrade_linear_roxo_claro_translucido");
				AddCSS(fundorouxocadastracargo,"bordas_redondas_leves");
				
				//inicio do bloco que faz o formatacao da tela de cadastro de risco
				AddCSS(fundocinzarisco,"fundo_degrade_linear_gelo");
				AddCSS(fundocinzarisco,"bordas_redondas_leves");
				AddCSS(fundorouxorisco,"fundo_degrade_linear_roxo_claro_translucido");
				AddCSS(fundorouxorisco,"bordas_redondas_leves");
		
		
			//formatando tela de cadastro de setor
		
		AddCSS(textoatribuicaosetor,"linux_style_text");
		AddCSS(txtdescricaosetor,"linux_style_text");

		
		AddCSS(setoratribuicao,"texto_branco");
		AddCSS(setoratribuicao,"fonte_25");
		
		AddCSS(setordescricao,"texto_branco");
		AddCSS(setordescricao,"fonte_25");
		
	
		//componentes tela de edicao de setor
		
		AddCSS(edtsetoratribuicao,"texto_branco");
		AddCSS(edtsetoratribuicao,"fonte_25");
		AddCSS(edtsetordescricao,"texto_branco");
		AddCSS(edtsetordescricao,"fonte_25");
		AddCSS(txteditatribuicaosetor,"linux_style_text");
		AddCSS(txteditdescricaosetor,"linux_style_text");
		AddCSS(canceledtsetor,"fonte_19");
		AddCSS(canceledtsetor,"texto_branco");
		AddCSS(canceledtsetor,"fundo_verde");
		AddCSS(canceledtsetor,"bordas_redondas_leves");
		
		AddCSS(cadedtsetor,"fonte_19");
		AddCSS(cadedtsetor,"texto_branco");
		AddCSS(cadedtsetor,"fundo_verde");
		AddCSS(cadedtsetor,"bordas_redondas_leves");
		
		//fiormatatndo a tela de cadastro de risco via css
		
		AddCSS(cancelarrisco1,"fonte_19");
		AddCSS(cancelarrisco1,"texto_branco");
		AddCSS(cancelarrisco1,"fundo_verde");
		AddCSS(cancelarrisco1,"bordas_redondas_leves");
		
		AddCSS(cadastrarrisco1,"fonte_19");
		AddCSS(cadastrarrisco1,"texto_branco");
		AddCSS(cadastrarrisco1,"fundo_verde");
		AddCSS(cadastrarrisco1,"bordas_redondas_leves");
		
		AddCSS(cadastrarnovofator,"fonte_19");
		AddCSS(cadastrarnovofator,"texto_branco");
		AddCSS(cadastrarnovofator,"fundo_verde");
		AddCSS(cadastrarnovofator,"bordas_redondas_leves");
		
		AddCSS(cadnofontegeradora,"fonte_19");
		AddCSS(cadnofontegeradora,"texto_branco");
		AddCSS(cadnofontegeradora,"fundo_verde");
		AddCSS(cadnofontegeradora,"bordas_redondas_leves");
		
		AddCSS(cadnovatransmissao,"fonte_19");
		AddCSS(cadnovatransmissao,"texto_branco");
		AddCSS(cadnovatransmissao,"fundo_verde");
		AddCSS(cadnovatransmissao,"bordas_redondas_leves");
		
		AddCSS(tipo,"texto_branco");
		AddCSS(tipo,"fonte_32");
		
		AddCSS(subtipo,"texto_branco");
		AddCSS(subtipo,"fonte_32");
		
		AddCSS(fatorrisco,"texto_branco");
		AddCSS(fatorrisco,"fonte_32");
		
		AddCSS(fontegeradora,"texto_branco");
		AddCSS(fontegeradora,"fonte_32");
		AddCSS(transmissao,"texto_branco");
		AddCSS(transmissao,"fonte_32");
		
		
		
		
		
		
		
		
		estados.setValue(estados.getItems().get(0));
		tipos.setValue(tipos.getItems().get(0));
		subtipos.setValue(tipos.getItems().get(0));
		fatoresrisco.setValue(tipos.getItems().get(0));
		fontesgeradora.setValue(tipos.getItems().get(0));
		viastransmissao.setValue(tipos.getItems().get(0));
		
		
		//fim do bloco acima
		
		//formatando o menu principal do cadastro de empresas via classe css
		AddCSS(txtempresa1,"btn_submenu_principal");
		AddCSS(txtempresa2,"btn_submenu_principal");
		AddCSS(txtempresa3,"btn_submenu_principal");
		AddCSS(txtempresa4,"btn_submenu_principal");
		AddCSS(txtempresa5,"btn_submenu_principal");
		AddCSS(txtempresa6,"btn_submenu_principal");
	
		//formatando o menu principal do cadastro de funcionarios via classe css
		
		AddCSS(txtfuncionario1,"btn_submenu_principal");
		AddCSS(txtfuncionario2,"btn_submenu_principal");
		AddCSS(txtfuncionario3,"btn_submenu_principal");
		AddCSS(txtfuncionario4,"btn_submenu_principal");
		AddCSS(txtfuncionario5,"btn_submenu_principal");
		
		//formatando o menu principal do cadastro de cargos via classe css
		
		AddCSS(txtcargo1,"btn_submenu_principal");
		AddCSS(txtcargo2,"btn_submenu_principal");
		AddCSS(txtcargo3,"btn_submenu_principal");
		AddCSS(txtcargo4,"btn_submenu_principal");
		AddCSS(txtcargo5,"btn_submenu_principal");
		
		//formatando o menu principal do cadastro de setores via classe css
		
				AddCSS(txtsetor1,"btn_submenu_principal");
				AddCSS(txtsetor2,"btn_submenu_principal");
				AddCSS(txtsetor3,"btn_submenu_principal");
				AddCSS(txtsetor4,"btn_submenu_principal");
				AddCSS(txtsetor5,"btn_submenu_principal");
				
				//formatando o menu principal do cadastro de riscos via classe css
				
				AddCSS(txtrisco1,"btn_submenu_principal");
				AddCSS(txtrisco2,"btn_submenu_principal");
				AddCSS(txtrisco3,"btn_submenu_principal");
				AddCSS(txtrisco4,"btn_submenu_principal");
				AddCSS(txtrisco5,"btn_submenu_principal");
				
				//formatando o menu principal do cadastro de ipi via classe css
				
				AddCSS(txtipi1,"btn_submenu_principal");
				AddCSS(txtipi2,"btn_submenu_principal");
				AddCSS(txtipi3,"btn_submenu_principal");
				AddCSS(txtipi4,"btn_submenu_principal");
				AddCSS(txtipi5,"btn_submenu_principal");
				
				//formatando o menu principal do cadastro de ppra via classe css
				
				AddCSS(txtppra1,"btn_submenu_principal");
				AddCSS(txtppra2,"btn_submenu_principal");
				AddCSS(txtppra3,"btn_submenu_principal");
				AddCSS(txtppra4,"btn_submenu_principal");
				
		
		
		
		//aloca a posicao x,y  do menu lateral esquerdo
		pmenu_principal_lateral_esquerdo.setLayoutX(0);
		pmenu_principal_lateral_esquerdo.setLayoutY(0);
		
		pmenu_principal_empresas.setLayoutX(300);
		pmenu_principal_empresas.setLayoutY(0);
		
		
		//o painel psub sempre sera o fundo cinza
		pmenu_principal_funcionarios.setLayoutX(300);
		pmenu_principal_funcionarios.setLayoutY(0);
		pmenu_principal_cargos.setLayoutX(300);
		pmenu_principal_cargos.setLayoutY(0);
		pmenu_principal_setores.setLayoutX(300);
		pmenu_principal_setores.setLayoutY(0);
		pmenu_principal_riscos.setLayoutX(300);
		pmenu_principal_riscos.setLayoutY(0);
		pmenu_principal_ipi.setLayoutX(300);
		pmenu_principal_ipi.setLayoutY(0);
		pmenu_principal_ppra.setLayoutX(300);
		pmenu_principal_ppra.setLayoutY(0);
		
		subpainelcena2.setLayoutX(275);
		subpainelcena2.setLayoutY(70);
		
		subpainelcena3.setLayoutX(275);
		subpainelcena3.setLayoutY(70);
		
		subpainelcena4.setLayoutX(275);
		subpainelcena4.setLayoutY(70);
		
		subpainelcena5.setLayoutX(275);
		subpainelcena5.setLayoutY(70);
		
		subpainelcena6.setLayoutX(275);
		subpainelcena6.setLayoutY(70);
		
		subpainelcena7.setLayoutX(275);
		subpainelcena7.setLayoutY(70);
		
		subpainelcena8.setLayoutX(275);
		subpainelcena8.setLayoutY(70);
		
		fundocinzaempresas.setLayoutX(300);
		fundocinzaempresas.setLayoutX(0);
		fundorouxoempresa.setLayoutX(15);
		fundorouxoempresa.setLayoutY(20);
		
		fundocinzadelempresa.setLayoutX(300);
		fundocinzadelempresa.setLayoutX(0);
		fundorouxodelempresa.setLayoutX(15);
		fundorouxodelempresa.setLayoutY(20);
		
		fundocinzasetor.setLayoutX(300);
		fundocinzasetor.setLayoutX(0);
		fundorouxosetor.setLayoutX(15);
		fundorouxosetor.setLayoutY(20);
		
		fundocinzaeditarsetor.setLayoutX(300);
		fundocinzaeditarsetor.setLayoutY(0);
		fundorouxoeditarsetor.setLayoutX(15);
		fundorouxoeditarsetor.setLayoutY(20);
		
		fundocinzafuncionario.setLayoutX(300);
		fundocinzafuncionario.setLayoutX(0);
		fundorouxofuncionario.setLayoutX(15);
		fundorouxofuncionario.setLayoutY(20);
		
		fundocinzarisco.setLayoutX(300);
		fundocinzarisco.setLayoutY(0);
		fundorouxorisco.setLayoutX(15);
		fundorouxorisco.setLayoutY(20);
		
		fundocinzacadastracargo.setLayoutX(300);
		fundocinzacadastracargo.setLayoutY(0);
		fundorouxocadastracargo.setLayoutX(15);
		fundorouxocadastracargo.setLayoutY(20);
		
		
		
		
		
		//adiciona os labels na subcena do menu lateral esquerdo
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu2);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu3);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu4);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu5);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu6);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu7);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu8);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu9);
		pmenu_principal_lateral_esquerdo.getChildren().add(textomenu10);
		
		//adiciona os menus do submenu da tela de cadastro de empresa
		subpainelcena2.getChildren().add(txtempresa1);
		subpainelcena2.getChildren().add(txtempresa2);
		subpainelcena2.getChildren().add(txtempresa3);
		subpainelcena2.getChildren().add(txtempresa4);
		subpainelcena2.getChildren().add(txtempresa5);
		subpainelcena2.getChildren().add(txtempresa6);
		//subpainelcena3.getChildren().add(txtempresa6);
		
		//adiciona os componentes da tela de cadastro de empresa
		fundorouxoempresa.getChildren().addAll(titulocadempresa,cancelar,cadastrar,cnpj,nmfantasia,rzsocial,cnae1,cnae2,endereco,
				num,bairro,cidade,estado,estados,fone,email,senha,confirmasenha);
	
		
		
		fundorouxoempresa.getChildren().addAll(tcnpj,tnmfantasia,trzsocial,tcnae1,tcnae2,tendereco,tnum,
				tbairro,tcidade,tfone,temail,tsenha,tconfirmasenha);
		
		fundorouxofuncionario.getChildren().addAll(nome,cpf,ctps,rg,pis,fonefu,admissao,nascimento,
				bairrofu,cep,tnome,tcpf,tctps,tpis,trg,tfonefu,tcep,tnascimento,tadmissao,
				cadastrarfuncionario,cancelarfuncionario,titulocadfuncionario,estadosfu,enderecofu,tbairrofu,tcidadefu,tenderecofu,cidadefu,estadofu);
	
		
		fundorouxosetor.getChildren().addAll(cadastrarsetor,cancelarsetor,setordescricao,setoratribuicao,
				txtdescricaosetor,textoatribuicaosetor,sugestoessetor,titulocadsetor);
		
		fundorouxoeditarsetor.getChildren().addAll(canceledtsetor,cadedtsetor,edtsetordescricao,edtsetoratribuicao,tbeditsetor,txteditdescricaosetor,txteditatribuicaosetor);
		
		//bloco que adiciona os itens na tela de cadastrfo que esta com o fundo rouxo
		//esse bloco se refere tambem a tela de cadastro de risco
		
		fundorouxorisco.getChildren().addAll(tipo,subtipo,fatorrisco,fontegeradora,transmissao,
				cancelarrisco1,cadastrarrisco1,tipos,subtipos,fatoresrisco,fontesgeradora,
				viastransmissao,cadastrarnovofator,cadnofontegeradora,cadnovatransmissao);
		
		
		//adiciona os menus do submenu da tela de cadastro de funcionarios
		subpainelcena3.getChildren().addAll(txtfuncionario1,txtfuncionario2,txtfuncionario3,
				txtfuncionario4,txtfuncionario5);
		
		//adiciona os menus do submenu da tela de cadastro de cargos
				subpainelcena4.getChildren().addAll(txtcargo1,txtcargo2,txtcargo3,txtcargo4,txtcargo5);

		
				//adiciona os menus do submenu da tela de cadastro de setores
				subpainelcena5.getChildren().add(txtsetor1);
				subpainelcena5.getChildren().add(txtsetor2);
				subpainelcena5.getChildren().add(txtsetor3);
				subpainelcena5.getChildren().add(txtsetor4);
				subpainelcena5.getChildren().add(txtsetor5);
				
				//adiciona os menus do submenu da tela de cadastro de riscos
				subpainelcena6.getChildren().addAll(txtrisco1,txtrisco2,txtrisco3,txtrisco4,txtrisco5);
				
				//adiciona os menus do submenu da tela de cadastro de ipi
				subpainelcena7.getChildren().addAll(txtipi1,txtipi2,txtipi3,txtipi4,txtipi5);

				//adiciona os menus do submenu da tela de cadastro de ppra
				subpainelcena8.getChildren().addAll(txtppra1,txtppra2,txtppra3,txtppra4);

				
		
		
		//adiciono o subpainel ao painel
		//este bloc de codigo sempre fara a insercao dos submenus principais
		
		pmenu_principal_empresas.getChildren().add(subpainelcena2);
		pmenu_principal_funcionarios.getChildren().add(subpainelcena3);
		pmenu_principal_cargos.getChildren().add(subpainelcena4);
		pmenu_principal_setores.getChildren().add(subpainelcena5);
		pmenu_principal_riscos.getChildren().add(subpainelcena6);
		pmenu_principal_ipi.getChildren().add(subpainelcena7);
		pmenu_principal_ppra.getChildren().add(subpainelcena8);
		
		//fim do bloco acima
		
		//as subcenas so serao visiveis apos um botao ser clicado
		fundocinzacadastracargo.getChildren().add(fundorouxocadastracargo);
		fundocinzaempresas.getChildren().add(fundorouxoempresa);
		fundocinzadelempresa.getChildren().add(fundorouxodelempresa);
		fundocinzafuncionario.getChildren().add(fundorouxofuncionario);
		
		fundocinzarisco.getChildren().add(fundorouxorisco);
		fundocinzasetor.getChildren().add(fundorouxosetor);
		fundocinzaeditarsetor.getChildren().add(fundorouxoeditarsetor);
		//fundocinzafuncionario.getChildren().add(fundorouxofuncionario);
		
		subcenas_menu_lateral_esquerdo = new Subcenas(pmenu_principal_lateral_esquerdo,300,900);
		subcenas_menu_lateral_esquerdo.setVisible(true);
		
		//subcena 1 corresponde ao menu principal do cadastro de empresa
		//seus componentes são o painel psubcena2
		subcenas_empresas = new Subcenas(pmenu_principal_empresas,1380,900);
		subcenas_empresas.setVisible(false);
		
		//cenacadempresa é a tela de cadastro da empresa
		cenacadempresa = new Subcenas(fundocinzaempresas,1380,900);
		cenacadempresa.setLayoutX(300);
		cenacadempresa.setLayoutY(0);
		cenacadempresa.setVisible(false);
		
		//cenacadempresa é a tela de apagar empresa
				cenadelempresa = new Subcenas(fundocinzadelempresa,1380,900);
				cenadelempresa.setLayoutX(300);
				cenadelempresa.setLayoutY(0);
				cenadelempresa.setVisible(false);
				
		//tela de cadastro de funcionario
				cenacadfuncionario = new Subcenas(fundocinzacadastrafuncionario,1380,900);
				cenacadfuncionario.setLayoutX(300);
				cenacadfuncionario.setLayoutY(0);
				cenacadfuncionario.setVisible(false);
		
		//tela de cadastro dos riscos
		cenacadrisco = new Subcenas(fundocinzarisco,1380,900);
		cenacadrisco.setLayoutX(300);
		cenacadrisco.setLayoutY(0);
		cenacadrisco.setVisible(false);
		
		cenacadsetor = new Subcenas(fundocinzasetor,1380,900);
		cenacadsetor.setLayoutX(300);
		cenacadsetor.setLayoutY(0);
		cenacadsetor.setVisible(false);
		
		//cena com o menu principal dos usuarios
		subcenas_funcionarios = new Subcenas(pmenu_principal_funcionarios,1380,900);
		subcenas_funcionarios.setVisible(false);	//menu principal cadastro de funcionaros
		
		subcenas_cargos = new Subcenas(pmenu_principal_cargos,1380,900);	//menu principal cadastro de cargos
		subcenas_cargos.setVisible(false);
		
		cenacadastrarcargo = new Subcenas(fundocinzacadastracargo,1380,900);	//menu principal cadastro de cargos
		cenacadastrarcargo.setVisible(false);
		
		subcenas_setores = new Subcenas(pmenu_principal_setores,1380,900);
		subcenas_setores.setVisible(false);
		
		cenaeditarsetor = new Subcenas(fundocinzaeditarsetor,1380,900);
		cenacadsetor.setLayoutX(300);
		cenacadsetor.setLayoutY(0);
		cenaeditarsetor.setVisible(false);
		
		subcenas_riscos = new Subcenas(pmenu_principal_riscos,1380,900);
		subcenas_riscos.setVisible(false);
		
		subcenas_ipi = new Subcenas(pmenu_principal_ipi,1380,900);
		subcenas_ipi.setVisible(false);
		
		subcenas_ppra = new Subcenas(pmenu_principal_ppra,1380,900);
		subcenas_ppra.setVisible(false);
		
		//cena da tela de cadastrfo de funcionarios
		cenacadfuncionario = new Subcenas(fundocinzafuncionario,1380,900);
		cenacadfuncionario.setLayoutX(300);
		cenacadfuncionario.setLayoutY(0);
		cenacadfuncionario.setVisible(false);
		
		
		
		
		
		clicar(textomenu);
		clicar(txtempresa1);
		clicar(cancelar);
		clicar(textomenu2);
		clicar(textomenu3);
		clicar(textomenu4);
		clicar(textomenu5);
		clicar(textomenu6);
		clicar(textomenu7);
		clicar(textomenu10);
		clicar(txtrisco1);
		clicar(cadastrarnovofator);
		clicar(cadnofontegeradora);
		clicar(cancelarrisco1);
		clicar(cadastrarrisco1);
		clicar(cadnofontegeradora);
		clicar(cadnovatransmissao);
		clicar(txtsetor1);
		clicar(txtsetor2);
		clicar(cadastrar);
		clicar(canceledtsetor);
		clicar(cadedtsetor);
		clicar(txtfuncionario1);
		clicar(cadastrarfuncionario);
		clicar(cancelarfuncionario);
		
	}
	
	
	
	//adiciona css a um elemento especifico voce pode referenciar uma classe css
	public static void AddCSS(Node e, String css){
		
	
		e.getStyleClass().add(css);
	}
	
	
	//este metodo faz o efeito hover de acordo com o item que passarmos o mouse exemplo:
	//se o item for um texto field fica de uma cor, se for um botao fica de outra cor
	public static void passarMouse(Node node){
	
		node.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				if(node instanceof fxTextField){
					FadeTransition tr = new FadeTransition(
							Duration.millis(300),node);
							tr.setFromValue(0);
							tr.setToValue(1);
							tr.play();
					node.setStyle("-fx-background-color: linear-gradient(from 10% 5% to 70% 100%, rgba(89,163,196,0.5), rgba(89,163,196,0.3) 200%);"
							+ "-fx-text-fill: rgb(255,255,255)");
					//node.setStyle("-fx-border-color : rgba(89,163,196,1);");
				}else{
					FadeTransition tr = new FadeTransition(
							Duration.millis(400),node);
							tr.setFromValue(0);
							tr.setToValue(1);
							tr.play();
					node.setStyle("-fx-background-color : rgb(89,163,196);");
				}
			}
			
		});
		node.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(node instanceof fxTextField
						//node.getClass().getName().equals("javafx.scene.control.TextField"
						){
					FadeTransition tr = new FadeTransition(
					Duration.millis(700),node);
					tr.setFromValue(0);
					tr.setToValue(1);
					tr.play();
					node.setStyle("-fx-border-color : rgba(89,0,196,0);");
				}else{
					
					node.setStyle("-fx-background-color : rgb(139,213,186);");
					
				}
				
			}
			
		});
		
		
	}
	
	public static void clicar(fxLabel node){
		
		node.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
			
				
				if(node.getObjName().equals("Empresa")){
					subcenas_empresas.setVisible(true);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_riscos.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
					cenacadfuncionario.setVisible(false);
					
				}else if(node.getObjName().equals("Cadastrar Empresa")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(true);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
					cenacadfuncionario.setVisible(false);
				}else if(node.getObjName().equals("Cadastrar Funcionarios")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
					cenacadfuncionario.setVisible(true);
					
				}else if(node.getObjName().equals("Cadastrar Setor")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(true);
					cenaeditarsetor.setVisible(false);
					cenacadfuncionario.setVisible(false);
					
				}else if(node.getObjName().equals("Editar Setor")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(true);
					cenacadfuncionario.setVisible(false);
					
				}else if(node.getObjName().equals("Cadastrar")){
					if(node.getId().equals("cadempresa")){
						try {
							
							tnum.validateNumber(tnum.getText());
							temail.validateEmail(temail.getText());
							tsenha.compareFields(tsenha, tconfirmasenha);
							MaskFieldUtil.decodefoneFields(tfone);
							
							//MaskFieldUtil.decodecnpjField(tcnpj);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
					}
					
				}else if(node.getObjName().equals("Cancelar")){
					if(node.getId().equals("cempresa")){
						tcnpj.setText("");
						trzsocial.setText(null);
						tnmfantasia.setText(null);
						tendereco.setText(null);
						tnum.setText(null);
						tcnae1.setText("");
						tcnae2.setText("");
						tsenha.setText(null);
						tfone.setText("");
						temail.setText(null);
						tcidade.setText(null);
						//testado.setText(null);
						tbairro.setText(null);
						tsenha.setText("");
						tconfirmasenha.setText("");
						subcenas_empresas.setVisible(true);
						cenacadempresa.setVisible(false);
						subcenas_riscos.setVisible(false);
						subcenas_ipi.setVisible(false);
						subcenas_ppra.setVisible(false);
						cenacadrisco.setVisible(false);	
						cenacadsetor.setVisible(false);
						cenaeditarsetor.setVisible(false);
					}if(node.getId().equals("cfuncionario")){
					
						subcenas_empresas.setVisible(false);
						cenacadempresa.setVisible(false);
						subcenas_riscos.setVisible(false);
						subcenas_ipi.setVisible(false);
						subcenas_ppra.setVisible(false);
						cenacadrisco.setVisible(false);	
						cenacadsetor.setVisible(false);
						cenaeditarsetor.setVisible(false);
						cenacadfuncionario.setVisible(false);
						subcenas_funcionarios.setVisible(true);
						
					}else if(node.getId().equals("crisco")){
						subcenas_empresas.setVisible(false);
						cenacadempresa.setVisible(false);
						subcenas_funcionarios.setVisible(false);
						subcenas_cargos.setVisible(false);
						subcenas_setores.setVisible(false);
						subcenas_ipi.setVisible(false);
						subcenas_ppra.setVisible(false);
						subcenas_riscos.setVisible(true);
						cenacadrisco.setVisible(false);
						cenacadsetor.setVisible(false);
						cenaeditarsetor.setVisible(false);
						opc.add("sdfghjkj");
					}else if(node.getId().equals("cancelarsetor")){
						subcenas_empresas.setVisible(false);
						cenacadempresa.setVisible(false);
						subcenas_funcionarios.setVisible(false);
						subcenas_cargos.setVisible(false);
						subcenas_setores.setVisible(true);
						subcenas_ipi.setVisible(false);
						subcenas_ppra.setVisible(false);
						subcenas_riscos.setVisible(false);
						cenacadrisco.setVisible(false);
						cenacadsetor.setVisible(false);
						cenaeditarsetor.setVisible(false);
						opc.add("sdfghjkj");
					}
					else if(node.getId().equals("canceledtsetor")){
						subcenas_empresas.setVisible(false);
						cenacadempresa.setVisible(false);
						subcenas_funcionarios.setVisible(false);
						subcenas_cargos.setVisible(false);
						subcenas_setores.setVisible(true);
						subcenas_ipi.setVisible(false);
						subcenas_ppra.setVisible(false);
						subcenas_riscos.setVisible(false);
						cenacadrisco.setVisible(false);
						cenacadsetor.setVisible(false);
						cenaeditarsetor.setVisible(false);
						opc.add("sdfghjkj");
					}
					
				}else if(node.getObjName().equals("Funcionarios")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_funcionarios.setVisible(true);
					subcenas_setores.setVisible(false);
					subcenas_riscos.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
				}else if(node.getObjName().equals("Cargos")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(true);
					subcenas_setores.setVisible(false);
					subcenas_riscos.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
				}else if(node.getObjName().equals("Setores")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_riscos.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					subcenas_setores.setVisible(true);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
				}else if(node.getObjName().equals("Riscos")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(false);
					subcenas_riscos.setVisible(true);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
					opc.add("sdfghjkj");
				}else if(node.getObjName().equals("Ipi")){
					
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_riscos.setVisible(false);
					subcenas_ppra.setVisible(false);
					subcenas_ipi.setVisible(true);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
					
					
				}else if(node.getObjName().equals("Cadastrar Risco")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_riscos.setVisible(false);
					subcenas_ppra.setVisible(false);
					subcenas_ipi.setVisible(false);
					cenacadrisco.setVisible(true);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
					
				}else if(node.getObjName().equals("Ppra")){
					subcenas_empresas.setVisible(false);
					cenacadempresa.setVisible(false);
					subcenas_funcionarios.setVisible(false);
					subcenas_cargos.setVisible(false);
					subcenas_setores.setVisible(false);
					subcenas_riscos.setVisible(false);
					subcenas_ipi.setVisible(false);
					subcenas_ppra.setVisible(true);
					cenacadrisco.setVisible(false);
					cenacadsetor.setVisible(false);
					cenaeditarsetor.setVisible(false);
					
				}else if(node.getObjName().equals("Cadastrar novo")){
					
					TextInputDialog tinput = new TextInputDialog();
					tinput.setTitle("Cadastrar nova fonte geradora");
					tinput.setHeaderText("Cadastrar nova fonte geradora");
					tinput.setContentText("Digite uma descrição para a nova fonte geradora");
					
					tinput.showAndWait().ifPresent(v-> retorno = v);
					
						try {
							validateText(retorno,cadastrarnovofator);
								
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					
					
					
					
					
					
					
				}else if(node.getObjName().equals("Cadastrar nova fonte geradora")){
					
					TextInputDialog tinput = new TextInputDialog();
					tinput.setTitle("Cadastrar nova fonte geradora");
					tinput.setHeaderText("Cadastrar nova fonte geradora");
					tinput.setContentText("Digite uma descrição para a nova fonte geradora");
					
					tinput.showAndWait().ifPresent(v-> retorno = v);
					
						try {
							validateText(retorno,cadnofontegeradora);
								
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					
	
				}else if(node.getObjName().equals("Cadastrar nova via de transmissao")){
					
					TextInputDialog tinput = new TextInputDialog();
					tinput.setTitle("Cadastrar nova via de transmissao");
					tinput.setHeaderText("Cadastrar nova via de transmissao");
					tinput.setContentText("Digite uma descrição para a nova via de transmissao");
					
					tinput.showAndWait().ifPresent(v-> retorno = v);
					
						try {
							validateText(retorno,cadnovatransmissao);
								
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
				}else if(node.getObjName().equals("Sair")){
					Alert saida = new Alert(AlertType.CONFIRMATION);
					ButtonType btsair = new ButtonType("Sair");
					ButtonType btcancel = new ButtonType("Cancelar");
					saida.getButtonTypes().setAll(btsair,btcancel);
					saida.setX(570);
					saida.setY(250);
					
					saida.setResizable(false);
					
					saida.setTitle("Encerrar programa");
					saida.setHeaderText("Tem certeza?");
					saida.setContentText("Ao encerrar este programa todas as alterações nao concluidas serao encerradas!");
					saida.showAndWait().ifPresent(b->{
						if(b==btsair){
							System.exit(0);
						}else if(b == btcancel){
							saida.close();
							
						}
					});
					
				
				}
			}
			
		});
	}
	
	//esse metodo garante a validacao do campo de texto sendo preenchido somente por letras
	public static boolean validateText(String retorno, fxLabel node) throws Exception{
		String[] vetor = {"!","?","°","/",";",".",",",
				":",">","<","~","´","`","*","&","¨","%","$","#","@","à","è","ì","ù","ò","á","á",
				"é","í","ó","ú","1","2","3","4","5","6","7","8","9"}; 
		
	//	for(int i= 0;i<=vetor.length;i++){
	//		if(retorno.contains(vetor[i]) || retorno.startsWith(" ") || retorno.startsWith(vetor[i])){
	//			throw new Exception("Erro de validacao");
	//		}
	//	}
		if(retorno.matches("[0-9]+{1,}+[A-Za-z]+{1,}") || retorno.matches("[0-9]+{1,}+[A-Za-z]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}")
				|| retorno.matches("[0-9]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[A-Za-z]+{1,}")
				|| retorno.matches("[A-Za-z]+{1,}+[0-9]+{1,}") || retorno.matches("[A-Za-z]+{1,}+[0-9]+{1,}+[A-Za-z]+{1,}") || retorno.matches("[A-Za-z]+{1,}+[0-9]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}")
				|| retorno.matches("[A-Za-z]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[0-9]+{1,}")
				|| retorno.matches("[A-Za-z]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[A-Za-z]+{1,}")
				|| retorno.matches("[A-Za-z]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[A-Za-z]+{1,}+[0-9]+{1,}")
				|| retorno.matches("[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[0-9]+{1,}+[A-Za-z]+{1,}")
				|| retorno.matches("[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[A-Za-z]+{1,}+[0-9]+{1,}")
				|| retorno.matches("[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[A-Za-z]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}+[A-Za-z]+{1,}")
				|| retorno.substring(0, 1).matches("[0-9]+{1,}") || retorno.substring(0, 1).matches("[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú]+{1,}") || retorno.startsWith(" ")
				|| retorno.matches("[A-Za-z]+{1,}+[!?°/;.,:><~´`*&¨%%$#@àèìùòááéíóú123456789]+{1,}")){
			throw new Exception("O campo: "+node.getObjName()+" Aceita somente letras!");
		}else{
			for(int i= 0;i<vetor.length;i++){
						if(retorno.contains(vetor[i]) || retorno.startsWith(" ") || retorno.startsWith(vetor[i])){
							throw new Exception("O campo: "+node.getObjName()+" Aceita somente letras!");
						}
					}
			return false;
		}
	}
	
		
		
	
	
}
