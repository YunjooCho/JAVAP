package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//채팅창 서버를 본인걸로 만들기
//Seversocket을 만들어 실행할 준비를 함
public class ChatServer {
	private ServerSocket ss; 
	private List<ChatHandler> list; //ChantHandler객체를 담는 list
	
	public ChatServer() {
		try {
			ss = new ServerSocket(9500);
		} catch (IOException e) {
			e.printStackTrace();
		}//포트값
		System.out.println("서버가 준비 완료되었습니다"); //클라이언트가 낚일때까지 무한정 기다림
		
		list = new ArrayList<ChatHandler>();
		
		while(true) { //클라이언트를 낚아챈다, ServerSocket쪽 소켓안에 넣어준다
				      //여러명의 클라이언트를 낚아채기 위해 while문(무한루프)를 돌림
					  //클라이언트 소켓이 스레드로 돌고 있으므로 서버쪽의 소켓(ServerSocket 아님)도 같이 스레드로 움직여야 함
					  //서버, ServersSocket은 한개만
			try {
				Socket socket = ss.accept();
				ChatHandler handler = new ChatHandler(socket, list); //소켓에 담긴 메시지와 클라이언트가 몇 명이나 접속했는지 정보를 리스트에 보냄
																     //소켓, br, pw가 들어있음
																	 //ChatHandler에서 매개값을 가지고 있는 생성자를 작성
																	 //스레드 생성
				handler.start();//스레드 시작 - 스레드 실행(run())
				list.add(handler); //list에 핸들러객체를 추가
			} catch (IOException e) {
				e.printStackTrace();
			} 
										 
		}
	}
	
	
	public static void main(String[] args) {
		new ChatServer();
	}

}

