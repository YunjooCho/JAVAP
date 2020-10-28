package p14_io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamP {

	public static void main(String[] args) throws IOException {
		
		
			FileInputStream fis = new FileInputStream("data.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			int data;
			while((data = bis.read())!= -1){
				System.out.println((char)data); //문자로 출력
			}
			
			bis.close();
		
		

	}

}
