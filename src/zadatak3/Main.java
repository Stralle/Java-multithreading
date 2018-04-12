package zadatak3;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int drivers, pumps;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of drivers");
		drivers = sc.nextInt();
		
		System.out.println("Enter number of pumps at gas station");
		pumps = sc.nextInt();
		
		sc.close();
		
		Semaphore semaphore = new Semaphore(pumps, false);
		
		for(int i = 0 ; i < drivers; i++) {
			new Thread(new DriverThread(i, semaphore)).start();
		}
		
	}
	
	
	

}
