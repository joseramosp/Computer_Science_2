package Support;

public class LinkedQueue<E> implements QueueInterface<E>
{

    private LinkedNode<E> front; 
    private LinkedNode<E> rear;  
    private int size;      

   
    public LinkedQueue() 
    {
        front = rear = new LinkedNode<E>(null);
        size = 0;
    }

    public boolean enqueue(E it)
    {
        rear.setNext(new LinkedNode<E>(it, null));
        rear = rear.getNext();
        size++;
        return true;
    }

    public E dequeue()
    {
        if (size == 0)
        {
            return null;
        }
        E it = front.getNext().getData(); 
        front.setNext(front.getNext().getNext()); 
        if (front.getNext() == null)
        {
            rear = front; 
        }
        size--;
        return it; 
    }

    public E frontValue()
    {
        if (size == 0)
        {
            return null;
        }
        return front.getNext().getData();
    }

    public int length()
    {
        return size;
    }

    public void clear()
    {
        front = rear = new LinkedNode<E>(null);
        size = 0;
    }
}
