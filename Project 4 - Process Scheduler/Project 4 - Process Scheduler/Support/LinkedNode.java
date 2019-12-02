package Support;


public class LinkedNode <E>
{
    protected E data;
    protected LinkedNode next;

    public LinkedNode( LinkedNode<E> next)
    {
        this.data = null;
        this.next = next;
    }
    
    public LinkedNode(E data, LinkedNode<E> next)
    {
        this.data = data;
        this.next = next;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
    }

    public LinkedNode<E> getNext()
    {
        return next;
    }

    public void setNext(LinkedNode<E> next)
    {
        this.next = next;
    }
    
    
    
    
}
