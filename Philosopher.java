/**
 * Philosopher.java
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 */

public class Philosopher implements Runnable {
   /*
    * pseudocode
    * need 5 philosophers 0 - 4
    * Thread t0 = new Thread();
    * Thread t1 = new Thread();
    * Thread t2 = new Thread();
    * Thread t3 = new Thread();
    * Thread t4 = new Thread();
    * 
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
         Thread.sleep((long) (Math.random() * 1000));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   // philosopher eating method
   private void eat() {
      System.out.println("Philosopher" + num + " is eating...");
      try {
         Thread.sleep((long) (Math.random() * 1000));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
