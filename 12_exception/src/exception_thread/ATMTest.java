package exception_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2.������ȭ
public class ATMTest implements Runnable {

	//1.�ʵ�� ����
	private long deositeMoney = 100000; //�ܾ�
	private long balance; //ã���� �ϴ� �ݾ�(�� ���� ã������ Ÿ���� int�� �ƴ� long���� ����)

	//3.�������̵� - �����⸸ ����
	//7.���� ���� �Է�
	@Override
	public synchronized void run() { //Lock�� �ɾ������ ���� ����ȭ(�ݵ�� �� ��ü�� ���� ����), �ٸ� ����ȭ ����� �� ����(�ϳ��� ��ü atm�� �����ϰ� �ֱ� ������)
		
		//8.�ܾ� ��� �޼ҵ�	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Thread.currentThread().getName() + "�� �ȳ��ϼ���"); //���� ���ù���(���� ����) �����尡 �������� �̸��� �������
		
		System.out.println("ã���� �ϴ� �ݾ� �Է� : ");
		try {
			balance = Long.parseLong(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} 
		//����ó���� IOException�� �Ȱɸ� - �θ�޼ҵ忡 ����ó���� ���� ������ ����� Ư����                   						 
		//    						    �θ�޼ҵ忡 ���� ����ó���� �ڽĸ޼ҵ忡 �����Ҽ� �����Ƿ� try~catch�̿�
		
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

//	ã���� �ϴ� �ݾ� �Է� : 
//	���������� �Է��ϼ���
//	ã���� �ϴ� �ݾ� �Է� :
//	ã���� �ϴ� �ݾ��� �ܾ׺��� ū ��� �ܾ׺���
	
	
	public static void main(String[] args) {
	
		//4.����
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm); //Thread - 0
		 //Thread mom = new Thread(this); ������ ��(static�� Ŭ���� �Ҽ��� �ƴϱ� ������)
		 //Thread mom = new Thread(new ATMTest()); - ������ü�� �Ƶ鰴ü�� ���� �ٸ� �޸𸮸� ��� �ֱ� ������ ������ �浹�� �Ͼ�� ����
		 //                           				  �̹� ������ �޸𸮸� �����ϴ� ����
		Thread son = new Thread(atm); //Thread - 1
		
		
		//6.������ �̸� �����ϱ�
		mom.setName("����"); //�Ǵ� �����ÿ� Thread mom = new Thread(atm, "����");
		son.setName("�Ƶ�"); //�Ǵ� �����ÿ� Thread son = new Thread(atm, "�Ƶ�");
		
		//5.������ ���� - ����(run()�޼ҵ�� ��)
		mom.start();
		son.start();
		
		
	}

}
