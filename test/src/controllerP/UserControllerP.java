package controllerP;

import java.util.ArrayList;

import modelP.UserDTOP;

public class UserControllerP {
	//3.로그인 메소드
	//데이터베이스가 없으므로 어레이리스트 선언
	private ArrayList<UserDTOP> list;
	
	//4.생성자
	public UserControllerP() {
		
		list = new ArrayList<>();
		UserDTOP u1 = new UserDTOP();
		u1.setId(1);
		u1.setUserId("admin");
		u1.setPassword("111");
		u1.setNickname("운영자");
		
		UserDTOP u2 = new UserDTOP();
		u1.setId(2);
		u1.setUserId("a");
		u1.setPassword("222");
		u1.setNickname("회원A");
		
		UserDTOP u3 = new UserDTOP();
		u1.setId(3);
		u1.setUserId("b");
		u1.setPassword("333");
		u1.setNickname("회원B");
		
		list.add(u1);
		list.add(u2);
		list.add(u3);//어레이리스트에 객체 추가
		
	}
	
	//5.로그인 메소드
	public UserDTOP logIn(UserDTOP attempt) {
		UserDTOP logIn = null;
		for(UserDTOP u : list) {
			if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())){
				logIn = u;
			}
		}
		return logIn;
	}
	
	
	//8. 중복확인 메소드
	public boolean isDuplicatedUserID(String id) {
		for(UserDTOP u : list) {
			if(u.getUserId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	//9-2.새로 등록된 객체를 어레이리스트에 추가
	public void insert(UserDTOP newPerson) {
		list.add(newPerson);
	}

}
