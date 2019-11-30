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
    public boolean var = false;
    Thread A;
    Thread B;
	public Vent()
	{
		Runnable runA = new Runnable()
		{
			public void run()
			{
			     runWork();
			}
		};
		Runnable runB = new Runnable()
		{
          	public void run()
          	{
				runWork2();
          	}
	    };
		A = new Thread(runA, "threadA");
	    A.start();
		B = new Thread(runB, "threadB");
   		B.start();
	}
    public void runWork(){
    	int time = (int)System.currentTimeMillis();
    	while(true)
    	{
    	int time2;
    	int time3;
    	if(!var){

    	time3 = (int)System.currentTimeMillis() - time;
    	System.out.println("before sleep " + (time3));
    	try{
    		Thread.sleep(interval);
    	}catch(Exception e){
    	}

    	time2 = (int)(System.currentTimeMillis() - time);
    	System.out.println("after sleep " + time2);
    	var = true;
    	}
    	}


    }
    public void runWork2()
    {
    	while(true)
    	{
    		if(var)
    		{

    			try
    			{
    				Thread.sleep(interval2);
    				System.out.println("refratory period over");
    				var = false;
    			} catch(Exception e){
				}
    		}
    		else
    		{

				try
				{
				    B.wait();
				} catch(Exception e){
				}
			}

    	}
    }
    public static void main(String[] args) {
        // Create application frame.
      //  VentFrame frame = new VentFrame();

        // Show frame
      //  frame.setVisible(true);
		Vent myVent = new Vent();
    }
}
