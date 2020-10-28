package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

//낚아채는 건 Sever가 하지만 실제로 io처리(입출력)하는 건 Handler
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
		//닉네임 받는 쪽
		 try {
			String nickName = br.readLine();
			//모든 클라이언트에게 닉네임정보를 보냄(입장) - broadcast()사용
			broadcast(nickName + "님이 입장하였습니다");
			
			while(true) {
				line = br.readLine();
				if(line == null || line.toLowerCase().equals("quiet")) { //퇴장 코드가 들어오면 연결을 다 끊어줌
																		 //누군가 대문자로 quiet를 사용 했을 수도 있으므로 
																		 //입력된 값을 모두 소문자로 받음
																		 //line == null 스레드는 main이 종료되어도 계속 남아있는 경우가 있음
					break; //while문을 나옴
				}
				
				//메시지를 모든 클라이언트에게 보내기
				broadcast("[" + nickName + "]" + line);
				
			}//while
			
			//quit를 보낸 클라이언트에게 quit를 메시지
			pw.println("quit");
			pw.flush();
			
			//남은 클라이언트에게 보내는 퇴장메시지
			list.remove(this); //현재 핸들러 객체값을 지움
			broadcast(nickName + "님이 퇴장하였습니다");
			
			br.close(); //51번줄 이후에 해당 코딩이 입력되어있어도 처리가능
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
