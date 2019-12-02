package ossimulation;
import Support.LinkedQueue;
import Support.QueueInterface;

public class RoundRobin implements ProcessScheduler {

    QueueInterface<Process> q;
    Process processToRun;
    int cyclesToRun = 5;

    public RoundRobin()
    {
        q = new LinkedQueue<Process>();
    }

    @Override
    public Process getProcessToRun() {

        /*
            Round Robin.
            If there is a process, it will run it as many time the Robing specify.
            Then it will go to the next process on the queue and run it as many time the Robing specify.
            If the process still not done, it will add it to the end of the queue.
            if the queue is empty, run an idle process
        */

        if(q.length() == 0 && (processToRun == null || processToRun.getCycles() <=0))
        {
            //if so, then make an idle process that runs for a cycle
            processToRun = new Process("Idle", 1);
        }
        else if(processToRun == null || processToRun.getCycles() <=0)
        {
            cyclesToRun = 5;
            //nothing was running or it is done, a new process is needed
            processToRun = q.dequeue();
        }
        else if(cyclesToRun == 0 && q.length()>0)
        {
            if(processToRun.cycles > 0){
                q.enqueue(processToRun);
            }
            processToRun = q.dequeue();
            cyclesToRun = 5;
        }
        cyclesToRun--;
        System.out.println("ProcessToRun: "+processToRun);

        return processToRun;
    }

    @Override
    public void scheduleProcess(Process p) {
        System.out.println("Scheduling PID "+p.getId());
        q.enqueue(p);
    }
}
