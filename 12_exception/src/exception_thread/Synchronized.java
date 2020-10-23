package exception_thread;

//1.상속
public class Synchronized extends Thread { //이 클래스는 스레드가 됨
	
	//6.필드
	private static int count; //객체 3개가 count필드를 공유
	
	public static void main(String[] args) {
		
		//2.스레드 생성
		Synchronized aa = new Synchronized();
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();
		
		//3.스레드 이름설정
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		
		//4.스레드 시작
		aa.start();
		bb.start();
		cc.start();
		
	}
	
	//5.run()메소드 오버라이딩 -  run()이 각각의 객체에 존재
	@Override
		//public synchronized void run() { //동기화 X sychronized키워드를 입력했음에도 불구
		  public void run() {
			synchronized(Synchronized.class) { //동기화 O 각각 다른 객체(클래스)를 동기화 시키겠다는 의미 - 하나의 클래스파일만 통과(싱글톤처리시 사용)
		      //synchronized(this){ //동기화 X - this는 다 다름(각각의 객체 aa, bb, cc)
				for(int i = 1; i <= 5; i++) {
					count++;
					System.out.println(Thread.currentThread().getName() + " : " + count);
					//메소드에 <sychronized>걸기 전
					//동시접근이 가능하기 때문에 aa : 2 cc : 2와 같이 중복으로 나오는 경우도 있음
					//출력순서가 count의 순번과 맞지 않기도 함
					
					//메소드에 <sychronaize>건 후
					//아직도 중복되는 count가 출력 - 동기화가 제대로 걸리고 있지 않음
					
					//synchronized(Synchronized.class) {}을 입력한 후
					//동기화가 제대로 실행
				}//for
			}
		}
}


//☆ATMTest와 다른 점은 ATMTest의 경우 하나의 클래스(atm)를 공유 - 이 경우 세가지 동기화 방법이 다 먹힘,
//  여기에서는 각각 aa, bb, cc로 각각의 클래스를 생성했기 때문에 각각의 run()이 따로 돎