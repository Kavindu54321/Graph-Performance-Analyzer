public class MyLinkedList {
    private static class Node {
        int value; Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size;
    private int lastSteps;

    public int getSize() { return size; }
    public int getLastSteps() { return lastSteps; }
    public boolean isEmpty() { return head == null; }

    public void insertFront(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
        size++;
        lastSteps = 1;
    }

    public void insertEnd(int value) {
        Node n = new Node(value);
        lastSteps = 1;
        if (head == null) { head = n; }
        else {
            Node cur = head;
            while (cur.next != null) { cur = cur.next; lastSteps++; }
            cur.next = n;
        }
        size++;
    }

    public boolean delete(int value) {
        if (isEmpty()) throw new IllegalStateException("Linked list is empty.");
        lastSteps = 1;
        if (head.value == value) { head = head.next; size--; return true; }
        Node cur = head;
        while (cur.next != null) {
            lastSteps++;
            if (cur.next.value == value) { cur.next = cur.next.next; size--; return true; }
            cur = cur.next;
        }
        return false;
    }

    public int search(int value) {
        lastSteps = 0;
        int pos = 0;
        for (Node cur = head; cur != null; cur = cur.next, pos++) {
            lastSteps++;
            if (cur.value == value) return pos;
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) { System.out.println("  Linked list is empty."); return; }
        StringBuilder sb = new StringBuilder("  HEAD -> ");
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.value).append(" -> ");
        System.out.println(sb.append("NULL   (size=" + size + ")"));
    }
}
