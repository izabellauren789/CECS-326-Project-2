/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 * Project 2
 *
 */

public class DiningPhilosophers {
   public static void main(String args[]) {
      int numPhils = 5; // total number of philosoophers --> we know its 5
      int maxIterations = 5;
      DiningServer diningServer = new DiningServerImpl();

      Thread[] philosophers = new Thread[numPhils];
      for (int i = 0; i < numPhils; i++) { // simulate the dining table
         philosophers[i] = new Thread(new Philosopher(i, diningServer, maxIterations));
         philosophers[i].start(); // the tread starts
         // dont we need an end thread type thing here?
      }
   }
}
