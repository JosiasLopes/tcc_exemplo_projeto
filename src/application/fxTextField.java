package application;



import javafx.application.Platform;
import javafx.scene.control.TextField;

public class fxTextField extends TextField implements DefaultStyleCss{
	
	private String objName, state;
	
	private String id;

	
	

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

	public fxTextField() {
		// TODO Auto-generated constructor stub
	}

	public fxTextField(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public fxTextField(int id){
		super();
		this.setObjName(this.getClass().getName());
		this.setId(this.getClass().getName()+id);
		
		
	}
	
	public fxTextField(String arg0, String nome) {
		super(arg0);
		this.objName = nome;
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
		String big = "ABCDEFGHIJKLMNOPRSTUVWXYZabcdefghijklmnopqrstuvwxyzÇç!@#$%¨&*()_-+=§{}[]^`:;.>,<°|`!àèìòùáéíóúÁÉÍÓÚÀÈÌÒÙ";
		String[] vetor = new String[big.length()];
		for(int j=0;j<big.length();j++){
			vetor[j] = String.valueOf(big.charAt(j));
			if(txt.contains(vetor[j]) || txt.startsWith(" ") || txt.startsWith(vetor[j]) || txt.endsWith(" ")){
				this.setText(null);
				throw new Exception("Não são permitidos letras neste campo!");
			}
		}		
	}
	
	public boolean compareFields(TextField tx1,TextField tx2) throws Exception{
		if(tx1.getText().equals(tx2.getText())){
			return true;
		}else{
			throw new Exception("Os valores dos campos: "+tx1.getId()+" e "+tx2.getId()+" devem ser iguais!");
		}
	}
	

	public void validateEmail(String txt) throws Exception{
		// TODO Auto-generated method stub
		if((!txt.contains("@") || txt.startsWith(" ")) || (!txt.contains(".") || txt.endsWith(" ")) || (txt.indexOf("@")<1)){
			this.setText(null);
			throw new Exception("Esse não é um e-mail válido!");
		}
	}
	
	
}


