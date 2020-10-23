package day0910P;

//성적 관리 프로그램
//우리가 사용자로부터 입력을 받되
//제일 마지막에 사용자로부터 계속할지 말지를 입력 받아서
//만약 사용자가 종료를 선택하면 프로그램이 종료가 되는 형식으로 만들어보자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05GradeBookP {

	public static void main(String[] args) throws IOException {
		//메모리 생성
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    
	    //키보드로 점수 입력받기
	    int kor = 0, eng = 0, math = 0, tot;
	    String yn;
	    do {
		    do { 
		    	
		    	if(kor > 100 || kor < 0) {
		    		System.out.println("잘못된 형식입니다. 다시 입력해 주세요");
		    	}
		    	System.out.println("국어 점수 입력 : ");
		    	kor = Integer.parseInt(bufferedReader.readLine());
		    	
		    }while(kor > 100 || kor < 0);
		    
		    do { 
		    	
		    	if(eng > 100 || eng < 0) {
		    		System.out.println("잘못된 형식입니다. 다시 입력해 주세요");
		    	}
		    	System.out.println("영어 점수 입력 : ");
		    	eng = Integer.parseInt(bufferedReader.readLine());
		    	
		    }while(eng > 100 || eng < 0);
	
		    do { 
		
		    	if(math > 100 || math < 0) {
		    		System.out.println("잘못된 형식입니다. 다시 입력해 주세요");
		    	}
		    	System.out.println("수학 점수 입력 : ");
		    	math = Integer.parseInt(bufferedReader.readLine());
		
		    }while(math > 100 || math < 0);
		    
		    tot = kor + eng + math;
		    System.out.println("총점 : " + tot);
		    System.out.println("계속 입력하시겠습니까?(Y/N)");
		    
		    //String 초기화
		    //yn = new String();
		    yn = bufferedReader.readLine().toUpperCase();
	    }while(yn.equals("Y"));
	    System.out.println("프로그램을 종료합니다");
	}

}
