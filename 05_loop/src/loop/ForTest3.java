package loop;

/*
  �빮��(A~Z)�� �������� 100���� �߻��Ͽ� 1�ٿ� 10���� ����Ͻÿ�
���߿��� A�� ����� ����Ͻÿ�

[������]
H  D  D  R  A  Y  A  K  T  H
C  X  F  Z  B  S  L  Y  Q  D
H  K  O  H  O  B  Z  N  J  T
U  P  A  P  K  Q  G  W  F  A
S  U  D  Z  I  V  J  U  O  G
L  M  Z  L  H  U  Y  D  Q  R
F  T  I  Z  A  W  E  O  F  Z
A  Y  C  I  U  Z  O  B  C  G
H  G  Y  Z  V  P  I  R  L  G
Y  H  R  R  M  H  Y  S  B  P

A�� ���� = 6
 */
public class ForTest3 {

	public static void main(String[] args) {
		//������ 65 ~ 90 ������ ���ڸ� 100�� �߻��Ͽ� ����Ͻÿ�
		
		//a~b ������ ���� �߻� => (int)(math.random()*(b-a+1) + a);
		//int num = (int)(Math.random() * 26) + 65;
		
		int num ;
		int count = 0;
		
		for(int i = 1; i <=100; i++){
			 num = (int)(Math.random() * 26) + 65;
			 System.out.printf("%-3c", (char)num);
			 //System.out.print((char)num + " ");
				 
			 //10���ڸ��� �ٹٲٱ�
			 if(i % 10 == 0) {
					System.out.println();
				 }
			 
			 //'A'������ ��
			 if((char)num == 'A' ) count++; //count = count + 1			
			 
		}//for

		System.out.println();
		System.out.println("A�� ���� = " + count);
		
	}
}

