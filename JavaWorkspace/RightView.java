// Java program to print right view of binary tree

// A binary tree node
class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

// class to access maximum level by reference
class Max_level {

    int max_level;
}

class RightView {

    Node root;
    Max_level max = new Max_level();

    // Recursive function to print right view of a binary tree.
    void rightViewUtil(Node node, int level, Max_level max_level) {

        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
    }

    void rightView() {
        rightView(root);
    }

    // A wrapper over rightViewUtil()
    void rightView(Node node) {

        rightViewUtil(node, 1, max);
    }

    // Driver program to test the above functions
    public static void main(String args[]) {
        RightView tree = new RightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        tree.rightView();

    }
}

// This code has been contributed by Mayank Jaiswal

// import java.util.LinkedList;
// import java.util.Queue;

// public class RightView {

// // Represent the node of binary tree
// public static class Node {
// int data;
// Node left;
// Node right;

// public Node(int data) {
// // Assign data to the new node, set left and right children to null
// this.data = data;
// this.left = null;
// this.right = null;
// }
// }

// // Represent the root of binary tree
// public Node root;

// public RightView() {
// root = null;
// }

// // findMaximumWidth() will find out the maximum width of the given binary
// tree
// public int findMaximumWidth() {
// int maxWidth = 0;

// // Variable nodesInLevel keep tracks of number of nodes in each level
// int nodesInLevel = 0;
// // queue will be used to keep track of nodes of tree level-wise
// Queue<Node> queue = new LinkedList<Node>();

// // Check if root is null, then width will be 0
// if (root == null) {
// System.out.println("Tree is empty");
// return 0;
// } else {
// // Add root node to queue as it represents the first level
// queue.add(root);

// while (queue.size() != 0) {

// // Variable nodesInLevel will hold the size of queue i.e. number of elements
// in
// // queue
// nodesInLevel = queue.size();
// // maxWidth will hold maximum width.
// // If nodesInLevel is greater than maxWidth then, maxWidth will hold the
// value
// // of nodesInLevel
// maxWidth = Math.max(maxWidth, nodesInLevel);

// // If variable nodesInLevel contains more than one node
// // then, for each node, we'll add left and right child of the node to the
// queue
// while (nodesInLevel > 0) {
// Node current = queue.remove();
// if (current.left != null)
// queue.add(current.left);
// if (current.right != null)
// queue.add(current.right);
// nodesInLevel--;
// }
// }
// }
// return maxWidth;
// }

// public static void main(String[] args) {

// RightView bt = new RightView();
// // Add nodes to the binary tree
// bt.root = new Node(1);
// bt.root.left = new Node(2);
// bt.root.right = new Node(3);
// bt.root.left.left = new Node(4);
// bt.root.left.right = new Node(5);
// bt.root.right.left = new Node(6);
// bt.root.right.right = new Node(7);
// bt.root.left.left.left = new Node(8);

// // Display the maximum width of given tree
// System.out.println("Maximum width of the binary tree: " +
// bt.findMaximumWidth());
// }
// }