package practice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginP extends JFrame {
	
	//1.�ʵ� ����
	private JLabel idL, pwL;
	private JTextField idT, pwT;
	private JButton loginBtn, cancleBtn;
	String id, pwd;
	
	public LoginP() {
		
		idL = new JLabel("���̵�");
		pwL = new JLabel("��й�ȣ");
		
		setLayout(null);
		setBounds(700, 300, 300, 500);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new LoginP();
	}
}
