package viewer;
//화면에 출력되는 print가 있는 것들이 모여있음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.UserController;
import model.UserDTO;
import util.InputUtil;

public class UserViewer {
	
	//▶6.필드명 설정 / 생성자 작성
	private UserController userController; 
	//UserController의 메소드(insert(),isDuplicatedUserId(),logIn())를 사용하기 위해 입력, 버퍼리더와 같음
	private BufferedReader bufferedReader;
	private BoardViewer boardViewer;
	private int id;//회원가입메소드가 실행될 때마다 1씩 증가(회원가입자 수가 늘때마다)
	private UserDTO logInUser; //데이터베이스나 서버가 있다면 거기에 저장
	
	
	public UserViewer() {//이전에는 main메소드에서 사용
		userController = new UserController();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boardViewer = new BoardViewer();
		id = 4;//UserController에서 객체 3개 입력 후라 4부터 시작
	}
	
	
	//▶11-1. 홈페이지 전제
	//11-2는 메인메소드
	public void index() throws IOException {
		while(true) {
			System.out.println("비트게시판");
			System.out.println("1.로그인  2.회원가입  3.종료");
			int choice = InputUtil.validateInt(1,3);
			if(choice == 1) {
				logInUser = logIn();
				//반환된 값은 UserViewer.logIn()->UserController.logIn()->UserViewer.logIn()을 통해 
				//n또는 null값이 반환
				while(logInUser == null) {
					System.out.println("잘못된 ID 혹은 PW입니다.");
					logInUser = logIn();
				}
				System.out.println("로그인 성공.");
				System.out.println(logInUser.getNickname() + "님, 환영합니다!");
				//여기서 getNickname을 쓸 수 있는건 logInUser = logIn();이부분에서 
				//반환된 객체정보를 끌어오기때문
				boardViewer.setLogInUser(logInUser);
				showMenu(); //상기 메소드로 로그인 성공하고 나면 메뉴가 뜸
			}else if(choice == 2) {
				register();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다");
				break;
			}
		}
	}
	
	
	//▶10. 메뉴 메소드
	private void showMenu() throws IOException {//글과 관련된 뷰어
		while(true) {
			System.out.println("1.글쓰기 2.목록보기 3.로그아웃");
			int userChoice = InputUtil.validateInt(1,3);
			if(userChoice == 1) {
				//글쓰기 메소드 호출
				boardViewer.writeBoard();
			}else if(userChoice == 2) {
				//글 목록보기 메소드 호출
				boardViewer.selectAll();
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				logInUser = null;//로그인 -> 로그아웃
				break;
			}
		}
	}
	
	//▶9-1.회원가입 메소드 - CarT나 Student에서 해왔던 setInfo()랑 같은 의미
	private void register() throws IOException { 
		//입력된 값과 객체에 있던 값들(id,userId)을 비교했을 때 true면 반복문이 실행
		//false면 어레이리스트에 추가됨
		UserDTO u = new UserDTO();// 여태까지 생성했던 객체들과는 또 다른 메모리에 생성된 객체
		u.setId(id);
		id++; //새로운 등록이 생겼으므로 id는 식별을 위해 사용자 입력이 없어도 자동으로 증가
		System.out.print("회원 id: ");
		u.setUserId(bufferedReader.readLine());
		while(userController.isDuplicatedUserId(u.getUserId())) {
			//여기서 u는 기존 객체가 아닌 여기서 새로 생성한 객체로 사용자가 입력한 userId가 담겨있음
			//헷갈리면 81번줄 변수명 u가 아닌 newPerson등으로 바꿔보기
			System.out.println("중복된 id입니다.");
			System.out.print("회원id : ");
			u.setUserId(bufferedReader.readLine());
		}
		System.out.print("회원 pw: ");
		u.setPassword(bufferedReader.readLine());
		System.out.print("회원 닉네임: ");
		u.setNickname(bufferedReader.readLine());
		userController.insert(u); //UserController의 list는 private임에도 겟터셋터가 없음
		 						  //list.add(u);를 UserViewer에서 추가할 수 없으므로  
								  //UserController(접근제어자 private는 같은 클래스에서는 실행가능)에서 insert메소드로 실행
	}
	
	
	//▶7.사용자한테 id,pw를 입력받아 로그인 하는 메소드
	private UserDTO logIn() throws IOException { //UserController의 logIn(UserDTO attempt)로 값을 넘겨줌
		UserDTO attempt = new UserDTO();
		System.out.println("id: ");
		attempt.setUserId(bufferedReader.readLine());
		System.out.println("PW: ");
		attempt.setPassword(bufferedReader.readLine());
		return userController.logIn(attempt); //▶여기가!!!바로!!!userController.logInt()메소드 호출장소!!!
		//▶2개 입력한 것을 하나만 출력하는 것 처럼 보이지만, attempt객체 안에 두 값을 저장한 후, attemp객체를 반환하는 것임
	}
	
	

//util패키지에 InputUtil따로 작성하여 필요 없어짐
//	public int validateInt(int minimum, int maximum) throws IOException {
//		int parsedValue = stringToInt();
//		while(parsedValue < minimum || parsedValue > maximum) {
//			System.out.println("잘못입력하셨습니다.");
//			parsedValue = stringToInt();
//		}
//		return parsedValue;
//	}//validateInt
//		
//	
//	
//	public int stringToInt() throws IOException{
//		System.out.print("> ");
//		String userInput = bufferedReader.readLine();
//		while(!userInput.matches("\\d*")) {
//			System.out.println("숫자만 입력해주세요");
//			System.out.print("> ");
//			userInput = bufferedReader.readLine();
//		}
//		return Integer.parseInt(userInput);
//	}//stringToInt 입력된 글자가 숫자면 정수화, 글자면 반복문 실행
//		
}	

