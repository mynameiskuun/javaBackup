public class BeepEx {

	public static void main(String[] args) {
		Thread mt = Thread.currentThread();
		System.out.println("이름:"+mt.getName());
		Thread th6 = new Thread(() -> {
			for (int i=0; i<15; i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("이름:"+Thread.currentThread().getName());
			}
		});
		th6.start();
		
//		Runnable th3 = new BeepTask2();
		Thread th4 = new Thread(new BeepTask2());
		th4.start();
		
		Thread th5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0; i<15; i++) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("이름:"+Thread.currentThread().getName());
				}
				
			}
			
		});
		th5.start();
		
		Thread th = new BeepTask();
		th.start();
		
		Thread th2 = new Thread() {
			
			@Override
			public void run() {
				for (int i=0; i<15; i++) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("이름:"+Thread.currentThread().getName());
				}
			}
			
		};
		th2.start();
	}

}
