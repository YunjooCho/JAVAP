package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
	
	
	//private static String line; 21번 줄 여기서 선언해도 결과값 똑같이 나옴, 초기화 불필요
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.liebli.com/");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
		//InputStreamReader - 웹 브라우저, 키보드, 소켓 등을 통해 정보를 받아들일 때
		//BufferedReader - 한 줄 씩 읽어옴
		String line = null; //지역변수라 쓰레기값을 쥐고있음
		int index;
		int count = 0;
		while((line = buffer.readLine()) != null) { //웹 브라우저(홈페이지)의 소스코드는 여러줄이므로 끝줄(null)에 갈때까지 읽어들이기 위해 while문 사용
			line = line.toLowerCase();//가져온 데이터를 전부 소문자로 바꿔줌(웹 브라우저가 아닌 console로 불러오고 있는 값을 바꿈)
									  //line = 을 해줘서 원본을 덮어버림
			index = 0;
			while((index = line.indexOf("14k", index)) != -1) { //처음 한번 찾아도 시작인덱스가 같으므로 뒷줄은 더 이상 찾지 않음, 
								 							 //해당 문자를 찾으면 시작인덱스를 그 다음 위치부터 찾도록  해야함
								    						 //14k 3글자이므로 indexOf()의 결과값 + 3을 해야함
				index += ("14k".length()); //"14k".length() = 3(14k의 글자수)
				count++;
			}
		}//while
		System.out.println("14k의 갯수 = " + count);
		buffer.close();
	}
}


//대소문자 구별없이 다 찾으세요 14k 14K
//meta 정보
//Script - Java Script


//내 풀이
//while((line = buffer.readLine()) != null) { //웹 브라우저(홈페이지)의 소스코드는 여러줄이므로 끝줄(null)에 갈때까지 읽어들이기 위해 while문 사용
//	System.out.println(line + "\n");
//	while(line.indexOf("14K") > 0 || line.indexOf("14k") >= 0) {
//		count++;
//	}
//}//while
