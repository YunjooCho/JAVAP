package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//가변형 배열
//가변형 배열이란 다차원 배열을 선언할때
//가장 위의 크기만 선언해주고
//거기에 속한 배열의 크기는 사용할 때 정해주는 방법이다.

//예시: 1학년 1반은 30명, 2반은 29명, 3반은 32명일때
//배열 선언을 어떻게 해야할까?
//int[][] scoreArray = int[3][];
//scoreArray[0] = new int[30];
//scoreArray[1] = new int[29];
//scoreArray[2] = new int[32];

public class Ex02MultiArray {
	
	final static int SIZE = 3;	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//1학년 각반의 학생수를 입력받고
		//그 학생들의 이름을 반마다 넣어주는 프로그램
		String[][] nameArray= new String[SIZE][]; //3개의 배열에 각각 몇개의 String이 들어갈지 지정안되어있음
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("비트고등학교 이름 관리 프로그램");
			System.out.println("1.입력  2.출력  3.종료");
			System.out.print("> ");
			int choice = Integer.parseInt(bufferedReader.readLine());
			if(choice == 1) {
				//반 선택하는 메소드 실행
				int classNumber = selectClassNumber(bufferedReader);
				
				//이름을 입력하는 메소드 실행
				//단 배열의 크기를 결정해야하므로
				//학생 숫자를 입력 받도록 한다.
				int studentSize = insertStudentSize(bufferedReader);
				//insertStudenSize에서 학생숫자 정해짐
				
				//입력받는 반과 학생숫자로 해당 배열을 초기화해준다
				nameArray[classNumber - 1] = new String[studentSize];
				
				//학생의 이름을 입력받는다
				for(int i = 0; i < nameArray[classNumber - 1].length; i++) {
					System.out.println((i+1) + "번 학생의 이름 : ");
					nameArray[classNumber - 1][i] = bufferedReader.readLine();
				}
				//insertStudentSize에서 입력한 학생 수만큼(배열이므로 [0]부터 입력이니까 [classNumber-1]
				
			}else if(choice == 2) {
				//반 선택하는 메소드 실행
				int classNumber = selectClassNumber(bufferedReader); 
 				
				//이름을 출력하는 메소드 실행
				//단 여기서 주의해야 할 것은
				//해당 배열이 초기화 되어있는지 체크를 해야한다(입력이 안되어있으면 null인 상태)
				//만약 해당 배열이 초기화되어있지 않다면
				//그 공간은  현재 null인 상태이므로
				//우리가 접근할 수 없다
				//따라서 그 배열이 null인지부터 체크하고
				//null이 아닐때에만 출력하는 for문을 실행한다
				
				//null이란 참조형 데이터타입의 초기화가
				//아직 이루어지지 않은 상태를
				//널이라고 한다.
				if(nameArray[classNumber - 1] == null) {
					System.out.println("아직 해당 반은 입력되지 않은 상태입니다.");
				}else {
					for(int i = 0; i < nameArray[classNumber - 1].length; i++) {
						System.out.println(nameArray[classNumber - 1][i]);
					}//위에 학생이름 입력부분을 출력
				}
				
				//기본형 데이터타입과 참조형 데이터 타입의 차이점
				//기본형 : 스택영역에 값이 곧장 들아가있는 데이터타입
				//		 byte short int long float double char boolean 8가지 종류가 있고
				//		  기본적으로 0으로 초기화된다
				
				//참조형 : 스택 영역에는 힙 영역으로 가는 주소값이 적혀져있고
				//	 	  실제 변수의 값 또는 메소드는 힙 영역을 확인해야 어떤 값, 어떤 메소드가 있는지 확인 가능한 데이터타입
				//		  참조형에는 클래스형(=객체형), 배열형, 인터페이스형 3가지가 있고
				//		 new를 통해서 초기화하지 않으면 null로 초기화가 된다
				//	     null인 상태에서는 아무런 메소드, 필드 접근이 불가능하다
				//		 접근을 하려고 하면 NullPointerException이 발생하게 된다!!!
				
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}
				
		}
	
	}
	static int selectClassNumber(BufferedReader reader) throws NumberFormatException, IOException  {
		
		System.out.println("반을 선택해주세요 : ");
		int classNumber = Integer.parseInt(reader.readLine());
		
		while(classNumber < 1 || classNumber > SIZE) {
			System.out.println("잘 못 입력하셨습니다");
			System.out.println("반을 선택해주세요(1부터" + SIZE + "까지");
			System.out.print("> ");
			classNumber = Integer.parseInt(reader.readLine());
		}
		return classNumber;
	}
	
	//학생의 숫자를 입력받는 메소드
	static int insertStudentSize(BufferedReader reader) throws NumberFormatException, IOException {
		System.out.print("학생의 숫자를 입력해주세요: ");
		int studentSize = Integer.parseInt(reader.readLine());
		while(studentSize < 0) {
			System.out.println("잘못입력하셨습니다. 0보다 큰 수를 입력해주세요");
			System.out.println("학생의 숫자를 입력해주세요 : ");
			studentSize = Integer.parseInt(reader.readLine());
		}
		return studentSize;
	}
}
