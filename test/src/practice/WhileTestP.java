package practice;

public class WhileTestP {

	public static void main(String[] args) {
		// 1 2 3 4 5 6 7 8 9 10
		int num = 0;
		
		while (num < 10) {
			++num;
			System.out.print(num + " ");
		}
		System.out.println();
		
		
		//A B C D E F G....X Y Z 출력하되 1줄에 7개씩 출력하기
		/*
		A ~ Z 출력하되 1줄에 7개씩 출력하기

		[실행결과]
		A B C D E F G
		H I J K L M N
		O P Q R S T U
		V W X Y Z
				 */
		
		char alp = 'A';
		int count = 0;
		
		while(alp <= 'Z') {
		
			System.out.print(alp + " ");
			alp++;
			
			count++;
			if(count % 7 == 0) {
				System.out.println();
				}
		}
		
	}

}
