package p05_loop;

/*A B C D E F G....X Y Z ����ϵ� 1�ٿ� 7���� ����ϱ�
A ~ Z ����ϵ� 1�ٿ� 7���� ����ϱ�

[������]
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
