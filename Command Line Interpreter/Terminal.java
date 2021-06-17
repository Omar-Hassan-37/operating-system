package os;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class Terminal {
	
		private static String[] cmds = new String[] {"cp", "mv", "rm", "pwd", "cat",
				"cd", "ls", "more", "mkdir", "rmdir", "args", "date",
				"help", "clear"};
		
		

		public void cp(String source , String destination) {
			FileOperator j = new FileOperator();
			j.copyFile(source, destination);
		}
		
		public void mv(String source , String destination) {
			FileOperator j = new FileOperator();
			j.moveFile(source, destination);
		}
		
		public void rm(String source) {
			FileOperator j = new FileOperator();
			j.removeFile(source);
		}
		
		public void pwd() {
			System.out.println(os.defaultPath.getAbsoluteFile());
		}
		
		public void cat(String[] Paths) {
			FileOperator j = new FileOperator();
			j.printFileContents(Paths);
		}
		
		
		
		public boolean mkdir(String path) {
			File e = new File(path);
			
			return e.mkdir();
			
		}
		public boolean rmdir(String path) {
			File e = new File(path);
			
			return e.delete();
		}
		
		public void date() {
			Date d = new Date();
			System.out.print(d);
		}
		
		public void clear() {
			
			for(int i = 0; i < 50; i++) System.out.print("\n");
			
		}
		
		public void ls() {
			for(String fileNames : os.defaultPath.list()) System.out.println(fileNames);
		}
		
		public void more(String fileName) {
			FileOperator r = new FileOperator();
			r.readFilePortions(fileName);
		}
		
		public void cd(String path) {
			File f = new File(path);
			if(f.exists())
				os.defaultPath = new File(path);
			else
				System.err.println("Couldn't excute command.");

		}
		
		public boolean isLongPath(String path) {
			return path.contains(":");
		}
		
		public boolean checkPath(String path) {
			int index = path.indexOf(':');
			if(index > 0) {
				return checkLongPath(path);
			}
			else {
				return checkShortPath(path);
			}
		}
		
		public boolean checkShortPath(String path) {
			File shortPath = new File(path);
			if(shortPath.exists())
				return true;
			else
				return false;
		}
		
		public boolean checkLongPath(String path) {
			Path longPath = Paths.get(path);
			if(Files.exists(longPath))
				return true;
			else
				return false;
		}
		
		
		public boolean isValidCmd(String userCmd) {
			for(int i = 0; i < cmds.length; i++ ) {
				if(cmds[i].equals(userCmd))
					return true;
			}
			return false;
		}
		
		public void run(String cmd, String[] args, String redirectFile, boolean append ) {
			if(this.isValidCmd(cmd)) {

				for(int i = 0; i < args.length; i++) {
					if(!this.isLongPath(args[i])) {
						args[i] = os.defaultPath.getAbsolutePath().concat("\\").concat(args[i]);
					}
				}
				
				switch(cmd) {
				
				
				
				case "cp":
					if(args.length > 2 || args.length < 2) {
						System.err.println("cp takes 2 arguments");
						break;
					}
					else {
						this.cp(args[0], args[1]);
					}
					break;
				case "mv":
					if(args.length > 2 || args.length < 2) {
						System.err.println("mv takes 2 arguments");
						
					}
					else {
						this.mv(args[0], args[1]);
						
					}
					break;
					
				case "rm":
					if(args.length < 1 || args.length > 1)
						System.err.println("rm takes 1 argument");
					else {
						this.rm(args[0]);
					}
					break;
				case "pwd":
					if(args.length > 0)
						System.err.println("pwd takes 0 arguments.");
					else {
						this.pwd();
					}
					break;
				case "cd":
					if(args.length > 1 || args.length < 1)
						System.err.println("cd takes 1 argument.");
					else {
						this.cd(args[0]);
					}
					break;
				case "ls":
					if(args.length > 0)
						System.err.println("ls takes 0 arguments.");
					else {
						this.ls();
					}
					break;
				case "mkdir":
					if(args.length > 1 || args.length < 1)
						System.err.println("mkdir takes 1 argument.");
					else {
						this.mkdir(args[0]);
					}
					break;
				case "rmdir":
					if(args.length > 1 || args.length < 1)
						System.err.println("rmdir takes 1 argument.");
					else {
						this.rmdir(args[0]);
					}
					break;
					
				case "date":
					if(args.length > 0)
						System.err.println("date takes 0 arguments.");
					else {
						this.date();
					}
					break;
					
				case "clear":
					if(args.length > 0)
						System.err.println("clear takes 0 arguments");
					else {
						this.clear();
					}
					break;
					
				case "more":
					if(args.length > 1 || args.length < 1)
						System.err.println("more takes 1 argument");
					else {
						this.more(args[0]);
					}
					break;
					
				case "cat":
					this.cat(args);
					break;
					
				case "args":
					if(args.length > 1 || args.length < 1)
						System.err.println("args takes 1 argument");
					else {
						this.args(args[0]);
					}
					break;
				
				case "help":
					if(args.length > 0)
						System.err.println("help takes 0 arguments");
					else {
						this.help();
					}
					break;
				}
				
			}
		}
			
		


		
		public boolean CheckPath(String path) {
			int index = path.indexOf(':');
			System.out.println(index);
			if(index > 0) {
				return checkLongPath(path);
			}
			else {
				return checkShortPath(path);
			}
		}
		
		public void args (String cmd) {
			if(cmd.equals("cp")) {
				System.out.println("arg1: source path ,arg2: destination path");
			}
			if(cmd.equals("mv")) {
				System.out.println("arg1: source path ,arg2: destination path");
			}
			if(cmd.equals("pwd")) {
				System.out.println("has no arguments");
			}
			if(cmd.equals("rm")) {
				System.out.println("arg1: source path");
			}
			if(cmd.equals("cat")) {
				System.out.println("arg1: paths");
			}
			if(cmd.equals("clear")) {
				System.out.println("has no arguments");
			}
			if(cmd.equals("ls")) {
				System.out.println("has no arguments");
			}
			if(cmd.equals("mkdir")) {
				System.out.println("arg1: path");
			}
			if(cmd.equals("rmdir")) {
				System.out.println("arg1: path");
			}
			if(cmd.equals("more")) {
				System.out.println("arg1: filename");
			}
			if(cmd.equals("date")) {
				System.out.println("has no arguments");
			}
			if(cmd.equals("cd")) {
				System.out.println("arg1: path");
			}
			if(cmd.equals("exit")) {
				System.out.println("has no argument");
			}
		}
		
		public void help () {
			System.out.println("cp       copy file from source path to destination path.");
			System.out.println("mv       move file from source path to destination path.");
			System.out.println("rm       remove file from source path.");
			System.out.println("pwd      display current user directory.");
			System.out.println("cat      concatenate files and print on the standard ouptut.");
			System.out.println("clear    clears the current terminal screen.");
			System.out.println("cd       change the current directory to another one.");
			System.out.println("ls       list files and directories in the folder.");
			System.out.println("mkdir    create a new directory.");
			System.out.println("rmdir    remove empty directory from the file system.");
			System.out.println("more     display and scroll down the output in one direction.");
			System.out.println("args     lists all the parameters in the command line.");
			System.out.println("date     output current system date and time.");
			System.out.println("exit     stop all.");
		}
		
		
		
		
			
		
}
