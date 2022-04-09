import sources.ArrayList;

public class ex1 {
    // the method is in LinkedBinaryTree class
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

        tree.addRoot(5);
        tree.addLeft(tree.root, 2);
        tree.addRight(tree.root, 7);

        tree.addLeft(tree.root.getLeft(), 1);
        tree.addRight(tree.root.getLeft(), 3);

        tree.addLeft(tree.root.getRight(), 6);
        tree.addRight(tree.root.getRight(), 8);


        ArrayList anc = tree.ancestors(tree.root.getRight().getRight());
        System.out.println(anc);

        ArrayList anc1 = tree.ancestors(tree.root.getLeft().getRight());
        System.out.println(anc1);

//        System.out.println(tree.ancestors(tree.root));


    }
}
