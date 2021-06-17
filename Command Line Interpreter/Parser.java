package os;

public class Parser {
	private String args[];
	private  String cmd;
	private String redirectFile;
	private boolean append;
	
	public Parser() {
		
		redirectFile = null;
		
	}
	
	public boolean parse(String input) {
		
		if(input.contains(">>")) {
			redirectFile = input.substring(input.indexOf(">>")+2);
			input = input.substring(0, input.indexOf(">>"));
			
			append = true;
		}
		else if (input.contains(">")) {
			redirectFile = input.substring(input.indexOf(">")+1);
			input = input.substring(0, input.indexOf(">"));
			append = false;
		}
		String[] temp = input.split(" ");
		
		cmd = temp[0];
		args = new String[temp.length - 1];
		for(int i = 1; i < temp.length; i++) {
			args[i-1] = temp[i];
		}
		return true;
	}
	
	public String getCmd() {
		return cmd;
	}
	public String[] getArguments() {
		return args;
	}
	public String getRedirectFile() {
		return redirectFile;
	}
	public boolean getAppendStatus() {
		return append;
	}
}

