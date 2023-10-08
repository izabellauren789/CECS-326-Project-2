/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 * Project 2
 *
 */

public class DiningPhilosophers {
   public static void main(String args[]) {
      /*
       * pseudocode
       * Philosopher call takeForks
       * philosopher call returnForks
       */
      int numPhils = 5;
      DiningServer diningServer = new DiningServerImpl(numPhils);

      Philosopher[] philosophers = new Philosopher[numPhils];
      for (int i = 0; i < numPhils; i++) {
         philosophers[i] = new Philosopher(i, diningServer);
         philosophers[i].run();
      }
   }
}
