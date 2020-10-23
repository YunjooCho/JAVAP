package controller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
	//3.�α��� �޼ҵ�
	//�������ͺ��̽��� �����Ƿ� ��̸���Ʈ ����
	private ArrayList<UserDTO> list;
	//��4. ������, ��ü�� ���� �߰�(u1, u2, u3��ü)�Ͽ� ��̸���Ʈ�� ��ü �߰�
	public UserController() {
		
		list = new ArrayList<>();
		UserDTO u1 = new UserDTO();
		u1.setId(1);
		u1.setUserId("admin");
		u1.setPassword("111");
		u1.setNickname("���");
		
		UserDTO u2 = new UserDTO();
		u2.setId(2);
		u2.setUserId("a");
		u2.setPassword("222");
		u2.setNickname("��� a");
		
		UserDTO u3 = new UserDTO();
		u3.setId(3);
		u3.setUserId("b");
		u3.setPassword("333");
		u3.setNickname("����� b");
		
		list.add(u1);
		list.add(u2);
		list.add(u3);
	}
	
	
	//��8. �ߺ�Ȯ�� �޼ҵ� 
	//UserViewer.java�� register()���� ȸ�������� ����
	//����ڷκ��� �Է¹��� id�� ���� ��ü�� �ִ��� Ȯ��, ������ true ������ false�� ��ȯ
	public boolean isDuplicatedUserId(String id) { //�� �Ķ���ʹ� UserViewer.java�� register()���� ���� ������ ��ü�� id
		for(UserDTO u : list) {
			if(u.getUserId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
//	//��5. logIn�޼ҵ� - model��Ű���� UserDTOŬ���� ��� 
//	//�� UserViewer�� logIn()�޼ҵ忡�� �޾ƿ� ��(attempt�� ��ü���� �������� �Ķ����)
//	//�� attempt : ����ڰ� �Է��� ���� ����ִ� ��ü(UserViewer.java����)
//	
//	public UserDTO logIn(UserDTO attempt) {
//		UserDTO logIn = null; //false�� null���� �״�� ��ȯ
//		for(UserDTO u : list) {
//			//�� for���� �ǹ̴�
//			//���� �迭�̳� ����Ʈó�� �Ѱ��� ������Ÿ���� ������ ������ ���
//			//0�� �ε������� �������� �ϳ��� �̾Ƴ��� u��� �θ���.
//			if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())) {
//				logIn = u; 
//				//��attemp�� ����ڰ� �Է��� ��, u�� ���� ��̸���Ʈ�� �ִ� ��??
//			}
//		}
//		//list�� ��� ���(id, pw)�� ������ return ���� ������ �ƹ� ó���� ���� �ʴ´�.
//		//for(UserDTO u : list)��
//		//for(int i = 0; i < list.size(); i++){
//		// 		UserDTO u = list.get(i); //��̸���Ʈ �����ŭ(��ϵ� ����� ����ŭ) �ݺ��ؼ� ��
//		//�� ���� ����
//		
//		return logIn; //UserDTO�� logIn��ü: null���� ��ȯ�ǰų� �Էµ� attempt�� ���� ���� ������ u��ü�� ���� ��ȯ
//		//����ȯ���� �ٽ� UserViewer�� logIn()�޼ҵ�� ȣ���
//	}
	public UserDTO logIn(UserDTO attempt) {
		UserDTO logIn = null; //false�� null���� �״�� ��ȯ
		for(UserDTO u : list) {
			if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())) {
				logIn = u; 
			}
		}				
		return logIn;
	}
	
	
	
	//��9-2.���� ��ϵ� ��ü�� ��̸���Ʈ�� �߰� - CarT�� Student���� �ؿԴ� add()�� ���� �ǹ�
	//UserViewer.java�� register()���� ����� ��ü
	public void insert(UserDTO u) {
		list.add(u); //list�� private�ӿ��� ���ͼ��Ͱ� ����
					 //list.add(u);�� UserViewer���� �߰��� �� �����Ƿ� �޼ҵ�� ����
					 //���� ��ü u�� �ٸ�(UserViewer.java�� register()�� �ּ�����)
	}
}


//1. UserController�� �ִ� logIn()�޼ҵ�  
//   UserDTO logIn = null;�� UserDTO logIn = new UserDTO();�̶� 
//   ���� �ǹ̷� null�� ���Ű� �³���??
//    ->���� �ǹ̰� �ƴմϴ�. ���� �α����� �õ��Ҷ� id,pw�� Ʋ���� 
//      null�� �����ؼ� ȣ���ߴ� �޼ҵ尡 �˼� �ְ� �ϱ� ���ؼ� �̷��� 
//      �Ѱ̴ϴ�.


//2. ���� �޼ҵ� �Ķ���� UserDTO attempt��
//   �޼ҵ� �ȿ��� UserDTO u�� ���� �ɷ� �����ߴµ� �³���?
//   ->attempt�� u�� �ٸ� �����Դϴ�.
//     ��attemp�� ����ڰ� �Է��� ��, u�� ���� ��̸���Ʈ�� �ִ� ��ü



//3. ���� �޼ҵ忡�� ��ȯ�� logIn��ü�� 
//   �ٽ� Viewer�� ȣ��Ǵ°ǰ���?
//   UserController�� logIn()�޼ҵ忡�� ��ȯ�� ���� ��� ��� ���̴��� �� ���ذ� �Ȱ��ϴ�..
//   ->���� attempt(�Է¹��� id,pw)�� ���� id�� pw�� ���� u�� ������ �α����� u�� �ʱ�ȭ�ؼ� ȣ��� ������ �����ݴϴ�. //���� ��� ȣ��ƴ���? ->UserViewer�޼ҵ��� return�κп��� ȣ�� 
//     �׷��� ȣ���� �޼ҵ尡 �� �޼ҵ��� ����� ���ϵ� UserDTO ��ü�� ������ �ƴ����� üũ�ؼ� �α�����                         //null:�ش� id,pw�� �������� ���� - �α��� ����, u�� �ʱ�ȭ�� �� ��ȯ - �α��� ����
//     �����ߴ��� �����ߴ����� ������ �� �ְ� �˴ϴ�.                                                    
