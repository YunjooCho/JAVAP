package p12_exception;

public class SnackTestP extends Thread {

	private String str;
	
	public SnackTestP(String str) {
		this.str = str;
	}
	
	public static void main(String[] args) {
		
		SnackTestP aa = new SnackTestP("새우깡");
		SnackTestP bb = new SnackTestP("폴라포");
		SnackTestP cc = new SnackTestP("양파링");
		
		aa.setName("새우깡");
		bb.setName("폴라포");
		cc.setName("양파링");
		
		aa.setPriority(10);
		bb.setPriority(Thread.MIN_PRIORITY);
		cc.setPriority(NORM_PRIORITY);
		
		aa.start();
		
		try {
			aa.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		bb.start();
		cc.start();
	}

}
