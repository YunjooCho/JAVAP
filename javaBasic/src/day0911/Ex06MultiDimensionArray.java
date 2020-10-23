package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다차원 배열
//똑같은 데이터타입이 모여있는 것을 배열이라고 한다.
//배열이 모여있는건?

//대표적인 다차원 배열의 예시
//학교의 학생들의 국어점수 배열
//[1학년][몇반][몇번의 점수]
//[2학년][몇반][몇번의 점수]
//[3학년][몇반][몇번의 점수]

public class Ex06MultiDimensionArray {

	public static void main(String[] args) throws IOException {
		//int 2차원 배열을 만들어보자
		int[][] array = new int[2][3];
		//상기 2차원 배열은
		//int가 3개 들어갈 수 있는 배열이 2개가 모여있다라는 뜻이 된다
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.println("i: " + i + ", j: " + j);
			}
		}
		//우리가 각 배열에 값을 넣을 때에는
		//1차원에서는
		//배열이름[인덱스] = 얼마;
		//이렇게 입력했지만
		
		//2차원에서는
		//배열이름[몇번째배열][인덱스] = 얼마;
		//이렇게 입력해야한다.
		
		//그럼 array의 0번째 배열 2번 인엑스에 10을 입력
		array[0][2] = 10;
		
		//학생의 국어 점수를 관리하는 배열을 만들되
		//1,2,3 학년
		//각각의 1학기 중간, 1학기 기말, 2학기 중간, 2학기 기말을 관리하는 배열을 선언해보세요
		int[][] korArray = new int[3][4];
		
		//사용자로부터 몇학년 몇번째 시험점수인지 입력 받아서
		//해당 위치에 점수를 넣는 코드를 구현하시오
		//조건1. 잘못된 학년이 입력되지 않게 하시오
		//조건2. 몇번째 시험정수를 입력 받을 때 잘못 된 순서가 입력되지 않게 하시오
		//조건3. 점수가 올바른 점수만 입력되기 하시오
		
		//예시
	    //몇학년 점수입니까? (입력 4)
	    //올바르지 않은 학년입니다.
	    //몇학년 점수입니까? (입력 2)
	    //몇번째 시험입니까? (입력 -2)
	    //올바르지 않은 순서입니다.
	    //몇번째 시험입니까? (입력 1)
	    //몇점입니까? (입력 80)
	    //2학년 1학기 중간 고사 국어에 80점이 입력되었습니다.
		//1학년 1학기 중간 
		//국어 40 영어 50 수학 45

		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("학년 입력(1,2,3) : ");
		int grade = Integer.parseInt(bufferedReader.readLine());
		
		while(grade < 1 || grade > 3) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			System.out.print("학년 입력(1,2,3) : ");
			grade = Integer.parseInt(bufferedReader.readLine());
		}//while
		
		System.out.println("몇번째?(1-1학기 중간,2-1학기 기말,3-2학기 중간,4-2학기 기말) : ");
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 1 || score > 4) {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			System.out.println("몇번째?(1->1학기 중간,2->1학기 기말,3->2학기 중간,4->2학기 기말) : ");
			score = Integer.parseInt(bufferedReader.readLine());
		}//while
		
		System.out.println("국어 점수 :");
		int korean = Integer.parseInt(bufferedReader.readLine());
		while(korean < 0 || korean > 100) {
			System.out.println("잘못된 점수입니다.");
			System.out.println("국어 점수 :");
			korean = Integer.parseInt(bufferedReader.readLine());
		}//while
		
		korArray[grade-1][score-1] = korean;
		System.out.println(grade + "학년 ");
		switch (score) {
		case 1:
			System.out.println("1학기 중간");
			break;
		case 2:
			System.out.println("1학기 기말");
			break;
		case 3:
			System.out.println("2학기 중간");
			break;
		case 4:
			System.out.println("2학기 기말");
			break;
		}
		System.out.println(" 국어에" + korean + "점이 입력되었습니다.");
		
		//주말 숙제
		//위의 내용을
		//1차 : 국어, 영어, 수학 순으로 관리할 수 있게 변경하고 
		//2차 : 무한 루프를 이용하여 메뉴를 통해서 입력과 출력을 할 수 있게 바꾸고
		//3차 : 메소드를 분리해보세요
	}

}
