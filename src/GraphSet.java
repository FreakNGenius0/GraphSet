public class GraphSet {
    private Graph[] all_the_graphs;
    private Graph K;
    private int current = 0;
   
    public GraphSet(int vertices) {
        int num_edges = (vertices*(vertices-1))/2;
        int num_graphs = (int) Math.pow(2,num_edges);
        all_the_graphs = new Graph[num_graphs];
        K = new Graph(vertices);

        int index = 0;
        for (int v1 = 0; v1 < vertices-1; v1++) {
            for (int v2 = v1+1; v2 < vertices; v2++) {
                Edge e = new Edge(v1, v2, index);
                K.addEdge(e);
                index++;
            }
        }

        for (int i = 0; i < num_graphs; i++) {
            all_the_graphs[i] = new Graph(vertices);
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
            index = 0;
            for (Edge e : K.getEdges()) {
                if (key_bool[index]) {
                    all_the_graphs[i].addEdge(e);
                }
                index++;
            }
        }
    }

    public Graph getCurrent() {
        return all_the_graphs[current];
    } 

    public Graph getNext() {
        current++;
        if (current >= all_the_graphs.length) {current = 0;}
        return all_the_graphs[current];
    }

    public Graph getComplete() {
        return K;
    }

    public Graph getGraph(int index) {
        return all_the_graphs[index];
    }

    public Graph[] getAll() {
        return all_the_graphs;
    }

    public int size() {
        return all_the_graphs.length;
    }
}
