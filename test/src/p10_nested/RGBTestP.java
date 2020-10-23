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

	//1.�ʵ弱��
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas canvas;
	
	//2.������ - �ʵ� �ʱ�ȭ
	public RGBTestP() {
		//������ ����
		setBounds(100,100, 200, 300);
		setVisible(true);
		
		//��ư �ۼ�
		redBtn = new Button("����");
		greenBtn = new Button("�ʷ�");
		blueBtn = new Button("�Ķ�");
		canvas = new DrCanvas();
		
		Panel panel = new Panel();
		panel.add(redBtn);
		panel.add(greenBtn);
		panel.add(blueBtn);
		
		//�̺�Ʈ
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
	
	//3.CanvasŬ����(Canvas�߰�)
	class DrCanvas extends Canvas{
		public DrCanvas() {
			setBackground(new Color(255,255,0));
		}
	}
	
	public static void main(String[] args) {
		new RGBTestP();

	}

}
