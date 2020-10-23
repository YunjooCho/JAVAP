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
	//1.�ʵ� ����(��ư, ������(����� �Է�), ��������ŭ ��ü����)
	private Button btn;
	private int count;
	private RacerP[] r;
	
	public RunRaceP() {
		
	}
	
	//2.������
	public RunRaceP(String[] args) { //Run Configuration���� ���� ����
		//4-1.����
		btn = new Button("���");
		count = Integer.parseInt(args[0]);
		r = new RacerP[count];
		
		//8.ĵ������ ��ư�� �ø� �г� ����
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
		
		
		//3.������ ����
		setBounds(700, 300, 600, 400);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//13.�̺�Ʈ
		btn.addActionListener(this);
	}

	//12.��ư�� Ȱ��ȭ, ��Ȱ��ȭ
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
			System.out.println("���� �������� �̸��� ������ ��ġ���� �ʽ��ϴ�");
			System.exit(0);
		}
		new RunRaceP(args);
	}

}
