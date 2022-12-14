package project_1214;

public class ThreadNameExample extends Thread {

	public void run() {
		for(;;) {
			System.out.println("**");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
