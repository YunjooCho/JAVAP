package practice;


public class CalTestP2 {
	    
 	    //�޼ҵ� �����<MethodTest3>
	    int c = 25; //static int c�� ����
		int d = 36; //static int d�� ����
				
		public int sum(int c, int d) { 
			return c + d;
		}
		
		public int sub(int c, int d) {
			return c - d;
		}
		
		public int mul(int c, int d) {
			return c * d;
		}
		
		public double div(int c, int d) {
			return (double) c / d;
		}
	
	public static void main(String[] args) {
		/*
		 *  <CalcTest>
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
			int sub = a-b;
			int mul = a * b;
			double div = (double)a / b;
			
			System.out.println(a + "�� " + b + "�� �� : " + sum);
			System.out.println(a + "�� " + b + "�� �� : " + sub);
			System.out.println(a + "�� " + b + "�� �� : " + mul);
			System.out.println(a + "�� " + b + "�� �� : " + String.format("%.2f", div));
		    System.out.println();
			
		/* 
		 *  ����, ����, ����, ������ �޼ҵ� �����
		 *  ���ڴ� 25, 36
		 *  �ʵ忡 �ۼ�
		 *  
		 */
			//int c = 25, d = 36;
			
			CalTestP2 calculation = new CalTestP2();
			
			System.out.println(calculation.c + "�� " + calculation.d + "�� �� : " + calculation.sum(calculation.c, calculation.d));
			System.out.println(calculation.c + "�� " + calculation.d + "�� �� : " + calculation.sub(calculation.c, calculation.d));
			System.out.println(calculation.c + "�� " + calculation.d + "�� �� : " + calculation.mul(calculation.c, calculation.d));
			System.out.println(calculation.c + "�� " + calculation.d + "�� �� : " + String.format("%.2f", calculation.div(calculation.c, calculation.d)));
			//calculation.sum(calculation.c, calculation.d)�� �ʹ� �� ���, int c�� d�տ� static�� �Է��ϱ�
	}

}
