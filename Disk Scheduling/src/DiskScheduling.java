import java.io.*;
import java.util.*;

public class DiskScheduling {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> requests = new ArrayList();
		ArrayList<Integer> getLessTHM = new ArrayList();
		int start, end;
		start = 120;
		end = 200;
		
		Scanner sn = new Scanner(new File("requests.txt"));
		while(sn.hasNext()) {
			requests.add(sn.nextInt());
		}
		FCFS f = new FCFS(requests);
		getLessTHM.add(f.calcHead(start));
		requests.clear();
		sn.close();
		
		sn = new Scanner(new File("requests.txt"));
		while(sn.hasNext()) {
			requests.add(sn.nextInt());
		}
		SSTF s = new SSTF(requests);
		getLessTHM.add(s.calcHead(start));
		requests.clear();
		sn.close();
		
		sn = new Scanner(new File("requests.txt"));
		while(sn.hasNext()) {
			requests.add(sn.nextInt());
		}
		SCAN S = new SCAN(requests);
		getLessTHM.add(S.calcHead(start));
		requests.clear();
		sn.close();
		
		sn = new Scanner(new File("requests.txt"));
		while(sn.hasNext()) {
			requests.add(sn.nextInt());
		}
		C_SCAN C = new C_SCAN(requests);
		getLessTHM.add(C.calcHead(start, end));
		requests.clear();
		sn.close();
		
		sn = new Scanner(new File("requests.txt"));
		while(sn.hasNext()) {
			requests.add(sn.nextInt());
		}
		C_LOOK L = new C_LOOK(requests);
		getLessTHM.add(L.calcHead(start));
		requests.clear();
		sn.close();
		
		sn = new Scanner(new File("requests.txt"));
		while(sn.hasNext()) {
			requests.add(sn.nextInt());
		}
		NewProposed n = new NewProposed(requests);
		getLessTHM.add(n.calcHead());
		requests.clear();
		sn.close();
		
		Collections.sort(getLessTHM);
		BufferedWriter writer = new BufferedWriter(new FileWriter("sequence.txt" , true));
		writer.write(String.valueOf("\n\nbest THM is : " + getLessTHM.get(0)));
		writer.close();
		
	}

}
