package practice;


public class CalcTestP {
	
	public int sum(int a, int b) {//���� �޼ҵ� - ����
		return a + b;             //�޼ҵ� ��ȣ �ȿ� �ִ� �� - parameter, argument
  	}
	
	public int sub(int a, int b) {//���� �޼ҵ� - ����
		return a - b;             
  	}
	
	public int mul(int a, int b) {//���� �޼ҵ� - ����
		return a * b;             
  	}
	
	public double div(int a, int b) {//������ �޼ҵ� - ����
		return (double) a / b;  
  	}
	
	public static void main(String[] args) {
	
		/*
		 *  ������ �����Ͽ� 320, 258�� ���� ���Ͻÿ�
		 *  
		 *  [������]
		 *  320 + 258 = XXX
		 *  320 - 258 = XXX(sub)
		 *  320 * 258 = XXX(mul)
		 *  320 / 258 = XXX(div) �Ҽ��� ���� 2�ڸ�
		 */
		
		int a = 320, b = 258;
		
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		double div = (double)a / b;
		
		System.out.println("sum = " + sum);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + String.format("%.2f", div));
		System.out.println();
		System.out.println();

		/* 
		 *  ����, ����, ����, ������ �޼ҵ� �����
		 *  ���ڴ� 25, 36
		 *  �ʵ忡 �ۼ�
		 *  
		 */
		
		 CalcTestP y = new CalcTestP();
		 System.out.println("sum = " + y.sum(25, 36));
		 System.out.println("sub = " + y.sub(25, 36));
		 System.out.println("mul = " + y.mul(25, 36));
		 System.out.println("div = " + String.format("%.2f", y.div(25, 36)));
		 
	}

}
