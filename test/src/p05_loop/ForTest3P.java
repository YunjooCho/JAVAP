package p05_loop;
/*
대문자(A~Z)를 무작위로 100개를 발생하여 1줄에 10개씩 출력하시오
이중에서 A가 몇개인지 출력하시오

[실행결과]
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

A의 개수 = 6
*/
public class ForTest3P {

	public static void main(String[] args) {
		//난수를 65 ~ 90 사이의 숫자를 100개 발생하여 출력하시오
		//a~b 사이의 난수 발생 => (int)(math.random()*(b-a+1) + a);
		int alp;
		int count = 0;
		
		for(int i = 1; i <= 100; i++) {
			alp = (int)(Math.random()*26 + 65);
			System.out.printf("%-3c", (char)alp);
			
			if(i % 10 == 0) {
				System.out.println();
			}
			
			if((char)alp == 'Y') {
				count++;
			}
		}System.out.println("Y의 개수 = " + count);
	}

}
