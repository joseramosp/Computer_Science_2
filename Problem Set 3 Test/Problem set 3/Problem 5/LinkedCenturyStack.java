import java.lang.*;

public class LinkedCenturyStack<E> extends LinkedStack<E>{

    int maxSize = 100;

    LinkedCenturyStack() {
        super();
    }

    @Override
    public boolean push(E it) {
        top = new Link<E>(it, top);

        if(size >= maxSize){
            Link<E> n = top;
            for(int i = size; i>= 2; i--){
                n = n.next();
            }
            n.setNext(null);
        }
        else {
            size++;
        }
        return true;
    }

    public static void main(String[] args) {

        LinkedCenturyStack<Integer> test = new LinkedCenturyStack<>();

        for(int i = 1; i<=111; i++){
            test.push(i);
        }

        for(int i = test.size; i>0; i--){
            System.out.println(test.pop());
        }
    }
}
