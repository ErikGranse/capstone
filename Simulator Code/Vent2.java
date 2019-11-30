/**
 * AWT Sample application
 *
 * @author 
 * @version 1.00 05/06/19
 */
 
 import java.util.*;
public class Vent {
    public static int interval = 999;
    public static int interval2 = 200;
    public static boolean var = false;
    static int time;
    static int time3;
      
    
    public static void runWork(){
    	
	    
    	time = (int)System.currentTimeMillis();
    	int time2;
    	
    	
    	while(true)
    	{
    	
    	//if(!var){
    	
    	time3 = (int)System.currentTimeMillis() - time;
    	
    	System.out.println("before sleep " + (time3));
    	
	    Runnable runB = new Runnable() {
	      	public void run(){
	      		runWork2();
		     }
		};
	    Thread B = new Thread(runB, "threadB");
//	    B.setPriority(10);

    	B.start();
    	
    	try{
    		Thread.sleep(interval);
	        
    	}catch(Exception e){
    	}
    	
    	time2 = (int)(System.currentTimeMillis() - time);
    	System.out.println("after sleep " + time2 + "\n");
    	//var = true;
    	//}
    	}
    		
    	
    }
    public static void runWork2()
    {
    	//while(true)
    	//{
    		//System.out.println("here");
    	//if(var)
    	//{
    	
    	try{
//    		System.out.println("called thread B");
    		Thread.sleep(interval2);
    		int refTime = (int)(System.currentTimeMillis() - time);
    		System.out.println("Refractory time elapsed = " + refTime);
    		//var = false;
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
              Runnable runA = new Runnable() {
              	public void run(){
              		runWork();
              	//	runWork2();
              	}
        };
   Thread A = new Thread(runA, "threadA");
        A.start();
    }

}
