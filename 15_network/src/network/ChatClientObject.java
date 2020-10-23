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



//������ ��ǥ, ����, ���濡�Ե� ǥ��
public class ChatClientObject extends JFrame implements ActionListener, Runnable {

	//0.�ʵ� ����
	private JTextField input;
	private JButton send;
	private JTextArea output;
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<InfoDTO> list;
	private String nickName;
	
	
	public ChatClientObject() {
		super("*~ä�ù�~*");
		//2.������Ʈ ����
		input = new JTextField(15);
		send = new JButton("������");
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
		
		
		//1.������ �����
		setBounds(700,300, 300, 300); 
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//��object�� ����ֱ�
			}
		});
		
		list = new ArrayList<InfoDTO>();
		
	}//ChatClientObject ������ 
	
	
	private void service() {
	   
		
		 //3.��������
		String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "192.168.0.17");
		if(serverIP == null || serverIP.length() == 0) {
			System.out.println("������ �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}
		
		//4.�г��ӹޱ�
		
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���", "�г���", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) {
			//�ڼմ�1,�մ�2,�մ�3....�����غ���
			nickName = "guest";	
		}
		
		//5.���ϻ���(�ڵ���)
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
