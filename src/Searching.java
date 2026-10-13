import java.util.Random;

public class Searching {
    private int[] data = new int[0];

    public int[] getData() { return data; }
    public boolean isEmpty() { return data.length == 0; }

    public void generateSorted(int n) {
        data = generateSortedArray(n);
    }

    public static int[] generateSortedArray(int n) {
        int[] a = new int[n];
        Random r = new Random(42);
        int cur = 0;
        for (int i = 0; i < n; i++) { cur += 1 + r.nextInt(5); a[i] = cur; }
        return a;
    }

    public static SearchResult linearSearch(int[] a, int target) {
        long steps = 0, start = System.nanoTime();
        int found = -1;
        for (int i = 0; i < a.length; i++) {
            steps++;
            if (a[i] == target) { found = i; break; }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    public static SearchResult binarySearch(int[] a, int target) {
        long steps = 0, start = System.nanoTime();
        int lo = 0, hi = a.length - 1, found = -1;
        while (lo <= hi) {
            steps++;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) { found = mid; break; }
            else if (a[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    public SearchResult linear(int target) { return linearSearch(data, target); }
    public SearchResult binary(int target) { return binarySearch(data, target); }

    public void displaySample() {
        int n = Math.min(data.length, 20);
        StringBuilder sb = new StringBuilder("  First " + n + " of " + data.length + ": ");
        for (int i = 0; i < n; i++) sb.append(data[i]).append(" ");
        System.out.println(sb);
    }
}
