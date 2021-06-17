package osAss2;

import java.util.*;
import java.io.*;

public class Network {
	
	private ArrayList <Connections> conlist;
	int N;
	int TC;
	String TClines;
	
	Network(int size){
		N = size;
		TC = 0;
		TClines = new String();
		conlist = new ArrayList<Connections>();
	}		
	
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int nCons = 0;
		int nDev = 0;
		String line = "";
		Network net = new Network(nCons);
		
		System.out.println("What is number of WI-FI Connections?");
		nCons = in.nextInt();
		System.out.println("What is number of devices Clients want to connect?");
		nDev = in.nextInt();
		System.out.println(nDev);
		
		for(int i = 0 ; i < nDev ; i ++) {
			if(in.hasNext()) {line = in.nextLine();}
			line = in.nextLine();
			Connections temp = parse(line);
			net.addConnection(temp);
		}
		
		for(int i = 0 ; i < nDev ; i ++) {
			System.out.println(net.conlist.get(i));
		}
		
		
	}
	
	
	
	
	
	public void addConnection(Connections newC) {
		
		conlist.add(newC);
		
	}
	
	public static Connections parse (String line) {
		
		return new Connections(line.split(" ")[0] , line.split(" ")[1]);
		
	}
	
}
