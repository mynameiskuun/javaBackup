package project_1214;

public class ThreadEx {

	public static void main(String[] args) {

		Thread th = new WorkThread();
		th.start();

		Thread th2 = new Thread(new ThreadNameExample());
		th2.start();

		Thread th3 = new Thread() {
			@Override
			public void run() {
				for (;;) {
					System.out.println("***");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		th3.start();
//		Thread th4 = new Thread( -> () {

				for (;;) {
					System.out.println("****");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//		});
//		th4.start();
	}
}
