
public class SimpleNotepad implements INotepad{

	private Page[] pages;
	
	public SimpleNotepad() {
		this.pages = new Page[11];
		for(int i=0; i<11; i++){
			this.pages[i] = new Page("Stranica " + i, "");
		}
	}

	@Override
	public void addTextTo(String text, int page) {
		this.pages[page].addText(text);
		
	}

	@Override
	public void editText(String text, int page) {
		this.pages[page].deleteText();
		this.pages[page].addText(text);
	}

	@Override
	public void deleteText(int page) {
		this.pages[page].deleteText();
		
	}

	@Override
	public void viewPages() {
		for(int i=0; i<11; i++){
			if(this.pages[i] != null)
			this.pages[i].viewPage();
		}
	}
	
	
	
}
