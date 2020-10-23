package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBufferTest {
	private int dan;
	
	//�⺻������
	public StringBufferTest() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϴ� ���� �Է� : ");
		this.dan = Integer.parseInt(br.readLine());
	}
	
	//�޼ҵ�
	public void disp() {
		StringBuffer buffer = new StringBuffer(); //���ۻ���
		
		for(int i = dan; i <= dan; i++) {
			for(int j = 1; j <= 9; j++) {
				//System.out.println(dan + "*" + j + "=" + (dan*j));
				buffer.append(dan);
				buffer.append("*");//�ϳ��� �޸𸮿� �߰�(����)��
				buffer.append(j);
				buffer.append("=");
				buffer.append(dan*j);
				System.out.println(buffer);//�ѹ� ��µǰ�
				buffer.delete(0, buffer.length());//��µ� �� ������ ������
			}
		}
		//for(int i = 1; i <= 9; i++{
		//    System.out.println(dan + "*" + i + "=" + (dan*i));
		//}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Ŭ���� ����
		StringBufferTest sb = new StringBufferTest();
		//�޼ҵ� ȣ��
		sb.disp();
	}
}
