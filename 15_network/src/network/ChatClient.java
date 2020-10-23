package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	private BufferedReader keyboard;
	
	public ChatClient() {
		
		//2.������Ʈ ����
		input = new JTextField(15);
		send = new JButton("������");
		output = new JTextArea();
		output.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false); //��ȭâ ���� �Ұ�
		
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add("Center", input);
		p.add("East", send);
				
		Container c = this.getContentPane();
		c.add("South", p);
		c.add("Center",scroll);
		
		
		//1.������ ����
		setBounds(700,300, 300, 300); 
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { //xǥ ������ quit�� ä��â�� �Էµ� �Ͱ� ���� ȿ���� error���� ����
				pw.println("quit");
				pw.flush();
			}
		});
		
	}//ChatClient()
	
	public void service()  {
		//����IP - ���������� �ٲٴ� ��
//		String serverIP = JOptionPane.showInputDialog(this,
//													  "����IP�� �Է��ϼ���",
//													  "����IP",
//													  JOptionPane.INFORMATION_MESSAGE);
		
		//3.���� ����
		String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "192.168.0.17"); //"192.168.0.17"�� �ʱ갪 ����
																							   //�Է��� ���� serverIP�� ����
		if(serverIP == null || serverIP.length() == 0) { //���� �Էµ��� �ʾ�����, ĭ�� �����ϰ� �Է����� �ʾ�����
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}
		
		//4.�г��� �ޱ�
		String nickName = JOptionPane.showInputDialog(this,
				 									  "�г����� �Է��ϼ���",
				 									  "�г���",
				 									  JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) {
			nickName = "guest";
		}
		
		//5.���ϻ���(�ڵ���)
		try {
			socket = new Socket(serverIP, 9500); //�ڵ��� ��ȣ | ��Ʈ��ȣ�� ���ǰ� ä��â ������ ��
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //���Ͽ� ����� ���� �޾ƿ�
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); //���Ͽ� ����� ���� ������
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("������ ������ �ȵǾ����ϴ�"); 
			e.printStackTrace();
			System.exit(0);
		} 
		
		
		//6.������ �г��Ӹ� ������
		pw.println(nickName);
		pw.flush();
		
		
		//7.������ ����
		Thread thread = new Thread(this);
		//������ ���� - ������ ����(run())
		thread.start();
		
		
		//8.�̺�Ʈ
		send.addActionListener(this);
		input.addActionListener(this); //JTextField���� ����
	}
	

	
	
	@Override
	public void run() {
		//9-2. �����κ��� �޴� ��
		String line;
		while(true) {
			try {
				line = br.readLine(); //
				if(line == null || line.toLowerCase().equals("quit")) { //���� �ڵ尡 ������ ������ �� ������
																		 //������ �빮�ڷ� quit�� ��� ���� ���� �����Ƿ� 
																		 //�Էµ� ���� ��� �ҹ��ڷ� ����
																		 //line == null ������� main�� ����Ǿ ��� �����ִ� ��찡 ����
					br.close();
					pw.close();
					socket.close();
					
					System.exit(0);
				}
				output.append(line + "\n");
				
				int pos = output.getText().length(); // TextArea ���� �� ��������
				output.setCaretPosition(pos);        // ��ġ���� ���� ��ũ���� ���� ��������
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//9-1. ������ ������ ��
		//������ ��ư ������ & �ؽ�Ʈ �ʵ忡�� ����ġ��
		//if�� ����� �ʿ� ����
		String msg = input.getText();
		pw.println(msg);
		pw.flush();
		input.setText("");
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new ChatClient().service();
	}
}

//300x300
//TextArea - ä��â
//TextField - ä���Է�â(ä��â�� �ø��� ���� �þ����)
//JButton - ������ ��ư