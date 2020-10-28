
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
	private Label idL, pwdL; //라벨
	private TextField idT, pwdT; //텍스트상자
	private Button loginBtn, cancleBtn;
	String id, pwd;
	
	public Login() {
		idL = new Label("아이디");
		pwdL = new Label("비밀번호");
		
		idT = new TextField();
		pwdT = new TextField();
		
		loginBtn = new Button("로그인");
		cancleBtn = new Button("취소");
		
		//idL.setLocation(50,80); //x, y
		//idL.setSize(50, 30);//너비, 높이
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
		
		setLayout(null); //동서남북 위치제한 없애버림 - 원하는 위치에 배치 가능
		setBounds(600, 100, 300, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {//추상메소드가 없는 추상클래스
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
			//<다른풀이> new LoginResult(this);- 객체의 주소값 넘기기
			// 위의 id와 pwd변수는 필드로 지정, 셋터겟터 필요
		}else if(e.getSource() == cancleBtn) {
			idT.setText(" "); //라벨에 입력된 글자 초기화, awt특성상 처음부터 ""는 안먹힘
			idT.setText("");
			pwdT.setText(" "); //라벨에 입력된 글자 초기화, awt특성상 처음부터 ""는 안먹힘
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
