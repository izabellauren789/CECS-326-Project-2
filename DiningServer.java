/**
 * DiningServer.java
 * Project 2
 * This class contains the methods called by the philosophers.
 * You are flexible to change it, here only display a sample
 */
public interface DiningServer {
   void pickUp(int philID) throws InterruptedException;

   void putDown(int philID) throws InterruptedException;

}