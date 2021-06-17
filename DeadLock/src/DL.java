
import java.util.*;

public class DL {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,m;
        System.out.println("enter number of processes");
        n = in.nextInt();
        System.out.println("enter number of resources");
        m = in.nextInt();
        ArrayList<Integer> process = new ArrayList();
        int[] rInst = new int[m];
        int[][] alloc = new int[n][m];
        int[][] max = new int[n][m];
        boolean[] finish = new boolean[n];
        Arrays.fill(finish, false);
        System.out.println();

        System.out.println("enter number of instances of resources");
        for(int i = 0; i < m; i++){
            rInst[i] = in.nextInt();
        }
        System.out.println();
        System.out.println("enter number of max instances needed by each process");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max[i][j] = in.nextInt();
            }
        }
        System.out.println();
        System.out.println("enter number of instances allocated to each process");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                alloc[i][j] = in.nextInt();
            }
        }
        System.out.println();

        Banker b = new Banker(n,m);
        b = new Banker(rInst, max, alloc,finish);
        process = b.bankerAlgorithm(n, m);
        
        System.out.print("sequence of proocesses : ");
        for(int i : process) {
        	System.out.print("P" + i + " ");	
        }
    }
}

