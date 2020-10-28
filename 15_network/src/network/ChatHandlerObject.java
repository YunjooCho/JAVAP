package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ChatHandlerObject extends Thread {
	private Socket socket;
	private List<ChatHandlerObject> list; //☆object
	
	private ObjectInputStream ois; //☆
	private ObjectOutputStream oos; //☆
	
	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		
		//oos가 먼저 생성되어야 한다(그렇지 않으면 입장메시지가 안 뜬다)
		//클라이언트쪽에서의 입력이 먼저이므로 서버쪽에서는 받는 내용을 먼저 설정해야 한다
		oos = new ObjectOutputStream(socket.getOutputStream()); 
		ois = new ObjectInputStream(socket.getInputStream());
	}
	
	@Override
	public void run() {
		//클라이언트로부터 받는 쪽이므로 new로 생성할 필요 없음
		//(새로 생성하게 되면 클라이언트로부터 발신된 객체내용과는 다른 새로운 객체를 생성하게 되어 정보를 꺼내올 수 없음)
		InfoDTO dto = null;
		String nickName = null;
		while(true) {
			try {
				dto = (InfoDTO)ois.readObject();
				
				if(dto.getCommand() == Info.JOIN) {
					//나를 포함한 모든 클라이언트에게 입장메시지를 보내기
					//한사람이 퇴장시 퇴장하는 사람(dto)과 남아있는 사람(sendDTO)에게 각각 다른 메시지를 보내기 위해, 객체를 새로 생성
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					nickName = dto.getNickName();
					sendDTO.setMessage(nickName + "님 입장하였습니다");
					broadcast(sendDTO);
				}else if(dto.getCommand() == Info.EXIT) {
					InfoDTO sendDTO = new InfoDTO();
					
					//quit를 보낸 클라이언트에게 quit를 메시지(나에게 보내는 것은 broadcast메소드를 사용하지 않아도 됨
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();
					
					ois.close();
					oos.close();
					socket.close();
					//남은 클라이언트에게 보내는 퇴장메시지
					list.remove(this);
					
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName + "님이 퇴장하였습니다");
					broadcast(sendDTO);
					
					break; //종료해버리면 남은 사람들과 상관없이 프로그램이 종료되어버림
					
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
	
	public void broadcast(InfoDTO sendDTO) { //dto객체를 주고받음
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
