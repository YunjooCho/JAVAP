package day0911;



//����ڷκ��� ���г� ���° ������������ �Է� �޾Ƽ�
//�ش� ��ġ�� ������ �ִ� �ڵ带 �����Ͻÿ�
//����1. �߸��� �г��� �Էµ��� �ʰ� �Ͻÿ�
//����2. ���° ���������� �Է� ���� �� �߸� �� ������ �Էµ��� �ʰ� �Ͻÿ�
//����3. ������ �ùٸ� ������ �ԷµǱ� �Ͻÿ�

//����
//���г� �����Դϱ�? (�Է� 4)
//�ùٸ��� ���� �г��Դϴ�.
//���г� �����Դϱ�? (�Է� 2)
//���° �����Դϱ�? (�Է� -2)
//�ùٸ��� ���� �����Դϴ�.
//���° �����Դϱ�? (�Է� 1)
//�����Դϱ�? (�Է� 80)
//2�г� 1�б� �߰� ��� ��� 80���� �ԷµǾ����ϴ�.
//1�г� 1�б� �߰� 
//���� 40 ���� 50 ���� 45


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06HomeWork {
	
	
	//1.�޴� �޼ҵ�
	static void showMenu()  {
		
		System.out.println("===========================");
		System.out.println(" ��Ʈ����б� ������ ���� ���� ���α׷�");
		System.out.println(" 1.�Է�\t2.���\t3.����");
		System.out.println("===========================");
		System.out.print("�޴����� > ");
	}
	
	
	//3.�迭 �Է� �޼ҵ�
	static int validateScore(BufferedReader bufferedReader) throws NumberFormatException, IOException {
		//main���κ��� BufferedReader������ �޾ƿͼ� ���
		//main�޼ҵ忡 �ִ� korean, english, math�� �޾ƿ� score�� ����
		//Ű����� �Է��� ������ ���⼭ ���͸���, 
		//���͸��� ���� �ٽ� main���� ���ư� ����(korean, english, math)�� �����
			
			System.out.print("������ �Է��ϼ��� : ");
			int score = Integer.parseInt(bufferedReader.readLine());
			
			while(score < 0 || score > 100) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				System.out.print("������ �Է��ϼ��� : ");
				score = Integer.parseInt(bufferedReader.readLine());
			}
			return score; //while���� �ش����� �ʴ� ��(��ȿ�� ����)�� score������ ����
			
		
		}
	
	
	//�ڡڡڡڡڡڡ�4.�迭 ��� �޼ҵ�
	//�ܺηκ��� ������ �ʿ��� ���� �� ()�ȿ� �ֱ�
	static void printScore(BufferedReader bufferedReader, int score, int grade, int[][] korArray, int[][] engArray, int[][] mathArray) throws IOException {
		
		System.out.print("����� �г�(1,2,3)�� ���� : ");
		int gradE = Integer.parseInt(bufferedReader.readLine());
		
		
		while( gradE < 0 || gradE > 100) {
			System.out.println("�ùٸ��� ���� �г��Դϴ�.");
			System.out.print("����� �г�(1,2,3)�� ���� : ");
			gradE = Integer.parseInt(bufferedReader.readLine());
		}
		
		System.out.print("���°?(1-1�б� �߰�,2-1�б� �⸻,3-2�б� �߰�,4-2�б� �⸻) : ");
		int whenScorE = Integer.parseInt(bufferedReader.readLine());
		while(whenScorE < 1 || whenScorE > 4) {
			System.out.println("�ùٸ��� ���� �����Դϴ�.");
			System.out.print("���°?(1-1�б� �߰�,2-1�б� �⸻,3-2�б� �߰�,4-2�б� �⸻) : ");
			whenScorE = Integer.parseInt(bufferedReader.readLine());					
		}
		
		
		System.out.println("==================================");
		System.out.print(gradE + "�г�");
		switch (whenScorE) {
		case 1:
			System.out.println("1�б� �߰�");
			break;
		case 2:
			System.out.println("1�б� �⸻");
			break;
		case 3:
			System.out.println("2�б� �߰�");
			break;
		case 4:
			System.out.println("2�б� �⸻");
			break;
		}
		System.out.printf("���� : %d, ���� : %d, ���� : %d\n", korArray[gradE-1][whenScorE-1], engArray[gradE-1][whenScorE-1], mathArray[gradE-1][whenScorE-1]);
	}
		
		
	//}
	
	public static void main(String[] args) throws IOException {
		
		//Ű���� �Է� �޸� ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//2.�迭 ����
		// -����, ����, ����(o)
		int[][] korArray = new int[3][4];
		int[][] engArray = new int[3][4];
		int[][] mathArray = new int[3][4];
		
		int grade = 0;
		int whenScore = 0;
		
		
		//1.�޴� �޼ҵ� �����
		// -�޼ҵ� (o)
		// -�Է��ϸ� �ش� �޴��� �Ѿ������(o)
		// -�Է¸޴� (o)
		// -��¸޴� (o)
		// -����޴�(o)
		while(true) {
			showMenu();
			int selectMenu = Integer.parseInt(bufferedReader.readLine());
			if(selectMenu == 1) {		
				//3.�迭�� �����Է��ϴ� �޼ҵ� �����
				// -�г�, �߰�/�⸻(o)
				// -����, ����, ���� (�ϳ��� ����)(o)
				for(int i = 0; i < korArray.length; i++)  {
					System.out.print("�г� �Է�(1,2,3) : ");
					grade = Integer.parseInt(bufferedReader.readLine());
					
					while(grade < 1 || grade > 3) {
						System.out.println("�ùٸ��� ���� �г��Դϴ�.");
						System.out.print("�г� �Է�(1,2,3) : ");
						grade = Integer.parseInt(bufferedReader.readLine());
					}//while
					for(int j = 0; j < korArray[i].length; j++) {
						System.out.print("���°?(1-1�б� �߰�,2-1�б� �⸻,3-2�б� �߰�,4-2�б� �⸻) : ");
						whenScore = Integer.parseInt(bufferedReader.readLine());
						while(whenScore < 1 || whenScore > 4) {
							System.out.println("�ùٸ��� ���� �����Դϴ�.");
							System.out.print("���°?(1->1�б� �߰�,2->1�б� �⸻,3->2�б� �߰�,4->2�б� �⸻) : ");
							whenScore = Integer.parseInt(bufferedReader.readLine());
						}//while
						
						System.out.print("���� ");
						korArray[grade-1][whenScore-1] = validateScore(bufferedReader); //�Է¿��� �ƴ� �޼ҵ�� ���� �Ѱ��ֱ� ���� ����
						//korean�� validateScore�� �޼ҵ� �����(score)�� ����
						
						System.out.print("���� ");
						engArray[grade-1][whenScore-1] = validateScore(bufferedReader);//�Է¿��� �ƴ� �޼ҵ�� ���� �Ѱ��ֱ� ���� ����
						
						System.out.print("���� ");
						mathArray[grade-1][whenScore-1] = validateScore(bufferedReader);//�Է¿��� �ƴ� �޼ҵ�� ���� �Ѱ��ֱ� ���� ����
						
					}//���� �Է� �ݺ� for j(����)
				}//���� �Է� �ݺ�  for i(�г�)
			}else if(selectMenu == 2) {
				//4.�ʿ��� ���� ����ϴ� �޼ҵ� �����
				// -�г�, �߰�/�⸻
				// -����, ����, ����
				
				
				printScore(bufferedReader, grade, whenScore, korArray, engArray, mathArray);
				
				
				
			}else {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
		

		

	}

}


	



	
}
