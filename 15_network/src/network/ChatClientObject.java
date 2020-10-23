package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
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
	private List<InfoDTO> list;
	private String nickName;
	
	
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
				//★object로 잡아주기
			}
		});
		
		list = new ArrayList<InfoDTO>();
		
	}//ChatClientObject 생성자 
	
	
	private void service() {
	   
		
		 //3.서버생성
		String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "192.168.0.17");
		if(serverIP == null || serverIP.length() == 0) {
			System.out.println("서버가 입력되지 않았습니다");
			System.exit(0);
		}
		
		//4.닉네임받기
		
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
			e.printStackTrace();
		}
	
		
		
		 Thread thread = new Thread(this);
		 thread.start();
		 
		 send.addActionListener(this);
		 input.addActionListener(this);
		
	}
	
	
	@Override
	public void run() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		InfoDTO dto = new InfoDTO();
		dto.setNickName(nickName);
		if(nickName != null || nickName.length() != 0) dto.setCommand(Info.JOIN);
		dto.setMessage(input.getText());
		input.setText("");
		dto.setCommand(Info.SEND);
		input.getText().toLowerCase();
		if(input.getText().equals("quit")) {
			dto.setCommand(Info.EXIT);
		}
		try {
			dto = (InfoDTO)ois.readObject();
			list.add(dto);
		} catch (ClassNotFoundException | IOException e1) {
			break;
		}
		
	}
	
	public static void main(String[] args) {
		new ChatClientObject().service();
	}





}
