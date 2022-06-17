public class GraphSet {
    private Graph K;
    private int current = 0;
    private int num_edges, num_graphs, v;

   
    public GraphSet(int vertices) {
        v = vertices;
        num_edges = (vertices*(vertices-1))/2;
        num_graphs = (int) Math.pow(2,num_edges);
        K = new Graph(vertices);

        int index = 0;
        for (int v1 = 0; v1 < vertices-1; v1++) {
            for (int v2 = v1+1; v2 < vertices; v2++) {
                Edge e = new Edge(v1, v2, index);
                K.addEdge(e);
                index++;
            }
        }

    }

    public Graph getCurrent() {
        return this.getGraph(current);
    } 

    public Graph getNext() {
        current++;
        if (current >= num_graphs) {current = 0;}
        return this.getGraph(current);
    }

    public Graph getComplete() {
        return K;
    }

    public Graph getGraph(int i) {
        Graph G = new Graph(v);
        String key = Integer.toBinaryString(i);
        while (key.length() < num_edges) {
            key = "0" + key;
        }
        boolean[] key_bool = new boolean[num_edges];
        for (int j = 0; j < num_edges; j++) {
            if (key.charAt(num_edges-1-j) == '1') {
                key_bool[j] = true;
            } else {
                key_bool[j] = false;
            }
        }
        int index = 0;
        for (Edge e : K.getEdges()) {
            if (key_bool[index]) {
                G.addEdge(e);
            }
            index++;
        }
        return G;
    }

    public int size() {
        return num_graphs; 
    }

    public Graph getNextTree() {
        if (this.getNext().isTree()) {
            return this.getCurrent();
        } else {
            return this.getNextTree();
        }
    }
}
