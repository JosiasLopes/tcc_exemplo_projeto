package application;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;

public class fxComboBox extends ComboBox {
	
	
	public fxComboBox(ObservableList l){
		super.setItems(l);
super.setButtonCell(new ListCell(){
			
			@Override	
			protected void updateItem(Object item, boolean empty){
				super.updateItem(item, empty);
				if(empty || item==null){
					setStyle("-fx-text-fill: rgb(255,0,255);");
				}else{
					setStyle("-fx-text-fill: rgb(255,255,255);");
					setText(item.toString());
				}
			}
			});
	}
	
	public fxComboBox(){
		super.setButtonCell(new ListCell(){
			
			@Override	
			protected void updateItem(Object item, boolean empty){
				super.updateItem(item, empty);
				if(empty || item==null){
					setStyle("-fx-text-fill: rgb(255,0,255);");
				}else{
					setStyle("-fx-text-fill: rgb(255,255,255);");
					setText(item.toString());
				}
			}
			});
	}
	
	public void setLayoutXY(double x, double y){
		this.setLayoutX(x);
		this.setLayoutY(y);
	}

}
