public class LinkedStack<T> implements StackInterface<T>
{
    private LinkedNode<T> top;
    private int size;

    public LinkedStack()
    {
        size = 0;
        top = null;
    }

    public boolean push(T data)
    {
        top = new LinkedNode<T>(data, top);
        size ++;
        return true;
    }

    public void pop()
    {
        if(size >1){
            top = top.getNext();
            size--;
        }
        else{
            top = null;
            size = 0;
        }
    }

    public T peek()
    {
        if (top == null) return null;
        return top.getData();
    }

    public void clear()
    {
       size = 0;
       top = null;
    }

    public int size()
    {
        return size;
    }
    
}
