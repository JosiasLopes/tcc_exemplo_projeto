package application;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class fxLabel extends Label implements DefaultStyleCss{
	
	private String objName, state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}
	
	public fxLabel(String txt, String nome){
		super(txt);
		this.setObjName(nome);
	}
	public fxLabel(String txt,String nome,String id){
		super(txt);
		this.setObjName(nome);
		this.setId(id);
		
	}
	
	//construtor responsavel por setar um texto, um id, e uma classe css para o elemento
	
	
	
	public void setDefaulStyle(){
		AddCSS(this,"fonte_32");
		AddCSS(this,"texto_branco");
		AddCSS(this,"fundo_verde");
		AddCSS(this,"bordas_redondas_leves_brancas");
	}

	public fxLabel(String txt) {
		super(txt);
	}

	public fxLabel() {
		// TODO Auto-generated constructor stub
	}
	
	public void setLayoutXY(double x,double y){
		this.setLayoutX(x);
		this.setLayoutY(y);
	}
	
	public void validateblankSpace(String txt) throws Exception{
		if(txt.startsWith(" ") || txt.endsWith(" ")){
			throw new Exception("Não são permitidos caracteres de "+"'ESPAÇO'"+"no inicio ou final do campo: "+
		this.getObjName()+"!");
		}
	}
	
	public void validateNumber(String txt) throws Exception{
		String[] vetor = {"!","?","°","/",";",".",",",
				":",">","<","~","´","`","*","&","¨","%","$","#","@","à","è","ì","ù","ò","á","á",
				"é","í","ó","ú"}; 
		if(txt.startsWith(" ") || txt.endsWith(" ") || txt.matches("[A-Za-z]+{1,}")){
			throw new Exception("Não são permitidos letras no campo: "+
		this.getObjName()+"!");
		}else{
			for(int i= 0;i<vetor.length;i++){
				if(txt.contains(vetor[i]) || txt.startsWith(" ") || txt.startsWith(vetor[i])){
					throw new Exception("Não são permitidos letras no campo: "+
							this.getObjName()+"!");
				}
			}
		}
	}
	
	public void AddCSS(Node e,String css){
		
		
		e.getStyleClass().add(css);
	}

}
