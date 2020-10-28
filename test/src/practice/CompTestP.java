package practice;


public class CompTestP {
public static void main(String[] args) {
	//80이상 100이하 ? "합격" : "불합격"
	int score = 99;
	String result = score >= 80 && score <= 100 ? "합격" : "불합격";
 	
 	 	//<if문> 100 ~ 90 A, 89 ~ 80 B, 79 ~ 70 C, 나머지 F
 	char grade;
 	
 	if (score >= 90) {
 		grade = 'A';
 	}
 	
 	else if (score >= 80) {
 		grade = 'B';
 	}
 	
 	else if (score >= 70 ) {
 		grade = 'C';
 	}
 	
 	else {
 		grade = 'F';
 	}
 	 	
 	System.out.println("1. 결과 = " + result + "\n     성적 = " + grade);
 	System.out.println();
 
 	
		
	//score의 값이 짝수이면 "짝수" 아니면 "홀수"라고 출력
 	int evenodd = 100;
 	String result2 = evenodd % 2 == 0 ? "짝수" : "홀수";
 	System.out.println("2. 짝수?홀수? = " +  result2);
 	System.out.println();
 
 	
	//a, b중에서 큰 값을 출력하시오
 	int biga = 70, bigb = 1;
 	int result3 = biga > bigb ? biga : bigb;
 	System.out.println("3. 큰 수 : " + result3);
 	System.out.println();
 	
	
	//c가 2와 3의 공배수인지 확인
 	int common = 60;
 	String result4 = common % 2 == 0 && common % 3 == 0 ? "공배수" : "공배수 아님";
 	System.out.println("4. 결과 : " + result4);
 	System.out.println();
	
	//Math클래스를 이용하여 2의 5승 구하기 - API참조(double형식)
 	double a = 2.0, b = 5.0;
	System.out.println("5. " + (int)a + "의 " + (int)b + "승은 : " + (int)Math.pow(a, b));
	System.out.println();
	
	//<CompTest2>
	/*
	 ch에 있는 데이터가 대문자이면 소문자로 출력하고 아니면(소문자) 대문자로 출력하시오
	 
	 [실행결과]
	  T -> t
	  
	  또는
	  
	  e -> E
	 */
	
	char alp = 'p';
	
	int result5 = alp >= 'A' && alp <= 'Z' ? (int)alp + 32 : alp - 32; //연산이 들어가기 때문에 result5는 int여야 함
	System.out.println("6. 결과 : " + alp + " -> " + (char)result5);
  }
}
