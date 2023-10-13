
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
			forks[(i+1)%4] = new Semaphore(1);
		}
	}
	public void returnForks(int num){

	}
}