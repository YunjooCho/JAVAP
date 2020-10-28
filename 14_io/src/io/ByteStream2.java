package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");//파일 객체 생성
		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		//★왜 여기서 Buffered???????
		
		//배열로 출력하기 위해 파일의 크기를 알아내야함
		int size = (int) file.length(); //파일의 크기는 long타입임
		byte[] b = new byte[size]; //파일크기 만큼의 배열을 만듦
		
		bis.read(b, 0, size); //데이터를 한글자씩이 아닌 한꺼번에 읽음
							  //부분만 선택해서 읽는것도 가능
		
		
		//출력할때 for문 말고 문자열로 생성(byte[]을 String으로 생성) - 다운로드
		String str = new String(b);
		System.out.println(str);
		
		bis.close();
	}

}
