package practice;

import java.io.IOException;

public class ForTestP {

	public static void main(String[] args) throws IOException {
		//10 9 8 7 6 5 4 3 2 1
		int num;
		for(num = 10; num>=1; num--) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		//A, B, C, D, E, F, G .....X, Y,Z
		int a;
		for(a = 'A'; a <= 'Z'; a++) {
			System.out.printf("%-3c", a);
		}
		System.out.println();
		
		//<ForTest2>
		/*
		���ϴ� ���� �Է� : 2  �� System.in.read()
		2*1=2g
		2*2=4
		2*3=6
		2*4=8
		2*5=10
		2*6=12
		2*7=14
		2*8=16
		2*9=18
		 */
		System.out.println("���ϴ� ���� �Է� : ");
		int dan = (int)System.in.read()-48;
		for(int i = dan; i <= dan; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
		System.out.println();
		
		
		//<ForTest3>
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
		
		int alp;
		int count = 0;
		
			
		for(int i = 1; i <= 100; i++) {
			
			alp = (int)(Math.random()*26)+65;{
			System.out.printf("%-2c", (char)alp);
			
			if(i % 10 == 0) {
				System.out.println();
			}
			
			
			}
			if((char)alp == 'A') {
				count++;
			}
			
			
		}//for
		System.out.println();
		System.out.println("'A'�� ���� : " + count);

	}

}
