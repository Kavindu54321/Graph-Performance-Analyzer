import java.util.List;

public class PerformanceAnalyzer {

    public static void run(Graph graph) {
        System.out.println("\n=============================================");
        System.out.println("PERFORMANCE COMPARISON");
        System.out.println("=============================================");

        System.out.println("\n[1] SEARCHING - worst case (target not in data)");
        System.out.printf("%-10s %-16s %-12s %-14s%n", "N", "Algorithm", "Steps", "Time (us)");
        int[] sizes = {100, 1000, 10000, 100000};
        for (int n : sizes) {
            int[] a = Searching.generateSortedArray(n);
            int target = a[n - 1] + 1;
            SearchResult lin = Searching.linearSearch(a, target);
            SearchResult bin = Searching.binarySearch(a, target);
            System.out.printf("%-10d %-16s %-12d %-14.2f%n", n, "Linear Search", lin.steps, lin.nanos / 1000.0);
            System.out.printf("%-10s %-16s %-12d %-14.2f%n", "", "Binary Search", bin.steps, bin.nanos / 1000.0);
            ResultsLog.add("Performance: N=" + n + " Linear=" + lin.steps + " steps, Binary=" + bin.steps + " steps");
        }

        System.out.println("\n[2] GRAPH TRAVERSAL");
        Graph g = graph;
        if (g.isEmpty()) {
            g = new Graph();
            g.loadSample();
            System.out.println("(Your graph is empty - using the built-in sample graph A-F)");
        }
        String start = g.vertices().iterator().next();
        List<String> bfs = g.bfs(start);
        long bfsSteps = g.getLastSteps();
        List<String> dfs = g.dfs(start);
        long dfsSteps = g.getLastSteps();
        System.out.println("Start vertex: " + start + "  (V=" + g.vertexCount() + ", E=" + g.edgeCount() + ")");
        System.out.printf("%-18s %-10s %-8s %s%n", "Operation", "Algorithm", "Steps", "Result");
        System.out.printf("%-18s %-10s %-8d %s%n", "Graph Traversal", "BFS", bfsSteps, bfs);
        System.out.printf("%-18s %-10s %-8d %s%n", "Graph Traversal", "DFS", dfsSteps, dfs);
        ResultsLog.add("Performance: BFS=" + bfsSteps + " steps " + bfs + ", DFS=" + dfsSteps + " steps " + dfs);

        System.out.println("\n[3] INSERT AT FRONT - Array vs Linked List");
        System.out.printf("%-10s %-16s %-14s%n", "N items", "Structure", "Total steps");
        for (int n : new int[]{100, 1000, 5000}) {
            DynamicArray arr = new DynamicArray(4);
            MyLinkedList ll = new MyLinkedList();
            long arrSteps = 0, llSteps = 0;
            for (int i = 0; i < n; i++) {
                arr.insert(0, i);  arrSteps += arr.getLastSteps();
                ll.insertFront(i); llSteps += ll.getLastSteps();
            }
            System.out.printf("%-10d %-16s %-14d%n", n, "Array", arrSteps);
            System.out.printf("%-10s %-16s %-14d%n", "", "Linked List", llSteps);
            ResultsLog.add("Performance: insert-front N=" + n + " Array=" + arrSteps + " steps, LinkedList=" + llSteps + " steps");
        }

        System.out.println("\n=============================================");
        System.out.println("WHY THE RESULTS DIFFER");
        System.out.println(" - Linear search is O(n); binary search is O(log n) but needs sorted data.");
        System.out.println(" - BFS and DFS are both O(V + E); they differ in visit ORDER, not cost.");
        System.out.println(" - Array insert-at-front is O(n) (shifting); linked list is O(1).");
        System.out.println("=============================================");
    }
}
