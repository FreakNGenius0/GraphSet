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

   public boolean isTree() {
       boolean[] visited = new boolean[v];
       Arrays.fill(visited, false);
       Integer parent = null;
       Stack<Integer> stack = new Stack<Integer>();
       LinkedList<Integer>[] adjacency = this.toAdjacencyList();

       stack.add(0);
       visited[0] = true;
       while (!stack.empty()) {
           int current = stack.pop();
           for (int vertex : adjacency[current]) {
               if (visited[vertex] == true && vertex != current && vertex != parent) {
                   return false;
               } else if (adjacency[vertex].size() != 1 && vertex != current){
                   stack.add(vertex);
               }
               visited[vertex] = true;
               parent = vertex;
           }
       }

       for (boolean vertex : visited) {
           if (!vertex) {
               return false;
           }
       }
      
       return true;
   }
}
