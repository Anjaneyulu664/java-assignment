class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Q1_BinaryTree {

    static void printNodesAtK(Node root, int k) {
        if (root == null) return;

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printNodesAtK(root.left, k - 1);
        printNodesAtK(root.right, k - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printNodesAtK(root, 2);
    }
}