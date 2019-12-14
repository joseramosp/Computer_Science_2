public class GraphMatrix<T> implements GraphInterface<T>{

	public GraphMatrix()
	{
		
	}

	private String[][] adjMatrix;
	private T[] valueList;
	private int edgeCount;
	
	public GraphMatrix(int n)
	{
		this.edgeCount=n;
		this.adjMatrix = new String[n][n];
		this.valueList = (T[]) new Object[n];
	}
	
	public void init(int n)
	{
		
	}

	public int nodeCount() {
		// TODO Auto-generated method stub
		return valueList.length;
	}

	public int edgeCount() {
		return edgeCount;
	}
	
	
	
	public T getValue(int v) {
		return valueList[v];
	}

	public void setValue(int v, T val)
	{
		valueList[v] = val;
	}

	public void addEdge(int v, int w, String wgt)
	{
		adjMatrix[v][w] = wgt;
	}

	public String weight(int v, int w)
	{
		return adjMatrix[v][w];
	}

	public void removeEdge(int v, int w)
	{
		adjMatrix[v][w] = "";
	}

	

	public int[] neighbors(int v)
	{
		int count=0;
		for(int i=0; i<edgeCount; i++)
		{
			if(adjMatrix[v][i] != "")
			{
				count++;
			}
		}
		
		int[] neigh = new int[count];
		
		for(int i=0; i<edgeCount; i++)
		{
			if(adjMatrix[v][i] != "")
			{
				neigh[count] = i;
			}
			count++;
		}
		
		return neigh;
	}
	
	public boolean hasEdge(int v, int w)
	{
		throw new UnsupportedOperationException("Not suported yet.");
	}
	
	
	public String toString()
	{
		String s = "";
		for (int i =0; i<adjMatrix.length; i++)
		{
			for(int j=0; j< adjMatrix.length; j++)
			{
				//s+="[i][j] = " + i +" " + j + " w = " + adjMatrix[i][j];
				s+=" " + adjMatrix[i][j];
			}
			s+="\n";
		}
		//s+=" ]";
		return s;
	}
	
}
