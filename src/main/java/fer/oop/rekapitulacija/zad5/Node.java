package fer.oop.rekapitulacija.zad5;

public class Node {
    private Node parent;
    private Node left = null;
    private Node right = null;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    @Override
    public String toString() {
        return "V: " + value + " L: " + (left == null ? "null" : left.getValue()) + " R: " + (right == null ? "null" : right.getValue());
    }
}
