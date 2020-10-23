package nested;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends Frame implements ActionListener {
	private Label idL, pwdL; //��
	private TextField idT, pwdT; //�ؽ�Ʈ����
	private Button loginBtn, cancleBtn;
	String id, pwd;
	
	public Login() {
		idL = new Label("���̵�");
		pwdL = new Label("��й�ȣ");
		
		idT = new TextField();
		pwdT = new TextField();
		
		loginBtn = new Button("�α���");
		cancleBtn = new Button("���");
		
		//idL.setLocation(50,80); //x, y
		//idL.setSize(50, 30);//�ʺ�, ����
		idL.setBounds(50, 80, 50, 20);
		this.add(idL);
		
		pwdL.setBounds(50, 160, 50, 20);
		this.add(pwdL);
		
		idT.setBounds(120, 80, 90, 20);
		this.add(idT);
		
		pwdT.setBounds(120, 160, 90, 20);
		this.add(pwdT);
		
		loginBtn.setBounds(50, 280, 70, 20);
		this.add(loginBtn);
		
		cancleBtn.setBounds(160, 280, 70, 20);
		this.add(cancleBtn);
		
		setLayout(null); //�������� ��ġ���� ���ֹ��� - ���ϴ� ��ġ�� ��ġ ����
		setBounds(600, 100, 300, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {//�߻�޼ҵ尡 ���� �߻�Ŭ����
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		loginBtn.addActionListener(this);
		cancleBtn.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			String id = idT.getText();
			String pwd = pwdT.getText();
			new LoginResult(id, pwd);
			//<�ٸ�Ǯ��> new LoginResult(this);- ��ü�� �ּҰ� �ѱ��
			// ���� id�� pwd������ �ʵ�� ����, ���Ͱ��� �ʿ�
		}else if(e.getSource() == cancleBtn) {
			idT.setText(" "); //�󺧿� �Էµ� ���� �ʱ�ȭ, awtƯ���� ó������ ""�� �ȸ���
			idT.setText("");
			pwdT.setText(" "); //�󺧿� �Էµ� ���� �ʱ�ȭ, awtƯ���� ó������ ""�� �ȸ���
			pwdT.setText("");
		}
	}
	
	public String getId() {
		return id;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public static void main(String[] args) {
		new Login();
		
	}

}
