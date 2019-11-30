/**
 * AWT Sample application
 *
 * @author
 * @version 1.00 05/06/19
 */

 import java.util.*;
public class Vent {
    public int interval = 1000;
    public int interval2 = 200;
    public volatile boolean var = false;
    int time;
    int time3;
    Thread A, B;

	public Vent(){
		Runnable runA = new Runnable() {
			public void run(){
       			runWork();            	//	runWork2();
	 		}
	    };
		A = new Thread(runA, "threadA");
        A.start();

	}

    public void runWork(){


    	int time2;

    	time = (int)System.currentTimeMillis();

    	while(true)
    	{





    	try{
			while(true)
			{
				time3 = (int)System.currentTimeMillis() - time;
				System.out.println("before sleep " + (time3));
    			Thread.sleep(interval);
    			if(!var)
    				break;
			}

    	}catch(Exception e){
    	}
		if(!var)
		{
    		time2 = (int)(System.currentTimeMillis() - time);
    		System.out.println("after sleep " + time2 + "\n");
    		var = true;
    		Runnable runB = new Runnable() {
				public void run(){
					runWork2();
				}
			};
			Thread B = new Thread(runB, "threadB");
			//	    B.setPriority(10);

    		B.start();
		}
    	//var = true;
    	//}
    	}


    }
    public void runWork2()
    {
    	//while(true)
    	//{
    		//System.out.println("here");
    	//if(var)
    	//{

    	try{
//    		System.out.println("called thread B");
			int refTime = (int)(System.currentTimeMillis() - time);
			System.out.println("Refractory time started = " + refTime);
    		Thread.sleep(interval2);
    		refTime = (int)(System.currentTimeMillis() - time);
    		System.out.println("Refractory time elapsed = " + refTime);
    		var = false;
    	}catch(Exception e){
    	}
    //	}
    //	}


    }
    public static void main(String[] args) {
        // Create application frame.
      //  VentFrame frame = new VentFrame();

        // Show frame
      //  frame.setVisible(true);
      Vent myVent = new Vent();

    }

}
