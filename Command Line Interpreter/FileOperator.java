package os;
import java.io.*;
import java.util.*;
public class FileOperator {
	public boolean copyFile(String source, String destination) {
		int nCharacters = 0;
		int offset = 0;
		char[] buffer = new char[100];
		File f = new File(destination);
		File srcFile = new File(source);
		
		
		try {
			FileReader r = new FileReader(source);
			

			
			
			FileWriter writeS = new FileWriter(f);
			
			while(offset < srcFile.length()) {
				nCharacters = r.read(buffer, offset, 99);
				if(nCharacters == -1) {
					break;
				}
				
				
				writeS.write(buffer, offset, nCharacters);
				offset += nCharacters;
			}
			
			writeS.flush();
			writeS.close();
			r.close();
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}	
		return true;
	}
	
	public boolean moveFile(String source, String destination) {
		int nCharacters = 0;
		int offset = 0;
		char[] buffer = new char[100];
		File f = new File(source);
		
		
		try {
			FileReader r = new FileReader(source);
			

			

			f = new File(destination);
			
			
			FileWriter writeS = new FileWriter(f);
			
			while(offset <= f.length()) {
				nCharacters = r.read(buffer, offset, 99);
				if(nCharacters == -1) {
					break;
				}
				
				
				writeS.write(buffer, offset, nCharacters);
				offset += nCharacters;
			}
			r.close();
			
			f = new File("C:\\Users\\gkari\\javatry\\os\\" + source);
			
			f.delete();
			writeS.flush();
			writeS.close();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}	
		
		
		return true;
	}
	
	public boolean removeFile(String fileName) {
		File fileToDelete = new File(fileName);
		fileToDelete.delete();
		return true;
	}
	
	public boolean getCurrentDirectory() {
		File here = new File(".");
		System.out.println(here.getAbsolutePath());
		return true;
	}
	public boolean printFileContents(String[] filePaths) {
		for(int i = 0; i < filePaths.length; i++) {
			File file = new File(filePaths[i]);
			
			try {
				
				BufferedReader fr = new BufferedReader(new FileReader(file));
				String a = fr.readLine();
				while(a != null) {
						
					System.out.println(a);
					a = fr.readLine();
				}
				
				fr.close();
			} catch(Exception e) {
				System.out.println(e);
			}
			
	
			
		}
		return true;
	}
	
	public boolean concatFilesToFile(String[] source, String destination) {
		

			
			try {
				FileWriter fw = new FileWriter(destination, true);
				BufferedWriter w = new BufferedWriter(fw);
				
				
				for(int i = 0; i < source.length; i++) {
				File file = new File(source[i]);
				BufferedReader fr = new BufferedReader(new FileReader(file));
				String a = new String();
				a = fr.readLine();
				
				while(a != null) {
					w.write(a);
					w.write('\n');
					a = fr.readLine();
				}
				
				fr.close();
			}
				w.close();
				fw.close();
			} catch(Exception e) {
				System.out.println(e);
			}
			
	
			
		
		return true;
	}
	
	public boolean readFilePortions(String fileName) {
		File file = new File(fileName);
		char[] buffer = new char[100];
		int offset = 0;
		FileReader fr = null;
		Scanner keyboard = new Scanner(System.in);
		
		try {
			fr = new FileReader(file);
		}catch(Exception e) {
			System.out.print(e);
			keyboard.close();
			return false;
		}
		
		try{
			
		while(fr.read(buffer, offset, 100) != -1) {
			System.out.print(buffer);
			keyboard.nextLine();
			
		}
		fr.close();
		}catch(Exception e) {
			System.out.println(e);
			keyboard.close();
			return false;
		}
		keyboard.close();
		return true;
		
		
		
	}
	
	
	
	
	
}
