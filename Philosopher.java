
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

   public Random rand = new Random();
   public int sleepDuration = rand.nextInt(3000) + 1000; // Random sleep between 1 and 3 seconds


   public Philosopher(int num, DiningServer diningServer) {
      this.diningServer = diningServer;
      this.num = num;
   }

   @Override
   public void run() {
      int i = 0;
      while (i < 5) {
         think(i);
         diningServer.takeForks(num);
         eat(i);
         diningServer.returnForks(num);
         i++;

      }
   }

   // philosopher thinking method
   private void think(int philID) {
      try {
         Thread.sleep(sleepDuration);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("philo" + philID+ " think");
   }

   // philosopher eating method
   private void eat(int philID) {
      try {
         Thread.sleep(sleepDuration);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("philo" + philID+ " eat");

   }
}
