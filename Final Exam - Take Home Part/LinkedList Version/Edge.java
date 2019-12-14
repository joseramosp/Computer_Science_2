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

public class Edge {

	int vertex;
	int weight;
	Edge prev, next;
	Edge(int v, int w, Edge p, Edge n)
	{
		vertex = v;
		weight = w;
		prev = p;
		next = n;
	}
}
