package fer.oop.rekapitulacija.zad3;

public class MyListElement {
    private MyListElement head;
    private Object data;

    public MyListElement(Object data) {
        this.data = data;
        this.head = null;
    }

    public void setHead(MyListElement head) {
        this.head = head;
    }

    public MyListElement getHead() {
        return head;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        if (head == null) {
            return data.toString();
        }
        return data.toString() + ' ' + head.toString();
    }
}
