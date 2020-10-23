package exception_thread;

class JoinTest implements Runnable {

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
//==================================================================================
public class JoinMain {

	public static void main(String[] args) {
		//스레드 생성
		JoinTest jt = new JoinTest();
		Thread thread = new Thread(jt); //jt부분에는 this를 입력해서는 안됨
		System.out.println("스레드를 시작하겠습니다");
		//스레드 실행
		thread.start();
		try {
			thread.join(); //☆JOIN
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("스레드가 종료됩니다");
		//main이 끝나도 백그라운드에서 스레드는 돌아가기 때문에 종료되지 않는다.
		
		//<결과값>
		//스레드를 시작하겠습니다
		//스레드가 종료됩니다
		//1
		//2
		//3
		//4
		//5
		
		//<예상값>
		//스레드를 시작하겠습니다
		//1
		//2
		//3
		//4
		//5
		//스레드가 종료됩니다
		//예상값에 대해 결과값이 상이한 이유 : start()에서 바로 run()으로 가는 것이 아님
		//                          스레드는 Background에서 계속 돎
		
		//join()을 입력하면 예상값대로 결과값이 출력됨
	}

}
