package method;

/*
 ch�� �ִ� �����Ͱ� �빮���̸� �ҹ��ڷ� ����ϰ� �ƴϸ�(�ҹ���) �빮�ڷ� ����Ͻÿ�
 
 [������]
  T -> t
  
  �Ǵ�
  
  e -> E
 */

public class CompTest2 {
	public static void main(String[] args) {
		char ch = 'P';
				
		//�빮��(A~Z) -> 65 ~ 90
		int result = ch >= 65 && ch <= 90 ? ch + 32 : ch - 32;
		System.out.println(ch + " -> " + (char)result);
		
		
		//<������ Ǯ��>
		//char�� ����ϸ� ������� int������ ��ȯ��
		//int result = ch>= 'A' && ch <= 'Z' ? ch + 32 : ch - 32;
		//System.out.println(ch + " -> " + (char)result);
	}
}
