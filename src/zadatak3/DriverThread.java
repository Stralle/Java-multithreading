package zadatak3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DriverThread implements Runnable {

	private int id;
	private Semaphore semaphore;
	private Random r = new Random();
	
	public DriverThread(int id, Semaphore sem) {
		this.id = id;
		this.semaphore = sem;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int spentTime = r.nextInt(1000);
		
		try {
			System.out.println(id + ". driver is driving " + spentTime);
			Thread.sleep(spentTime);
			
			System.out.println(id + ". driver is waiting at the gas station");
			this.semaphore.acquire();
			
			spentTime = r.nextInt(1000);
			System.out.println(id + ". driver is fueling the vehicle for " + spentTime);
			Thread.sleep(spentTime);
			
			spentTime = r.nextInt(1000);
			System.out.println(id + ". driver is PAYING the bill for " + spentTime);
			Thread.sleep(spentTime);
			
			this.semaphore.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
