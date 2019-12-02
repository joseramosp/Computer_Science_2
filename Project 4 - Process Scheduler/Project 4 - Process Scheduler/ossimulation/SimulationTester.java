/*
Michael Penta
this class drives assigns the scheduler and starts the simulator
*/
package ossimulation;

public class SimulationTester
{
   
    public static void main(String[] args)
    {
        //modify to run your scheduler
        ProcessScheduler scheduler = new FirstComeFistServeScheduler();
        OSSimulation os = new OSSimulation(scheduler);

        ProcessScheduler RoundRobin_scheduler = new RoundRobin();
        OSSimulation RoundRobin_os = new OSSimulation(RoundRobin_scheduler);

        ProcessScheduler ShortestJobNext_scheduler = new ShortestJobNext();
        OSSimulation ShortestJobNext_os = new OSSimulation(ShortestJobNext_scheduler);

        //change the number of cycles

        System.out.println("\n---------------------| First Come Fist Serve Scheduler |---------------------\n");
        os.simulate(50);
        System.out.println("\n-------------------------------| Round Robin |-------------------------------\n");
        RoundRobin_os.simulate(50);
        System.out.println("\n----------------------------| Shortest Job Next |----------------------------\n");
        ShortestJobNext_os.simulate(50);

    } 
}
