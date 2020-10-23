package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SwitchTest22 {
	public static void main(String[] args) throws IOException {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      DecimalFormat df = new DecimalFormat("#.0"); //.���� �Ҽ��ڸ��� 000�� �� ����
		      
		      System.out.print("a �Է� : ");
		      int a = Integer.parseInt(br.readLine());
		      System.out.print("b �Է� : ");
		      int b = Integer.parseInt(br.readLine());
		      System.out.print("������(+,-,*,/) �Է� : ");
		      String op = br.readLine();
		      
		      double result=0;
		      switch(op) {
		      case "+" : result = a+b; break;
		      case "-" : result = a-b; break;
		      case "*" : result = a*b; break;
		      case "/" : result = (double)a/b; break;
		      default  : System.out.println("������ error"); 
		               System.exit(0); //���α׷� ���� ����
		               
		      }//switch
		      
		      System.out.println(a+ op + b + " = "+ df.format(result)); //String.format ��� ����
		   }

	}


