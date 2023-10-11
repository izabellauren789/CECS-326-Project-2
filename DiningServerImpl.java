
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
		for (int i = 0; i < numPhils; i++) {//  numPhils 5
			forks[i] = new Semaphore(2); //1 threads at a time
			System.out.println("Philosopher" + i + "made");

		}
		mutex = new Semaphore(2); //whats 
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
			System.out.println("Philosopher" + philID + " takes fork.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}