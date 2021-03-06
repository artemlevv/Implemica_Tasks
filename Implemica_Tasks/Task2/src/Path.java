import static java.lang.Math.min;
import static java.util.Arrays.fill;

/**
 * @author Artem Levchenko
 */
public class Path {
    private final int inf = 10001;
    // Adjacency matrix
    private int[][] cost;

    /**
     * @param vertices is the number of vertices in the graph
     */
    public Path(int vertices) {
        cost = new int[vertices][vertices];
    }

    /**
     * Set the weight between the cities
     *
     * @param i      point and point j that create an edge [path]
     * @param j      point and point i that create an edge [path]
     * @param weight of the edges - non-negative number
     */
    public void set(int i, int j, int weight) {
        cost[i][j] = weight;
    }

    /**
     * Transportation cost
     *
     * @param i point and point j that create an edge
     * @param j point and point i that create an edge
     * @return 0 if i and j are the same, infinity, if there is no connection
     */
    private int getCost(int i, int j) {
        if (i == j) {
            return 0;
        }
        if (cost[i][j] == 0) {
            return inf;
        }
        return cost[i][j];
    }

    /**
     * Select the closest untagged vertex
     *
     * @param result  assign top vertex equal to source
     * @param visited an array of visited cities
     * @return the index of the smallest element of distances, ignoring those in visited.
     */
    private int getUntaggedVertex(Integer[] result, boolean[] visited) {
        int best = -1;
        for (int i = 0; i < cost.length; i++) { // Sort out the vertices
            if (!visited[i] && ((best < 0) || (result[i] < result[best]))) { // Select the closest untagged vertex
                best = i;
            }
        }
        return best;
    }

    /**
     * Returns The ways of minimum cost between pairs of cities
     *
     * @param startIndex Initial vertex
     * @return an array of distances between cities
     */
    public Integer[] minimumCost(int startIndex) {
        boolean[] visited = new boolean[cost.length];// visit the city
        Integer[] result = new Integer[cost.length]; // distance array
        fill(result, inf);                      // set the distance to all vertices INFINITY
        result[startIndex] = startIndex;             // initial vertex

        for (int[] aCost : cost) {
            int city = getUntaggedVertex(result, visited);
            visited[city] = true;
            for (int j = 0; j < cost.length; j++) {
                result[j] = min(result[j], result[city] + getCost(city, j));
            }
        }
        return result;
    }
}
