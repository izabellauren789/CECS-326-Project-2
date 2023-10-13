
/**
 * DiningServer.java
 * This class contains the methods called by the philosophers.
 */

import java.util.concurrent.CountDownLatch;

public class DiningServerImpl implements DiningServer {
	// The states of the philosoper can be in any of these
	private enum State {
		THINKING, HUNGRY, EATING
	};

	// The state of each philosopher
	private State[] philstate;

	// keeps track to see if all philosophers eat at least once
	private int[] mealsEaten;
	private CountDownLatch countDownLatch;
	private static final int numMeals = 5;

	/**
	 * Creates a monitor for the number of philosophers passed
	 */
	public DiningServerImpl(int numPhilosophers, CountDownLatch countDownLatch, int numMeals) {
		philstate = new State[numPhilosophers];
		mealsEaten = new int[numPhilosophers];
		for (int i = 0; i < numPhilosophers; i++) {
			philstate[i] = State.THINKING;
			mealsEaten[i] = 0;
		}
		this.countDownLatch = countDownLatch;
	}

	/**
	 * A philosopher picks up both forks, waits if either of its neighbors
	 * is eating
	 */
	public synchronized void pickUp(int philosopherId) throws InterruptedException {
		philstate[philosopherId] = State.HUNGRY;
		System.out.println("Philosopher " + philosopherId + " is hungry... is waiting to eat.");
		System.out.flush();

		while (neighborEating(philosopherId)) {
			wait();
		}

		philstate[philosopherId] = State.EATING;
		System.out.println("Philosopher " + philosopherId + " has both forks and is eating...");
		System.out.flush();
	}

	/**
	 * Return true if some neighbor is currently eating
	 */
	private boolean neighborEating(int philosopherId) {
		int numPhilosophers = philstate.length;
		if (philstate[(philosopherId + 1) % numPhilosophers] == State.EATING) {
			return true;
		}

		if (philstate[(philosopherId + numPhilosophers - 1) % numPhilosophers] == State.EATING) {
			return true;
		}

		return false;
	}

	/**
	 * Put down both forks. Notify all waiting philosophers
	 */
	public synchronized void putDown(int philosopherId) throws InterruptedException {
		philstate[philosopherId] = State.THINKING;
		mealsEaten[philosopherId]++;
		if (mealsEaten[philosopherId] >= numMeals) {
			countDownLatch.countDown();
		}
		System.out.println("Philosopher " + philosopherId + " puts down forks.");
		notifyAll();
	}

}
