package p10_nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardTestP {
	
	//1. 필드 선언
	private Frame frame;
	private CardLayout card;
	
	//2. 생성자
	public CardTestP() {
		frame = new Frame();
		card = new CardLayout();
		
		frame.setLayout(card);
		
		Panel[] p = new Panel[6];
		Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.YELLOW};
		String[] name = {"빨강", "파랑", "초록", "청록", "자주", "노랑"};
		
		for(int i = 0; i < p.length; i++) {
			p[i] = new Panel();
			p[i].setBackground(color[i]);
			frame.add(p[i], name[i]);
			
			p[i].addMouseListener(new MouseAdapter(){
				public void mouseClicked(java.awt.event.MouseEvent e) {
					card.next(frame);
				}
			});
		}
		
		frame.setBounds(200, 200, 200,200);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new CardTestP();

	}

}
