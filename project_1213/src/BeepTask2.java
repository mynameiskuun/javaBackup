
public class BeepTask2 implements Runnable {

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

}
