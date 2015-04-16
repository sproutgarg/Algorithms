/**
 * 
 */
package array;

/**
 * @author ankugarg
 * @question: A suffix array is a sorted array of all suffixes of a given
 *            string. The definition is similar to Suffix Tree which is
 *            compressed trie of all suffixes of the given text. Any suffix tree
 *            based algorithm can be replaced with an algorithm that uses a
 *            suffix array enhanced with additional information and solves the
 *            same problem in the same time complexity (Source Wiki). A suffix
 *            array can be constructed from Suffix tree by doing a DFS traversal
 *            of the suffix tree. In fact Suffix array and suffix tree both can
 *            be constructed from each other in linear time. Advantages of
 *            suffix arrays over suffix trees include improved space
 *            requirements, simpler linear time construction algorithms (e.g.,
 *            compared to Ukkonen’s algorithm) and improved cache locality
 *            (Source: Wiki)
 *            
Example:
Let the given string be "banana".

0 banana                          5 a
1 anana     Sort the Suffixes     3 ana
2 nana      ---------------->     1 anana  
3 ana        alphabetically       0 banana  
4 na                              4 na   
5 a                               2 nana

So the suffix array for "banana" is {5, 3, 1, 0, 4, 2}
 */
public class SuffixArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
