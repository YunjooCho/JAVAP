package p06_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
ġȯ�ϴ� ���α׷��� �ۼ��Ͻÿ�
String Ŭ������ �޼ҵ带 �̿��Ͻÿ�
��ҹ��� ������� ������ ����Ͻÿ�

[������]
���ڿ� �Է� : aabba
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : cc
ccbba
1�� ġȯ

���ڿ� �Է� : aAbbA
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : cc
ccbba
1�� ġȯ

���ڿ� �Է� : aabbaa
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : cc
ccbbcc
2�� ġȯ

���ڿ� �Է� : AAccaabbaaaaatt
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddccddbbddddatt
4�� ġȯ

���ڿ� �Է� : aabb
���� ���ڿ� �Է� : aaaaa
�ٲ� ���ڿ� �Է� : ddddd
�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�

indexOf()
replace(??, ??)
 */
public class StringTest2TP {

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
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�.");
		}else {
			str = str.toLowerCase();
			target = target.toLowerCase();
			
			index = count = 0;
			while((index = str.indexOf(target,index)) != -1) { //target���ڿ��� �ִ� ���� index(0)��° ���ڿ����� ã��
				index += target.length();
				count++;
			}
			
			System.out.println(str.replace(target, replaceing));
			System.out.println(count + "�� ġȯ");
		}
		

	}

}
