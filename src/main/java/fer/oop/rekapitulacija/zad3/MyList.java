package fer.oop.rekapitulacija.zad3;

public class MyList {
    private MyListElement head;
    private MyListElement last;
    private int size = 0;

    public MyList() {
        head = null;
    }

    public int addLast(Object data) {
        MyListElement element = new MyListElement(data);
        if (size == 0) {
            head = element;
        } else {
            last.setHead(element);
        }
        last = element;
        return size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyListElement element = head;
        if (index == 0) {
            head = head.getHead();
            size--;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            element = element.getHead();
        }
        element.setHead(element.getHead().getHead());
        size--;
    }

    public Object elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyListElement element = head;
        for (int i = 0; i < index; i++) {
            element = element.getHead();
        }
        return element.getData();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }
        return head.toString() + ' ';
    }
}
