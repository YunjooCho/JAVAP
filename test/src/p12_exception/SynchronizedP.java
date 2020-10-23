package p12_exception;

//1.���
public class SynchronizedP extends Thread {

	private static int count;
	
	public static void main(String[] args) {
		//2.������ ����
		SynchronizedP aa = new SynchronizedP();
		SynchronizedP bb = new SynchronizedP();
		SynchronizedP cc = new SynchronizedP();
		
		//3.������ �̸� ����
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		
		//4.������ ����
		aa.start();
		bb.start();
		cc.start();

	}
	
	@Override
	//public synchronized void run() { //�ߺ� ���� �߻�
	  public void run() {//�ߺ� ���� �߻�
		//synchronized(this){//�ߺ� ���� �߻�
		  synchronized(SynchronizedP.class) {//�ߺ� �߻� ����
			for(int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : " + count);
			}
		}
	}

}
