package p12_exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2.������ȭ
public class ATMTestP implements Runnable {

	//1.�ʵ�� ����
	private long deositeMoney = 100000; //�ܾ�
	private long balance; //��ݾ�
	
	//3.�������̵�
	@Override
	public synchronized void run() {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Thread.currentThread().getName() + "�� �ȳ��ϼ���"); //���� �������� �����尡 �������� ���
	
		System.out.println("ã���� �ϴ� �ݾ� �Է� : ");
		try {
			balance = Long.parseLong(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		if(deositeMoney >= balance) {
			if(balance % 10000 == 0) {
				deositeMoney -= balance;
				System.out.println("�ܾ� : " + deositeMoney + "�Դϴ�");
			}else {
				System.out.println("���� ������ �Է��ϼ���");
			}
		}else {
			System.out.println("�ܾ��� �����մϴ�");
		}
	}
	
	public static void main(String[] args) {
		//4.����
		ATMTestP atm = new ATMTestP();
		Thread mom = new Thread(atm);
		Thread son = new Thread(atm);
		
		mom.setName("����");
		son.setName("�Ƶ�");
		
		mom.start();
		son.start();
		

	}


}
