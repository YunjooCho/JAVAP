package p04_if_switch;


import java.io.IOException;


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


public class RGSGameP {

	public static void main(String[] args) throws IOException {
		
		int com, user;
		
		com = (int)(Math.random()*3) + 1;
		//a~b ������ ���� �߻� => (int)(math.random()*(b-a+1) + a);
		//a~b ������ ���� �߻� => (int)(math.random()*(3-1+1) + 1);
		
		System.out.println("����(1) ����(2) ��(3) �� ��ȣ �Է�: ");
		user = System.in.read() - '0'; //�Էµ� ���ڹ��ڸ� ���ڷ� ġȯ
		
		if(com == 1) {//���� ������ ���
			if(user == 1) {
				System.out.println("��ǻ�� : ����\t ����� : ����");
				System.out.println("You Draw!");
			}else if(user == 2) {
				System.out.println("��ǻ�� : ����\t ����� : ����");
				System.out.println("You Win!");
			}else if(user == 3) {
				System.out.println("��ǻ�� : ����\t ����� : ��");
				System.out.println("You Lose!");
			}
		}else if(com == 2) {//���� ������ ���
			if(user == 1) {
				System.out.println("��ǻ�� : ����\t ����� : ����");
				System.out.println("You Lose!");
			}else if(user == 2) {
				System.out.println("��ǻ�� : ����\t ����� : ����");
				System.out.println("You Draw!");
			}else if(user == 3) {
				System.out.println("��ǻ�� : ����\t ����� : ��");
				System.out.println("You Win!");
			}
		}else if(com == 3) {//���� ���ڱ��� ���
			if(user == 1) {
				System.out.println("��ǻ�� : ��\t ����� : ����");
				System.out.println("You Win!");
			}else if(user == 2) {
				System.out.println("��ǻ�� : ��\t ����� : ����");
				System.out.println("You Draw!");
			}else if(user == 3) {
				System.out.println("��ǻ�� : ��\t ����� : ��");
				System.out.println("You Lose!");
			}
		}
	}
}
