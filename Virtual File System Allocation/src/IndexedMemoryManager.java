import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;



public class IndexedMemoryManager implements MemoryManager {
	
	int nBlocks;
	Block b;
	ArrayList<AllocBlock> ab;
	//HashMap<Integer, String> allocationMap; //Map between name of file and Starting point of allocation
	HashMap<Integer, String> sizeMap; // Map between name of file and it's size
	
	IndexedMemoryManager(){
		//allocationMap = new HashMap<Integer, String>();
		sizeMap = new HashMap<Integer, String>();
		nBlocks = Disc.getInstance().getnBlocks();
		ab = new ArrayList();
		
		
		
	}
	
	@Override
	public void alloc(String fileName, int size) throws OutOfMemoryError {
		b = new Block(Disc.getInstance().blocks, Disc.getInstance().nBlocks);
		if(Disc.getInstance().getRemainingDiscSpace() < size) {
			throw new OutOfMemoryError();
		}
		
		for(String m : Disc.getInstance().allocationMap.values()) {
			if(m.equals(fileName)) {
				System.out.println("file already exists");
				return;
			}
		}
		
		int start = b.getFreeBlock();
		AllocBlock allocToBlock = new AllocBlock(start);
		Disc.getInstance().allocationMap.put(start, fileName);
		sizeMap.put(size, fileName);
		
		for(int i = 0; i < size - 1; i++) {
			int newBlock = b.getFreeBlock();
			allocToBlock.addLinkedBlock(newBlock);
		}
		Disc.getInstance().allocIndexed(start, size, allocToBlock.linkedBlocks);
		ab.add(allocToBlock);
		
		for(int i = 0; i < b.freeBlocks.length; i++) {
			Disc.getInstance().blocks[i] = b.freeBlocks[i];
		}
	}

	@Override
	public void deAlloc(String fileName) {
		b = new Block(Disc.getInstance().blocks, Disc.getInstance().nBlocks);
		int key = getKey(Disc.getInstance().allocationMap, fileName);
		Disc.getInstance().allocationMap.remove(key);
		dAllocBlockList(key);
		for(int i = 0; i < b.freeBlocks.length; i++) {
			Disc.getInstance().blocks[i] = b.freeBlocks[i];
		}
	}
	
	public void dAllocBlockList(int startAllocation) {
		AllocBlock o = new AllocBlock();
		for(AllocBlock no : ab) {
			if(no.getStartAllocation() == startAllocation) {
				o = no;
				break;
			}
		}
		Disc.getInstance().deAllocIndexed(startAllocation, o.linkedBlocks.size() + 1, o.linkedBlocks);
		//System.out.println("blocks : " + b.freeBlocks);
		for(int i = 0; i < o.linkedBlocks.size(); i++) {
			b.dAllocBlock(o.linkedBlocks.get(i));
		}
		b.dAllocBlock(startAllocation);
		//System.out.println("blocks : " + b.freeBlocks);
		ab.remove(o);
	}
	
	public int getKey(HashMap<Integer, String> map, String value) {
		for (Integer key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return 0;
	}
	
	private class Block{
		private boolean[] freeBlocks;
		
		
		public Block(boolean [] fBlock, int nBlocks) {
			freeBlocks = new boolean[nBlocks];
			for(int i = 0; i < fBlock.length; i++) {
				this.freeBlocks[i] = fBlock[i];
			}
		}
		
		
		public int getFreeBlock() {
			int index = 0;
			for(int i = 0; i < freeBlocks.length; i++) {
				if(freeBlocks[i] == false) {
					index = i;
					freeBlocks[i] = true;
					break;
				}
			}
			return index;
		}
		
		public void dAllocBlock(int block) {
			freeBlocks[block] = false;
		}
		
	}
	
	private class AllocBlock{
		private int startAllocation;
		private LinkedList<Integer> linkedBlocks;
		public AllocBlock() {
			this.startAllocation = 0;
			linkedBlocks = new LinkedList();
		}
		public AllocBlock(int startAllocation) {
			this.startAllocation = startAllocation;
			linkedBlocks = new LinkedList();
		}
		
		public void setStartOfAllocation(int startAllocation) {
			this.startAllocation = startAllocation;
		}
		
		public int getStartAllocation() {
			return startAllocation;
		}
		
		public void addLinkedBlock(int block) {
			this.linkedBlocks.add(block);
		}
		public LinkedList<Integer> getLinkedBlocks(){
			return linkedBlocks;	}
		
		public void clearLinkedBlocks() {
			this.linkedBlocks.clear();
		}
		
	}
	
	
}
