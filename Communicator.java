import java.util.ArrayList;
import java.util.List;

public class Communicator {

private String name;
private List<String> listDialog = new ArrayList<>();

Communicator (String txt){
	setName(txt);

}


public void setName(String name){

	this.name=name;
	
	
}

public String getName() {
	
	return this.name;
	
}

public void setDialog(String line) {
	listDialog.add(line);
}

public String communicate() {


	return null;

}

	public List<String> getDialogPart() {

	return listDialog;
	}
}