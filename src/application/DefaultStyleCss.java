package application;

import java.util.ArrayList;

import javafx.scene.Node;

public interface DefaultStyleCss {
	
	
public default void AddCSS(Node e,String css){
		
		
		e.getStyleClass().add(css);
	}

public default void setDefaulStyle(Node e,ArrayList<String> lista){
	for(int i=0;i<lista.size();i++){
	AddCSS(e,lista.get(i));
}
}

public default void setDefaulStyle(Node e,String css){
	AddCSS(e,css);
}


}
