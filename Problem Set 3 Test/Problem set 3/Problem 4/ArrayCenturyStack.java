public class ArrayCenturyStack<E> extends StackArray<E> {

//    private E stackArray[];         // Array holding stack
//    private int maxSize = 100;      // Maximum size of stack
//    private int top;                // First free position at top

    public ArrayCenturyStack(){
        top = 0;
        maxSize = 100;
        stackArray = (E[])new Object[maxSize];
    }

    @Override
    public boolean push(E it){
        if(top >= maxSize){
            for(int i = 0; i<top - 1; i++){
                stackArray[i] = stackArray[i + 1];
            }
            stackArray[top -1] = it;
        }
        else{
            stackArray[top++] = it;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayCenturyStack<Integer> test = new ArrayCenturyStack<>();

        for(int i = 1; i <= 100; i++){
            test.push(i);
        }

        test.push(104);
        System.out.println("The stackArray size is: " + test.length());

        while(test.length() > 0){
            System.out.println(test.pop());
        }
    }
}
