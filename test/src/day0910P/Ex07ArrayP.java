package day0910P;
//�迭
//�迭�̶� �Ȱ��� �ڷ����� ���ִ� ���� ����Ŵ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//����:
//��Ʈ �迭�̶�� �ϸ�
//��Ʈ�� ����� ������ ��ŭ�� ������ ���ְ�
//�� ��ü�� �ϳ��� �迭�̶�� �Ѵ�
public class Ex07ArrayP {

	public static void main(String[] args) throws IOException {
		//�迭 ����
		int[] arr = new int[5];
		
		arr[0] = 15;
		System.out.println("arr[0] = " + arr[0]);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "�� �ε����� �Է��� �� : ");
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
		
		int size = 10;
		arr = new int[size];
		System.out.println(arr[10]);
	}

}
