public class FSM extends GraphMatrix {

    public FSM(int n){
        super(n);
    }

    public static void main(String[] args) {
        FSM test = new FSM(14);

        for(int i =0; i<13; i++){
            test.addEdge(i,i+1,1);
            test.setValue(i,i);
        }
        test.setValue(13,13);

        System.out.println(test);
    }
}
