package if_switch;

import java.io.IOException;

//������ Ǯ��
public class RPSGame3 {

	public static void main(String[] args) throws IOException{
		int com, user;
		
		com = (int)(Math.random()*3)+1; //1~3 ���� �߻�
		
		System.out.println("����(1), ����(2), ��(3) �� ��ȣ �Է� : ");
		//user = System.in.read()-48; //1���� ���� �Է�(�Էµ� ����('1','2','3')�� ���ڷ� ġȯ)
		
		user = System.in.read()-'0';
		
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
