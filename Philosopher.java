
/**
 * Philosopher.java
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 */
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher implements Runnable {
   // philosopher's unique id
   private int id;

   // Controls when a philosopher can pick up forks
   private DiningServerImpl monitor;

   // tracks which philosophers have successfully eaten
   private CountDownLatch countDownLatch;

   /**
    * Contruct a new philosopher
    */
   public Philosopher(int id, DiningServerImpl monitor, CountDownLatch countDownLatch) {
      this.id = id;
      this.monitor = monitor;
      this.countDownLatch = countDownLatch;
   }

   /**
    * Repeatedly think, pick up forks, eat and put down forks
    */
   public void run() {
      try {
         while (true) {
            think(id);
            monitor.pickUp(id);
            eat(id);
            monitor.putDown(id);
            countDownLatch.countDown();
         }
      } catch (InterruptedException e) {
         System.out.println("Philosopher " + id + " was interrupted.\n");
      }
   }

   /**
    * Sleep for a random amount to time between 1 and 3 to model thinking
    */
   public void think(int id) throws InterruptedException {
      System.out.println("Philosopher " + id + " is thinking.");
      System.out.flush();
      Random numGenerator = new Random();
      int sleepTime = numGenerator.nextInt(2001) + 1000; // Generates a random number between 1000 (1 second) and 3000
                                                         // (3 seconds)
      Thread.sleep(sleepTime);
   }

   /**
    * Sleep for a random amount of time between 1 and 3 to model eating
    */
   public void eat(int id) throws InterruptedException {
      Random numGenerator = new Random();
      int sleepTime = numGenerator.nextInt(2001) + 1000; // Generates a random number between 1000 (1 second) and 3000
                                                         // (3 seconds)
      Thread.sleep(sleepTime);
   }

}
