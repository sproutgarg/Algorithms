package binary_tree;

/**
 * 
 * @author ankugarg
 * @Idea Inorder traversal of a Binary tree is either be done using recursion or
 *       with the use of a auxiliary stack. The idea of threaded binary trees is
 *       to make inorder traversal faster and do it without stack and without
 *       recursion. A binary tree is made threaded by making all right child
 *       pointers that would normally be NULL point to the inorder successor of
 *       the node (if it exists).
 *
 *
 *       How to convert a Given Binary Tree to Threaded Binary Tree? We
 *       basically need to set NULL right pointers to inorder successor. We
 *       first do an inorder traversal of the tree and store it in a queue (we
 *       can use a simple array also) so that the inorder successor becomes the
 *       next node. We again do an inorder traversal and whenever we find a node
 *       whose right is NULL, we take the front item from queuue and make it the
 *       right of current node. We also set isThreaded to true to indicate that
 *       the right pointer is a threaded link.
 */
public class ThreadedBinaryTree {

}
