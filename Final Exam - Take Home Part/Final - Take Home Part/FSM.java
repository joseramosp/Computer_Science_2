/* Final Exam - Take Home

Name: Jose Ramos
NECC ID#: 00299444
Date: December 12, 2019

-- OBJECTIVE --

Using your graph implementation create a class called FSM (finite state machine) – you can extend the graph or use a
composition. Create an instance of FSM that models the inset graph.

NOTE: I am not testing if the FSM is failing or not. I am just assigning the values necessary to every edge to pass the
FSM conditions.

*/

public class FSM extends GraphLink {

    public FSM(int n){
        super(n);
    }

    public static void main(String[] args) {

        FSM test = new FSM(14);

        for(int i = 0; i<test.nodeCount(); i++){
            test.setValue(i,i);
        }

        test.addEdge(0,1,(int)'(');
        test.addEdge(1,2,(int)'4');
        test.addEdge(2,3,(int)'0');
        test.addEdge(3,4,(int)'7');
        test.addEdge(4,5,(int)')');
        test.addEdge(5,6,(int)'1');
        test.addEdge(6,7,(int)'2');
        test.addEdge(7,8,(int)'3');
        test.addEdge(8,9,(int)'-');
        test.addEdge(9,10,(int)'4');
        test.addEdge(10,11,(int)'5');
        test.addEdge(11,12,(int)'6');
        test.addEdge(12,13,(int)'7');

        System.out.println(test);
    }
}
