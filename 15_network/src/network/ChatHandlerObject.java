package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ChatHandlerObject extends Thread {
	private Socket socket;
	private List<ChatHandlerObject> list; //��object
	
	private ObjectInputStream ois; //��
	private ObjectOutputStream oos; //��
	
	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		
		//oos�� ���� �����Ǿ�� �Ѵ�(�׷��� ������ ����޽����� �� ���)
		//Ŭ���̾�Ʈ�ʿ����� �Է��� �����̹Ƿ� �����ʿ����� �޴� ������ ���� �����ؾ� �Ѵ�
		oos = new ObjectOutputStream(socket.getOutputStream()); 
		ois = new ObjectInputStream(socket.getInputStream());
	}
	
	@Override
	public void run() {
		//Ŭ���̾�Ʈ�κ��� �޴� ���̹Ƿ� new�� ������ �ʿ� ����
		//(���� �����ϰ� �Ǹ� Ŭ���̾�Ʈ�κ��� �߽ŵ� ��ü������� �ٸ� ���ο� ��ü�� �����ϰ� �Ǿ� ������ ������ �� ����)
		InfoDTO dto = null;
		String nickName = null;
		while(true) {
			try {
				dto = (InfoDTO)ois.readObject();
				
				if(dto.getCommand() == Info.JOIN) {
					//���� ������ ��� Ŭ���̾�Ʈ���� ����޽����� ������
					//�ѻ���� ����� �����ϴ� ���(dto)�� �����ִ� ���(sendDTO)���� ���� �ٸ� �޽����� ������ ����, ��ü�� ���� ����
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					nickName = dto.getNickName();
					sendDTO.setMessage(nickName + "�� �����Ͽ����ϴ�");
					broadcast(sendDTO);
				}else if(dto.getCommand() == Info.EXIT) {
					InfoDTO sendDTO = new InfoDTO();
					
					//quit�� ���� Ŭ���̾�Ʈ���� quit�� �޽���(������ ������ ���� broadcast�޼ҵ带 ������� �ʾƵ� ��
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();
					
					ois.close();
					oos.close();
					socket.close();
					//���� Ŭ���̾�Ʈ���� ������ ����޽���
					list.remove(this);
					
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName + "���� �����Ͽ����ϴ�");
					broadcast(sendDTO);
					
					break; //�����ع����� ���� ������ ������� ���α׷��� ����Ǿ����
					
				}else if(dto.getCommand() == Info.SEND) {
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("[" + nickName + "]" + dto.getMessage());
					broadcast(sendDTO);
				}
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void broadcast(InfoDTO sendDTO) { //dto��ü�� �ְ����
		for(ChatHandlerObject handler : list) {
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//for
	}//broadcast()
}
