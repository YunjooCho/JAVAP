package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//문자가 아닌 바이트 단위로 들어갔다 나오는 형태 확인
public class DataStream {

	public static void main(String[] args) {
		try { //값을 다른 매체에 저장하기 위해 밖으로 뺌
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt")); //없는 파일은 생성해서 만들어줌
			dos.writeUTF("홍길동"); //최종 목적지 : "result.txt" - 결과값이 이상하게 나옴
								  //내부적으로 Serializable(직렬화) 되어있음, Comparable도 되어있음
			dos.writeInt(25);
			//dos.writeDouble(185.3); //디폴트
			dos.writeFloat(185.3f);
			dos.close();
		} catch (IOException e) {//FileNotFoundException 와 IOException를 같이 처리 -> IOException이 상위이므로 다른 예외처리도 전부 해결
			e.printStackTrace();
		} 
		
		
		
		//파일 속의 데이터는 깨져도 다시 읽어오면 정상적으로 보여짐
		//읽어오면서 출력
		try { //다른 매체에 저장되어 있는 값을 읽어들임
			DataInputStream dis = new DataInputStream(new FileInputStream("result.txt")); //여기서 실존파일(""안의 파일명)이 없으면 error!가 떨어짐
																						 //java.io.FileNotFoundException이 나타남
			System.out.println("이름 : " + dis.readUTF()); //write때와 똑같은 함수를 써줘야 함
			System.out.println("나이 : " + dis.readInt());
			System.out.println("키 : " + dis.readFloat()); //dis.readDouble()은 error!
													      //EOF - End Of File 에러메시지가 뜸
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
