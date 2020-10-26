package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

//����ä�� �� Sever�� ������ ������ ioó��(�����)�ϴ� �� Handler
public class ChatHandler extends Thread {
	
	private Socket  socket;
	private List<ChatHandler> list;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatHandler(Socket socket, List<ChatHandler> list) throws IOException {
			this.socket = socket;
			this.list = list;
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
	}
	
	 @Override
	public void run() {
		 String line;
		//�г��� �޴� ��
		 try {
			String nickName = br.readLine();
			//��� Ŭ���̾�Ʈ���� �г��������� ����(����) - broadcast()���
			broadcast(nickName + "���� �����Ͽ����ϴ�");
			
			while(true) {
				line = br.readLine();
				if(line == null || line.toLowerCase().equals("quiet")) { //���� �ڵ尡 ������ ������ �� ������
																		 //������ �빮�ڷ� quiet�� ��� ���� ���� �����Ƿ� 
																		 //�Էµ� ���� ��� �ҹ��ڷ� ����
																		 //line == null ������� main�� ����Ǿ ��� �����ִ� ��찡 ����
					break; //while���� ����
				}
				
				//�޽����� ��� Ŭ���̾�Ʈ���� ������
				broadcast("[" + nickName + "]" + line);
				
			}//while
			
			//quit�� ���� Ŭ���̾�Ʈ���� quit�� �޽���
			pw.println("quit");
			pw.flush();
			
			//���� Ŭ���̾�Ʈ���� ������ ����޽���
			list.remove(this); //���� �ڵ鷯 ��ü���� ����
			broadcast(nickName + "���� �����Ͽ����ϴ�");
			
			br.close(); //51���� ���Ŀ� �ش� �ڵ��� �ԷµǾ��־ ó������
			pw.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//run()
	 
	
	public void broadcast(String msg) {
		for(ChatHandler handler : list) {
			handler.pw.println(msg);
			handler.pw.flush();
		}//for
	}//broadcast()
}
