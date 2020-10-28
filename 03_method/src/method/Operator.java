package method;

public class Operator {

	public static void main(String[] args) {
		int a = 0;
		
		a += 5; // a = a + 5;
		a *= 2; // a = a * 2;
		a -= 3; // a = a - 3;
		System.out.println("a = " + a); // a = 7
		
		
		//a가 1씩 증감할때만 아래와 같이 표기(단항연산자)
		//a = a + 1 ---> a += 1 ---> ++a 또는 a++
		//a = a - 1 ---> a -= 1 ---> --a 또는 a--
		//   3항        --->   2항    ---> 단항(선행) 또는 (후행)
		
		a++; // a = a + 1;
		System.out.println("a = " + a); // a = 8
		
		int b = a++; //아래 주석 두 줄을 합친 것
		//int b = a;
		//a++;          
		System.out.println("a = " + a + " b = " + b); // a = 9 b = 8
		//System.out.println("b = " + b + " a = " + a); 이걸 찍어본 것임(후행연산)
		
		int c = ++a; //아래 주석 두 줄을 합친 것
		//++a;
		//int c = a;
		System.out.println("a = " + a + " c = " + c); // a = 10 c = 10
		
		
		int d = ++a - b--; //아래 주석 세 줄을 합친 것
		//++a;
		//int d = a - b;
		//b--;
		System.out.println("a = " + a + " b = " + b + " d = " + d); 
		//a = 11 b = 7 d = 3
		
		System.out.println("a++ = " + a++); // a = 11
		//System.out.println("a++ = " + a);
		//a++;
		
		System.out.println("a = " + a); // a = 12
		
		System.out.println("++a = " + ++a);
		
	}

}

//연산자 우선순위
//()
//++, --
