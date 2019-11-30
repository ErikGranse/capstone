import java.util.*;
/**
 * AWT Sample application
 *
 * @author 
 * @version 1.00 05/06/07
 */
public class Ventricle implements Runnable {
	
	private int interval = 1000;
	
	
	public Ventricle(int interval) {
		this.interval = interval;
		Timer timer = new Timer();
        timer.schedule(new BeatTask(),
                       0,        //initial delay
                       interval);  //subsequent rate
    }

	

	/**
	 * Method setInterval
	 *
	 *
	 */
	 public void setInterval(int interval) {
		this.interval = interval;
	}	
    
	/**
	 * Method getInterval
	 *
	 *
	 * @return
	 *
	 */
	 public int getInterval() {
		return interval;
	}
	
	
	/**
	 * Method run
	 *
	 *
	 */
	public void run() {
		System.out.println("I ran");
	}	
	
	
		
	
    public static void main(String[] args) {
    	
        // Create application frame.
        Ventricle ventricle = new Ventricle(1000);
        
        //new Thread(ventricle).start();
        
        Runnable runA = new Runnable() {
        	public void run() {
	}	
	
        };
        
        Thread A = new Thread(runA, "threadA");
        A.start();
        
        
        
    }

    class BeatTask extends TimerTask {
        public void run() {
            System.out.println("Beat!");
 			
            }
        }




}
