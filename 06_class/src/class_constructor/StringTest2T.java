package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTest2T {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str, target, replaceing;
		int index, count;
		
		System.out.println("���ڿ� �Է� : ");
		str = br.readLine();
		
		System.out.println("���� ���ڿ� �Է� : ");
		target = br.readLine();
		
		System.out.println("�ٲ� ���ڿ� �Է� : ");
		replaceing = br.readLine();
		
		if(str.length() < target.length()) {
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�");
		}else {
			str = str.toLowerCase();
			target = target.toLowerCase();
			
			index = count = 0;
			while((index = str.indexOf(target,index)) != -1) {//str�ȿ� target���ڿ��� ������
				System.out.println("index1 = " + index);//���� Ȯ�ο����� �ۼ��Ѱ�
				//target���ڿ��� �ִ� ���� index(0)��° ���ڿ����� ã��
				index += target.length(); //index = index + target.length();
				System.out.println("index2 = " + index);//���� Ȯ�ο����� �ۼ��Ѱ�
				count++;
			}
			
			System.out.println(str.replace(target, replaceing));
			System.out.println(count + "�� ġȯ");
		}
	}

}
