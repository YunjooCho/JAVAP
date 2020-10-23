package p12_exception;

public class SnackTestP extends Thread {

	private String str;
	
	public SnackTestP(String str) {
		this.str = str;
	}
	
	public static void main(String[] args) {
		
		SnackTestP aa = new SnackTestP("�����");
		SnackTestP bb = new SnackTestP("������");
		SnackTestP cc = new SnackTestP("���ĸ�");
		
		aa.setName("�����");
		bb.setName("������");
		cc.setName("���ĸ�");
		
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
