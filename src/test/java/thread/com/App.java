package thread.com;

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {

			System.out.println("Running");

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor pro = new Processor();
		pro.start();
		// Wait for the enter key
		System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		pro.shutdown();
	}
}
