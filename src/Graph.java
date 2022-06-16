import java.util.LinkedList;

public class Graph {
    private LinkedList<Edge> edgeList;

   public Graph(int vertices) {
        edgeList = new LinkedList<>();
   }

   public void addEdge(Edge e) {
       edgeList.add(e);
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
}
