package loop;

public class WhileTest2 {
	public static void main(String[] args) {
/*A B C D E F G....X Y Z ����ϵ� 1�ٿ� 7���� ����ϱ�
A ~ Z ����ϵ� 1�ٿ� 7���� ����ϱ�

[������]
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
			//���°���� ǥ���ϴ� ������ �ʿ�
			
		}//While
		
	}
}
