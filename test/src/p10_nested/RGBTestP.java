package p10_nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RGBTestP extends Frame {

	//1.필드선언
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas canvas;
	
	//2.생성자 - 필드 초기화
	public RGBTestP() {
		//프레임 생성
		setBounds(100,100, 200, 300);
		setVisible(true);
		
		//버튼 작성
		redBtn = new Button("빨강");
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		canvas = new DrCanvas();
		
		Panel panel = new Panel();
		panel.add(redBtn);
		panel.add(greenBtn);
		panel.add(blueBtn);
		
		//이벤트
		add("North", panel); 
		add("Center", canvas);
		redBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.RED);
			}
		});
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.GREEN);
			}
		});
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setBackground(Color.BLUE);
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
			
		
	}
	
	//3.Canvas클래스(Canvas추가)
	class DrCanvas extends Canvas{
		public DrCanvas() {
			setBackground(new Color(255,255,0));
		}
	}
	
	public static void main(String[] args) {
		new RGBTestP();

	}

}
