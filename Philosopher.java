
/**
 * Philosopher.java
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 */
import java.util.Random;

public class Philosopher implements Runnable {
   /*
    * lock for thinking and eating
    */
   private DiningServer diningServer;
   private int num;

   public Philosopher(int num, DiningServer diningServer) {
      this.diningServer = diningServer;
   }

   @Override
   public void run() {
      int i = 0;
      while (i < 5) {
         think();
         diningServer.takeForks(num);
         eat();
         diningServer.returnForks(num);
         i++;

      }
   }

   // philosopher thinking method
   private void think() {
      System.out.println("Philosopher" + num + " is thinking...");
      try {
         Random rand = new Random();
         int sleepDuration = rand.nextInt(3000) + 1000; // Random sleep between 1 and 3 seconds
         Thread.sleep(sleepDuration);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   // philosopher eating method
   private void eat() {
      System.out.println("Philosopher" + num + " is eating...");
      try {
         Random rand = new Random();
         int sleepDuration = rand.nextInt(3000) + 1000; // Random sleep between 1 and 3 seconds
         Thread.sleep(sleepDuration);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
