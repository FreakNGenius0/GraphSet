public class App {
    public static void main(String[] args) throws Exception {
        GraphSet G = new GraphSet(4);

        System.out.println(G.getComplete().toString());

        for (int i = 0; i < G.size(); i++) {
            System.out.println(G.getGraph(i).toString());
            System.out.println(G.getGraph(i).isTree());
        }
    }
}
