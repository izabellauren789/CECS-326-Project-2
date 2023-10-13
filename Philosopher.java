
/**
 * Philosopher.java
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 */
import java.util.Random;

public class Philosopher implements Runnable {
   private Thread philosophers[];
   
   public void run(){
      for(int i =0; i<5; i++){
            philosophers[i] = new Thread(); }
      // try{
         
      // } catch (InterruptedException e) {
		// 	e.printStackTrace();
      // }
   }
   
}
