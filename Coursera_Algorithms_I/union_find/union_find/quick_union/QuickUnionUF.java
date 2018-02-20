package union_find.quick_union;

/**
 * Cousera Algorithms part 1
 * Union-Find
 * 
 * @author magcarnota
 *
 */
public class QuickUnionUF {
	private int[] id;
	
	/**
	 * We initialize array of ids on each position with
	 * same id as position (each element root of itself).
	 * Array id stores roots for each element
	 * example (array 10 length):
	 * element 	    0 1 2 3 4 5 6 7 8 9
	 * id[](root)   0 1 2 3 4 5 6 7 8 9
	 * @param lengthOfArray
	 */
	public QuickUnionUF(int lengthOfArray) {
		id = new int[lengthOfArray];
		for(int i=0; i<lengthOfArray; i++) id[i] = i;
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
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		id[root(p)] = root(q);
	}
}
