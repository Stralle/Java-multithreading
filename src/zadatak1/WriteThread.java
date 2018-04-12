package zadatak1;

public class WriteThread implements Runnable {
	
	private Buffer buffer;
	private int count;
	private int key = 0;
	
	public WriteThread(Buffer buffer, int counter) {
		this.buffer = buffer;
		this.count = counter;
	}
	
	public void run() {
		for(int i = 0; i < count; i++) {
			key = i;
//			doesExist();
//			System.out.println("...Key is " + key);
			buffer.write(key, "Value " + key);
		}
	}	
	
}
