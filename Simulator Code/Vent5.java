/**
 * Heart Simulator
 *
 * @author
 * @version 1.00 06/21/2005
 */

 import java.util.*;
public class Vent {

	// time interval for the heart
    public volatile int heartInterval = 1000;

    // time interval for the refractory period
    public volatile int refractInterval = 200;

    // time interval for the pacing device
    public volatile int paceInterval = 150000;

    // boolean variable that states if the heart is in refractory
    public volatile boolean inRefractory = false;

    // start time of the simualtor
    int startTime;

    // declares the 3 threads that will be running
    // Thread A:  The heart thread
    // Thread B:  The refractory period thread
    // Thread C:  The pacing device thread
    Thread A, B, C;

    // Declares 3 runnable objects runA, runB, runC
    Runnable runA, runB, runC;

    // boolean variable that lets the refractory thread
    // know whether the heart or the pacing device thread
    // intialized it
    public volatile boolean threadCall = false;

	// called by thread A (the heart thread), or thread C
	// (the pacing device thread).  Instanciates and runs
	// Thread B (the refractory period thread)
	public void contract()
	{
		System.out.println("Beat!");
		B = new Thread(runB, "threadB");
		B.start();
	}

	public Vent()
	{

		// Defines runB and states that when it is run,
		// it calls runWork2
		runB = new Runnable()
		{
			public void run()
			{
				runWork2();
			}
		};

		// gets the current time and stores it in the
		// variable time
		startTime = (int)System.currentTimeMillis();

		// Defines runA and states that when it is run
		// it calls runWork
		runA = new Runnable()
		{
			public void run()
			{
       			runWork();
	 		}
	    };

	    // Defines thread A and associates it with runA
	    // then starts up thread A
		A = new Thread(runA, "threadA");
        A.start();

        // Defines runA and states that when it is ran
		// it calls runWork
		runC = new Runnable()
		{
			public void run()
			{
       			runWork3();
	 		}
	    };

	   	// Defines thread C and associates it with runC
	    // then starts up thread C
		C = new Thread(runC, "threadC");
        C.start();
	}

	// pacing device method
	public void runWork3(){
		while(true)
		{
			try{
				while(true)
				{
					// stores in time4 the current elapsed time and displays it
					int time4 = (int)System.currentTimeMillis() - startTime;
					System.out.println("pacer before sleep " + (time4));
					// sleeps thread C for pace interval
					C.sleep(paceInterval);
					// checks to see if heart is in refractory period.
					// If so starts sleep cycle over, else breaks out
					if(!inRefractory)
						break;
				}
			}
			catch(Exception e){ }
			if(!inRefractory)
			{
				int time5 = (int)(System.currentTimeMillis() - startTime);
				System.out.println("pacer after sleep " + time5 + "\n");
				inRefractory = true;
				threadCall = true;
				contract();
			}
		}
	}

	// runs heart interval
    public void runWork(){
    	while(true)
    	{
			try
			{
				while(true)
				{
					int time3 = (int)System.currentTimeMillis() - startTime;
					System.out.println("heart before sleep " + (time3));
					A.sleep(heartInterval);
					if(!inRefractory)
						break;
				}

			}
			catch(Exception e){ }
			if(!inRefractory)
			{
				int time2 = (int)(System.currentTimeMillis() - startTime);
				System.out.println("heart after sleep " + time2 + "\n");
				inRefractory = true;
				threadCall = false;
				contract();

			}
    	}
    }
    // runs refractory period
    public synchronized void runWork2()
    {
    	try
    	{
			if(threadCall)
				A.interrupt();
//			else
//				C.interrupt();
			int refTime = (int)(System.currentTimeMillis() - startTime);
			System.out.println("Refractory time started = " + refTime);
    		Thread.sleep(refractInterval);
    		refTime = (int)(System.currentTimeMillis() - startTime);
    		System.out.println("Refractory time elapsed = " + refTime);
    		inRefractory = false;
    	}
    	catch(Exception e){ }
    }
    public static void main(String[] args) {
      Vent myVent = new Vent();
    }

}
