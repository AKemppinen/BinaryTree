// BinarySearchTree class
public class BinarySearchTree {
    private Node root;

    // Node class
    private static class Node {
        private int key;
        private Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }

    // Adds a new node to the tree in the right place
    public void add(int key) {
        root = add(root, key);
    }

    // Recursive helper method for adding a new node
    private Node add(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = add(node.left, key);
        } else if (key > node.key) {
            node.right = add(node.right, key);
        }
        // If the key is already in the tree, do nothing
        return node;
    }

    // Removes an arbitrary node from the tree
    public void remove(int key) {
        root = remove(root, key);
    }

    // Recursive helper method for removing a node
    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            // Handle 3 cases:
            // 1. The node has no children (leaf node)
            if (node.left == null && node.right == null) {
                return null;
            }
            // 2. The node has only one child
            else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // 3. The node has two children
            else {
                // Find the successor node (the minimum key in the right subtree)
                Node successor = findMin(node.right);
                // Replace the node's key with the successor's key
                node.key = successor.key;
                // Delete the successor node
                node.right = remove(node.right, successor.key);
            }
        }
        return node;
    }

    // Helper method for finding the minimum key in a subtree
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Prints the tree in preorder
    public void printPreorder() {
        printPreorder(root);
        System.out.println();
    }

    // Recursive helper method for printing the tree in preorder
    private void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public int height() {
        return height(root);
    }

    // Recursive helper method for calculating the height of a subtree
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Method for printing the height of the tree
    public void printHeight() {
        System.out.println("height: " + height());
    }
}