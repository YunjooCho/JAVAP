package p12_exception;

class JoinTestP implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

//====================================================================================
public class JoinMainP {

	public static void main(String[] args) {
		
		JoinTestP jt = new JoinTestP(); //스레드 생성
		Thread thread = new Thread(jt);
		System.out.println("스레드를 시작하겠습니다");
		
		thread.start();//스레드 실행
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("스레드가 종료됩니다");

	}

}
