package nested;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginResult extends Frame { 
	private String id;
	private String pwd;
	//<�ٸ�Ǯ��>private Login login;
	
	public LoginResult(String id, String pwd) {
	//<�ٸ�Ǯ��> public LoginResult(Login login){ - ��ü�� �ּҰ� �ѱ��
	// this.login = login
		this.id = id;
		this.pwd = pwd;
		setLayout(null); //�������� ��ġ���� ���ֹ��� - ���ϴ� ��ġ�� ��ġ ����
		setBounds(600, 100, 300, 400);
		setVisible(true);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) { //Frame�� ��ӹ޾ƾ� �ش� �޼ҵ带 ����� �� ����
									//�Ǵ� Frame�� �ʵ弱�� �ϴ� ���, �����κп��� "�͸�Ŭ����" ���
								    //Frame�� �߻�Ŭ������ �ƴϴ��� ��� ����
		//<�ٸ�Ǯ��> - ��ü�� �ּҰ� �ѱ��
		//String id = login.getId();
		//String pwd = login.getPwd();
		if(id.equals("angel") && pwd.equals("1004")) {
			g.drawString("�α��� ����", 100, 100);
		}else {
			g.drawString("�α��� ����", 100, 100);
		}
	}
	
}	
//â ũ�� 200, 200
//�����ư ������ �ٽ� login�� ȣ��� - ����
//�α��� �񱳴� LoginResult����
//if (id == id && pw == pw) - "�α��� ����" - drawString
//else - "�α��� ����"