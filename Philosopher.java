
/**
 * Philosopher.java
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 */
//import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread {

   public int number;
   public DiningServer leftfork;
   public DiningServer rightfork;

   Philosopher(int num, DiningServer left, DiningServer right) {
      number = num;
      leftfork = left;
      rightfork = right;
   }

   public void run() {

      while (true) {
         leftfork.takeForks();
         System.out.println("philosopher " + (number + 1) + " grabs left chopstick.");
         rightfork.takeForks();
         System.out.println("philosopher " + (number + 1) + " grabs right chopstick.");
         eat();
         leftfork.returnForks();
         System.out.println("philosopher " + (number + 1) + " releases left chopstick.");
         rightfork.returnForks();
         System.out.println("philosopher " + (number + 1) + " releases right chopstick.");
      }
   }

   void eat() {
      try {
         int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
         System.out.println("philosopher " + (number + 1) + " eats for " + sleepTime);
         Thread.sleep(sleepTime);
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }

}

/*
 * lock for thinking and eating
 * private DiningServer diningServer;
 * private int num;
 * 
 * public Philosopher(int num, DiningServer diningServer) {
 * this.diningServer = diningServer;
 * }
 * 
 * @Override
 * public void run() {
 * int i = 0;
 * while (i < 5) {
 * think();
 * diningServer.takeForks(num);
 * eat();
 * diningServer.returnForks(num);
 * i++;
 * 
 * }
 * }
 * 
 * // philosopher thinking method
 * private void think() {
 * System.out.println("Philosopher" + num + " is thinking...");
 * try {
 * Random rand = new Random();
 * int sleepDuration = rand.nextInt(3000) + 1000; // Random sleep between 1 and
 * 3 seconds
 * Thread.sleep(sleepDuration);
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 * }
 * 
 * // philosopher eating method
 * private void eat() {
 * System.out.println("Philosopher" + num + " is eating...");
 * try {
 * Random rand = new Random();
 * int sleepDuration = rand.nextInt(3000) + 1000; // Random sleep between 1 and
 * 3 seconds
 * Thread.sleep(sleepDuration);
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 * }
 */
