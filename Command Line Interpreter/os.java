package os;
import java.io.*;
import java.util.*;
public class os {
	
	static File defaultPath = new File("");
	
	public static void changeOutStream(String fileName, boolean append) {
		try {
			
		PrintStream newStream = new PrintStream(new FileOutputStream(fileName, append));
		System.setOut(newStream);
		
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void resetOutStream(PrintStream p) {
		System.setOut(p);
	}
	
	public static void main(String[] args) {
		
		PrintStream stdout = System.out;
		String userInput = new String();
		Scanner keyboard = new Scanner(System.in);
		Parser inputParser = new Parser();
		Terminal mainTerminal = new Terminal();
		
		
		while(!userInput.contentEquals("dd")) {
		System.out.print('<' + defaultPath.getAbsolutePath() + '>');
		
		
		userInput = keyboard.nextLine();
		if(inputParser.parse((userInput))){
			
			String redirectFile = inputParser.getRedirectFile();
			if (redirectFile != null) {
				changeOutStream(redirectFile, inputParser.getAppendStatus());
			}
			
			mainTerminal.run(inputParser.getCmd(), inputParser.getArguments(),
					redirectFile, inputParser.getAppendStatus());
			
			resetOutStream(stdout);
		}
		else {
			System.out.print("Invalid Input!");
		}
		
		}
		keyboard.close();
		
		
	}
}
