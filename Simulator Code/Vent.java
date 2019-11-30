/**
 * AWT Sample application
 *
 * @author 
 * @version 1.00 05/06/19
 */
 
 import java.util.*;
public class Vent {
    public static int interval = 1000;
    public static int interval2 = 200;
    public static boolean var = false;
    
    public static void runWork(){
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
    public static void runWork2()
    {
    	while(true)
    	{
    		System.out.println("here");
    	if(var)
    	{
    	
    	try{
    		Thread.sleep(interval);
    		System.out.println("refratory period over");
    		var = false;
    	}catch(Exception e){
    	}
    	}
    	}
    	
    	
    }
    public static void main(String[] args) {
        // Create application frame.
      //  VentFrame frame = new VentFrame();
        
        // Show frame
      //  frame.setVisible(true);
              Runnable runA = new Runnable() {
              	public void run(){
              		runWork();
              		runWork2();
              	}
        };
   Runnable runB = new Runnable() {
              	public void run(){
              		runWork2();
              	}
        };
   Thread A = new Thread(runA, "threadA");
        A.start();
    }
}
