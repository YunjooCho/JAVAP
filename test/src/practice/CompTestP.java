package practice;


public class CompTestP {
public static void main(String[] args) {
	//80�̻� 100���� ? "�հ�" : "���հ�"
	int score = 99;
	String result = score >= 80 && score <= 100 ? "�հ�" : "���հ�";
 	
 	 	//<if��> 100 ~ 90 A, 89 ~ 80 B, 79 ~ 70 C, ������ F
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
 	 	
 	System.out.println("1. ��� = " + result + "\n     ���� = " + grade);
 	System.out.println();
 
 	
		
	//score�� ���� ¦���̸� "¦��" �ƴϸ� "Ȧ��"��� ���
 	int evenodd = 100;
 	String result2 = evenodd % 2 == 0 ? "¦��" : "Ȧ��";
 	System.out.println("2. ¦��?Ȧ��? = " +  result2);
 	System.out.println();
 
 	
	//a, b�߿��� ū ���� ����Ͻÿ�
 	int biga = 70, bigb = 1;
 	int result3 = biga > bigb ? biga : bigb;
 	System.out.println("3. ū �� : " + result3);
 	System.out.println();
 	
	
	//c�� 2�� 3�� ��������� Ȯ��
 	int common = 60;
 	String result4 = common % 2 == 0 && common % 3 == 0 ? "�����" : "����� �ƴ�";
 	System.out.println("4. ��� : " + result4);
 	System.out.println();
	
	//MathŬ������ �̿��Ͽ� 2�� 5�� ���ϱ� - API����(double����)
 	double a = 2.0, b = 5.0;
	System.out.println("5. " + (int)a + "�� " + (int)b + "���� : " + (int)Math.pow(a, b));
	System.out.println();
	
	//<CompTest2>
	/*
	 ch�� �ִ� �����Ͱ� �빮���̸� �ҹ��ڷ� ����ϰ� �ƴϸ�(�ҹ���) �빮�ڷ� ����Ͻÿ�
	 
	 [������]
	  T -> t
	  
	  �Ǵ�
	  
	  e -> E
	 */
	
	char alp = 'p';
	
	int result5 = alp >= 'A' && alp <= 'Z' ? (int)alp + 32 : alp - 32; //������ ���� ������ result5�� int���� ��
	System.out.println("6. ��� : " + alp + " -> " + (char)result5);
  }
}
