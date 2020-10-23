package p14_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamP {

	public static void main(String[] args) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
			dos.writeUTF("ȫ�浿");
			dos.writeInt(25);
			dos.writeDouble(185.6);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
			System.out.println("�̸� : " + dis.readUTF()); //write���� �Ȱ��� �Լ��� ����� ��
			System.out.println("���� : " + dis.readInt());
			System.out.println("Ű : " + dis.readDouble()); //dis.readDouble()�� error!
													      //EOF - End Of File �����޽����� ��
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
