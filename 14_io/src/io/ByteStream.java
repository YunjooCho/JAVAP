package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		
			//BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
			FileInputStream fis = new FileInputStream("data.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			//read() - int형 반환 -> ASCII코드값으로 가져옴 A(65),B(66),C(67),D(68).....글자를 하나씩 읽다가 더이상 읽을게 없으면 -1이 반환됨
			//read(byte[]) - 한꺼번에 읽음
			//서버에서 파일 다운로드는 이걸로 사용
			int data;
			
			while((data = bis.read()) != -1) { //-1이 나올때까지 한글자씩 꺼냄 (중간에 출력되는 1310은 엔터값임(밑으로\n, 맨앞으로\r)
				//System.out.println(data); - 숫자로 출력됨
				System.out.println((char)data); //문자로 출력됨
			}
			
			bis.close();
	}

}
