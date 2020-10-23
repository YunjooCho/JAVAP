package viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Util.InputUtil;
import controllerP.UserControllerP;
import modelP.UserDTOP;

public class UserViewerP {
	
	//6.필드명 설정
	private UserControllerP userController;//UserController에 있는 메소드 사용
	private BufferedReader bufferedReader;
	private UserDTOP logInUser;//???????데이터베이스&서버가 없으므로 대신하여 생성
	private int id; //왜 이것만 또 필드선언???
	      			//UserDTOP에서 생성한 다른 필드들은 키보드로 입력받거나 
					//Calendar클래스를 사용을 위해 
				    //이건 따로 없어서??
	
	
	public UserViewerP() {//생성자
		userController = new UserControllerP();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		id = 4;//UserControllerP에서 객체 3개 입력 후라 4부터 시작
		
	}
	
	//7.사용자한테 id,pw를 입력받아 로그인하는 메소드
	private UserDTOP logIn() throws IOException {
		UserDTOP attempt = new UserDTOP();
		System.out.println("id: ");
		attempt.setUserId(bufferedReader.readLine());
		System.out.println("pw: ");
		attempt.setPassword(bufferedReader.readLine());
		
		return userController.logIn(attempt); 
		//사용자에게 입력받은 값을 UserControlle.java의 logIn()에 넘겨주고
		//UserControlle.java의 logIn()에서 반환된 값을 다시 여기로 가져옴
		//최종 결과값은 일치하는 정보가 없다면 null, 일치하는 정보가 있다면 해당객체 u가 반환되어있는 상태
		
	}
	
	
	//9-1.회원가입 메소드
	private void register() throws IOException {
		UserDTOP newPerson = new UserDTOP(); // 여태까지 생성했던 객체들과는 또 다른 메모리에 생성된 객체
		newPerson.setId(id);
		id++;
		System.out.print("회원 id: ");
		newPerson.setUserId(bufferedReader.readLine());
		while(userController.isDuplicatedUserID(newPerson.getUserId())){
			System.out.println("중복된 id입니다.");
			System.out.print("회원 id: ");
			newPerson.setUserId(bufferedReader.readLine());
		}
		System.out.print("회원 pw: ");
		newPerson.setPassword(bufferedReader.readLine());
		System.out.print("회원 닉네임: ");
		newPerson.setNickname(bufferedReader.readLine());
		userController.insert(newPerson);	
	}
	
	
	//10.메뉴 메소드
	private void showMenu() throws IOException {
		while(true) {
			System.out.println("1.글쓰기   2.목록보기   3.로그아웃");
			int userChoice = InputUtil.validateInt(1,3);
			if(userChoice == 1) {
				//글쓰기 메소드 호출
			}else if(userChoice == 2) {
				//목록보기 메소드 호출
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				logInUser = null;//로그인 -> 로그아웃
				break;
			}
		}
	}
	
	
	//11-1.홈페이지 전체
	public void index() throws IOException {
		while(true) {
			System.out.println("비트게시판");
			System.out.println("1.로그인   2.회원가입   3.종료");
			int choice = InputUtil.validateInt(1,3);
			if(choice == 1) {
				logInUser = logIn();
				while(logInUser == null) {
					System.out.println("잘못된 ID 혹은 PW입니다.");
					logInUser = logIn();
				}
				System.out.println("로그인 성공!");
				System.out.println(logInUser.getNickname() + "님, 환영합니다!");
				//boardViewer.setLogInUser(logInUser);
				showMenu();
			}else if(choice == 2) {
				register();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
	}
}
