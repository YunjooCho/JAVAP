package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SwitchTest22 {
	public static void main(String[] args) throws IOException {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      DecimalFormat df = new DecimalFormat("#.0"); //.이후 소숫자리가 000일 때 생략
		      
		      System.out.print("a 입력 : ");
		      int a = Integer.parseInt(br.readLine());
		      System.out.print("b 입력 : ");
		      int b = Integer.parseInt(br.readLine());
		      System.out.print("연산자(+,-,*,/) 입력 : ");
		      String op = br.readLine();
		      
		      double result=0;
		      switch(op) {
		      case "+" : result = a+b; break;
		      case "-" : result = a-b; break;
		      case "*" : result = a*b; break;
		      case "/" : result = (double)a/b; break;
		      default  : System.out.println("연산자 error"); 
		               System.exit(0); //프로그램 강제 종료
		               
		      }//switch
		      
		      System.out.println(a+ op + b + " = "+ df.format(result)); //String.format 사용 안함
		   }

	}


