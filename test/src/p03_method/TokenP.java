package p03_method;

import java.util.StringTokenizer;

public class TokenP {

	public static void main(String[] args) {
		
		//StringTokenizerŬ����
		String str = "�п�/��//���ӹ�";
		
		StringTokenizer st = new StringTokenizer(str, "/"); //'/'�� �����Ѵٰ� ���� - �������� ��ȣ�� �� �� ����
		System.out.println("��ū ���� = " + st.countTokens());
		//3��, �ڷᰡ ���� ���� ���õ�(���� �ƹ��͵� ���� ��), " "�� ���� 32��� ���� ����
		
		while(st.hasMoreTokens()) {//��ū�� �ִ��� ������ True|False
			System.out.println(st.nextToken());
		}//��ū�� �ִ� ���� ��ū ����ϱ�(��ū�� ���� ���� ��ū�� ã�� �̵�)
		
		
		//������
		//for���� ����� �� ����
		//������ ��� ����
		
		System.out.println("---------------------------------------");
		
		//split()�޼ҵ�
		String[] ar = str.split("/");
		//StringŬ���� �Լ�, �迭�� ������
		//split��� �Լ��� �迭�� ����� �ѱ�� �Լ�(String[])�� new�� ���� �ʾƵ� ��
		for(String data : ar) {
			System.out.println(data);
		}//for
		System.out.println("ar�迭 ũ�� = " + ar.length);
		//������
		//for�� ��밡��
		//���鵵 �迭 �ε����� �ϳ� ����(�迭�� �����) - 0���� ����

	}

}
