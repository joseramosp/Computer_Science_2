package Support;

public interface QueueInterface<E>
{
    public void clear();

    public boolean enqueue(E it);

    public E dequeue();

    public E frontValue();

    public int length();
}
