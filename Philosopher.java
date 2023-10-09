
/**
 * Philosopher.java
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 */
import java.util.Random;

public class Philosopher implements Runnable {
   /*
    * pseudocode
    * each thread sleep for random period between 1 and 3
    * lock for thinking and eating
    */
   private int num;
   private DiningServer diningServer;

   public Philosopher(int num, DiningServer diningServer) {
      this.num = num;
      this.diningServer = diningServer;
   }

   @Override
   public void run() {
      while (true) {
         think();
         diningServer.takeForks(num);
         eat();
         diningServer.returnForks(num);
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
