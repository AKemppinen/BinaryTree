public class Main {
    public static void main(String[] args) {
        System.out.println("Binarysearchtree test:");
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        //First add makes root
        binarySearchTree.add(50);

        binarySearchTree.add(77);
        binarySearchTree.add(9);
        binarySearchTree.add(181);
        binarySearchTree.add(4);
        binarySearchTree.add(60);
        binarySearchTree.add(44);


        binarySearchTree.printPreorder();
        binarySearchTree.printHeight();

        binarySearchTree.remove(9);
        binarySearchTree.printPreorder();
        binarySearchTree.add(2);

        binarySearchTree.printPreorder();
        binarySearchTree.printHeight();

        binarySearchTree.find(1);
        binarySearchTree.find(4);

    }
}