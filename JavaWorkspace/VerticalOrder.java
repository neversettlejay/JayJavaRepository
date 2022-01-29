// a node of a binary tree  
class TreeNode {
    // for holding value of the node
    int val;
    // for referring to the other nodes
    // left for the left child and right to the right child
    TreeNode left, right;

    // constructor of the class TreeNode
    // the construct initializes the class fields
    public TreeNode(int i) {
        val = i;
        right = left = null;
    }
}

// a class for storing the farthest value in the left as well as in the right
// direction from
// the root node
class Values {
    public int maximum;
    public int minimum;
}

public class VerticalOrder {
    TreeNode r;
    Values v = new Values();

    // A utility method to look for the minimum and maximum distances with respect
    // to
    // root.
    void findMinMaximum(TreeNode root, Values min, Values max, int h) {
        // the base case
        if (root == null) {
            return;
        }
        // Updating the minimum and maximum
        if (h < min.minimum) {
            min.minimum = h;
        } else if (h > max.maximum) {
            max.maximum = h;
        }
        // applying recursion for the right and left subtrees
        findMinMaximum(root.left, min, max, h - 1);
        findMinMaximum(root.right, min, max, h + 1);
    }

    // A utility method for displaying all of the nodes on the given line_num.
    // h is the horizontal distance of the current node by taking root as the
    // reference.
    void displayVerticalLine(TreeNode root, int line_num, int h) {
        // the base case
        if (root == null) {
            return;
        }
        // If the node is lying on the line number
        // print the value of that node
        if (h == line_num) {
            System.out.print(root.val + " ");
        }
        // applying recursion for the right and left subtrees
        displayVerticalLine(root.left, line_num, h - 1);
        displayVerticalLine(root.right, line_num, h + 1);
    }

    // The main method that displays the given binary tree in
    // the vertical order
    void verticalOrder1(TreeNode root) {
        // Find min and max distances with resepect to root
        findMinMaximum(root, v, v, 0);
        // iterating across all of the possible vertical lines beginning from
        // the left most line and displaying the nodes line by line
        for (int line_num = v.minimum; line_num <= v.maximum; line_num++) {
            displayVerticalLine(root, line_num, 0);
            System.out.println("");
        }
    }

    // main method
    public static void main(String argvs[]) {
        // creating an object of the class VerticalOrder
        VerticalOrder tree = new VerticalOrder();
        // constructing the binary tree as shown
        // in the above diagram
        tree.r = new TreeNode(4);
        tree.r.left = new TreeNode(2);
        tree.r.right = new TreeNode(5);
        tree.r.left.left = new TreeNode(1);
        tree.r.left.right = new TreeNode(3);
        tree.r.right.left = new TreeNode(6);
        tree.r.right.right = new TreeNode(7);
        tree.r.right.left.right = new TreeNode(18);
        tree.r.right.right.right = new TreeNode(19);
        // print statement
        System.out.println("The vertical order traversal of the binary tree is :");
        // invoking method verticalOrder()
        tree.verticalOrder1(tree.r);
        // tree.verticalOrder2(tree.r);

    }
}
