
/**
 * DiningServer.java
 * This class contains the methods called by the  philosophers.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class DiningServerImpl implements DiningServer {
	private Semaphore forks[]; //0-4 forks

	public void takeForks(int num){
		for(int i =0; i<5; i++){
			forks[i] = new Semaphore(1);
			forks[(i+1)%5] = new Semaphore(1); //4+1 = 5, 5 not index 5th has to be 0
		}
	}
	public void returnForks(int num){

	}
}