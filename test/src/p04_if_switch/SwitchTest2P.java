package p04_if_switch;

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

public class SwitchTest2P {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("a �Է� : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("b �Է� : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("������(+,-,*,/) �Է� : ");
		String y = br.readLine();
		
		
		switch(y) {
		case "+" : System.out.println(a + y + b + "= " + (a + b));
			       break;
		case "-" : System.out.println(a + y + b + "= " + (a - b));
				   break;
		case "*" : System.out.println(a + y + b + "= " + (a * b));
			       break;
		case "/" : System.out.println(a + y + b + "= " + (a / b));
				   break;
		default : System.out.println("������ error");
		}
		

	}

}
