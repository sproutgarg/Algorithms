package binary_tree;

/**
 * 
 * @author ankugarg
 * @question A K-D Tree(also called as K-Dimensional Tree) is a binary search
 *           tree where data in each node is a K-Dimensional point in space. In
 *           short, it is a space partitioning(details below) data structure for
 *           organizing points in a K-Dimensional space.
 * 
 *           A non-leaf node in K-D tree divides the space into two parts,
 *           called as half-spaces.
 * 
 *           Points to the left of this space are represented by the left
 *           subtree of that node and points to the right of the space are
 *           represented by the right subtree. We will soon be explaining the
 *           concept on how the space is divided and tree is formed.
 * 
 *           For the sake of simplicity, let us understand a 2-D Tree with an
 *           example.
 * 
 *           The root would have an x-aligned plane, the root’s children would
 *           both have y-aligned planes, the root’s grandchildren would all have
 *           x-aligned planes, and the root’s great-grandchildren would all have
 *           y-aligned planes and so on. EXAMPLE:::: Consider following points
 *           in a 2-D plane: (3, 6), (17, 15), (13, 15), (6, 12), (9, 1), (2,
 *           7), (10, 19)
 * 
 *           Insert (3, 6): Since tree is empty, make it the root node. Insert
 *           (17, 15): Compare it with root node point. Since root node is
 *           X-aligned, the X-coordinate value will be compared to determine if
 *           it lies in the rightsubtree or in the right subtree. This point
 *           will be Y-aligned. Insert (13, 15): X-value of this point is
 *           greater than X-value of point in root node. So, this will lie in
 *           the right subtree of (3, 6). Again Compare Y-value of this point
 *           with the Y-value of point (17, 15) (Why?). Since, they are equal,
 *           this point will lie in the right subtree of (17, 15). This point
 *           will be X-aligned. Insert (6, 12): X-value of this point is greater
 *           than X-value of point in root node. So, this will lie in the right
 *           subtree of (3, 6). Again Compare Y-value of this point with the
 *           Y-value of point (17, 15) (Why?). Since, 12 < 15, this point will
 *           lie in the left subtree of (17, 15). This point will be X-aligned.
 *           Insert (9, 1):Similarly, this point will lie in the right of (6,
 *           12). Insert (2, 7):Similarly, this point will lie in the left of
 *           (3, 6). Insert (10, 19): Similarly, this point will lie in the left
 *           of (13, 15).
 */
public class KDimensionalTree {

}