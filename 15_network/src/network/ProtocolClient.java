package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	private BufferedReader keyboard;//키보드
	
	public ProtocolClient() throws IOException {
		try {
			socket = new Socket("192.168.0.17", 9500); //IP : 집주소 포트(9500) : 이름 - 포트
													   //IP를 틀리게 쓰면 "클라이언트를 연결할 수 없습니다"에러가 뜸
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
			
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다"); 
			e.printStackTrace();
			System.exit(0);
		}

//-----------------------------------------------------------------------------------------------
		String msg, line;
		while(true) {
			//서버로 보내는 쪽(Output) - bw
			msg = keyboard.readLine();
			bw.write(msg + "\n"); //"100 : angel"    "200 : angel"   "300 : angel : 안녕"
								  // bw : 위에서 보내는 생성을 실시
								  // readLine()은 엔터를 인식하지 않음
								  // 서버측에서 readLine()으로 읽어들일때 엔터(문장의 끝)를 찾아 빙빙 돔(Lock걸림)
								  // ->실행안됨 (대응책으로 엔터를 일부러 넣어줌("\n")
			bw.flush(); //버퍼를 통해 수시로 다시 메시지를 보내야 하므로 버퍼를 비워줘야함
			
			
			
			//서버로부터 받는 쪽(Input) - br
			line = br.readLine();   //"angle님 입장"    "angel님 퇴장"    "[angel] 안녕" - Protocol.java의 상수에 따라 움직임
			System.out.println(line);
			
			String[] ar = msg.split(":"); //":"을 기준으로 나누기 -> 배열이 나옴 (StringTokenizer)
			if(ar[0].equals(Protocol.EXIT)) {
				br.close(); //클라이언트와 서버 양쪽에 소켓이 있으므로 양쪽다 close()해줘야 끊어짐(여기서는 클라이언트쪽만 끊어준 것)
				bw.close();
				socket.close();
				
				keyboard.close();
				System.exit(0);
			}
			
		}//while
		
	}//ProtocolClient()
	
	public static void main(String[] args) throws IOException {
		new ProtocolClient(); //error - java.net.ConnectException: Connection timed out: connect
	}

}







