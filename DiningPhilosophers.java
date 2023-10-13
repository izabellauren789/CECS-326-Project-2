
/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 * Project 2
 *
 */
import java.util.concurrent.CountDownLatch;

public class DiningPhilosophers {
   private static final int numphils = 5;
   private static final int numMeals = 5;

   public static void main(String args[]) {
      Philosopher[] philosophers = new Philosopher[numphils];
      CountDownLatch countDownLatch = new CountDownLatch(numphils);

      // Monitors ensure that the philosophers pick up forks at the same time
      DiningServerImpl monitor = new DiningServerImpl(numphils, countDownLatch, numMeals);
      for (int i = 0; i < numphils; i++) {
         philosophers[i] = new Philosopher(i, monitor, countDownLatch);
         new Thread(philosophers[i]).start();
      }
      try {
         countDownLatch.await(); // Wait for all philosophers to finish their meals
         System.out.println("Everyone Eats!");
         System.exit(0);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
