package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {
	
	private ServerSocket ss;
	private BufferedReader br; //클라이언트와 동일하게 메시지를 주고받을 수 있는 기능이 필요(소켓을 만들어주어야 함)
	private BufferedWriter bw;
	private Socket socket;
	
	public ProtocolServer() {
		try {
			ss = new ServerSocket(9500);//포트값
			System.out.println("서버가 준비 완료되었습니다"); //클라이언트가 낚일때까지 무한정 기다림(한 명만 잡을 수 있음)
			
			socket = ss.accept(); //클라이언트를 낚아챔
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0); //연결이 끊어지면 종료시켜버림
		}
		
   //-------------------------------------------------------------
		String line, msg;
		while(true) {
			//클라이언트로부터 오는 메세지 읽기
			try {
				line = br.readLine(); //Client에서 bw.write(msg + "\n")의 '\n'을 꼭해주어야 문제 없이 읽어들임(아니면 문장의 끝을 찾아다님)
									  //"100 : angel"    "200 : angel"   "300 : angel : 안녕" 을 읽음
				
				//클라이언트로 보내기(쪼개서 보내기)
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) { //Protocol에서 정의한 상수가 배열 0번째에 들어있다면
					bw.write(ar[1] + "님 입장\n"); //줄바꿈을 해야 클라이언트쪽에서 읽어들임
					System.out.println(ar[1] + "님 입장\n");
					bw.flush();
				}else if(ar[0].equals(Protocol.EXIT)) { //200이 들어오면 바로 꺼져버림
					bw.write(ar[1] + "님 퇴장\n"); //종료 메시지 보내기 "angel님 퇴장"
					System.out.println(ar[1] + "님 퇴장\n");
					bw.flush();
					
					br.close(); //클라이언트와 서버 양쪽에 소켓이 있으므로 양쪽다 close()해줘야 끊어짐(여기서는 클라이언트쪽만 끊어준 것)
					bw.close();
					socket.close();
					
					System.exit(0); //프로그램 종료
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("[" + ar[1] + "]" + ar[2] + "\n"); //메시지 보내기
					bw.flush();//버퍼비우기
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			
		}//while
		
		
	}
	
	
	public static void main(String[] args) {
		new ProtocolServer();
	}
}
