package method;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "�п�,��,,���ӹ�";
		
		//StringTokenizerŬ������ countTokens()�޼ҵ�, �Ķ���Ͱ� �ִ� ������(str, ",")
		//ǥ�ø� �������� �߶���� �� �߶��� �͵��� ����
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("��ū ���� = " + st.countTokens()); 
		//3��, �ڷᰡ ���� ���� ���õ� - ����(���� �ƿ� ����, ����ִ� ���)
		//" "�� ���� (32��� ���� ����) �ڷᰡ �ִ� ������ ó��
		
		//hasMoreTokens()�޼ҵ�
		while(st.hasMoreTokens()) {//true / false
			System.out.println(st.nextToken());
		}//while - ��ū�� �ִ� ���� ��ū ����ϱ�(��ū�� ���� ���� ��ū�� ã�� �̵�)
		
		//������
		//for�� ��� ����
		//������ ��� ����
		
		System.out.println("------------------------------------");
		
		//StringŬ������ split()�޼ҵ�
		String[] ar = str.split(","); 
		//StringŬ���� �Լ�, �迭�� ������
		//split�̶�� �Լ��� �迭�� ����� �ѱ�� �Լ�(String[])�� new�� ���� �ʾƵ� ��
		for(String data : ar) {
			System.out.println(data);
		}//for
		System.out.println("ar�迭 ũ�� = " + ar.length);
		
		//������
		//for�� ���
		//���鵵 �迭 �ε��� �ϳ� ����(�迭�� �����) - 0���� ����
	}

}
