import sources.BinaryTree;
import sources.Position;

public class ex2 {
    // first attempt below, didn't want to delete it
    /*
    public static int findMinInATree(LinkedBinaryTree<Integer> tree, Position<Integer> position) {
        int min = tree.root.getElement();

        printInorder(position, tree, min);

        return min;
    }

    private static void printInorder(Position<Integer> position, BinaryTree<Integer> tree, int min) {
        if (position == null)
            return;

        if(min > position.getElement()){
            min = position.getElement();
        }


        // first recur on left child
        printInorder(tree.left(position), tree, min);

        // then print the data of node
        System.out.print(position.getElement() + " ");


        System.out.println(min);
        // now recur on right child
        printInorder(tree.right(position), tree, min);
    }

    */


    // second attempt
    // O(n) since it loops through the tree and compares the elements
    public static int findMinInATree(LinkedBinaryTree<Integer> tree, Position<Integer> root){
        int min = root.getElement();

        if (tree.left(root) != null){
            int curr = findMinInATree(tree, tree.left(root));
            if(min > curr){
                min = curr;
            }
        }
        if (tree.right(root) != null){
            int curr = findMinInATree(tree, tree.right(root));
            if(min > curr){
                min = curr;
            }
        }
        return min;
    }



    public static void main(String[] args) {

        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

        tree.addRoot(5);
        tree.addLeft(tree.root, 2);
        tree.addRight(tree.root, 7);

        tree.addLeft(tree.root.getLeft(), 1);
        tree.addRight(tree.root.getLeft(), 3);

        tree.addLeft(tree.root.getRight(), 6);
        tree.addRight(tree.root.getRight(), 8);

        System.out.println(findMinInATree(tree, tree.root));

    }
}
