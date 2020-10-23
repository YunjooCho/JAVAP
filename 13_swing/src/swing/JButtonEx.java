package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

//카드 뒤집기 게임
public class JButtonEx extends JFrame {
	//1.필드선언
	private Icon icon1 = new ImageIcon("image/jindo.jpg");
	private Icon icon2 = new ImageIcon("image/liver.jpg");
	private Icon icon3 = new ImageIcon("image/poodle.jpg");
	private Icon icon4 = new ImageIcon("image/shizu.jpg");
	
	private JRadioButton[] jb = new JRadioButton[4]; //여러개의 항목 중 하나만 선택할 수 있도록 하기 위한 버튼
	private ButtonGroup bg = new ButtonGroup();		 //ButtonGroup 버튼을 여러개 묶어주기 위한 것
	
	//★단일객체, 4개 이상의 배열객체로도 만들어봐서 어떤식으로 배치되는 것인지 확인
	public JButtonEx() {
		super("Test");//윈도우 창 이름표시
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i = 0; i < jb.length; i++) {
			jb[i] = new JRadioButton(i + 1 + "번 버튼" , icon1); //기본화면으로 icon1이 뜲
			con.add(jb[i]); 
			jb[i].setToolTipText(i + 1 + "번째 버튼이다. 눌러....");
			jb[i].setMnemonic(i+49);//단축키
			jb[i].setRolloverIcon(icon2); //위아래로 할때 출력되는 그림 liver
			jb[i].setPressedIcon(icon3);  //누르면 출력되는 그림          poodle
			jb[i].setSelectedIcon(icon4); //선택(되어 있는 상태에서 클릭)하면 출력되는 그림 shizu
			bg.add(jb[i]);
		}
		
		pack();//창의 크기를 알맞게 맞춰주는(여기서는 사진의 사이즈에 맞게 맞춰준듯) 메소드
			   //setBouns대신
		setVisible(true); //프레임은 있는데(setVisible) 크기를 정하지 않은 것뿐, 크기는 첨부한 사진의 크기에 따라 자동으로 조절됨 - 크기가 자율화 된 것
	}
	
	
	public static void main(String[] args) {
		new JButtonEx();

	}

}


//모델은 객체?데이터?의 저장 삭제를 담당
//제이리스트가 출력

//Tooltip : 마우스 갖다대면 메시지풍선 같은게 뜨는것
//Mnemonic : 단축키
//