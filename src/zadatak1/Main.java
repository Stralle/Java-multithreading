package zadatak1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Unesite velicinu HashMap-e:");
		int n = scanner.nextInt();
		System.out.println("Unesite broj niti koje upisuju:");
		int k = scanner.nextInt();
		System.out.println("Unesite broj niti koje citaju:");
		int m = scanner.nextInt();
		
		scanner.close();
		
		Buffer buffer = new Buffer(n);
		
		for(int i = 0; i < k; i++) {
			new Thread(new WriteThread(buffer, 10)).start();
		}
		
		for(int i = 0; i < m; i++) {
			new Thread(new ReadThread(buffer, 10)).start();
		}
		
	}
	
}
