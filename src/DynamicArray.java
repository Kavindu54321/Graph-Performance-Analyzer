import java.util.Arrays;

public class DynamicArray {
    private int[] data;
    private int size;
    private int lastSteps;  

    public DynamicArray(int capacity) {
        data = new int[Math.max(capacity, 2)];
    }

    public int getSize() { return size; }
    public int getLastSteps() { return lastSteps; }
    public boolean isEmpty() { return size == 0; }

    public void insert(int index, int value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
        lastSteps = 0;
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
            lastSteps += size;                    
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
            lastSteps++;
        }
        data[index] = value;
        size++;
        lastSteps++;
    }

    public void append(int value) { insert(size, value); }

    public int deleteAt(int index) {
        if (isEmpty()) throw new IllegalStateException("Array is empty.");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        lastSteps = 0;
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            lastSteps++;
        }
        size--;
        lastSteps++;
        return removed;
    }

    public int deleteValue(int value) {
        int idx = linearSearch(value);
        int searchSteps = lastSteps;
        if (idx == -1) return -1;
        deleteAt(idx);
        lastSteps += searchSteps;
        return idx;
    }

    public int linearSearch(int target) {
        lastSteps = 0;
        for (int i = 0; i < size; i++) {
            lastSteps++;
            if (data[i] == target) return i;
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) { System.out.println("  Array is empty."); return; }
        StringBuilder sb = new StringBuilder("  [");
        for (int i = 0; i < size; i++) sb.append(data[i]).append(i < size - 1 ? ", " : "");
        System.out.println(sb.append("]  (size=" + size + ", capacity=" + data.length + ")"));
    }
}
