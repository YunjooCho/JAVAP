package p14_io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamTest2P  {
		
	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		int size = (int) file.length();
		byte[] b = new byte[size];
		
		bis.read(b, 0, size);
		
		String str = new String(b);
		System.out.println(str);
		
		bis.close();
	}
}
