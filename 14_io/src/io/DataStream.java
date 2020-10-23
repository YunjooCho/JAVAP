package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//���ڰ� �ƴ� ����Ʈ ������ ���� ������ ���� Ȯ��
public class DataStream {

	public static void main(String[] args) {
		try { //���� �ٸ� ��ü�� �����ϱ� ���� ������ ��
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt")); //���� ������ �����ؼ� �������
			dos.writeUTF("ȫ�浿"); //���� ������ : "result.txt" - ������� �̻��ϰ� ����
								  //���������� Serializable(����ȭ) �Ǿ�����, Comparable�� �Ǿ�����
			dos.writeInt(25);
			//dos.writeDouble(185.3); //����Ʈ
			dos.writeFloat(185.3f);
			dos.close();
		} catch (IOException e) {//FileNotFoundException �� IOException�� ���� ó�� -> IOException�� �����̹Ƿ� �ٸ� ����ó���� ���� �ذ�
			e.printStackTrace();
		} 
		
		
		
		//���� ���� �����ʹ� ������ �ٽ� �о���� ���������� ������
		//�о���鼭 ���
		try { //�ٸ� ��ü�� ����Ǿ� �ִ� ���� �о����
			DataInputStream dis = new DataInputStream(new FileInputStream("result.txt")); //���⼭ ��������(""���� ���ϸ�)�� ������ error!�� ������
																						 //java.io.FileNotFoundException�� ��Ÿ��
			System.out.println("�̸� : " + dis.readUTF()); //write���� �Ȱ��� �Լ��� ����� ��
			System.out.println("���� : " + dis.readInt());
			System.out.println("Ű : " + dis.readFloat()); //dis.readDouble()�� error!
													      //EOF - End Of File �����޽����� ��
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
