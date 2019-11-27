package ossimulation;

import Support.LinkedList;
import Support.LinkedNode;
import Support.LinkedQueue;
import Support.QueueInterface;

public class ShortestJobNext implements ProcessScheduler{

    LinkedQueue<Process> q;
    LinkedQueue<Process> q2 = new LinkedQueue<>();
    Process processToRun;

    public ShortestJobNext() {q = new LinkedQueue<Process>();}

    @Override
    public Process getProcessToRun() {

        /*
            Shortest Job Next.
            The next process is going to be scheduled and sorted by cycles required to be finish.
            The process that is going to take less time to be processed is going to be first in
            the list and the longest is going to be the last in the list.
        */

        if(q.length() == 0 && (processToRun == null || processToRun.getCycles() <=0))
        {
            //if so, then make an idle process that runs for a cycle
            processToRun = new Process("Idle", 1);
        }
        else if(processToRun == null || processToRun.getCycles() <=0)
        {
            //nothing was running or it is done, a new process is needed
            processToRun = q.dequeue();
        }
        else
        {
            //continue to run the process that was running
        }
        System.out.println("ProcessToRun: "+processToRun);

        return processToRun;
    }

    @Override
    public void scheduleProcess(Process p) {
        System.out.println("Scheduling PID: "+p.getId() + " Cycles: " + p.getCycles());

        if(q.length() > 0) {
            while (q.length() > 0) {
                if (p.cycles < q.frontValue().cycles){
                    q2.enqueue(p);
                    while (q.length() > 0) {
                        q2.enqueue(q.dequeue());
                    }
                }
                else{
                    q2.enqueue(q.dequeue());
                    if(q.length() <= 0){
                        q2.enqueue(p);
                    }
                }
            }
            while (q2.length() > 0) {
                q.enqueue(q2.dequeue());
            }
        }
        else{
            q.enqueue(p);
        }
        printAllTheCyclesOfEveryElementInTheQueue();
    }



    public void printAllTheCyclesOfEveryElementInTheQueue(){
        System.out.println("The cycles of every processes in the queue are: ");
        while(q.length() > 0){
            System.out.print(q.frontValue().cycles + " ");
            q2.enqueue(q.dequeue());
        }
        System.out.println();
        while(q2.length() > 0){
            q.enqueue(q2.dequeue());
        }
    }
}
