/*
6. If you solution above is not in constant time, can you create an array based implementation of the century stack that
does insertion in constant time? Detail it or implement it in code.

In this case I created a variable to keep track of the length of the array called size. Every time that an insertion is made
the method push add 1 to size and top as well, but if size reached 100 already then it will add 1 to top but not size.
When size is >= 100, the array will loop starting at the end of the array and then add the value to the location (Line 42).

 */

public class ArrayCenturyStack<E> extends StackArray<E> {

    int loopTop;
    int size;

    public ArrayCenturyStack(){
        top = 0;
        size = 0;
        maxSize = 100;
        stackArray = (E[])new Object[maxSize];
    }

    @Override
    public boolean push(E it){
        if(top >= maxSize){
            stackArray[++top%maxSize -1] = it;
        }
        else{
            stackArray[top++] = it;
            size++;
        }
        return true;
    }

    @Override
    public int length() { return size; }

    @Override
    public E pop() {
        if (size == 0) return null;
        size--;
        return stackArray[--top%maxSize];
    }

    public static void main(String[] args) {
        ArrayCenturyStack<Integer> test = new ArrayCenturyStack<>();

        for(int i = 1; i <= 120; i++){
            test.push(i);
        }

        test.push(104);
        System.out.println("The stackArray size is: " + test.length());

        while(test.length() > 0){
            System.out.println(test.pop());
        }
    }
}
