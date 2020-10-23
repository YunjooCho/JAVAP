package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		
			//BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
			FileInputStream fis = new FileInputStream("data.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			//read() - int�� ��ȯ -> ASCII�ڵ尪���� ������ A(65),B(66),C(67),D(68).....���ڸ� �ϳ��� �дٰ� ���̻� ������ ������ -1�� ��ȯ��
			//read(byte[]) - �Ѳ����� ����
			//�������� ���� �ٿ�ε�� �̰ɷ� ���
			int data;
			
			while((data = bis.read()) != -1) { //-1�� ���ö����� �ѱ��ھ� ���� (�߰��� ��µǴ� 1310�� ���Ͱ���(������\n, �Ǿ�����\r)
				//System.out.println(data); - ���ڷ� ��µ�
				System.out.println((char)data); //���ڷ� ��µ�
			}
			
			bis.close();
	}

}
