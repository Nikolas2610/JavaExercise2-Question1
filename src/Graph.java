import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

class Graph {
    private final int NODES;
    private final HashMap<Integer, Integer>[] nodesArray;
    private final int EDGES;

    Graph(int NODES, int EDGES) {
        this.EDGES = EDGES;
        this.NODES = NODES;
        nodesArray = new HashMap[NODES];

//      Add the nodes to an array of hashmaps
        for (int i = 0; i < NODES; i++) {
            nodesArray[i] = new HashMap<>();
        }
        addEdgesAutomatically();
    }

//    Get number of Nodes
    public int getNODES() {
        return NODES;
    }

    // Add an edge to the both nodes
    private void addEdge(int v, int w) {
        nodesArray[v].put(w, 1);
        nodesArray[w].put(v, 1);
    }

    // Add edges automatically to the graph
    private void addEdgesAutomatically() {
        for (int i = 0; i < EDGES; i++) {
            addEdge(randomNumber(0, (NODES - 1)), randomNumber(0, (NODES - 1)));
        }
    }

    // Check edge if exists to the graph and return the response message
    public String edgeExists(int u, int v) {
        String message = "";
        if (nodesArray[u].containsKey(v) && nodesArray[v].containsKey(u)) {
            message += "\033[34m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\033[0m\n" +
                    "\033[32mThe edge between vertex " + u + " and vertex " + v + " exists in the graph.\033[0m\n" +
                    "\033[34m++++++++++++++++++++++++++++++++++++++++++++\033[0m\n";
        } else {
            message += "\033[34m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\033[0m\n" +
                    "\033[31mThe edge between vertex " + u + " and vertex " + v + " does not exist in the graph.\033[0m\n" +
                    "\033[34m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\033[0m\n";
        }
        return message;
    }

    // Print the edges to a string format for the option to save it to a text file
    private String printEdges() {
        String message = "";
        message += "++++++++++++++++++++++++++++++++++++++++++++\n";
        message += "The edges in the graph are: \n";
        for (int i = 0; i < NODES; i++) {
            for (int j : nodesArray[i].keySet()) {
                message +=  i + " \t\t\t" + j + "\n";
            }
        }
        message += "++++++++++++++++++++++++++++++++++++++++++++\n";
        return message;
    }

    // Save the graph to a txt file
    public void saveGraphToFile() {
        System.out.println("\033[34m Start to save the edges to the graph.txt file! We need some time for this process\033[0m");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("graph.txt"))) {
            String message = printEdges();
            bw.write(message);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the graph to a txt file");
            e.printStackTrace();
        }
        System.out.println("\033[34m Save graph to file\033[0m");
    }

    //  Return random number
    private static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max + 1) - min) + (min);
    }
}