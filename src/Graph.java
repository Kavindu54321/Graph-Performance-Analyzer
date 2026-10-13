import java.util.*;

public class Graph {
    private final Map<String, List<String>> adj = new LinkedHashMap<>();
    private int lastSteps;   

    public int getLastSteps() { return lastSteps; }
    public boolean isEmpty() { return adj.isEmpty(); }
    public boolean hasVertex(String v) { return adj.containsKey(v); }
    public int vertexCount() { return adj.size(); }
    public Set<String> vertices() { return adj.keySet(); }

    public int edgeCount() {
        int total = 0;
        for (List<String> l : adj.values()) total += l.size();
        return total / 2;
    }

    public void addVertex(String v) {
        if (adj.containsKey(v)) throw new IllegalArgumentException("Vertex " + v + " already exists.");
        adj.put(v, new ArrayList<>());
    }

    public void addEdge(String a, String b) {
        if (!adj.containsKey(a)) throw new IllegalArgumentException("Vertex " + a + " does not exist.");
        if (!adj.containsKey(b)) throw new IllegalArgumentException("Vertex " + b + " does not exist.");
        if (a.equals(b)) throw new IllegalArgumentException("Self-loops are not allowed.");
        if (adj.get(a).contains(b)) throw new IllegalArgumentException("Edge " + a + "-" + b + " already exists.");
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public void display() {
        if (isEmpty()) { System.out.println("  Graph is empty."); return; }
        System.out.println("  Adjacency list (" + vertexCount() + " vertices, " + edgeCount() + " edges):");
        for (Map.Entry<String, List<String>> e : adj.entrySet())
            System.out.println("   " + e.getKey() + " -> " + (e.getValue().isEmpty() ? "(none)" : e.getValue()));
    }

    public List<String> bfs(String start) {
        requireVertex(start);
        lastSteps = 0;
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start); visited.add(start);
        while (!q.isEmpty()) {
            String v = q.poll();
            order.add(v);
            lastSteps++;                       
            for (String n : adj.get(v)) {
                lastSteps++;                   
                if (visited.add(n)) q.add(n);
            }
        }
        return order;
    }

    public List<String> dfs(String start) {
        requireVertex(start);
        lastSteps = 0;
        List<String> order = new ArrayList<>();
        dfsVisit(start, new HashSet<>(), order);
        return order;
    }

    private void dfsVisit(String v, Set<String> visited, List<String> order) {
        visited.add(v);
        order.add(v);
        lastSteps++;                          
        for (String n : adj.get(v)) {
            lastSteps++;                     
            if (!visited.contains(n)) dfsVisit(n, visited, order);
        }
    }

    public List<String> shortestPath(String from, String to) {
        requireVertex(from); requireVertex(to);
        lastSteps = 0;
        Map<String, String> parent = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(from); parent.put(from, null);
        while (!q.isEmpty()) {
            String v = q.poll();
            lastSteps++;
            if (v.equals(to)) break;
            for (String n : adj.get(v)) {
                lastSteps++;
                if (!parent.containsKey(n)) { parent.put(n, v); q.add(n); }
            }
        }
        if (!parent.containsKey(to)) return null;
        LinkedList<String> path = new LinkedList<>();
        for (String v = to; v != null; v = parent.get(v)) path.addFirst(v);
        return path;
    }

    public void loadSample() {
        adj.clear();
        for (String v : new String[]{"A", "B", "C", "D", "E", "F"}) addVertex(v);
        String[][] edges = {{"A","B"},{"A","C"},{"B","D"},{"B","E"},{"C","F"},{"E","F"}};
        for (String[] e : edges) addEdge(e[0], e[1]);
    }

    private void requireVertex(String v) {
        if (!adj.containsKey(v)) throw new IllegalArgumentException("Vertex " + v + " does not exist.");
    }
}
