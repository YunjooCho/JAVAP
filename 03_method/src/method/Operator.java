package method;

public class Operator {

	public static void main(String[] args) {
		int a = 0;
		
		a += 5; // a = a + 5;
		a *= 2; // a = a * 2;
		a -= 3; // a = a - 3;
		System.out.println("a = " + a); // a = 7
		
		
		//a�� 1�� �����Ҷ��� �Ʒ��� ���� ǥ��(���׿�����)
		//a = a + 1 ---> a += 1 ---> ++a �Ǵ� a++
		//a = a - 1 ---> a -= 1 ---> --a �Ǵ� a--
		//   3��        --->   2��    ---> ����(����) �Ǵ� (����)
		
		a++; // a = a + 1;
		System.out.println("a = " + a); // a = 8
		
		int b = a++; //�Ʒ� �ּ� �� ���� ��ģ ��
		//int b = a;
		//a++;          
		System.out.println("a = " + a + " b = " + b); // a = 9 b = 8
		//System.out.println("b = " + b + " a = " + a); �̰� �� ����(���࿬��)
		
		int c = ++a; //�Ʒ� �ּ� �� ���� ��ģ ��
		//++a;
		//int c = a;
		System.out.println("a = " + a + " c = " + c); // a = 10 c = 10
		
		
		int d = ++a - b--; //�Ʒ� �ּ� �� ���� ��ģ ��
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

//������ �켱����
//()
//++, --