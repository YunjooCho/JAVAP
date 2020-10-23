package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//String Ŭ������ ���� �˾ƺ���
//String �̶�?
//�������� ���ڰ� ���ִ� char[]�� ->char�迭�� Ŭ������ ��Ʈ��
//�츮�� �ٷ�� ���� Ŭ������ ���·� �ٲ���� ��

//String Ŭ���� �ȿ��� ��Ʈ���� �ٷ�� �� ������ �Ǵ� �پ��� �޼ҵ尡 �غ�Ǿ��ִ�.

public class Ex01String {
	public static void main(String[] args) throws IOException {
		String string1 = new String("abc");
		String string2 = "abc";
		String string3 = "1234567";
		System.out.println("string1.equals(string2) : " + string1.equals(string2));//�ܼ��� ���ں�
		
		//1��: �ش� ��Ʈ���� ���° ĭ�� ���� ���ڰ� �ִ��� Ȯ���� ������
		//charAt(index)�� �����ϸ� �ȴ�.
		System.out.println("string1.charAt(0): " + string1.charAt(0)); //����� : a
		
		
		//2��: 2���� ���ڿ��� �����ų������ concat�� ����Ѵ�.
		System.out.println("string1.concat(string2) : " + string1.concat(string2)); //����� : abcabc
		
		
		//3��: �ش� ���ڿ��� �̷��� ���� ���ڿ��� �ִ��� üũ�� ������ contains()�� ����Ѵ�.
		System.out.println("string1.contains(\"ab\") : "+ string1.contains("ab"));
		//\�ڿ� "�� �Է��ϸ� "�̺κе� �״�� ��µ�
		
		
		//4��: �ش� ���ڿ��� �ʱ�ȭ�� �Ǿ������� ����ִ� ���ڿ����� üũ�� ������ isEmpty()�� ����Ѵ�.
		
		//null != ""; (�����ϰ� �ʱ�ȭ ���ϸ� null��)
		//null�� ���¿��� �ƹ��͵� �� �� ����. ���ο� �ʱ�ȭ�� �� �� ����
		//""Ȥ�� new String()���� �ʱ�ȭ�ϸ� ��� �޼ҵ带 ȣ�� �� �� ������
		//�ٸ� �ƹ��� ���ڵ� ���ڿ��� ���� ������ ���̴�.
		
		//null : ���� �������� �ּҰ��� �ο��Ǿ������� �� ������ �ش� �ּҰ� �ƹ��� �ʱ�ȭ�� �Ǿ����� ���� ����
		//�츮�� �� Ŭ������ �ʵ� Ȥ�� �޼ҵ带 ���� �Ϸ���
		//�� �������� �� ������ ã�ƾ� �ϴµ�
		//���� ���¿����� �� ������� �����Ƿ�
		//������ �� ���� �Ǵ� ���̴�.(�̻��� ���� �ǹ��� �� �ö� ����)
		//""�� �� ������ �Ҵ��� �Ǿ��ִ� ����
		
		//�� isEmpty()�޼ҵ��
		//�ش� ��Ʈ���� ���� �ƴ� ���� ���డ���ϴ�.		
		System.out.println("string1.isEmpty():" + string1.isEmpty());
		System.out.println("\"\".isEmpty() : " + "".isEmpty());
		
		//5��: �ش� ��Ʈ���� ���̸� �˰� ���� ���� length()
		System.out.println("string1.length() : " + string1.length()); //����� : 3
		
		//6��: �ش� ���ڿ��� �������ϰ� ��ġ�ϴ��� Ȯ���� ������ matches()�� ����Ѵ�
		//     ���� ������ ����ǥ������ ����ؾ��Ѵ�.
		//     �پ��� ����ǥ������ ����ؼ� �츮�� ���ڿ��� �������� ���¸� �����ϴ���
		//     �׽�Ʈ �����ϴ�	
		//     ex)�ڵ��� ��ȣ
		//     ������ ����� �����̹Ƿ� �츮�� �ش� ���ڿ��� ���ڷθ� �̷�����°� �ƴѰ��� ��������� ����
		//     �ش� ��Ʈ���� ��δ� ��Ʈ������ �̷�������� üũ�� ������ \d* ���� �׽�Ʈ�Ѵ�.
		//StudentŬ����(day0915)�� s1.getKorean().matches("\\d*")); ->korean�� int���̹Ƿ� �񱳰� �ȵ�
		
		//\\d : \�� 2�� ���̴� ������ "\\d" ���� �ȿ��� \ ���� \���ڰ� Ư�����ڶ�� �˷��ִ� �Ͱ� �����ϴ�. �� ������ ����ϸ� ���ڸ� true�� ��ȯ�մϴ�.
		//       ex) ^[a-zA-Z]+\\d{2} �� ��� ���� true�� ��ȯ�ұ�?
		//       => ^���ۿ��� �˸��⿡ �տ� a~Z���� +�� ���� ���ڰ� �� 1�� ���� �մϴ�.. �׸��� ���� 2���� �����Ѵٶ�� �ؼ� �� �� �ֽ��ϴ�.
		//��ó: https://postitforhooney.tistory.com/entry/JavaRegex-�ڹ�-����ǥ���Ŀ�-���ؼ�-�����ϰ�-����-����� [PostIT]

		System.out.println("string: " + string1); //abc
		System.out.println("string1.matches(\\d*) : " + string1.matches("\\d*")); //����� : false
		System.out.println("string3.matches(\\d*) : " + string3.matches("\\d*")); //����� : true->���� ���ڸ� true�� ����
		//�� false�� �����°� : �ܼ��� string1, string2�� ���ڰ��� ���� ����
		System.out.println("\"12345\".matches(\\d*) : " + "12345".matches("\\d*"));
		
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���ڸ� �Է����ּ��� : ");
		String userInput = bufferedReader.readLine();
		while(!userInput.matches("\\d*")) {//��� ���ڿ� ���ڰ� �����Ǵ��� : ���Ǿտ� !�� �پ� �־� false�϶� while������ �ݺ� ����, true�̸� ������ ��������
			System.out.println("���ڸ� �Է����ּ���");
			System.out.print("> ");
			userInput = bufferedReader.readLine();
		}
		int userNumber = Integer.parseInt(userInput);//�������¸� �Է��ϸ� ����� �ͼ� ����ȭ -> userNumber�� ���ԵǾ� �Ʒ��� ��µ�
		System.out.println("����ڰ� �Է��� ���� : " + userNumber);
	}
}
