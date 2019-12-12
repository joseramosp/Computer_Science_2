public class GraphLink<T> implements GraphInterface<T> {

    private Edge[] nodeArray;
    private T[] nodeValues;
    private int numEdge;

    public GraphLink(int n)
    {
        nodeArray = new Edge[n];

        for(int i=0; i<n; i++)
        {
            nodeArray[i] = new Edge(-1,-1,null,null);
        }
        nodeValues = (T[]) new Object[n];
        numEdge = 0;
    }

    public void init(int n) {
        // TODO Auto-generated method stub
        nodeArray = new Edge[n];

        for(int i=0; i<n; i++)
        {
            nodeArray[i] = new Edge(-1,-1,null,null);
        }
        nodeValues = (T[]) new Object[n];
        numEdge = 0;
    }

    public int nodeCount() {
        // TODO Auto-generated method stub
        return nodeArray.length;
    }

    public int edgeCount() {
        // TODO Auto-generated method stub
        return numEdge;
    }

    public T getValue(int v) {
        // TODO Auto-generated method stub
        return nodeValues[v];
    }

    public void setValue(int v, T val) {
        // TODO Auto-generated method stub
        nodeValues[v]=val;
    }

    private Edge find(int v, int w)
    {
        Edge curr = nodeArray[v];
        while((curr.next !=null)&&(curr.next.vertex<w))
        {
            curr = curr.next;
        }
        return curr;
    }


    public void addEdge(int v, int w, int wgt) {
        // TODO Auto-generated method stub
        if (wgt == 0) return;
        Edge curr = find(v,w);
        if((curr.next !=null)&&(curr.next.vertex==w))
            curr.next.weight=wgt;
        else
        {
            curr.next = new Edge(w, wgt, curr, curr.next);
            if (curr.next.next != null) curr.next.next.prev = curr.next;
        }
        numEdge++;
    }

    public int weight(int v, int w) {
        // TODO Auto-generated method stub
        Edge curr = find(v,w);
        if ((curr.next == null) || (curr.next.vertex != w)) return 0;
        else return curr.next.weight;
    }

    public void removeEdge(int v, int w) {
        // TODO Auto-generated method stub
        Edge curr = find(v,w);
        if ((curr.next == null) || curr.next.vertex != w)return;
        else
        {
            curr.next=curr.next.next;
            if(curr.next != null) curr.next.prev = curr;
        }
        numEdge++;
    }

    public boolean hasEdge(int v, int w) {
        // TODO Auto-generated method stub
        return weight(v,w)!=0;
    }

    public int[] neighbors(int v) {
        // TODO Auto-generated method stub

        int cnt=0;
        Edge curr;
        for (curr = nodeArray[v].next; curr != null; curr = curr.next)
        {
            cnt++;
            int[] temp = new int[cnt];

            cnt = 0;
            for (curr = nodeArray[v].next; curr != null; curr=curr.next)
                temp[cnt++] = curr.vertex;
            return temp;
        }

        return null;
    }


    public String toString()
    {
        String s = "[";
        for (int i =0; i<nodeArray.length; i++)
        {
            for(int j=0; j< nodeArray.length; j++)
            {
                //s+="[i][j] = " + i +" " + j + " w = " + nodeArray[i].vertex + nodeArray[j].weight;
                s+=" " + nodeArray[i].vertex + nodeArray[j].weight;
            }
            s+="\n";
        }
        s+=" ]";
        return s;
    }

}