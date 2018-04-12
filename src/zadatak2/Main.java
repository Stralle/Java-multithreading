package zadatak2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class Main {
	
	private static int number;
	private static int threads;
	private static CyclicBarrier barrier;
	private static ArrayList<Integer> prosti = new ArrayList<Integer>();
	
	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter tens");
		number = sc.nextInt();	//2
		System.out.println("Enter number of threads");
		threads = sc.nextInt(); //3
		
		sc.close();
		
		barrier = new CyclicBarrier(threads, new Runnable() {
			public void run() {
				System.out.println("-------------");
				System.out.println("Prime numbers are:");
//				Collections.sort(prosti);
				for(Integer i: prosti) {
					System.out.println(i);
				}
				System.out.println("Tasks finished.");
			}
		});
		
		int br = 1;
		
		for (int i = 0; i < threads; ++i) {
			new Thread(new CBThread(barrier, br, br+number*10-1)).start();
			br = br+number*10;
		}
		
	}
	
	public synchronized static void addElement(int element) {
//		System.out.println("Added " + element);
		prosti.add(element);
	}

}
