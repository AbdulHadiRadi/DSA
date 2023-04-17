package Graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuildGraphTest {
    private BuildGraph graphBuilder;
    private ArrayList<Edge>[] graph;
    @BeforeEach
    void setUp() {
        graphBuilder = new BuildGraph(7);
        graph =  graphBuilder.buildGraph();
        //getNeighbours(graph,2);
        boolean [] visited = new boolean[graph.length];
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buildGraph() {
    }

    @Test
    void getNeighbours() {
    }

    @Test
    void bfs() {
    }
}