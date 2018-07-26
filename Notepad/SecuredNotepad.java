import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad{

	private final String password;
	
	public SecuredNotepad(String password) {
		super();
		this.password = password;
	}

	@Override
	public void addTextTo(String text, int page) {
		System.out.println("To add text, you should first enter correct password!!");
		if(Verification()){
			super.addTextTo(text, page);
		}
	}

	@Override
	public void editText(String text, int page) {
		System.out.println("To edit text, you should first enter correct password!!");
		if(Verification()){
			super.editText(text, page);
		}	
	}

	@Override
	public void deleteText(int page) {
		System.out.println("To delete text, you should first enter correct password!!");
		if(Verification()){
			super.deleteText(page);
		}
	}

	@Override
	public void viewPages() {
		System.out.println("To view pages, you should first enter correct password!!");
		if(Verification()){
			super.viewPages();
		}
		
	}
	private boolean Verification(){
		System.out.println("Enter your password:");
		Scanner sc = new Scanner(System.in);
		String entered = sc.nextLine();
		if(entered.equals(password)){
			System.out.println("Operation Succesful!");
			return true;
		}
		else{
			System.out.println("Wrong password! Operation failed!");
			return false;
		}
	}
	
}
