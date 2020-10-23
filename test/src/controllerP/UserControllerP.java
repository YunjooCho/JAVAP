package controllerP;

import java.util.ArrayList;

import modelP.UserDTOP;

public class UserControllerP {
	//3.�α��� �޼ҵ�
	//�����ͺ��̽��� �����Ƿ� ��̸���Ʈ ����
	private ArrayList<UserDTOP> list;
	
	//4.������
	public UserControllerP() {
		
		list = new ArrayList<>();
		UserDTOP u1 = new UserDTOP();
		u1.setId(1);
		u1.setUserId("admin");
		u1.setPassword("111");
		u1.setNickname("���");
		
		UserDTOP u2 = new UserDTOP();
		u1.setId(2);
		u1.setUserId("a");
		u1.setPassword("222");
		u1.setNickname("ȸ��A");
		
		UserDTOP u3 = new UserDTOP();
		u1.setId(3);
		u1.setUserId("b");
		u1.setPassword("333");
		u1.setNickname("ȸ��B");
		
		list.add(u1);
		list.add(u2);
		list.add(u3);//��̸���Ʈ�� ��ü �߰�
		
	}
	
	//5.�α��� �޼ҵ�
	public UserDTOP logIn(UserDTOP attempt) {
		UserDTOP logIn = null;
		for(UserDTOP u : list) {
			if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())){
				logIn = u;
			}
		}
		return logIn;
	}
	
	
	//8. �ߺ�Ȯ�� �޼ҵ�
	public boolean isDuplicatedUserID(String id) {
		for(UserDTOP u : list) {
			if(u.getUserId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	//9-2.���� ��ϵ� ��ü�� ��̸���Ʈ�� �߰�
	public void insert(UserDTOP newPerson) {
		list.add(newPerson);
	}

}
