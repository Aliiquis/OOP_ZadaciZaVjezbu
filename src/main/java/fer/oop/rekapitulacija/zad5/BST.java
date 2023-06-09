package fer.oop.rekapitulacija.zad5;

public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void add(int i) {
        Node node = new Node(i);
        if (root == null) {
            root = node;
            return;
        }
        boolean inserted = false;
        Node current = root;
        while (!inserted) {
            if (node.getValue() < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    inserted = true;
                } else {
                    current = current.getLeft();
                }
            } else {
                if (current.getRight() == null) {
                    current.setRight(node);
                    inserted = true;
                } else {
                    current = current.getRight();
                }
            }
        }
    }

    static void printNode(Node root, int space) {
        if (root == null) {
            return;
        }
        space += 10;
        printNode(root.getRight(), space);
        System.out.println();
        for (int i = 10; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.getValue());
        printNode(root.getLeft(), space);
    }

    public void print() {
        printNode(root, 0);
    }
}
