package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerObject {
	private ServerSocket ss;
	private List<ChatHandlerObject> list;
	
	public ChatServerObject() {
		try {
			ss = new ServerSocket(9500);
			System.out.println("서버가 준비완료 되었습니다");
			
			list = new ArrayList<ChatHandlerObject>();
			
			while(true) {
				Socket socket = ss.accept();
				ChatHandlerObject handler = new ChatHandlerObject(socket, list);
				handler.start();
				
				list.add(handler);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		new ChatServerObject();
	}
}
