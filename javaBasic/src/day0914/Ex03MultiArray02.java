package day0914;

//반 별로 국영수 점수를 따로 관리하는 프로그램을 작성해보세요
//반의 총 갯수는 4개입니다
//한 반의 최대 학생수는 10명입니다
//만약 입력이 안된 반은
//입력이 안되었다고 출력되게 하세요

//입력을 선택하면
//몇 반인지 입력을 받고
//그 반의 학생수를 입력받고
//그 반 학생들의 국영수 점수를 차례대로 입력받게 하세요.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03MultiArray02 {
	//1. 상수선언
	//최대 학생수 체크용 상수
	final static int CLASS_NUMBER = 4;
	//반의 총 갯수
	final static int STUDENT_SIZE = 10;

	public static void main(String[] args) throws IOException{
	//0.입력받을 때 사용할 변수(=객체)생성
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));	
	//2.배열선언 -점수를 저장할 int[][] socreArray생성
	//과목별 배열 만듦
	//또는 scoreArray 커다란 배열을 만듦
	int[][][] scoreArray = new int[CLASS_NUMBER][][];
	
	//scoreArray[0]은 무엇을 뜻하는가?
	//scoreArray[0][3] 1반 4번학생
	//scoreArray[0][3][1] 1반 4번학생 영어점수
	
	//3-2.메뉴 출력
	while(true) {
		showMenu();
	    int selectMenu = Integer.parseInt(bufferedReader.readLine());
	    if(selectMenu == 1) {
	    	//7-2.입력메소드 출력
	    	
	    	//5-2.반선택
	    	int classNumber = selectClassNumber(bufferedReader);
	    	//6-2.학생수 입력
	    	int studentSize = selectStudentSize(bufferedReader);
	    	

	    	//입력(for문)
	    	scoreArray[classNumber] = new int[studentSize][3];
	    	 //scoreArray의 classNumber 인덱스는
	    	 //int 2차원 배열이다
	    	 //2차원 배열이 classNumber만큼 모여있는 3차원 배열이다
	    	 //3차원은 2차원 배열이 모여서 된것, [3]은 과목수
	    	 //남은 2차원,1차원도 초기화(3차원은 classNumber = 4로 상수선언했기때문에 초기화안함)
	    	 //만약 상수 없이 3차원 초기화 한다면 아래와 같음
	    	 //int[][][] scoreArray = new int[4][][]
	   
	    	//위의 코드의 의미는
	    	//scoreArray는 int의 3차원 배열인데 int 2차원 배열이 CLASS_NUMBER개 만큼 모여있다는 의미가 된다
	    	//우리가 scoreArray[0]을 사용하려면
	    	//그 0번이 어떤 크기의 2차원 배열로 이루어져있는지를 지정해야한다.
	    	//scoreArray[0] = new int[studentSize][]
	    	//이렇게 적으면
	    	//scoreArray의 0번 인덱스는 int가 3개 모여있는 int 1차원 배열이 studentSize만큼 보여있는 int 2차원 배열이다
	    	
	    	//scoreArray의 classNumber 인덱스는 int 2차원배열이고 크기는 2차원은 studenNumber, 1차원은 3의 크기란 의미
	    	
	    	//int[4] 는 int가 4개 모여있다
	    	//int[2][4] 는
	    	//          int가 4개 보여있는 배열이 2개 모여있다.
	    	
	    	//int[5][2][4]는
	    	//			int가 4개모여있는 배열이
	    	//			2개 모여서 하나의 배열이 되고(2차원배열)
	    	//			그러한 배열이 5개가 모여있다 라는 의미가 된다.
	    	//int[][][] arr = int[5][2][4]
	    	//            -arr[0]: int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[1]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[2]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[3]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//            -arr[4]:int[2][4]
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	//				  -int[4]
	    	//					 int, int, int, int
	    	
	    	// int[] arr = new int[5]
	    	// int가 5개모인 것
	    	
	    	// int[][] arr = new int[3][5]
	    	// 이것은 int[]이 3개가 모인게 arr이다
	    	// 그렇다면 arr[0]은 무엇인가?
	    	// int[5]이다
	    	// 더 자세하게 말하면 arr[0]은 int 배열의 배열이다
	    	
	    	//값은 scoreArray[i][j][z]안에 저장되있으니까
	    	//print(scoreArray[i]) 이거나
	    	//print(scoreArray[i][j]) 이렇게 출력하면 3차원배열이 아닌 그냥  1차원, 2차원 배열로 인식해서 오류가 나고
	    	//print(scoreArray[i][j][z])까지 해야 값이 나옴
	    	
	    	for(int i = 0; i < scoreArray[classNumber].length; i++) {
	    		System.out.println((i+1)+ "번 학생의 점수 입력 : ");
	    		scoreArray[classNumber][i][0] = validateScore(bufferedReader, 1); //[classNumber반][i번학생][0]국어점수
	    		scoreArray[classNumber][i][1] = validateScore(bufferedReader, 2); //[classNumber반][i번학생][1]영어점수
	    		scoreArray[classNumber][i][2] = validateScore(bufferedReader, 3); //[classNumber반][i번학생][2]수학점수
	    		//학생수만큼 점수 입력(학생수는 위에서 사용자가 입력한 것)
	    	}
			
	    	
	    }else if(selectMenu == 2) {
	    	//8-2.출력메소드
	    	//5-2반선택
	    	int classNumber = selectClassNumber(bufferedReader);
	    	//해당반이 초기화 되었는지 체크
	    	//초기화 되어 있으면 출력
	    	if(scoreArray[classNumber] == null) {
	    		//아직 초기화가 안되어 있으므로 경고메시지 출력
				System.out.println("아직 입력되지 않은 상태입니다.");
			}else {
				for(int i = 0; i < scoreArray[classNumber].length; i++) {
					System.out.println("==========================");
					System.out.println((i+1) + "반 학생의 점수");
					System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n",
							scoreArray[classNumber][i][0], scoreArray[classNumber][i][1], scoreArray[classNumber][i][2]);
				}//위에 학생이름 입력부분을 출력
			}
	    	
	    	
	    }else if(selectMenu == 3) {
	    	System.out.println("사용해주셔서 감사합니다");
	    	break;
	    }else {
	    	System.out.println("메뉴를 잘못 입력하셨습니다.");
	    	System.out.print("메뉴 선택> ");
	    	selectMenu = Integer.parseInt(bufferedReader.readLine());
	    }
	}
	}
	
	//3-1.메뉴 메소드 만들기
	static void showMenu() {
		System.out.println("==========================");
		System.out.println("비트고등학교 국영수 점수관리 프로그램");
		System.out.println("1.입력\t2.출력\t3.종료");
		System.out.println("==========================");
		System.out.print("메뉴 선택> ");
	}//showMenu
	
	
	//5. 반선택 메소드 만들기
	static int selectClassNumber(BufferedReader buffredReader) throws IOException {
		System.out.print("반을 선택하세요(1~4) :");
		System.out.print("> ");
		int classNumber = Integer.parseInt(buffredReader.readLine());
		while(classNumber < 1 || classNumber > CLASS_NUMBER) {
			System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
			System.out.print("반을 선택하세요(1~4) :");
			System.out.print("> ");
			classNumber = Integer.parseInt(buffredReader.readLine());
		}
		return classNumber - 1;//배열은[0]부터 시작하므로 -1로 [0][1][2][3]에 해당
	}//selectClassNumber
	
	//6-1. 학생수 입력 메소드
	static int selectStudentSize(BufferedReader bufferedReader) throws IOException{
		System.out.println("학생의 숫자를 선택해 주세요 :");
		System.out.print("> ");
		int studentSize = Integer.parseInt(bufferedReader.readLine());
		while(studentSize < 0 || studentSize > STUDENT_SIZE) {
			System.out.println("잘못된 형식입니다. 다시 입력해주세요");
			System.out.println("학생의 숫자를 입력해 주세요 (~10):");
			studentSize = Integer.parseInt(bufferedReader.readLine());
			}
		return studentSize; //여기서는 -1 필요없음, 배열의 크기를 설정하기 위한 숫자이기 때문
	}
	
	//7-1. 입력메소드 만들기
	static int validateScore(BufferedReader bufferedReader, int code) throws IOException {
		String message = new String();
		switch(code) {
		case 1:
			message = "국어";
			break;
		case 2:
			message = "영어";
			break;
		case 3:
			message = "수학";
			break;
		}
		message += " 점수를 입력하세요: ";
		System.out.println(message);
		System.out.print("> ");
		int score = Integer.parseInt(bufferedReader.readLine());
		while(score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다");
			System.out.print(message);
			System.out.print("> ");
			score = Integer.parseInt(bufferedReader.readLine());
		}
		return score;
	}
	
	//8-1. 출력메소드 만들기
}
