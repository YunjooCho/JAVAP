package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//ä��â ������ ���ΰɷ� �����
//Seversocket�� ����� ������ �غ� ��
public class ChatServer {
	private ServerSocket ss; 
	private List<ChatHandler> list; //ChantHandler��ü�� ��� list
	
	public ChatServer() {
		try {
			ss = new ServerSocket(9500);
		} catch (IOException e) {
			e.printStackTrace();
		}//��Ʈ��
		System.out.println("������ �غ� �Ϸ�Ǿ����ϴ�"); //Ŭ���̾�Ʈ�� ���϶����� ������ ��ٸ�
		
		list = new ArrayList<ChatHandler>();
		
		while(true) { //Ŭ���̾�Ʈ�� ����æ��, ServerSocket�� ���Ͼȿ� �־��ش�
				      //�������� Ŭ���̾�Ʈ�� ����ä�� ���� while��(���ѷ���)�� ����
					  //Ŭ���̾�Ʈ ������ ������� ���� �����Ƿ� �������� ����(ServerSocket �ƴ�)�� ���� ������� �������� ��
					  //����, ServersSocket�� �Ѱ���
			try {
				Socket socket = ss.accept();
				ChatHandler handler = new ChatHandler(socket, list); //���Ͽ� ��� �޽����� Ŭ���̾�Ʈ�� �� ���̳� �����ߴ��� ������ ����Ʈ�� ����
																     //����, br, pw�� �������
																	 //ChatHandler���� �Ű����� ������ �ִ� �����ڸ� �ۼ�
																	 //������ ����
				handler.start();//������ ���� - ������ ����(run())
				list.add(handler); //list�� �ڵ鷯��ü�� �߰�
			} catch (IOException e) {
				e.printStackTrace();
			} 
										 
		}
	}
	
	
	public static void main(String[] args) {
		new ChatServer();
	}

}

