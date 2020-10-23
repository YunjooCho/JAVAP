package p12_exception;

//1.상속
public class SynchronizedP extends Thread {

	private static int count;
	
	public static void main(String[] args) {
		//2.스레드 생성
		SynchronizedP aa = new SynchronizedP();
		SynchronizedP bb = new SynchronizedP();
		SynchronizedP cc = new SynchronizedP();
		
		//3.스레드 이름 설정
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		
		//4.스레드 시작
		aa.start();
		bb.start();
		cc.start();

	}
	
	@Override
	//public synchronized void run() { //중복 숫자 발생
	  public void run() {//중복 숫자 발생
		//synchronized(this){//중복 숫자 발생
		  synchronized(SynchronizedP.class) {//중복 발생 안함
			for(int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : " + count);
			}
		}
	}

}
