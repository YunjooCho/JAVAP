package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBufferTest {
	private int dan;
	
	//기본생성자
	public StringBufferTest() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원하는 단을 입력 : ");
		this.dan = Integer.parseInt(br.readLine());
	}
	
	//메소드
	public void disp() {
		StringBuffer buffer = new StringBuffer(); //버퍼생성
		
		for(int i = dan; i <= dan; i++) {
			for(int j = 1; j <= 9; j++) {
				//System.out.println(dan + "*" + j + "=" + (dan*j));
				buffer.append(dan);
				buffer.append("*");//하나의 메모리에 추가(수정)됨
				buffer.append(j);
				buffer.append("=");
				buffer.append(dan*j);
				System.out.println(buffer);//한번 출력되고
				buffer.delete(0, buffer.length());//출력된 뒤 내용이 지워짐
			}
		}
		//for(int i = 1; i <= 9; i++{
		//    System.out.println(dan + "*" + i + "=" + (dan*i));
		//}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//클래스 생성
		StringBufferTest sb = new StringBufferTest();
		//메소드 호출
		sb.disp();
	}
}
