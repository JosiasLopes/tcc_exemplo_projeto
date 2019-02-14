package application;

import javafx.scene.Parent;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;

public class Subcenas extends SubScene {
	
	public boolean state;

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Subcenas(Parent arg0, double arg1, double arg2) {
		super(arg0, arg1, arg2);
		this.state = true;
		// TODO Auto-generated constructor stub
	}

	public Subcenas(Parent arg0, double arg1, double arg2, boolean arg3, SceneAntialiasing arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
		this.state = true;
		// TODO Auto-generated constructor stub
	}
	
	public void changeStateofView(){
		if(this.getState()== true){
			this.state = false;
			this.setVisible(false);
		}else{
			this.state = true;
			this.setVisible(true);
		}
		
	}

}
