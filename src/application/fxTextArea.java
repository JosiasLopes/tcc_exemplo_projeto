package application;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class fxTextArea extends TextArea {
	
	
	public void setLayoutXY(double x,double y){
		this.setLayoutX(x);
		this.setLayoutY(y);
	}
	
	public fxTextArea(){
		
	}
	
	public void init(){
		
		super.setStyle("background-color: rgba(0,0,0,0);");
		super.setOpaqueInsets(super.getInsets());
		
		}
		
		
	}


