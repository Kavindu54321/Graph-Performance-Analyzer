public class Main {
    private static final DynamicArray array = new DynamicArray(5);
    private static final MyStack stack = new MyStack(10);
    private static final MyQueue queue = new MyQueue(10);
    private static final MyLinkedList list = new MyLinkedList();
    private static final Searching searching = new Searching();
    private static final Graph graph = new Graph();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=============================================");
            System.out.println("DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            switch (InputHelper.readInt("Enter your choice: ", 1, 9)) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: PerformanceAnalyzer.run(graph); InputHelper.pause(); break;
                case 8: ResultsLog.displayAll(); InputHelper.pause(); break;
                case 9: running = false; System.out.println("Goodbye!"); break;
            }
        }
    }

    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at Position\n2. Insert at End\n3. Delete by Index");
            System.out.println("4. Delete by Value\n5. Search (Linear)\n6. Display\n7. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 7);
            try {
                switch (c) {
                    case 1: {
                        int idx = InputHelper.readInt("Index (0-" + array.getSize() + "): ");
                        int val = InputHelper.readInt("Value: ");
                        array.insert(idx, val);
                        report("Array: inserted " + val + " at index " + idx, array.getLastSteps());
                        break;
                    }
                    case 2: {
                        int val = InputHelper.readInt("Value: ");
                        array.append(val);
                        report("Array: appended " + val, array.getLastSteps());
                        break;
                    }
                    case 3: {
                        if (array.isEmpty()) throw new IllegalStateException("Array is empty.");
                        int idx = InputHelper.readInt("Index to delete: ");
                        int removed = array.deleteAt(idx);
                        report("Array: deleted " + removed + " from index " + idx, array.getLastSteps());
                        break;
                    }
                    case 4: {
                        if (array.isEmpty()) throw new IllegalStateException("Array is empty.");
                        int val = InputHelper.readInt("Value to delete: ");
                        int at = array.deleteValue(val);
                        if (at < 0) System.out.println("  Value " + val + " not found.");
                        else report("Array: deleted value " + val + " (was at index " + at + ")", array.getLastSteps());
                        break;
                    }
                    case 5: {
                        if (array.isEmpty()) throw new IllegalStateException("Array is empty.");
                        int val = InputHelper.readInt("Value to search: ");
                        int at = array.linearSearch(val);
                        report(at < 0 ? "Array: " + val + " not found" : "Array: found " + val + " at index " + at,
                               array.getLastSteps());
                        break;
                    }
                    case 6: array.display(); break;
                    case 7: return;
                }
            } catch (RuntimeException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    private static void stackMenu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 5);
            try {
                switch (c) {
                    case 1: { int v = InputHelper.readInt("Value to push: ");
                              stack.push(v); report("Stack: pushed " + v, 1); break; }
                    case 2: { int v = stack.pop(); report("Stack: popped " + v, 1); break; }
                    case 3: System.out.println("  Top element: " + stack.peek()); break;
                    case 4: stack.display(); break;
                    case 5: return;
                }
            } catch (RuntimeException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    private static void queueMenu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek/Front\n4. Display\n5. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 5);
            try {
                switch (c) {
                    case 1: { int v = InputHelper.readInt("Value to enqueue: ");
                              queue.enqueue(v); report("Queue: enqueued " + v, 1); break; }
                    case 2: { int v = queue.dequeue(); report("Queue: dequeued " + v, 1); break; }
                    case 3: System.out.println("  Front element: " + queue.peek()); break;
                    case 4: queue.display(); break;
                    case 5: return;
                }
            } catch (RuntimeException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    private static void linkedListMenu() {
        while (true) {
            System.out.println("\n------------- LINKED LIST OPERATIONS -------------");
            System.out.println("1. Insert at Front\n2. Insert at End\n3. Delete by Value");
            System.out.println("4. Search\n5. Display\n6. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 6);
            try {
                switch (c) {
                    case 1: { int v = InputHelper.readInt("Value: ");
                              list.insertFront(v); report("LinkedList: inserted " + v + " at front", list.getLastSteps()); break; }
                    case 2: { int v = InputHelper.readInt("Value: ");
                              list.insertEnd(v); report("LinkedList: inserted " + v + " at end", list.getLastSteps()); break; }
                    case 3: { int v = InputHelper.readInt("Value to delete: ");
                              if (list.delete(v)) report("LinkedList: deleted " + v, list.getLastSteps());
                              else System.out.println("  Value " + v + " not found."); break; }
                    case 4: { if (list.isEmpty()) throw new IllegalStateException("Linked list is empty.");
                              int v = InputHelper.readInt("Value to search: ");
                              int pos = list.search(v);
                              report(pos < 0 ? "LinkedList: " + v + " not found" : "LinkedList: found " + v + " at position " + pos,
                                     list.getLastSteps()); break; }
                    case 5: list.display(); break;
                    case 6: return;
                }
            } catch (RuntimeException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    private static void searchMenu() {
        while (true) {
            System.out.println("\n------------- SEARCHING OPERATIONS -------------");
            System.out.println("1. Generate Sorted Dataset\n2. Linear Search\n3. Binary Search");
            System.out.println("4. Compare Linear vs Binary\n5. Show Dataset Sample\n6. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 6);
            if (c == 6) return;
            if (c == 1) {
                int n = InputHelper.readInt("Dataset size (1-1000000): ", 1, 1000000);
                searching.generateSorted(n);
                System.out.println("  Generated " + n + " sorted values.");
                searching.displaySample();
                continue;
            }
            if (searching.isEmpty()) { System.out.println("  [!] Generate a dataset first (option 1)."); continue; }
            if (c == 5) { searching.displaySample(); continue; }
            int target = InputHelper.readInt("Target value: ");
            if (c == 2) {
                printSearch("Linear Search", searching.linear(target), target);
            } else if (c == 3) {
                printSearch("Binary Search", searching.binary(target), target);
            } else {
                System.out.println("\n  Target = " + target + "   N = " + searching.getData().length);
                printSearch("Linear Search", searching.linear(target), target);
                printSearch("Binary Search", searching.binary(target), target);
            }
        }
    }

    private static void printSearch(String name, SearchResult r, int target) {
        String msg = r.found() ? "found at index " + r.index : "not found";
        System.out.printf("  %-14s %-20s steps=%-8d time=%.2f us%n", name, msg, r.steps, r.nanos / 1000.0);
        ResultsLog.add(name + " for " + target + ": " + msg + ", steps=" + r.steps
                + ", time=" + String.format("%.2f", r.nanos / 1000.0) + " us");
    }

    private static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. BFS Traversal");
            System.out.println("5. DFS Traversal\n6. Find Shortest Path (search)\n7. Load Sample Graph\n8. Return to Main Menu");
            int c = InputHelper.readInt("Enter your choice: ", 1, 8);
            try {
                switch (c) {
                    case 1: { String v = InputHelper.readLabel("Vertex label: ");
                              graph.addVertex(v); System.out.println("  Added vertex " + v); break; }
                    case 2: { String a = InputHelper.readLabel("From vertex: ");
                              String b = InputHelper.readLabel("To vertex: ");
                              graph.addEdge(a, b); System.out.println("  Added edge " + a + " - " + b); break; }
                    case 3: graph.display(); break;
                    case 4: case 5: {
                        if (graph.isEmpty()) throw new IllegalStateException("Graph is empty. Add vertices first.");
                        String s = InputHelper.readLabel("Start vertex " + graph.vertices() + ": ");
                        boolean bfs = (c == 4);
                        java.util.List<String> order = bfs ? graph.bfs(s) : graph.dfs(s);
                        String name = bfs ? "BFS" : "DFS";
                        System.out.println("  " + name + " order: " + order);
                        report("Graph " + name + " from " + s + ": " + order, graph.getLastSteps());
                        break;
                    }
                    case 6: {
                        if (graph.isEmpty()) throw new IllegalStateException("Graph is empty. Add vertices first.");
                        String a = InputHelper.readLabel("From vertex: ");
                        String b = InputHelper.readLabel("To vertex: ");
                        java.util.List<String> p = graph.shortestPath(a, b);
                        if (p == null) System.out.println("  No path between " + a + " and " + b + ".");
                        else report("Graph shortest path " + a + "->" + b + ": " + p, graph.getLastSteps());
                        break;
                    }
                    case 7: graph.loadSample(); System.out.println("  Sample graph loaded."); graph.display(); break;
                    case 8: return;
                }
            } catch (RuntimeException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    private static void report(String message, int steps) {
        System.out.println("  " + message + "  (steps: " + steps + ")");
        ResultsLog.add(message + " [steps: " + steps + "]");
    }
}
