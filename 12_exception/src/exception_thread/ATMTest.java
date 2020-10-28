package exception_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2.스레드화
public class ATMTest implements Runnable {

	//1.필드명 선언
	private long deositeMoney = 100000; //잔액
	private long balance; //찾고자 하는 금액(돈 많이 찾으려고 타입을 int가 아닌 long으로 설정)

	//3.오버라이딩 - 껍데기만 만듦
	//7.실행 내용 입력
	@Override
	public synchronized void run() { //Lock을 걸어버리는 것을 동기화(반드시 한 객체만 접근 가능), 다른 동기화 방법도 다 먹힘(하나의 객체 atm을 공유하고 있기 때문에)
		
		//8.잔액 계산 메소드	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Thread.currentThread().getName() + "님 안녕하세요"); //현재 선택받은(실행 중인) 스레드가 무엇인지 이름을 출력해줌
		
		System.out.println("찾고자 하는 금액 입력 : ");
		try {
			balance = Long.parseLong(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} 
		//예외처리에 IOException이 안걸림 - 부모메소드에 예외처리가 없기 때문에 상속의 특성상                   						 
		//    						    부모메소드에 없는 예외처리를 자식메소드에 적용할수 없으므로 try~catch이용
		
		if(deositeMoney >= balance) {
			if(balance % 10000 == 0) {
				deositeMoney -= balance;
				System.out.println("잔액 : " + deositeMoney + "입니다");
			}else {
				System.out.println("만원 단위로 입력하세요");
			}
		}else {
			System.out.println("잔액이 부족합니다");
		}
			
	}		

//	찾고자 하는 금액 입력 : 
//	만원단위로 입력하세요
//	찾고자 하는 금액 입력 :
//	찾고자 하는 금액이 잔액보다 큰 경우 잔액부족
	
	
	public static void main(String[] args) {
	
		//4.생성
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm); //Thread - 0
		 //Thread mom = new Thread(this); 에러가 남(static은 클래스 소속이 아니기 때문에)
		 //Thread mom = new Thread(new ATMTest()); - 엄마객체와 아들객체가 각각 다른 메모리를 잡고 있기 때문에 영원히 충돌이 일어나지 않음
		 //                           				  이번 목적은 메모리를 공유하는 것임
		Thread son = new Thread(atm); //Thread - 1
		
		
		//6.스레드 이름 설정하기
		mom.setName("엄마"); //또는 생성시에 Thread mom = new Thread(atm, "엄마");
		son.setName("아들"); //또는 생성시에 Thread son = new Thread(atm, "아들");
		
		//5.스레드 시작 - 실행(run()메소드로 감)
		mom.start();
		son.start();
		
		
	}

}
