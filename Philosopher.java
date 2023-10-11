
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
   private int num;
   private DiningServer diningServer;
   private int maxIterations;
   private int currentIteration = 0;

   public Philosopher(int num, DiningServer diningServer, int maxIteration) {
      this.num = num;
      this.diningServer = diningServer;
      this.maxIterations = maxIterations;
   }

   @Override
   public void run() {
      int i = 0;
      while (currentIteration < maxIterations) {
         think();
         diningServer.takeForks(num);
         eat();
         diningServer.returnForks(num);
         currentIteration++;

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
