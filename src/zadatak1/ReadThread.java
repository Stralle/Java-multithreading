package zadatak1;

public class ReadThread implements Runnable {

	private Buffer buffer;
	private int count;
	
	public ReadThread(Buffer buffer, int counter) {
		this.buffer = buffer;
		this.count = counter;
	}
	
	public void run() {
		for(int i = 0; i < count; i++) {
			buffer.read();
		}
	}
	
	
}
