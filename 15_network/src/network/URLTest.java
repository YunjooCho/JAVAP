package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.google.com/index.html");
		System.out.println("프로토콜  = " + url.getProtocol());
		System.out.println("호스트 = " + url.getHost());
		System.out.println("포트 = " + url.getPort()); //위의 URL에서 아무것도 기재를 안해서 값이 없다는 뜻의 -1이 반환됨
		System.out.println("기본 포트  = " + url.getDefaultPort());
		System.out.println("파일 = " + url.getFile());
		System.out.println();
		
		
		//IOStream - 입력스트림
		//IO로 가져온 홈페이지의 소스코드를 Console창에 찍어내기
		//openStream() - 반환값 : InputStream
		BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
		//유사한 형태 : BufferedReader bufferkey = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while((line = buffer.readLine()) != null) {
			System.out.println(line + "\n");
		}//while
		
		buffer.close();
	}

}

//UTF-8
//encoding(euc-kr)