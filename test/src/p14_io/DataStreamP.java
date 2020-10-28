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
			dos.writeUTF("홍길동");
			dos.writeInt(25);
			dos.writeDouble(185.6);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
			System.out.println("이름 : " + dis.readUTF()); //write때와 똑같은 함수를 써줘야 함
			System.out.println("나이 : " + dis.readInt());
			System.out.println("키 : " + dis.readDouble()); //dis.readDouble()은 error!
													      //EOF - End Of File 에러메시지가 뜸
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
