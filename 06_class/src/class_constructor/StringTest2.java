package class_constructor;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTest2 {
	//�ʵ��
	private String inputWord;
	private String keyWord;
	private String changeWord;
	private int count;
	
	//������
	public StringTest2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ڿ� �Է� : ");
		this.inputWord = br.readLine().toLowerCase();
		System.out.print("���� ���ڿ� �Է� : ");
		this.keyWord = br.readLine().toLowerCase();//�ڡڡڡڡڶȰ��� �ҹ��ڷ� ��ȯ�ؾ���
		System.out.print("�ٲ� ���ڿ� �Է� : ");
		this.changeWord = br.readLine();
		
		while(inputWord.length() < keyWord.length() || inputWord.length() < changeWord.length()) {
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�.");
			System.out.print("���� ���ڿ� �Է� : ");
			this.keyWord = br.readLine();
			System.out.print("�ٲ� ���ڿ� �Է� : ");
			this.changeWord = br.readLine();
		}
	}
	
	public void replaceString() {
		
		//�ڡڡڡڡ�ġȯ Ƚ�� Ȯ��(�̿ϼ�)
		
		int index = count = 0;
		while((index = inputWord.indexOf(keyWord, index)) != -1) {
			index += keyWord.length();
			count++;
		}
		
		
		//���� ��ȯ
		inputWord = inputWord.replace(keyWord, changeWord);
		//������ ���� �ٲ��� ���� : ��)aabbaa aa->cc ����� : ccbbcc
		//������ aabbaa�״��
		//<����� Ǯ��>
		
		
		//���
		StringBuffer buffer = new StringBuffer();
		buffer.append(inputWord);
		System.out.println(buffer);
		buffer.append(count);
		buffer.append("�� ġȯ");
		buffer.delete(0, inputWord.length());
		System.out.println(buffer);
		
		
	}
	

	public static void main(String[] args) throws IOException {
		
		StringTest2 st = new StringTest2();
		st.replaceString();
		
	}
}

//<������>
//String str = "aabbaa"
//System.out.println(str.replace("aa","tt"));
//System.out.println("str=" + str);
//������ ���� �ٲ��� ���� : ��)aabbaa aa->tt ����� : ttbbtt
//������ aabbaa�״��

//System.out.println(str.indexOf("aa"));
//System.out.println(str.indexOf("aa",2));-2��°���� ��ġ ã��