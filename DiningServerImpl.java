
/**
 * DiningServer.java
 * This class contains the methods called by the  philosophers.
 */

import java.util.concurrent.Semaphore;

public class DiningServerImpl implements DiningServer {
	private Semaphore[] forks;
	private Semaphore mutex;

	public DiningServerImpl(int numPhils) {
		forks = new Semaphore[numPhils];
		for (int i = 0; i < numPhils; i++) {
			forks[i] = new Semaphore(1);
		}
		mutex = new Semaphore(1);
	}

	public void takeForks(int philID) { //not being called
		try {
			mutex.acquire();
			forks[philID].acquire();
			forks[(philID + 1) % forks.length].acquire();
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void returnForks(int philID) { //not being called
		try {
			mutex.acquire();
			forks[philID].release();
			forks[(philID + 1) % forks.length].release();
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}