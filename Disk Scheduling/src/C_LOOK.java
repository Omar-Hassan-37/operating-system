import java.io.*;
import java.util.*;

public class C_LOOK {
	public ArrayList<Integer> requests = new ArrayList<Integer>();
	
	C_LOOK(ArrayList<Integer> r){
		this.requests = r;
	}
	
	public int calcHead(int start) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("sequence.txt", true));
		writer.write(" \nC_LOOK : ");
		int THM = 0;
		requests.add(start);
		sortReq(requests);
		int current = requests.indexOf(start);
		for(int i = current; i > 0; i--) {
			THM += Math.abs(requests.get(i) - requests.get(i - 1));
			writer.write(String.valueOf(requests.get(i)) + " ");
		}
		writer.write(String.valueOf(requests.get(0)) + " ");
		THM += requests.get(requests.size() - 1) - requests.get(0);
		for(int i = requests.size() - 1; i > current + 1; i--) {
			THM += Math.abs(requests.get(i) - requests.get(i - 1));
			writer.write(String.valueOf(requests.get(i)) + " ");
		}
		writer.write(String.valueOf(requests.get(current + 1)) + " ");
		writer.write("\ntotal head movement : " + String.valueOf(THM));
		writer.close();
		return THM;
	}
	
	public void sortReq(ArrayList<Integer> requests) {
		for(int i = 0; i < requests.size(); i++) {
			for(int j = 0; j < requests.size(); j++) {
				if(requests.get(j) > requests.get(i)) {
					Collections.swap(requests, i, j);
				}
			}
		}
	}
}
