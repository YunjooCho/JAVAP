package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	
	//0.필드선언
	private JTextField input;
	private JButton send;
	private JTextArea output;
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw; //엔터값 처리하기 편함
	
	public ChatClient() {
		
		//2.컴포넌트 생성
		input = new JTextField(15);
		send = new JButton("보내기");
		output = new JTextArea();
		output.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false);
		
		
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add("Center",input);
		p.add("East", send);
				
		Container c = this.getContentPane();
		c.add("South", p);
		c.add("Center",scroll);
		
		
		//1.프레임 생성
		setBounds(700,300, 300, 300); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}//ChatClient()
	
	public void service()  {
		//서버IP - 유동적으로 바꾸는 법
//		String serverIP = JOptionPane.showInputDialog(this,
//													  "서버IP를 입력하세요",
//													  "서버IP",
//													  JOptionPane.INFORMATION_MESSAGE);
		
		//서버 생성
		String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "192.168.0.17"); //"192.168.0.17"로 초깃값 설정
		if(serverIP == null || serverIP.length() == 0) { //값이 입력되지 않았을때, 칸은 선택하고 입력하지 않았을때
			System.out.println("서버IP가 입력되지 않았습니다");
			System.exit(0);
		}
		
		//닉네임 받기
		String nickName = JOptionPane.showInputDialog(this,
				 									  "닉네임을 입력하세요",
				 									  "닉네임",
				 									  JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) {
			nickName = "guest";
		}
		
		//소켓생성(핸드폰)
		try {
			socket = new Socket(serverIP, 9500); //핸드폰 번호 | 포트번호는 대기실과 채팅창 나눠도 됨
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다"); 
			e.printStackTrace();
			System.exit(0);
		} 
		
		//서버로 닉네임만 보내기
		pw.println(nickName);
		pw.flush();
		
		
		//스레드 생성
		Thread thread = new Thread(this);
		//스레드 시작 - 스레드 실행(run())
		thread.start();
		
		//이벤트
		send.addActionListener(this);
		input.addActionListener(this); //JTextField에서 엔터
	}
	

	@Override
	public void run() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if문 사용할 필요 없음
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new ChatClient().service();
	}
}

//300x300
//TextArea - 채팅창
//TextField - 채팅입력창(채팅창을 늘리면 같이 늘어나야함)
//JButton - 보내기 버튼