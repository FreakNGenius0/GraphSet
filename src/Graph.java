import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private LinkedList<Edge> edgeList;
    private int v, edges = 0;

   public Graph(int vertices) {
        v = vertices;
        edgeList = new LinkedList<>();
   }

   public void addEdge(Edge e) {
       edgeList.add(e);
       edges++;
   }

   public LinkedList<Edge> getEdges() {
       return edgeList;
   }

   public int numEdges() {
       return edges;
   }

   public String toString() {
       String ans = "";
       for (Edge e : edgeList) {
           ans += e.toString();
           ans += "\n";
       }
       return ans;
   }

   public LinkedList[] toAdjacencyList() {
       LinkedList<Integer>[] adjacency = new LinkedList[v];
       for (int i = 0; i < v; i++) {
           adjacency[i] = new LinkedList<>();
           for (Edge e : edgeList) {
               if (e.getV1() == i) {
                   adjacency[i].add(e.getV2());
               } else if (e.getV2() == i) {
                   adjacency[i].add(e.getV1());
               }
           }
       }
       return adjacency;
   }

   private boolean hasCycle(int v, boolean[] visited, int parent, LinkedList<Integer>[] adj) {
        visited[v] = true;
        for (int vertex : adj[v]) {
            if (!visited[vertex]) {
                if (hasCycle(vertex, visited, v, adj)) {
                    return true;
                }
            } else if (vertex != parent) {
                return true;
            }
        }
        return false;
   }

   public boolean isTree() {
       boolean[] visited = new boolean[v];
       Arrays.fill(visited, false);
       LinkedList<Integer>[] adjacency = this.toAdjacencyList();

       if (hasCycle(0, visited, -1, adjacency)) {
           return false;
       }

       for (boolean vertex : visited) {
           if (!vertex) {
               return false;
           }
       }
      
       return true;
   }
}
