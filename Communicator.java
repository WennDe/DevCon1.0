import java.util.ArrayList;

public class Communicator {

private String name;
ArrayList<String> listDialogEN = new ArrayList<>();
private ArrayList<String> listDialogDE = new ArrayList<>();

public Communicator () {
		}

public Communicator (String txt){
	setName(txt);

}


public void setName(String name){

	this.name=name;
	
	
}

public String getName() {
	
	return this.name;
	
}

public void setDialogEN(String line) {
//	System.out.println(line);
	this.listDialogEN.add(line);
}

	public void setDialogDE(String line) {
//		System.out.println(line);
		this.listDialogDE.add(line);
	}


	public ArrayList<String> getDialogPartEN() {

	return this.listDialogEN;
	}

	public ArrayList<String> getDialogPartDE() {
		return this.listDialogDE;
	}

	public String getDialogENentry(int idx) {
return this.listDialogEN.get(idx);
}

	public String getDialogDEentry(int idx) {
	return this.listDialogDE.get(idx);
	}
}