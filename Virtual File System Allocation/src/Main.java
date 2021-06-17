import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String input = "";
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter C or I");
		input = in.next();
		
		if(input.equals("C")) {
			Disc.initialize("C", 1000);
			OperatingSystem os = new OperatingSystem("C");
			String cmd = "";
			cmd =  sc.nextLine();
			while(!cmd.equals("quit")) {
				os.execute(cmd);
				System.out.println();
				cmd =  sc.nextLine();
			}
		}
		
		else if(input.equals("I")) {
			Disc.initialize("I", 1000);
			OperatingSystem os = new OperatingSystem("I");
			String cmd = "";
			cmd =  sc.nextLine();
			while(!cmd.equals("quit")) {
				os.execute(cmd);
				System.out.println();
				cmd =  sc.nextLine();
			}
		}
	}
	
}
