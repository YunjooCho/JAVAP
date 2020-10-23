package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Swing을 이용하여 창 만들기
public class SwingTest extends JFrame implements ActionListener { //부모가 Frame이라서 Frame의 기능도 가지고 있음
	private JButton newBtn, exitBtn;
	private JTextArea area; //TextField는 한 줄, 여러 줄을 발생시킬땐 TextArea
	
	public SwingTest() {
		//newBtn = new JButton("새로 만들기");
		//JButton의 생성자 Icon은 인터페이스
		//Icon인터페이스를 구현한 클래스 : ImageIcon
		//ImageIcon을 통해 생성
		newBtn = new JButton("새파일", new ImageIcon("image/crab.gif"));
		exitBtn = new JButton("종료");
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area); //스크롤에 TextArea를 붙여 프레임에 올려둠
		
		JPanel p = new JPanel();
		p.add(newBtn);
		p.add(exitBtn);
		
		
		Container c = this.getContentPane(); //결과 화면이 달라지는 것은 아니지만 내부적으로 콘테이너에 한번 집어넣어 Component들을 보호
		c.add("North", p); //★★★★콘테이너 관련 개념 찾아보기(인강)
		//add("Center", area);
		c.add("Center", scroll); 
		
		//이벤트
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		//this.addWindowListener(this);
		
		setBounds(700, 100, 300, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // swing에서는 아래 코드가 아닌 이 메소드를 이용하여 창을 종료시킴
		           								       // 나중에 채팅에서 상대방에게도 종료를 알릴때 WindowLister사용
													   // 여기를 DO_NOTHING_ON_CLOSE로 바꿈으로서 56번줄의 코드가 적용 - WindowListener에도 영향을 줌
													   // 이 부분을 눌렀을 때 창이 종료된 것 처럼 보이지만 사실은 창이 숨은것 뿐이다(디폴트값이 HIDE임)
													   // 따라서 이부분을 바꿔주지 않으면 완전 종료된 것이 아님
		
		//swing에서 아래 코드를 입력하지 않아도 x를 누르면 창이 꺼지는데 종료된 것이 아닌 창이 숨은 것임
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(SwingTest.this, "정말로 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				                                           //여기서 this만 있으면 익명클래스를 가리키므로, SwingTest.을 넣어 주어야 error가 나지 않는다
				if(result == 0) System.exit(0); //0이 예
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newBtn) {
			//area.setText(" "); - swing은 필요없음
			area.setText("");
			
		}else if(e.getSource() == exitBtn) {
			//System.exit(0);
			int result = JOptionPane.showConfirmDialog(this, "정말로 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); //this -> JFRAME
													  //익명클래스가 없으므로 여기서는 this만 써도 됨
			//동의를 구하는 메소드
			/*
			Parameters:
				parentComponent - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used.
				어디에 대해 실행하는지(실행하는 대상)
				message - the Object to display
				메시지
				title - the title string for the dialog
				대화상자의 타이틀
				optionType - an integer designating the options available on the dialog: YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION
				버튼 종류
				messageType - an integer designating the kind of message this is; primarily used to determine the icon from the pluggable Look and Feel: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE
				표시할 아이콘
				Returns: - 정수형을 return함
				an integer indicating the option selected by the user
				
		   */
			if(result == 0) {
				System.exit(0);
			}
			
		}
	}
	
	public static void main(String[] args) {
		new SwingTest();
	}

}

//awt와 구분하기 위해 대부분 J라는 앞글자를 추가
//확장패키지가 필요하기 때문에 javax사용
//Frame은 Component를 보호하지 않고 바로 올림
//JFrame은 상자 안에 Component를 실음 - Component보호 


//setDefaultCloseOperation
//DO_NOTHING_ON_CLOSE (defined in WindowConstants)
// : Don't do anything; require the program to handle the operation in the windowClosing method of a registered WindowListener object.
//HIDE_ON_CLOSE (defined in WindowConstants) - 창을 숨김
// : Automatically hide the frame after invoking any registered WindowListener objects.
//DISPOSE_ON_CLOSE (defined in WindowConstants) - 사후처리(많이 씀)
// : Automatically hide and dispose the frame after invoking any registered WindowListener objects.
//EXIT_ON_CLOSE (defined in JFrame) - 완전 종료
// : Exit the application using the System exit method. Use this only in applications.
