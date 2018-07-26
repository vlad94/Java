
public class Demo {

	public static void main(String[] args) {
		
		
		SimpleNotepad sn = new SimpleNotepad();
		sn.addTextTo("Hello World!", 3);
		sn.addTextTo("Right back", 6);
		sn.viewPages();
		sn.editText("Right back at You!!", 7);
		sn.editText("Right back at You!!", 6);
		sn.viewPages();
		
		
		SecuredNotepad ssn = new SecuredNotepad("1234");
		ssn.addTextTo("Hello!", 3);
		ssn.addTextTo("Is it working\n I guess so", 6);
		ssn.viewPages();
		ssn.editText("Wow", 7);
		ssn.addTextTo("Good job", 7);
		ssn.deleteText(3);
		ssn.viewPages();
		
		
		
		
	}

}
