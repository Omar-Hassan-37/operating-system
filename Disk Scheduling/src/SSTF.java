import java.io.*;
import java.util.*;

public class SSTF {
	
	public ArrayList<Integer> requests = new ArrayList<Integer>();
	public ArrayList<Integer> req = new ArrayList();
	
	SSTF(ArrayList<Integer> r){
		this.requests = r;
	}
	
	public int calcHead(int start) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("sequence.txt", true));
		writer.write(" \nSSTF : ");
		int THM = 0;
		int min = Math.abs(start - requests.get(0));
		int current = 0;
		int currentValue = 0;
		boolean flag = false;
		for(int i = 0; i < requests.size() - 1; i++) {
			if(Math.abs(start - requests.get(i)) < min) {
				min = Math.abs(start - requests.get(i));
				current = i;
			}
		}
		writer.write(String.valueOf(requests.get(current)));
		THM = min;
		int i = 0;
		while(requests.size() > 1) {
			if(current == requests.size()) {
				current --;
			}
			min = Math.abs(requests.get(current) - requests.get(0));
			if(requests.get(current) == requests.get(0)) {
				min = Math.abs(requests.get(current) - requests.get(1));
			}
			currentValue = requests.get(current);
			requests.remove(current);
			
			for(i = 0;i < requests.size(); i++) {
				if(Math.abs(currentValue - requests.get(i)) < min) {
					min = Math.abs(currentValue - requests.get(i));
					current = i;
					flag = true;
				}
				if(flag == false) {
					current = 0;
				}
			}
			writer.write(String.valueOf(currentValue) + " ");
			flag = false;
			THM += min;
		}
		writer.write(String.valueOf(requests.get(0)) + " ");
		writer.write(String.valueOf("\ntotal head movement : " + THM));
		writer.close();
		return THM;
	}
	
}
