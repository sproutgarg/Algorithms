/**
 * 
 */
package binary_tree;

/**
 * @author ankugarg
 * @question Given a very large n-ary tree. Where the root node has some
 *           information which it wants to pass to all of its children down to
 *           the leaves with the constraint that it can only pass the
 *           information to one of its children at a time (take it as one
 *           iteration).
 * 
 *           Now in the next iteration the child node can transfer that
 *           information to only one of its children and at the same time
 *           instance the child’s parent i.e. root can pass the info to one of
 *           its remaining children. Continuing in this way we have to find the
 *           minimum no of iterations required to pass the information to all
 *           nodes in the tree.
 * 
 *           Minimum no of iterations for tree below is 6. The root A first
 *           passes information to B. In next iteration, A passes information to
 *           E and B passes information to H and so on.
 * 
 *           example tree @ /Algorithms/tree_samples/n_ary_tree.png
 *
 */
public class PassInformation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
