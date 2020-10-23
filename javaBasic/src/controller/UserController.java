package controller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
	//3.로그인 메소드
	//▶데이터베이스가 없으므로 어레이리스트 선언
	private ArrayList<UserDTO> list;
	//▶4. 생성자, 객체에 정보 추가(u1, u2, u3객체)하여 어레이리스트에 객체 추가
	public UserController() {
		
		list = new ArrayList<>();
		UserDTO u1 = new UserDTO();
		u1.setId(1);
		u1.setUserId("admin");
		u1.setPassword("111");
		u1.setNickname("운영자");
		
		UserDTO u2 = new UserDTO();
		u2.setId(2);
		u2.setUserId("a");
		u2.setPassword("222");
		u2.setNickname("운영자 a");
		
		UserDTO u3 = new UserDTO();
		u3.setId(3);
		u3.setUserId("b");
		u3.setPassword("333");
		u3.setNickname("사용자 b");
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
	}
	
	
	//▶8. 중복확인 메소드 
	//UserViewer.java의 register()에서 회원가입을 위해
	//사용자로부터 입력받은 id가 기존 객체에 있는지 확인, 있으면 true 없으면 false를 반환
	public boolean isDuplicatedUserId(String id) { //이 파라미터는 UserViewer.java의 register()에서 새로 생성한 객체의 id
		for(UserDTO u : list) {
			if(u.getUserId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
//	//▶5. logIn메소드 - model패키지의 UserDTO클래스 사용 
//	//▶ UserViewer의 logIn()메소드에서 받아온 값(attempt는 객체값을 가져오는 파라미터)
//	//▶ attempt : 사용자가 입력한 값이 들어있는 객체(UserViewer.java참조)
//	
//	public UserDTO logIn(UserDTO attempt) {
//		UserDTO logIn = null; //false면 null값이 그대로 반환
//		for(UserDTO u : list) {
//			//이 for문의 의미는
//			//만약 배열이나 리스트처럼 한가지 데이터타입이 여러개 모여있을 경우
//			//0번 인덱스부터 끝까지를 하나씩 뽑아내서 u라고 부른다.
//			if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())) {
//				logIn = u; 
//				//▶attemp는 사용자가 입력한 값, u는 기존 어레이리스트에 있던 값??
//			}
//		}
//		//list의 모든 요소(id, pw)를 같으면 return 같이 않으면 아무 처리도 하지 않는다.
//		//for(UserDTO u : list)는
//		//for(int i = 0; i < list.size(); i++){
//		// 		UserDTO u = list.get(i); //어레이리스트 사이즈만큼(등록된 사용자 수만큼) 반복해서 비교
//		//랑 같은 형태
//		
//		return logIn; //UserDTO의 logIn객체: null값이 반환되거나 입력된 attempt와 값이 같은 기존의 u객체의 값이 반환
//		//▶반환값은 다시 UserViewer의 logIn()메소드로 호출됨
//	}
	public UserDTO logIn(UserDTO attempt) {
		UserDTO logIn = null; //false면 null값이 그대로 반환
		for(UserDTO u : list) {
			if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())) {
				logIn = u; 
			}
		}				
		return logIn;
	}
	
	
	
	//▶9-2.새로 등록된 객체를 어레이리스트에 추가 - CarT나 Student에서 해왔던 add()랑 같은 의미
	//UserViewer.java의 register()에서 등록한 객체
	public void insert(UserDTO u) {
		list.add(u); //list는 private임에도 겟터셋터가 없음
					 //list.add(u);를 UserViewer에서 추가할 수 없으므로 메소드로 실행
					 //기존 객체 u와 다름(UserViewer.java의 register()의 주석참조)
	}
}


//1. UserController에 있는 logIn()메소드  
//   UserDTO logIn = null;과 UserDTO logIn = new UserDTO();이랑 
//   같은 의미로 null로 쓰신거 맞나요??
//    ->같은 의미가 아닙니다. 만약 로그인을 시도할때 id,pw가 틀리면 
//      null을 리턴해서 호출했던 메소드가 알수 있게 하기 위해서 이렇게 
//      한겁니다.


//2. 동일 메소드 파라미터 UserDTO attempt가
//   메소드 안에서 UserDTO u랑 같은 걸로 이해했는데 맞나요?
//   ->attempt와 u는 다른 존재입니다.
//     ▶attemp는 사용자가 입력한 값, u는 기존 어레이리스트에 있던 객체



//3. 동일 메소드에서 반환된 logIn객체는 
//   다시 Viewer로 호출되는건가요?
//   UserController의 logIn()메소드에서 반환된 값이 어디서 어떻게 쓰이는지 잘 이해가 안갑니다..
//   ->만약 attempt(입력받은 id,pw)와 같은 id와 pw를 가진 u가 있으면 로그인을 u로 초기화해서 호출된 곳으로 보내줍니다. //현재 어디서 호출됐는지? ->UserViewer메소드의 return부분에서 호출 
//     그러면 호출한 메소드가 저 메소드의 결과로 리턴된 UserDTO 객체가 널인지 아닌지를 체크해서 로그인이                         //null:해당 id,pw가 존재하지 않음 - 로그인 실패, u로 초기화된 값 반환 - 로그인 성공
//     성공했는지 실패했는지를 보여줄 수 있게 됩니다.                                                    
