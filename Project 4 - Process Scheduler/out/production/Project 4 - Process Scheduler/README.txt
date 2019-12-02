* Jose Ramos
* Student ID: 00299444* CIS 252 - T-7847
* November 17 of 2019* Project 4 - Process Scheduler
---------------------------* This project has as its purpose to create a process scheduler for a simulation of an operating system running each cycle of a process. 

The reqhimenst of this project are:

1- Implement schedulers, using the ProcessSchedulerInterface, for the following algorithms and structures
	* First Come First Serve - already done as an example 
	* Round Robin
	* Shortest Job Next
2- For shortest job next, sort the processes by cycle time - extend a queue so that each time a processes is enqueued the list is sorted and the shortest jobs are at the front. 
3- For all schedulers, if no jobs are in the queue, create an idle process that runs for 1 cycle (as in the FCFS example)
4- Write a main program that simulates each of the above schedulers for 50 cycles.
5- To complete these you will not alter the attached code. You should extend and override things. You can override any part of the scheduler or any of the data structure behaviors. 
6- You will primarily use queues to solve these, but you can use any linked data structure.
7- DO NOT USE ARRAYS OR ARRAY LISTS* The main of this project is in the "SimulationTester.java" file compile and run that file to see the output of the program.* In this project, the most difficult part was to create the ShortestJobNext class because the I was used to modify the data structure in order to make it do what I want. But in this project I had to come up with a different algorithm than the ones that I am most use, like sorting, to make every new element in the queue sorted by the cycles amount.* Citations: In this project, all the others clases besides RoundRobin and ShortestJobNext, were originally made by the professor Michael Penta.NOTE: When running the ShortestJobNext scheduler, it will be better to increase the running cycles to more than 50 to visualize that the scheduler is working properly. I created a method in the class ShortestJobNext called "printTheCyclesOfEveryProcessInTheQueue". That method will be called every time a new process is scheduled, so that it will be easier to visualizes how many elements there is in the queue and how many cycles all of them has.