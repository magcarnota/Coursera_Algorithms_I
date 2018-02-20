package union_find.quick_union_weighted;

/**
 * Cousera Algorithms part 1
 * Union-Find
 * Quick Union Weighted
 * 
 * We have an extra array with count number of objects in
 * the tree at this position
 * 
 * Times of processing
 * initialize     |  Union          	| find
 * ------------------------------------------------
 * lengthOfArray  |  log(lengthOfArray) | log(lengthOfArray)
 * 
 * (*) log base 2
 * 
 * Find is too expensive (could be lengthOfArray accesses)
 * @author magcarnota
 *
 */
public class QuickUnionWeightedUF {
	private int[] id;
	private int[] size;
	
	/**
	 * We initialize array of ids on each position with
	 * same id as position (each element root of itself).
	 * Array id stores roots for each element
	 * example (array 10 length):
	 * element 	    0 1 2 3 4 5 6 7 8 9
	 * id[](root)   0 1 2 3 4 5 6 7 8 9
	 * size[]		1 1 1 1 1 1 1 1 1 1
	 * @param lengthOfArray
	 */
	public QuickUnionWeightedUF(int lengthOfArray) {
		id = new int[lengthOfArray];
		size = new int[lengthOfArray];
		for(int i = 0; i<lengthOfArray; i++) {
			id[i] = i;
			size[i] = 1; 
		}
	}
	
	/**
	 * Find root of element
	 * @param element (element to find root)
	 * @return root of element
	 */
	private int root(int element) {
		while(element != id[element]) element = id[element];
		return element;
	}

	/**
	 * Checks if two elements p and q have the same root
	 * which means they are connected.
	 * @param p
	 * @param q
	 * @return true if they are connected or false otherwise
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	/**
	 * Joins two elements p and q
	 * Smaller tree joins to taller tree
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if(rootP == rootQ) return;
		if(size[rootP] < size[rootQ]) {
			id[rootP] = rootQ;	
			size[rootQ] += size[rootP];	
		} else {
			id[rootQ] = rootP;	
			size[rootP] += size[rootQ];
		}
	}
}
