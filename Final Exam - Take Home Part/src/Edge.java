public class Edge {

	int vertex, weight;
	Edge prev, next;
	Edge(int v, int w, Edge p, Edge n)
	{
		vertex = v;
		weight = w;
		prev = p;
		next = n;
	}
}
