package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {//�Ϲ�Ŭ����(�߻�Ŭ����)

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress naver = new InetAddress(); //error! - InetAddress���� �⺻�����ڰ� �����Ƿ� new�� �����Ұ�)
											     //�޼ҵ�� ����
		InetAddress naver = InetAddress.getByName("www.naver.com");
		InetAddress[] naver2 = InetAddress.getAllByName("www.naver.com");
		System.out.println("Naver IP = " + naver.getHostAddress()); //125.209.222.142
		for(InetAddress data : naver2) {
			System.out.println("Naver2 IP = " + data.getHostAddress());
		}
		System.out.println();
		
		InetAddress local = InetAddress.getLocalHost(); //�� IP�� �˾Ƴ��� �ڵ�
		System.out.println("localhost IP = " + local.getHostAddress()); //192.168.0.17
		System.out.println();
		
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");//IP�ϳ��� �ϳ��� �迭 ĭ���� �޾ƿ�
		for(InetAddress data : daum) {
			System.out.println("Daum IP = " + data.getHostAddress());
		}
	}
}
