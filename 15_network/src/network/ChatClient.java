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
	
	//0.�ʵ弱��
	private JTextField input;
	private JButton send;
	private JTextArea output;
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw; //���Ͱ� ó���ϱ� ����
	
	public ChatClient() {
		
		//2.������Ʈ ����
		input = new JTextField(15);
		send = new JButton("������");
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
		
		
		//1.������ ����
		setBounds(700,300, 300, 300); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}//ChatClient()
	
	public void service()  {
		//����IP - ���������� �ٲٴ� ��
//		String serverIP = JOptionPane.showInputDialog(this,
//													  "����IP�� �Է��ϼ���",
//													  "����IP",
//													  JOptionPane.INFORMATION_MESSAGE);
		
		//���� ����
		String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "192.168.0.17"); //"192.168.0.17"�� �ʱ갪 ����
		if(serverIP == null || serverIP.length() == 0) { //���� �Էµ��� �ʾ�����, ĭ�� �����ϰ� �Է����� �ʾ�����
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}
		
		//�г��� �ޱ�
		String nickName = JOptionPane.showInputDialog(this,
				 									  "�г����� �Է��ϼ���",
				 									  "�г���",
				 									  JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) {
			nickName = "guest";
		}
		
		//���ϻ���(�ڵ���)
		try {
			socket = new Socket(serverIP, 9500); //�ڵ��� ��ȣ | ��Ʈ��ȣ�� ���ǰ� ä��â ������ ��
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("������ ������ �ȵǾ����ϴ�"); 
			e.printStackTrace();
			System.exit(0);
		} 
		
		//������ �г��Ӹ� ������
		pw.println(nickName);
		pw.flush();
		
		
		//������ ����
		Thread thread = new Thread(this);
		//������ ���� - ������ ����(run())
		thread.start();
		
		//�̺�Ʈ
		send.addActionListener(this);
		input.addActionListener(this); //JTextField���� ����
	}
	

	@Override
	public void run() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if�� ����� �ʿ� ����
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new ChatClient().service();
	}
}

//300x300
//TextArea - ä��â
//TextField - ä���Է�â(ä��â�� �ø��� ���� �þ����)
//JButton - ������ ��ư