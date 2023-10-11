
/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 * Project 2
 *
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class DiningPhilosophers {
   static Philosopher philosophers[] = new Philosopher[5];
   static DiningServer forks[] = new DiningServer[5];

   public static void main(String argv[]) {

      for (int i = 0; i < 5; i++) {
         forks[i] = new DiningServerImpl();
      }
      for (int i = 0; i < 5; i++) {
         philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % 5]);
         philosophers[i].start();
      }

      while (true) {
         try {
            // sleep 1 sec
            Thread.sleep(1000);

            // check for deadlock
            boolean deadlock = true;
            for (DiningServer f : forks)  
               if (f.isFree()) {
                  deadlock = false;
                  break;
               }
            }
            if (deadlock) {
               Thread.sleep(1000);
               System.out.println("Everyone Eats");
               break;
            }
         } catch (Exception e) {
            e.printStackTrace(System.out);
         }
      }

   System.out.println("Exit The Program!");System.exit(0);
}
/*
 * public static void main(String args[]) {
 * int numPhils = 5; // total number of philosoophers --> we know its 5
 * DiningServer diningServer = new DiningServerImpl();
 * 
 * Thread[] philosophers = new Thread[numPhils];
 * for (int i = 0; i < numPhils; i++) { // simulate the dining table
 * philosophers[i] = new Thread(new Philosopher(i, diningServer));
 * philosophers[i].start(); // the tread starts
 * // dont we need an end thread type thing here?
 * }
 * }
 */
