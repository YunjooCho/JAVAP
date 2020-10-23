package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");//���� ��ü ����
		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		//�ڿ� ���⼭ Buffered???????
		
		//�迭�� ����ϱ� ���� ������ ũ�⸦ �˾Ƴ�����
		int size = (int) file.length(); //������ ũ��� longŸ����
		byte[] b = new byte[size]; //����ũ�� ��ŭ�� �迭�� ����
		
		bis.read(b, 0, size); //�����͸� �ѱ��ھ��� �ƴ� �Ѳ����� ����
							  //�κи� �����ؼ� �д°͵� ����
		
		
		//����Ҷ� for�� ���� ���ڿ��� ����(byte[]�� String���� ����) - �ٿ�ε�
		String str = new String(b);
		System.out.println(str);
		
		bis.close();
	}

}
