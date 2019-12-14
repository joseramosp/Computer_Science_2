public interface GraphInterface<T> {
    // Return the number of vertices
    int nodeCount();

    // Return the current number of edges
    int edgeCount();

    // Get the value of node with index v
    T getValue(int v);

    // Set the value of node with index v
    void setValue(int v, T val);

    // Adds a new edge from node v to node w with weight wgt
    void addEdge(int v, int w, String wgt);

    // Get the weight value for an edge
    String weight(int v, int w);

    // Removes the edge from the graph.
    void removeEdge(int v, int w);

    // Returns true iff the graph has the edge
    boolean hasEdge(int v, int w);

    // Returns an array containing the indices of the neighbors of v
    int[] neighbors(int v);

}
