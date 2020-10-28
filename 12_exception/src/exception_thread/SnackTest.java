package exception_thread;

//5.상속
public class SnackTest extends Thread {
	
	//1.필드선언
	private String str;
	
	
	//2.생성자
	public SnackTest(String str) {
		this.str = str;
	}
	
	
	//3.메소드 - 8. 콜백으로 변함 //★★start()에서 호출?
	public void run() {
		//9.스레드 흐름 확인할수 있게 수정
		//11.i의 값 추가
		for(int i = 1; i <= 5; i++) { //여기서 i는 묶어서 1,2,3...증가하는 것이 아니라
			                          //새우깡 i = 1,2,3....
			                          //포카칩 i = 1,2,3....
			 						  //썬칩 i = 1,2,3... 이렇게 각각 계산이 됨
			System.out.println(str + "\t" + "i - " + i + "\t"+Thread.currentThread()); //★★str만 찍을 때는 5번씩 찍혔는데 왜 결과가 다름?
			                                                                            //★★Thread.currentThread()는 흐름만 보여주는 것 아닌지?
		}
	}
	
	
	//4.객체생성
	public static void main(String[] args) {
		//6.스레드 생성 - 객체생성에서 수정사항 없음
		SnackTest aa = new SnackTest("새우깡"); //스레드 생성 Thread-0
		SnackTest bb = new SnackTest("포카칩"); //스레드 생성 Thread-1
		SnackTest cc = new SnackTest("썬칩");  //스레드 생성  Thread-2
		
//		aa.run();
//		bb.run();
//		cc.run(); //절차식(위에서부터 순서대로 실행)
		
		//10.스레드 이름 부여
		aa.setName("새우깡"); //Thread-0
		bb.setName("포카칩"); //Thread-1
		cc.setName("썬칩");  //Thread-2
		
		//13.우선순위 1~10 부여(default : 5) - 1~10순위를 추가(11,12,13...)하거나 줄일수(3,5...)는 없음
		//aa.setPriority(Thread.MAX_PRIORITY); //MAX_PRIORITY는 최대숫자(final static)이므로 10임(1~10까지 순위매김)
		//★★나머지 1,5,10을 제외한 나머지 숫자는 뭐가 들어있음?? 왜 우선순위가 있는데 묶여서 찍히지 않음??
		aa.setPriority(10); //제일 우선순위가 높음
		bb.setPriority(Thread.MIN_PRIORITY); //1 제일 우선순위가 낮음
		cc.setPriority(Thread.NORM_PRIORITY); //5 중간 우선순위
		
		
		
		
		//7.스레드를 시작할 준비
		aa.start(); //스레드 시작-> 스레드 실행(run())
		//12.join() & 예외처리
//		try {
//			aa.join(); //join()만 있을 땐 error - interrupt, 목적은 해당 객체는 프로그램이 끝날때까지 계속 실행
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		} 
		bb.start();
		cc.start();
	}

}
