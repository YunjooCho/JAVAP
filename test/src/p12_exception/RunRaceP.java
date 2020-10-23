package p12_exception;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunRaceP extends Frame implements ActionListener {
	//1.필드 선언(버튼, 마리수(사용자 입력), 마리수만큼 객체생성)
	private Button btn;
	private int count;
	private RacerP[] r;
	
	public RunRaceP() {
		
	}
	
	//2.생성자
	public RunRaceP(String[] args) { //Run Configuration으로 값을 받음
		//4-1.생성
		btn = new Button("출발");
		count = Integer.parseInt(args[0]);
		r = new RacerP[count];
		
		//8.캔버스와 버튼을 올릴 패널 생성
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);
		
		for(int i = 0; i < count; i++) {
			r[i] = new RacerP(args[i+1]);
			add("Center",r[i]);
		}
		
		add("South",p);
		
		Panel p2 = new Panel(new GridLayout(count,1));
		for(int i = 0; i < count; i++) {
			p2.add(r[i]);
		}
		add("Center",p2);
		
		
		//3.프레임 생성
		setBounds(700, 300, 600, 400);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//13.이벤트
		btn.addActionListener(this);
	}

	//12.버튼의 활성화, 비활성화
	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false);
		
		Thread[] t = new Thread[count];
		for(int i = 0; i < count; i++) {
			t[i] = new Thread(r[i]);
			t[i].setPriority((int)(Math.random()*10+1));
			t[i].start();
		}
		
	}
	
	public static void main(String[] args) {
		
		//4-2
		if(args.length < 2) {
			System.out.println("Usage : java RunRaceP count name1, ...");
			System.exit(0);
		}
		
		if(Integer.parseInt(args[0]) != args.length - 1) {
			System.out.println("말의 마리수와 이름의 갯수가 일치하지 않습니다");
			System.exit(0);
		}
		new RunRaceP(args);
	}

}
