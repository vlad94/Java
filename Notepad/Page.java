
public class Page {

	private String name;
	private String text;
	
	public Page(String name, String text) {
		this.name = name;
		this.text = text;
	}
	
	void addText(String newText){
		this.text = text + " " + newText;
	}
	
	void deleteText(){
		this.text = "";
	}
	
	void viewPage(){
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return this.name + "\n" + this.text;
	}
	
}
