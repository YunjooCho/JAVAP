package viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Util.InputUtil;
import controllerP.UserControllerP;
import modelP.UserDTOP;

public class UserViewerP {
	
	//6.�ʵ�� ����
	private UserControllerP userController;//UserController�� �ִ� �޼ҵ� ���
	private BufferedReader bufferedReader;
	private UserDTOP logInUser;//???????�����ͺ��̽�&������ �����Ƿ� ����Ͽ� ����
	private int id; //�� �̰͸� �� �ʵ弱��???
	      			//UserDTOP���� ������ �ٸ� �ʵ���� Ű����� �Է¹ްų� 
					//CalendarŬ������ ����� ���� 
				    //�̰� ���� ���??
	
	
	public UserViewerP() {//������
		userController = new UserControllerP();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		id = 4;//UserControllerP���� ��ü 3�� �Է� �Ķ� 4���� ����
		
	}
	
	//7.��������� id,pw�� �Է¹޾� �α����ϴ� �޼ҵ�
	private UserDTOP logIn() throws IOException {
		UserDTOP attempt = new UserDTOP();
		System.out.println("id: ");
		attempt.setUserId(bufferedReader.readLine());
		System.out.println("pw: ");
		attempt.setPassword(bufferedReader.readLine());
		
		return userController.logIn(attempt); 
		//����ڿ��� �Է¹��� ���� UserControlle.java�� logIn()�� �Ѱ��ְ�
		//UserControlle.java�� logIn()���� ��ȯ�� ���� �ٽ� ����� ������
		//���� ������� ��ġ�ϴ� ������ ���ٸ� null, ��ġ�ϴ� ������ �ִٸ� �ش簴ü u�� ��ȯ�Ǿ��ִ� ����
		
	}
	
	
	//9-1.ȸ������ �޼ҵ�
	private void register() throws IOException {
		UserDTOP newPerson = new UserDTOP(); // ���±��� �����ߴ� ��ü����� �� �ٸ� �޸𸮿� ������ ��ü
		newPerson.setId(id);
		id++;
		System.out.print("ȸ�� id: ");
		newPerson.setUserId(bufferedReader.readLine());
		while(userController.isDuplicatedUserID(newPerson.getUserId())){
			System.out.println("�ߺ��� id�Դϴ�.");
			System.out.print("ȸ�� id: ");
			newPerson.setUserId(bufferedReader.readLine());
		}
		System.out.print("ȸ�� pw: ");
		newPerson.setPassword(bufferedReader.readLine());
		System.out.print("ȸ�� �г���: ");
		newPerson.setNickname(bufferedReader.readLine());
		userController.insert(newPerson);	
	}
	
	
	//10.�޴� �޼ҵ�
	private void showMenu() throws IOException {
		while(true) {
			System.out.println("1.�۾���   2.��Ϻ���   3.�α׾ƿ�");
			int userChoice = InputUtil.validateInt(1,3);
			if(userChoice == 1) {
				//�۾��� �޼ҵ� ȣ��
			}else if(userChoice == 2) {
				//��Ϻ��� �޼ҵ� ȣ��
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				logInUser = null;//�α��� -> �α׾ƿ�
				break;
			}
		}
	}
	
	
	//11-1.Ȩ������ ��ü
	public void index() throws IOException {
		while(true) {
			System.out.println("��Ʈ�Խ���");
			System.out.println("1.�α���   2.ȸ������   3.����");
			int choice = InputUtil.validateInt(1,3);
			if(choice == 1) {
				logInUser = logIn();
				while(logInUser == null) {
					System.out.println("�߸��� ID Ȥ�� PW�Դϴ�.");
					logInUser = logIn();
				}
				System.out.println("�α��� ����!");
				System.out.println(logInUser.getNickname() + "��, ȯ���մϴ�!");
				//boardViewer.setLogInUser(logInUser);
				showMenu();
			}else if(choice == 2) {
				register();
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			}
		}
	}
}
