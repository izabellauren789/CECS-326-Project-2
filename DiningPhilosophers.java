/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 * Project 2
 *
 */

public class DiningPhilosophers {
   public static void main(String args[]) {
      DiningServer diningServer = new DiningServerImpl();

      Thread[] philosophers = new Thread[5];
      for (int i = 0; i < 5; i++) { // simulate the dining table
         philosophers[i] = new Thread(new Philosopher(i, diningServer)); //instantiate philosopher object as work of thread
         philosophers[i].start();
      }
   }
}
