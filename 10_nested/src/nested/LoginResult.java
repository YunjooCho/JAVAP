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
	//<다른풀이>private Login login;
	
	public LoginResult(String id, String pwd) {
	//<다른풀이> public LoginResult(Login login){ - 객체의 주소값 넘기기
	// this.login = login
		this.id = id;
		this.pwd = pwd;
		setLayout(null); //동서남북 위치제한 없애버림 - 원하는 위치에 배치 가능
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
	public void paint(Graphics g) { //Frame을 상속받아야 해당 메소드를 사용할 수 있음
									//또는 Frame을 필드선언 하는 경우, 생성부분에서 "익명클래스" 사용
								    //Frame이 추상클래스가 아니더라도 사용 가능
		//<다른풀이> - 객체의 주소값 넘기기
		//String id = login.getId();
		//String pwd = login.getPwd();
		if(id.equals("angel") && pwd.equals("1004")) {
			g.drawString("로그인 성공", 100, 100);
		}else {
			g.drawString("로그인 실패", 100, 100);
		}
	}
	
}	
//창 크기 200, 200
//종료버튼 누르면 다시 login이 호출됨 - 생성
//로그인 비교는 LoginResult에서
//if (id == id && pw == pw) - "로그인 성공" - drawString
//else - "로그인 실패"
