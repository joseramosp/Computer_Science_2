package Support;

public class LinkedList<E> implements ListInterface<E>
{

    protected LinkedNode<E> head;
    protected LinkedNode<E> tail;
    protected LinkedNode<E> curr;
    protected int listSize;

    public LinkedList()
    {
        curr = tail = new LinkedNode<E>(null);
        head = new LinkedNode<E>(tail);
        listSize = 0;
    }

    public void clear()
    {
        curr = tail = new LinkedNode<E>(null);
        head = new LinkedNode<E>(tail);
        listSize = 0;
    }

    public boolean insert(E it)
    {
        curr.setNext(new LinkedNode<E>(curr.getData(), curr.getNext()));
        curr.setData(it);
        if (tail == curr)
        {
            tail = curr.getNext();
        }
        listSize++;
        return true;
    }

    public boolean append(E it)
    {
        tail.setNext(new LinkedNode<>(null));
        tail.setData(it);
        tail = tail.getNext();
        listSize++;
        return true;
    }

    public E remove()
    {
        if (curr == tail)
        {
            return null;
        }

        E it = curr.getData();
        curr.setData((curr.getNext()).getData());

        if (curr.getNext() == tail)
        {
            tail = curr;
        }

        curr.setNext(curr.getNext().getNext());

        listSize--;
        return it;
    }

    public void moveToStart()
    {
        curr = head.getNext();
    }

    public void moveToEnd()
    {
        curr = tail;
    }

   
    public void prev()
    {
        if (head.getNext() == curr)
        {
            return; 
        }
        LinkedNode<E> temp = head;
       
        while (temp.getNext() != curr)
        {
            temp = temp.getNext();
        }
        curr = temp;
    }

    public void next()
    {
        if (curr != tail)
        {
            curr = curr.getNext();
        }
    }

    public int length()
    {
        return listSize;
    }

    public int currPos()
    {
        LinkedNode<E> temp = head.getNext();
        int i;
        for (i = 0; curr != temp; i++)
        {
            temp = temp.getNext();
        }
        return i;
    }

    // Move down list to "pos" position
    public boolean moveToPos(int pos)
    {
        if ((pos < 0) || (pos > listSize))
        {
            return false;
        }
        curr = head.getNext();
        for (int i = 0; i < pos; i++)
        {
            curr = curr.getNext();
        }
        return true;
    }

    // Return true if current position is at end of the list
    public boolean isAtEnd()
    {
        return curr == tail;
    }

    // Return current element value. Note that null gets returned if curr is at the tail
    public E getValue()
    {
        return curr.getData();
    }
}
