package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputTest {

	public static void main(String[] args) throws IOException {
		//MethodTest4���� �ߴ� �Է��� �ѱ��� �ۿ� �Է��Ҽ� �����Ƿ�
		//���ڿ��� �Է��ϴ� ����� �ǽ�
		//IOSteam
		
		//�޸� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("���� A :");
		int a = Integer.parseInt(br.readLine()); //�� ��,���͸� ĥ ������ �� �ٷ� ���
		//br.readLine()�� ���ڿ�
		System.out.println("�Ǽ� B : ");
		double b = Double.parseDouble(br.readLine());
		
		System.out.println(a + " + " + b + " = " + (a+b));
	}

}
