package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("���ϴ� �� �Է� : ");
		int month = Integer.parseInt(br.readLine());
		//�� ��� Ű����� ���ڰ� �ԷµǸ� ���ڷ� ��ȯ �ȵ�
		//char�� parse����
		int days;
		
		switch(month) {
		case 1 : 
		case 3 : 
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : days = 31; 
				break; //switch�� �����
		case 2 : days = 28; 
				break;
		
		case 4 : 
		case 6 : 
		case 9 :
		case 11 : days = 30;
				break;
			
		default : days = 0; //������ ���� ���� ���� ���� �� ����� ����(�ʱ�ȭ�� ����)
		}
		System.out.println(month + "���� " + days + "�� �Դϴ�");
	}
	
}
