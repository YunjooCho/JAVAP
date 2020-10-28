package p12_exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2.스레드화
public class ATMTestP implements Runnable {

	//1.필드명 선언
	private long deositeMoney = 100000; //잔액
	private long balance; //출금액
	
	//3.오버라이딩
	@Override
	public synchronized void run() {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Thread.currentThread().getName() + "님 안녕하세요"); //현재 실행중인 스레드가 무엇인지 출력
	
		System.out.println("찾고자 하는 금액 입력 : ");
		try {
			balance = Long.parseLong(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
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
	
	public static void main(String[] args) {
		//4.생성
		ATMTestP atm = new ATMTestP();
		Thread mom = new Thread(atm);
		Thread son = new Thread(atm);
		
		mom.setName("엄마");
		son.setName("아들");
		
		mom.start();
		son.start();
		

	}


}
