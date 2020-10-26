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



//������ ��ǥ, ����, ���濡�Ե� ǥ��
public class ChatClientObject extends JFrame implements ActionListener, Runnable {

	//0.�ʵ� ����
	private JTextField input;
	private JButton send;
	private JTextArea output;
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	//private List<InfoDTO> list;
	
	
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
		
		
		
	}//ChatClientObject ������ 
	
	
	private void service() {
	   
		
		 //3.��������
		String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "192.168.0.17");
		if(serverIP == null || serverIP.length() == 0) {
			System.out.println("������ �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}
		
		//4.����ڷκ��� �г��ӹޱ�
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
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		//6.������ �г��� ������
		try {
			InfoDTO dto = new InfoDTO(); //�г��� ���ۿ����� �ѹ� ���� ����
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
		//������ ���� ����
		while(true) {
			InfoDTO dto = null;
			try {
				dto = (InfoDTO)ois.readObject();
				//list = (ArrayList)ois.readObject();
				if(dto.getCommand() == Info.EXIT) { //������ �޽����� ���Դ���
					ois.close();
					oos.close();
					socket.close();
					System.exit(0);
				}else if(dto.getCommand() == Info.SEND){
					
					output.append(dto.getMessage() + "\n");
					
					int pos = output.getText().length(); // TextArea ���� �� ��������
					output.setCaretPosition(pos);        // ��ġ���� ���� ��ũ���� ���� ��������
					
				}
				
			} catch (ClassNotFoundException | IOException e) {
				
				e.printStackTrace();
			}
		}//while
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			//������ ����
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
