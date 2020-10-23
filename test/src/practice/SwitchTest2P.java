package practice;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTest2P {

	public static void main(String[] args) throws IOException {
		//�޸� �Է�
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    //Ű���� �Է�
	    System.out.println("a �Է� : ");
	    int a = Integer.parseInt(br.readLine());
	    System.out.println("b �Է� : ");
	    int b = Integer.parseInt(br.readLine());
	    System.out.println("������(+,-,*,/,%) �Է� : ");
	    String calc = br.readLine();
	    
	    //���
	    switch (calc) {
	    	case "+" : System.out.println(a + calc + b + " = " + (a + b));
	    				break;
	    	case "-" : System.out.println(a + calc + b + " = " + (a - b));
						break;
	    	case "*" : System.out.println(a + calc + b + " = " + (a * b));
			            break;
	    	case "/" : System.out.println(a + calc + b + " = " + (String.format("%.3f", (double)a / b)));
			            break;
	    	case "%" : System.out.println(a + calc + b + " = " + (a % b));
            			break;
	    	default : System.out.println("������ error");
	    	
	    }

	}

}
