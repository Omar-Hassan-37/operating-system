import java.io.*;
import java.util.*;

public class NewProposed {
	public ArrayList<Integer> requests = new ArrayList<Integer>();
	
	NewProposed(ArrayList<Integer> r){
		this.requests = r;
	}
	
	public int calcHead() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("sequence.txt", true));
		writer.write(" \nNewProposed : ");
		int THM = 0;
		sortReq(requests);
		THM = requests.get(0);
		writer.write(String.valueOf(0) + " ");
		for(int i = 0; i < requests.size() - 1; i++) {
			THM += requests.get(i+1) - requests.get(i);
			writer.write(String.valueOf(requests.get(i)) + " ");
		}
		writer.write(String.valueOf(requests.get(requests.size() - 1)) + " ");
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
