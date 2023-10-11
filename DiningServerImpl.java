
/**
 * DiningServer.java
 * This class contains the methods called by the  philosophers.
 */

import java.util.concurrent.Semaphore;

public class DiningServerImpl implements DiningServer {
	private Semaphore[] forks;
	private Semaphore mutex;

	public DiningServerImpl() { 
		forks = new Semaphore[5];
		for (int i = 0; i < 5; i++) {
			forks[i] = new Semaphore(2);
		}
		mutex = new Semaphore(2);
	}

	public void takeForks(int philID) {
		try {
			mutex.acquire();
			forks[philID].acquire();
			forks[(philID + 1) % forks.length].acquire();
			mutex.release();
			System.out.println("Philosopher" + philID + " takes fork.");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void returnForks(int philID) {
		try {
			mutex.acquire();
			forks[philID].release();
			forks[(philID + 1) % forks.length].release();
			mutex.release();
			System.out.println("Philosopher" + philID + " returns fork.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}