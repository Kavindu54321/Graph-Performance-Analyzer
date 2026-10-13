public class MyQueue {
    private final int[] items;
    private int front = 0, rear = -1, count = 0;

    public MyQueue(int capacity) { items = new int[capacity]; }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == items.length; }

    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue overflow: queue is full (" + items.length + ").");
        rear = (rear + 1) % items.length;
        items[rear] = value;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue underflow: cannot dequeue from an empty queue.");
        int v = items[front];
        front = (front + 1) % items.length;
        count--;
        return v;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty: no front element.");
        return items[front];
    }

    public void display() {
        if (isEmpty()) { System.out.println("  Queue is empty."); return; }
        StringBuilder sb = new StringBuilder("  FRONT -> ");
        for (int i = 0; i < count; i++) sb.append(items[(front + i) % items.length]).append(" ");
        System.out.println(sb.append("<- REAR   (size=" + count + ")"));
    }
}
