/**
 * DiningServer.java
 * This class contains the methods called by the  philosophers.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl  implements DiningServer
{
	//private ReentrantLock lockObj = new ReentrantLock();
	/*psuedocode
	 * Thread t1 = new Threads();
	 */
	do{
		wait(philosopher[i]);
		wait(philosopher[(i+1)%5]); //need to access adjacent

		//eat
		signal(philosopher[i]);
		signal(philosopher[(i+1)%5]); //need to access adjacent
		//think
		

	}while(true);
	//only max two people can eat at once
	//odd/even philosophers 
}
