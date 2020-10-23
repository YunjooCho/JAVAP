package p03_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
월급 계산 프로그램
이름, 직급, 기본급, 수당을 입력하여 세금과 월급을 계산하시오
세율은 급여가 4,000,000 만원 이상이면 3% 아니면 2%로 한다

만약 이 문제를 다 풀었다면
세금은 calcTax()
월급은 calcSalary()를 이용해서 계산하시오

급여 = 기본급 + 수당
세금 = 급여 * 세율
월급 = 급여 - 세금

[실행결과]
이름 입력 : 홍길동
직급 입력 : 부장
기본급 입력 : 4500000
수당 입력 : 200000

   *** 홍길동 월급 명세서 ***
직급 : 부장
기본급                    수당    		  급여 	   세율      세금            월급
4500000      200000     4700000   3%   xxxxx   xxxxxxx

변수 8개
전부 정수형
다 풀고 나서 메소드 사용
yeoni5@naver.com 메일 java 파일 보내드리기 (일요일 17:00까지)
 */
public class Salary {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 입력 : ");
		String name = br.readLine();
		System.out.print("직급 입력 : ");
		String position = br.readLine();
		System.out.print("기본급 입력 : ");
		int basePay = Integer.parseInt(br.readLine());
		System.out.print("수당 입력 : ");
		int extraPay = Integer.parseInt(br.readLine());
		
		int totalPay = basePay + extraPay;
		double taxRate = totalPay >= 4000000 ? 0.03 : 0.02;
		
		Salary sal = new Salary();
		double tax = sal.calcTax(totalPay, taxRate);
		double salary = sal.calcSalary(totalPay, tax);

		
		//숫자를 3자리마다 , 찍기
		DecimalFormat df = new DecimalFormat("#,###");
		
		//출력
		System.out.println("\t*** " + name + " 월급 명세서 ***");
		System.out.println("직급 : " + position);
		System.out.println("기본급\t     수당\t     급여\t      세율\t세금\t월급");
		System.out.println(df.format(basePay) + " " + df.format(extraPay) + " " + df.format(totalPay) + " " + String.format("%.0f", (taxRate*100)) + "% " + df.format((int)tax) + "  " + df.format((int)salary));
		

	}
	
	public double calcTax(int totalPay, double taxRate) {
		return totalPay * taxRate;
	}
	
	public double calcSalary(int totalPay, double tax) {
		return totalPay - tax;
	}

}
