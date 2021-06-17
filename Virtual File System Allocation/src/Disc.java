import java.util.HashMap;
import java.util.LinkedList;

public class Disc {
	private static Disc instance;
	
	
	int nBlocks;
	int remainingDiscSpace;
	boolean[] blocks;
	HashMap<Integer, String> allocationMap;
	
	
	public int getnBlocks() {
		return nBlocks;
	}
	public void setnBlocks(int nBlocks) {
		this.nBlocks = nBlocks;
	}
	public int getRemainingDiscSpace() {
		return remainingDiscSpace;
	}
	public void setRemainingDiscSpace(int remainingDiscSpace) {
		this.remainingDiscSpace = remainingDiscSpace;
	}
	
	private Disc(String mode, int nBlocks) {
		this.nBlocks = nBlocks;
		this.remainingDiscSpace = nBlocks;
		allocationMap = new HashMap<Integer, String>();
		blocks = new boolean[nBlocks];
	}
	public static Disc getInstance() {
		
		if(instance == null) {
			instance = new Disc(null,0);
		}
		return instance;
	}
	
	public static void initialize(String mode, int nBlocks) {
		if(instance == null)
			instance = new Disc(mode,nBlocks);
	}
	
	public void alloc(int start, int size) {
		remainingDiscSpace -= size;
		System.out.print(start + "  " + size);
		for(int i = start; i < start+size; i++) {
			blocks[i] = true;
		}
	}
	
	public void allocIndexed(int start, int size, LinkedList<Integer> blocksIndexes) {
		remainingDiscSpace -= size;
		blocks[start] = true;
		for(int i : blocksIndexes) {
			blocks[i] = true;
		}
		System.out.println(start + "  " + blocksIndexes);
		System.out.println();
	}
	public String getDiskStatus() {
		return "Total Space = " + nBlocks+"\nRemaining: " + remainingDiscSpace; 
	}
	public void deAlloc(Integer start, Integer size) {
		remainingDiscSpace += size;
		
		for(int i = start; i < start+size; i++) {
			blocks[i]=false;
		}
		
		System.out.println("file is deleted");
	}
	
	public void deAllocIndexed(int start, int size, LinkedList<Integer> blocksIndexes) {
		remainingDiscSpace += size;
		blocks[start] = false;
		for(int i : blocksIndexes) {
			blocks[i] = false;
		}
		System.out.println("file is deleted");
	}
	
	

}
