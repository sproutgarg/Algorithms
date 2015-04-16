/**
 * 
 */
package binary_tree;

/**
 * @author ankugarg
 *
 */
public class BST {
	
	/**
	 * Inorder predecessor and successor for a given key in BST
	 * Algo:
	 * Input: root node, key
output: predecessor node, successor node

1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most 
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child 
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree
	 */
	public Node presucc(Node root){
		return null;
	}
	
	/**
	 * For example (in binary_search_tree.gif), consider the BST in diagram, LCA of 10 and 14 is 12 and LCA of 8 and 14 is 8.
	 * 
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
	public Node LCA(Node root, Node a, Node b){
		return null;
	}
	
	/**
	 * question:
	 * We have discussed BST search and insert operations. In this post, delete operation is discussed. 
	 * When we delete a node, there possibilities arise.

1) Node to be deleted is leaf: Simply remove from the tree.

              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70 
         /  \    /  \                     \    /  \ 
       20   40  60   80                   40  60   80
2) Node to be deleted has only one child: Copy the child to the node and delete the child

              50                            50
           /     \         delete(30)      /   \
          30      70       --------->    40     70 
            \    /  \                          /  \ 
            40  60   80                       60   80
3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.

              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70 
                 /  \                            \ 
                60   80                           80
	 * @param root
	 * @param x
	 * @return
	 */
	public Node deleteNode(Node root, Node x){
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
