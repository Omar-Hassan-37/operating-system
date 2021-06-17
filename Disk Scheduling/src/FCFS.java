import java.util.*;
import java.io.*;

public class FCFS {
	public ArrayList<Integer> requests = new ArrayList<Integer>();
	
	FCFS(ArrayList<Integer> r){
		this.requests = r;
	}
	
	public int calcHead(int start) throws IOException {
		int THM = 0;
		THM = Math.abs(start - requests.get(0));
		for(int i = 0; i < requests.size() - 1; i++) {
			THM += Math.abs(requests.get(i) - requests.get(i+1));
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("sequence.txt"));
		writer.write("FCFS : ");
		for(int i : requests) {
			System.out.print(i + " ");
			writer.write(String.valueOf(i) + " ");
		}
		writer.write("\n");
		writer.write("total head movement : " + String.valueOf(THM));
		writer.close();
		
		return THM;
	}
}
