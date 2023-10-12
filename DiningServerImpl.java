
/**
 * DiningServer.java
 * This class contains the methods called by the  philosophers.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.Semaphore;

public class DiningServerImpl implements DiningServer {
	private Semaphore[] forks;

	public DiningServerImpl() { 
		forks = new Semaphore[5]; //array of semaphore
		for (int i = 0; i < 5; i++) {
			forks[i] = new Semaphore(1);
		}
	}

	private int left(int philID){
		return philID;
	}

	private int right(int philID){
		return (philID +1) % 5; // +1 is get adjacent and mod because its circular
	}

	public void takeForks(int philID) {
		try {
		int left = left(philID);
		int right = right(philID);

		forks[left].acquire();
		forks[right].acquire();

		System.out.println("Philosopher"+ philID+ " taek fork ");

		forks[left].release();
		forks[right].release();

		} catch (InterruptedException e) {
			e.printStackTrace(); }

	}

	public void returnForks(int philID) {
		System.out.println("philo"+philID+" return");
	}
}