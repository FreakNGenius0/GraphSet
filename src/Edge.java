import java.util.LinkedList;

public class Edge {
    private int v1, v2, id;
    
    public Edge(int vertex1, int vertex2, int ID) {
        v1 = vertex1;
        v2 = vertex2;
        id = ID;
    }

    public boolean checkID(int target) {
        return id == target;
    }

    public String toString() {
        return v1 + " -- " + v2;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }
}
