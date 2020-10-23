package viewer;
//ȭ�鿡 ��µǴ� print�� �ִ� �͵��� ������
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.UserController;
import model.UserDTO;
import util.InputUtil;

public class UserViewer {
	
	//��6.�ʵ�� ���� / ������ �ۼ�
	private UserController userController; 
	//UserController�� �޼ҵ�(insert(),isDuplicatedUserId(),logIn())�� ����ϱ� ���� �Է�, ���۸����� ����
	private BufferedReader bufferedReader;
	private BoardViewer boardViewer;
	private int id;//ȸ�����Ը޼ҵ尡 ����� ������ 1�� ����(ȸ�������� ���� �ö�����)
	private UserDTO logInUser; //�����ͺ��̽��� ������ �ִٸ� �ű⿡ ����
	
	
	public UserViewer() {//�������� main�޼ҵ忡�� ���
		userController = new UserController();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boardViewer = new BoardViewer();
		id = 4;//UserController���� ��ü 3�� �Է� �Ķ� 4���� ����
	}
	
	
	//��11-1. Ȩ������ ����
	//11-2�� ���θ޼ҵ�
	public void index() throws IOException {
		while(true) {
			System.out.println("��Ʈ�Խ���");
			System.out.println("1.�α���  2.ȸ������  3.����");
			int choice = InputUtil.validateInt(1,3);
			if(choice == 1) {
				logInUser = logIn();
				//��ȯ�� ���� UserViewer.logIn()->UserController.logIn()->UserViewer.logIn()�� ���� 
				//n�Ǵ� null���� ��ȯ
				while(logInUser == null) {
					System.out.println("�߸��� ID Ȥ�� PW�Դϴ�.");
					logInUser = logIn();
				}
				System.out.println("�α��� ����.");
				System.out.println(logInUser.getNickname() + "��, ȯ���մϴ�!");
				//���⼭ getNickname�� �� �� �ִ°� logInUser = logIn();�̺κп��� 
				//��ȯ�� ��ü������ ������⶧��
				boardViewer.setLogInUser(logInUser);
				showMenu(); //��� �޼ҵ�� �α��� �����ϰ� ���� �޴��� ��
			}else if(choice == 2) {
				register();
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�");
				break;
			}
		}
	}
	
	
	//��10. �޴� �޼ҵ�
	private void showMenu() throws IOException {//�۰� ���õ� ���
		while(true) {
			System.out.println("1.�۾��� 2.��Ϻ��� 3.�α׾ƿ�");
			int userChoice = InputUtil.validateInt(1,3);
			if(userChoice == 1) {
				//�۾��� �޼ҵ� ȣ��
				boardViewer.writeBoard();
			}else if(userChoice == 2) {
				//�� ��Ϻ��� �޼ҵ� ȣ��
				boardViewer.selectAll();
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				logInUser = null;//�α��� -> �α׾ƿ�
				break;
			}
		}
	}
	
	//��9-1.ȸ������ �޼ҵ� - CarT�� Student���� �ؿԴ� setInfo()�� ���� �ǹ�
	private void register() throws IOException { 
		//�Էµ� ���� ��ü�� �ִ� ����(id,userId)�� ������ �� true�� �ݺ����� ����
		//false�� ��̸���Ʈ�� �߰���
		UserDTO u = new UserDTO();// ���±��� �����ߴ� ��ü����� �� �ٸ� �޸𸮿� ������ ��ü
		u.setId(id);
		id++; //���ο� ����� �������Ƿ� id�� �ĺ��� ���� ����� �Է��� ��� �ڵ����� ����
		System.out.print("ȸ�� id: ");
		u.setUserId(bufferedReader.readLine());
		while(userController.isDuplicatedUserId(u.getUserId())) {
			//���⼭ u�� ���� ��ü�� �ƴ� ���⼭ ���� ������ ��ü�� ����ڰ� �Է��� userId�� �������
			//�򰥸��� 81���� ������ u�� �ƴ� newPerson������ �ٲ㺸��
			System.out.println("�ߺ��� id�Դϴ�.");
			System.out.print("ȸ��id : ");
			u.setUserId(bufferedReader.readLine());
		}
		System.out.print("ȸ�� pw: ");
		u.setPassword(bufferedReader.readLine());
		System.out.print("ȸ�� �г���: ");
		u.setNickname(bufferedReader.readLine());
		userController.insert(u); //UserController�� list�� private�ӿ��� ���ͼ��Ͱ� ����
		 						  //list.add(u);�� UserViewer���� �߰��� �� �����Ƿ�  
								  //UserController(���������� private�� ���� Ŭ���������� ���డ��)���� insert�޼ҵ�� ����
	}
	
	
	//��7.��������� id,pw�� �Է¹޾� �α��� �ϴ� �޼ҵ�
	private UserDTO logIn() throws IOException { //UserController�� logIn(UserDTO attempt)�� ���� �Ѱ���
		UserDTO attempt = new UserDTO();
		System.out.println("id: ");
		attempt.setUserId(bufferedReader.readLine());
		System.out.println("PW: ");
		attempt.setPassword(bufferedReader.readLine());
		return userController.logIn(attempt); //�����Ⱑ!!!�ٷ�!!!userController.logInt()�޼ҵ� ȣ�����!!!
		//��2�� �Է��� ���� �ϳ��� ����ϴ� �� ó�� ��������, attempt��ü �ȿ� �� ���� ������ ��, attemp��ü�� ��ȯ�ϴ� ����
	}
	
	

//util��Ű���� InputUtil���� �ۼ��Ͽ� �ʿ� ������
//	public int validateInt(int minimum, int maximum) throws IOException {
//		int parsedValue = stringToInt();
//		while(parsedValue < minimum || parsedValue > maximum) {
//			System.out.println("�߸��Է��ϼ̽��ϴ�.");
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
//			System.out.println("���ڸ� �Է����ּ���");
//			System.out.print("> ");
//			userInput = bufferedReader.readLine();
//		}
//		return Integer.parseInt(userInput);
//	}//stringToInt �Էµ� ���ڰ� ���ڸ� ����ȭ, ���ڸ� �ݺ��� ����
//		
}	

