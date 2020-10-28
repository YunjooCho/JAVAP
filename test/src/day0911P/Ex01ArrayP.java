package day0911P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2개의 배열을 동시에 사용해서
//이름과 총점을 동시에 관리해보자(5명)

public class Ex01ArrayP {
	
	final static int SIZE = 5;

	public static void main(String[] args) throws IOException {
	//메모리생성
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	//이름을 담당할 배열을 하나 만들자	
	String[] nameArray = new String[SIZE];
		
	//총점을 담당할 배열을 하나 만들자
	int[] totArray = new int[SIZE];	
		
	//차례대로 입력을 해보자
	for(int i = 0; i < nameArray.length; i++) {
		System.out.println((i+1) + "번 학생의 이름 입력 : ");
		nameArray[i] = bufferedReader.readLine();
		
		System.out.println(nameArray[i] + "학생의 총점 : ");
		totArray[i] = Integer.parseInt(bufferedReader.readLine());
		while(totArray[i] < 0 || totArray[i] > 100) {
			System.out.println("잘못 입력하셨습니다");
			System.out.println(nameArray[i] + "학생의 총점 : ");
			totArray[i] = Integer.parseInt(bufferedReader.readLine());
		}//while
	
		
	}
	 //보고 싶은 학생의 번호를 입력하면 그 학생의 정보를 출력하게 만들어보자
	System.out.println("출력을 희망하는 학생의 번호(1~5) : ");
	int selectNumber = Integer.parseInt(bufferedReader.readLine());
	System.out.printf(selectNumber + "번 학생의 이름 : %s, 총점 : %d", nameArray[selectNumber-1], totArray[selectNumber-1]);	
   
	
	}

}
