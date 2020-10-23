package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {//일반클래스(추상클래스)

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress naver = new InetAddress(); //error! - InetAddress에는 기본생성자가 없으므로 new로 생성불가)
											     //메소드로 생성
		InetAddress naver = InetAddress.getByName("www.naver.com");
		InetAddress[] naver2 = InetAddress.getAllByName("www.naver.com");
		System.out.println("Naver IP = " + naver.getHostAddress()); //125.209.222.142
		for(InetAddress data : naver2) {
			System.out.println("Naver2 IP = " + data.getHostAddress());
		}
		System.out.println();
		
		InetAddress local = InetAddress.getLocalHost(); //내 IP를 알아내는 코드
		System.out.println("localhost IP = " + local.getHostAddress()); //192.168.0.17
		System.out.println();
		
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");//IP하나당 하나의 배열 칸으로 받아옴
		for(InetAddress data : daum) {
			System.out.println("Daum IP = " + data.getHostAddress());
		}
	}
}
