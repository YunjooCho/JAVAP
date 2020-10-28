package loop;

public class WhileTest2 {
	public static void main(String[] args) {
/*A B C D E F G....X Y Z 출력하되 1줄에 7개씩 출력하기
A ~ Z 출력하되 1줄에 7개씩 출력하기

[실행결과]
A B C D E F G
H I J K L M N
O P Q R S T U
V W X Y Z
 */
		
		char ch = 'A';
		int count = 0;
		while(ch<='Z') {
			
			System.out.print(ch + " ");
			ch++;
			
			count++; // 1 2 3 4 5
			if(count % 7 == 0) System.out.println();
			//몇번째인지 표시하는 변수가 필요
			
		}//While
		
	}
}
