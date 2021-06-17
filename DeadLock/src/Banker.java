import java.util.*;

public class Banker {
    int[] resourcesInst;
    //int[] available;
    int[][] maximum;
    int[][] allocation;
    int[][] need;
    int[] work;
    boolean[] finish;
    ArrayList <Integer> processes = new ArrayList();

    public Banker(int n, int m){
        resourcesInst = new int[m];
        //available = new int[m];
        maximum = new int[n][m];
        allocation = new int[n][m];
        need = new int[n][m];
        work = new int[m];
        //work = available;
        finish = new boolean[n];
        Arrays.fill(finish, false);
    }

    public Banker(int[] rInst, int[][] max, int[][] alloc, boolean[] finich){
        this.resourcesInst = rInst;
        this.maximum = max;
        this.allocation = alloc;
        this.finish = finich;
    }

    public boolean checkAllocLessMax(int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(allocation[i][j] > maximum[i][j]){
                    System.out.println("Memory allocated is more than max");
                    return false;
                }
            }
        }
        return true;
    }

    public void getAvail(int n, int m){
    	int[] available = new int[m];
        int calc = 0;
        if(checkAllocLessMax(n,m)) {
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    calc += allocation[i][j];
                }
                available[j] = resourcesInst[j] - calc;
                calc = 0;
            }
            work = available;
        }
        else{
            System.out.println("resources allocated is more than maximum");
        }
    }

    public  void getNeed(int n, int m){
    	int[][] neeed = new int[n][m];
        if(checkAllocLessMax(n,m)){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    neeed[i][j] = maximum[i][j] - allocation[i][j];
                }
            }
            need = neeed;
        }
        else{
            System.out.println("resources allocated is more than maximum");
        }
    }


    public ArrayList<Integer> bankerAlgorithm(int n, int m){
    	ArrayList <Integer> process = new ArrayList();
    	int[] avail = new int[m];
        getAvail(n,m);
        getNeed(n,m);
        int counter = 0;
        int i = 0;
        int j = 0;
        while(checkFinish(finish) == false){
        	printAvail(m);
            System.out.println("Process : " + i);
            System.out.print("Need : ");
            for(j = 0; j < m; j++){
                System.out.print(need[i][j] + " ");
                if(need[i][j] > work[j]){
                    continue;
                }
                else{
                    counter++;
                }
            }
            System.out.println();
            System.out.print("Allocated to it : ");
            for(int k = 0; k < m; k++) {
            	System.out.print(allocation[i][k]+" ");
            }
            System.out.println();
            if(counter == j && finish[i] == false){
                counter = 0;
                System.out.println("resources needed are available");
                for(int z = 0; z < m; z++){
                    work[z] += allocation[i][z];
                }
                finish[i] = true;
                process.add(i);
            }
            else {
            	counter = 0;
            	if(finish[i] == true) {
            		System.out.println("process finished");
            	}
            	else {
            		System.out.println("resources needed are more than available.");
            	}
            }
            System.out.println("-----------------------------------------------------------");
            i++;
            if((checkSafety(avail, work, m) == true) && i == n) {
            	System.out.println("deadLock occured");
            	return process;
            }
            if(i == n) {
            	avail = work;
            	i = 0;
        	}
        }
        if(checkFinish(finish) == true) {
        	processes = process;
        	System.out.println("system in a safe state");
        }
        else {
        	System.out.println("system is not in safe state");
        }
        return process;
    }

    public boolean checkFinish(boolean[] f){
        for(int i = 0; i < finish.length; i++){
            if(finish[i] == false){
                return false;
            }
        }
        return true;
    }

    public void printAvail(int m){
    	System.out.print("Availabel : ");
        for(int i = 0; i < m; i++){
            System.out.print(work[i] + " ");
        }
        System.out.println();
    }
    
    public boolean checkSafety(int[] array1, int[] array2 ,int m) {
    	for(int i = 0; i < m; i++) {
    		if(array1[i] != array2[i]) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public void printProcess(int n) {
    	 System.out.print("sequence of proocesses : ");
         for(int i : processes) {
         	System.out.print("P" + i + " ");	
         }
    }
}
