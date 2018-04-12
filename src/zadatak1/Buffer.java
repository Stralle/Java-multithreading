package zadatak1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Buffer {

	private int size;
	private int counter;
	private HashMap<Integer, String> data;
	private Random r = new Random();
	
	public Buffer(int size) {
		this.size = size;
		data = new HashMap<>(size);
		counter = 0;
	}
	
	public synchronized boolean isFull() {
		return counter==size?true:false;
	}
	
	public synchronized boolean isEmpty() {
		return counter==0?true:false;
	}
	
	public synchronized void write(int key, String value) {
		while(isFull()) {
			try {
				wait();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Buffer is full. Please wait...");
		}
		while(this.data.containsKey(key))
			key = r.nextInt(10000);
//			System.out.println("It doesn't exist: " + key + "......");
		
		data.put(key, value);
		System.out.println("Written data: " + "(" + key + "," + value + ")");
		counter++;
		notifyAll();
	}

	public synchronized void read() {
		while(isEmpty()) {
			try {
				wait();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Buffer is empty. Please wait...");
			
		}
		
		for(Map.Entry<Integer, String> entry: data.entrySet()) {
			System.out.println("Read: " + "(" + entry.getKey() + "," + entry.getValue() + ")");
			data.remove(entry.getKey());
			break;
		}
		
		counter--;
		notifyAll();
		
	}
	
	
}
