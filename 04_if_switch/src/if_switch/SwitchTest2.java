package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2���� ������ ���ڿ� ������(+,-,*,/)�� �Է��Ͽ� ����Ͻÿ�

[������]
a �Է� : 25
b �Է� : 36
������(+,-,*,/) �Է� : +
25 + 36 = xx

a �Է� : 25
b �Է� : 36
������(+,-,*,/) �Է� : /
25 / 36 = 0.xxx

a �Է� : 25
b �Է� : 36
������(+,-,*,/) �Է� : $
������ error
 */
public class SwitchTest2 {

	public static void main(String[] args) throws IOException {
		//�޸� �Է�
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    System.out.println("a �Է� : ");
		int a = Integer.parseInt(br.readLine());
		System.out.println("b �Է� : ");
		int b = Integer.parseInt(br.readLine()); 
		System.out.println("������(+,-,*,/) �Է� : ");
		String op = br.readLine();
		int result;
		
		//if���� ���
		//if(op.equals("+"))
		
		switch (op) {
		case "+" : System.out.println(a + op + b + " = " + (a + b));
					break;
		case "-" : System.out.println(a + op + b + " = " + (a - b));
					break;
		case "*" : System.out.println(a + op + b + " = " + (a * b));
					break;
		case "/" : System.out.println(a + op + b + " = " + String.format("%.3f", ((double)a / b)));
					break;
		default : System.out.println("������ error");			
		}
		
	}

}
