package p05_loop;

/*A B C D E F G....X Y Z 출력하되 1줄에 7개씩 출력하기
A ~ Z 출력하되 1줄에 7개씩 출력하기

[실행결과]
A B C D E F G
H I J K L M N
O P Q R S T U
V W X Y Z
 */

public class WhileTest2P {

	public static void main(String[] args) {
		char a = 'A';
		int count = 0;
		while(a <= 'Z') {
			System.out.print(a + " ");
			a++;
			
			count++;
			if(count % 7 == 0) {
				System.out.println();
			}
		}

	}

}
