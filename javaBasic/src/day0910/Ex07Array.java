package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�迭
//�迭�̶� �Ȱ��� �ڷ����� ���ִ� ���� ����Ŵ

//����:
//��Ʈ �迭�̶�� �ϸ�
//��Ʈ�� ����� ������ ��ŭ�� ������ ���ְ�
//�� ��ü�� �ϳ��� �迭�̶�� �Ѵ�
public class Ex07Array {

	public static void main(String[] args) throws IOException {
		// �迭�� �����ϴ� ���
		// �迭�� �ڷ���[] �迭�̸� = new �ڷ���[ũ��]
		
		//���� �츮�� int�迭�� ����� �ȴٸ�
		int[] arr = new int[5];
		//�̷��� ����� �ȴ�

		
		//�迭�� �츮�� �׻� ũ�� ������ �� ����� ��
		//�� ũ�⸦ ��� �� ����
		//���� arr�� �ش� �迭�� 5���� ��Ʈ������ �ٷ� �� �ִٴ� ���� ���Ѵ�
		
		//�迭�� �ִ� �� ������ ������ ������
		//�迭�̸�[�ش� ��ġ]�� ��� �����ϰ� �ȴ�.

		//�ش� ��ġ�� �츮�� index��� ǥ���Ѵ�
		//�׸��� �ε�����
		//0~(ũ��-1)���� �̴�.
		//�� ũ�Ⱑ 5�� �迭��
		//�ε����� 0������ 4������ �ִ�
		
		//�츮�� ������
		//�������� ��쿡��
		int a;
		a = 20;
		System.out.println("a : " + a);
		
		//�迭���� ��쿡��
		arr[0] = 15;
		System.out.println("arr[0]" + arr[0]);
		//�̷��� �迭�̸�[�ε���]�� �����Ѵ�.
		
		//�׷� �迭�� �� ��ҿ� ���� �ѹ� �Է��غ���
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//0������ 4������ ���ʴ�� �Է��� �غ���
		System.out.print("0�� �ε����� �Է��� �� : ");
		arr[0] = Integer.parseInt(bufferedReader.readLine());
		
		System.out.print("1�� �ε����� �Է��� �� : ");
		arr[1] = Integer.parseInt(bufferedReader.readLine());
		
		System.out.print("2�� �ε����� �Է��� �� : ");
		arr[2] = Integer.parseInt(bufferedReader.readLine());
		
		System.out.print("3�� �ε����� �Է��� �� : ");
		arr[3] = Integer.parseInt(bufferedReader.readLine());
		
		System.out.print("4�� �ε����� �Է��� �� : ");
		arr[4] = Integer.parseInt(bufferedReader.readLine());
		
		System.out.println("arr[0]" + arr[0]);
		System.out.println("arr[1]" + arr[1]);
		System.out.println("arr[2]" + arr[2]);
		System.out.println("arr[3]" + arr[3]);
		System.out.println("arr[4]" + arr[4]);
		
		//�迭�� �ٷ� �� �˾Ƶθ� ���� ��
		//1. ũ��� ������ �� �� �ִ�
		int size = 10;
		arr = new int[size];
		//2. index�� ����� ���� ������ ����.
		//java.lang.ArrayIndexOutOfBoundsException: 10
		System.out.println(arr[10]);
		//3. �ε����� ������ �־��� �� �ִ�.
		
	}

}
