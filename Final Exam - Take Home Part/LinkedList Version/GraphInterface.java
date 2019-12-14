/* Final Exam - Take Home

Name: Jose Ramos
NECC ID#: 00299444
Date: December 12, 2019

-- OBJECTIVE --

Using your graph implementation create a class called FSM (finite state machine) – you can extend the graph or use a
composition. Create an instance of FSM that models the inset graph.

NOTE: I am not testing if the FSM is failing or not. I am just assigning the values necessary to every edge to pass the
FSM conditions.

*/


interface GraphInterface<T>
{
    // Return the number of vertices
    int nodeCount();

    // Return the current number of edges
    int edgeCount();

    // Get the value of node with index v
    T getValue(int v);

    // Set the value of node with index v
    void setValue(int v, T val);

    // Adds a new edge from node v to node w with weight wgt
    void addEdge(int v, int w, int wgt);

    // Get the weight value for an edge
    int weight(int v, int w);

    // Removes the edge from the graph.
    void removeEdge(int v, int w);

    // Returns true iff the graph has the edge
    boolean hasEdge(int v, int w);

    // Returns an array containing the indicies of the neighbors of v
    int[] neighbors(int v);
}
