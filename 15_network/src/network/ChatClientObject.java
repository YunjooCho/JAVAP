package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



//오목의 좌표, 색깔, 상대방에게도 표시
public class ChatClientObject extends JFrame implements ActionListener, Runnable {

	//0.필드 선언
	private JTextField input;
	private JButton send;
	private JTextArea output;
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	//private List<InfoDTO> list;
	
	
	public ChatClientObject() {
		super("*~채팅방~*");
		//2.컴포넌트 생성
		input = new JTextField(15);
		send = new JButton("보내기");
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add("Center", input);
		p1.add("East", send);
		
		Container c = this.getContentPane();
		c.add("Center",scroll);
		c.add("South", p1);
		
		
		//1.프레임 만들기
		setBounds(700,300, 300, 300); 
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(ois == null || oos == null) System.exit(0);
				InfoDTO dto = new InfoDTO();
				dto.setCommand(Info.EXIT);
				try {
					oos.writeObject(dto);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
	}//ChatClientObject 생성자 
	
	
	private void service() {
	   
		
		 //3.서버생성
		String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "192.168.0.17");
		if(serverIP == null || serverIP.length() == 0) {
			System.out.println("서버가 입력되지 않았습니다");
			System.exit(0);
		}
		
		//4.사용자로부터 닉네임받기
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) {
			//★손님1,손님2,손님3....설정해보기
			nickName = "guest";	
		}
		
		//5.소켓생성(핸드폰)
		try {
			
			socket = new Socket(serverIP, 9500);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		//6.서버로 닉네임 보내기
		try {
			InfoDTO dto = new InfoDTO(); //닉네임 전송용으로 한번 쓰고 버림
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			oos.writeObject(dto);
			//list.add(dto);
			//oos.writeObject(list);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 Thread thread = new Thread(this);
		 thread.start();
		 
		 send.addActionListener(this);
		 input.addActionListener(this);
		
	}
	
	
	@Override
	public void run() {
		//서버로 부터 받음
		while(true) {
			InfoDTO dto = null;
			try {
				dto = (InfoDTO)ois.readObject();
				//list = (ArrayList)ois.readObject();
				if(dto.getCommand() == Info.EXIT) { //종료라는 메시지가 들어왔는지
					ois.close();
					oos.close();
					socket.close();
					System.exit(0);
				}else if(dto.getCommand() == Info.SEND){
					
					output.append(dto.getMessage() + "\n");
					
					int pos = output.getText().length(); // TextArea 글자 수 가져오기
					output.setCaretPosition(pos);        // 위치값에 따라 스크롤이 같이 움직여짐
					
				}
				
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		}//while
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			//서버로 보냄
			String msg = input.getText();
			//list = new ArrayList<InfoDTO>();
			InfoDTO dto = new InfoDTO();			
			
			if(msg.toLowerCase().equals("quit")) {
				dto.setCommand(Info.EXIT);
			}else {
				dto.setCommand(Info.SEND);
				dto.setMessage(msg);
				
			}
		
			try {
				oos.writeObject(dto);
				oos.flush();
				//list.add(dto);
				//oos.writeObject(list);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			input.setText("");
				
			
	}
	
	public static void main(String[] args) {
		new ChatClientObject().service();
	}





}
