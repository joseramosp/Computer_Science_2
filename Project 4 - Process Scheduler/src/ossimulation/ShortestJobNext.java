package ossimulation;
import Support.QueueInterface;
import Support.LinkedQueue;

public class ShortestJobNext extends LinkedQueue<Process> implements ProcessScheduler{

    LinkedQueue<Process> q  = new LinkedQueue<>(); // This queue is used to sort the main queue used to get the next process.
    Process processToRun;

    public ShortestJobNext() {

    }

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

        enqueue(p);

        printTheCyclesOfEveryProcessInTheQueue();
    }

    @Override
    public boolean enqueue(Process p) {

        if(q.length() > 0) {
            while (q.length() > 0) {
                if (p.cycles < q.frontValue().cycles){
                    super.enqueue(p);
                    while (q.length() > 0) {
                        super.enqueue(q.dequeue());
                    }
                }
                else{
                    super.enqueue(q.dequeue());
                    if(q.length() <= 0){
                        super.enqueue(p);
                    }
                }
            }
            while (length() > 0) {
                q.enqueue(dequeue());
            }
        }
        else{
            q.enqueue(p);
        }

        return true;
    }


    public void printTheCyclesOfEveryProcessInTheQueue(){
        System.out.println("The cycles of every processes in the queue are: ");
        while(q.length() > 0){
            System.out.print(q.frontValue().cycles + " ");
            super.enqueue(q.dequeue());
        }
        System.out.println();
        while(length() > 0){
            q.enqueue(dequeue());
        }
    }
}
