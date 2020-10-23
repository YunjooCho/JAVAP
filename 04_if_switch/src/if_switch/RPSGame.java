package if_switch;

/*
����(1), ����(2), ��(3) ����

[������]
����(1),����(2),��(3) �� ��ȣ �Է� : 3 (user)
��ǻ�� : ����   �� : ���ڱ�
You Win!!

����(1),����(2),��(3) �� ��ȣ �Է� : 3 (user)
��ǻ�� : ����   �� : ���ڱ�
You Lose!!

����(1),����(2),��(3) �� ��ȣ �Է� : 2 (user)
��ǻ�� : ����   �� : ����
You Draw!!
 */
//com 1 ~ 3�� ����, user Ű���� �Է�
//���ڰ� �ƴ� �ѱ۷� ǥ��(����, ����, ��)
//�� ���ڸ� ���Ͽ� ���и� ǥ�� - if��(9��), system.out

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RPSGame  {

	public static void main(String[] args) throws IOException {
		//�޸� ����(Ű���� �Է�)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				
		System.out.println("����(1) ����(2) ��(3) �� ��ȣ �Է�: ");
		int user = Integer.parseInt(br.readLine());
		
		
		//���� -��ǻ�Ͱ� �������� �߻��ϴ� ��, 0 <= ���� < 1 (�Ǽ���)
		//a~b ������ ���� �߻� => (int)(math.random()*(b-a+1) + a);
		
		//<����>
		//double a = Math.random();
		//System.out.println(a); // 0.99999999999999999
		//System.out.println(a*100); // 99.999999999999999
		//System.out.println((int)(a*100)); // 99, 0~99
		//System.out.println((int)(a*100)+1); // 1~100
		
		//<����2>
		//int a = (int)(Math.random()*25+65);
		//System.out.println((a)); //65~90
		//System.out.println((char)a); //A~Z
		
		//com�� ���� ���� ��
		double b = Math.random();
		//System.out.println(b);
		//System.out.println(b*3);
		//System.out.println((int)(b*3)); // 0~2
		//System.out.println((int)(b*3)+1); // 1~3
		
		
		//com�� ���ڸ� �۾��� ǥ��
		int com = (int) ((b*3)+1);
		System.out.println("��ǻ�� : ");
		if((int)(b*3)+1 == 1) {
			System.out.println("����");
		}else if ((int)(b*3)+1 == 2) {
			System.out.println("����");
		}else {
			System.out.println("��");
		}
		System.out.println();
		
		//user�Է�
		System.out.println("�� : ");
		if (user == 1) {
			System.out.println("����");
		}else if(user == 2){
			System.out.println("����");
		}else {
			System.out.println("��");
		}
		
		//���а��
		 if(user == 1 ) {
			if (com == 2) {
				System.out.println("You Lose!");				
			}else if(com == 3){
				System.out.println("You Win!");
			}else {
				System.out.println("You Draw!");
			}
		}else if(user == 2) {
			if (com == 1) {
				System.out.println("You Win!");
			}else if(com == 3) {
				System.out.println("You Lose!");
			}else {
				System.out.println("You Draw!");
			}
		}else if(user == 3) {
			if(com == 1) {
				System.out.println("You Lose!");
			}else if(com == 2){
				System.out.println("You Win!");
			}else {
				System.out.println("You Draw!");
			}
		}

		
		
	}

}
