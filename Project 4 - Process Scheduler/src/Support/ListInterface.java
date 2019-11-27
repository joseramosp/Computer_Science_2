package Support;

public interface ListInterface<E>
{
    public void clear();

    public boolean insert(E it);

    public boolean append(E it);

    public E remove();

    public void moveToStart();

    public void moveToEnd();

    public void prev();

    public void next();

    public int length();

    public int currPos();

    public boolean moveToPos(int pos);

    public boolean isAtEnd();

    public E getValue();
}
