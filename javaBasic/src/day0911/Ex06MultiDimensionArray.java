package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//������ �迭
//�Ȱ��� ������Ÿ���� ���ִ� ���� �迭�̶�� �Ѵ�.
//�迭�� ���ִ°�?

//��ǥ���� ������ �迭�� ����
//�б��� �л����� �������� �迭
//[1�г�][���][����� ����]
//[2�г�][���][����� ����]
//[3�г�][���][����� ����]

public class Ex06MultiDimensionArray {

	public static void main(String[] args) throws IOException {
		//int 2���� �迭�� ������
		int[][] array = new int[2][3];
		//��� 2���� �迭��
		//int�� 3�� �� �� �ִ� �迭�� 2���� ���ִٶ�� ���� �ȴ�
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.println("i: " + i + ", j: " + j);
			}
		}
		//�츮�� �� �迭�� ���� ���� ������
		//1����������
		//�迭�̸�[�ε���] = ��;
		//�̷��� �Է�������
		
		//2����������
		//�迭�̸�[���°�迭][�ε���] = ��;
		//�̷��� �Է��ؾ��Ѵ�.
		
		//�׷� array�� 0��° �迭 2�� �ο����� 10�� �Է�
		array[0][2] = 10;
		
		//�л��� ���� ������ �����ϴ� �迭�� �����
		//1,2,3 �г�
		//������ 1�б� �߰�, 1�б� �⸻, 2�б� �߰�, 2�б� �⸻�� �����ϴ� �迭�� �����غ�����
		int[][] korArray = new int[3][4];
		
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

		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�г� �Է�(1,2,3) : ");
		int grade = Integer.parseInt(bufferedReader.readLine());
		
		while(grade < 1 || grade > 3) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���");
			System.out.print("�г� �Է�(1,2,3) : ");
			grade = Integer.parseInt(bufferedReader.readLine());
		}//while
		
		System.out.println("���°?(1-1�б� �߰�,2-1�б� �⸻,3-2�б� �߰�,4-2�б� �⸻) : ");
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 1 || score > 4) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���");
			System.out.println("���°?(1->1�б� �߰�,2->1�б� �⸻,3->2�б� �߰�,4->2�б� �⸻) : ");
			score = Integer.parseInt(bufferedReader.readLine());
		}//while
		
		System.out.println("���� ���� :");
		int korean = Integer.parseInt(bufferedReader.readLine());
		while(korean < 0 || korean > 100) {
			System.out.println("�߸��� �����Դϴ�.");
			System.out.println("���� ���� :");
			korean = Integer.parseInt(bufferedReader.readLine());
		}//while
		
		korArray[grade-1][score-1] = korean;
		System.out.println(grade + "�г� ");
		switch (score) {
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
		System.out.println(" ���" + korean + "���� �ԷµǾ����ϴ�.");
		
		//�ָ� ����
		//���� ������
		//1�� : ����, ����, ���� ������ ������ �� �ְ� �����ϰ� 
		//2�� : ���� ������ �̿��Ͽ� �޴��� ���ؼ� �Է°� ����� �� �� �ְ� �ٲٰ�
		//3�� : �޼ҵ带 �и��غ�����
	}

}
