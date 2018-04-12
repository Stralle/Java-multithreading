package zadatak2;

import java.util.concurrent.CyclicBarrier;

public class CBThread implements Runnable {
	
	private CyclicBarrier barrier;
	private int first;
	private int last;
	
	public CBThread(CyclicBarrier barrier, int first, int last) {
		this.barrier = barrier;
		this.first = first;
		this.last = last;
	}

	@Override
	public void run() {
		
		System.out.println("Processing prime numbers from " + first + " to " + last);
		first = first==1?2:first;
		for(int i = first; i <= last; i++) {
			if(isPrime(i)) {
				Main.addElement(i);
			}
		}
		
		try {
			System.out.println("Waiting for all of us to finish... " + first);
			barrier.await();
			System.out.println("Finished waiting.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isPrime(int i) {
		
		for(int j = 2; j <= Math.sqrt(i); j++) {
			if(i%j==0)
				return false;
		}
		return true;
	}

}