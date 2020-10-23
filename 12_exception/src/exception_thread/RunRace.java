package exception_thread;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunRace extends Frame implements ActionListener{ //Racer�� �����尡 ��
	//1.�ʵ� ����
	private Button btn; //��߹�ư
	private int count;  //�� ���� ��
	private Racer[] r;  //�� ���� ����ŭ�� ��ü ����
	
	//-.������(�⺻������)
	public RunRace () {
		
	}
	
	
	//2.������(���ڿ��� �Ķ���ͷ� �ϴ� ������) - ������, ��ư, ������, �迭, ������ �ø� �г�
	public RunRace(String[] args) { //String[] args�� Run Configuration���� ���� ����
		//4.����
		btn = new Button("���");
		count = Integer.parseInt(args[0]);
		r = new Racer[count]; //ĵ����Ŭ���� - 1.�迭����
		
		//7.������ �ø� �г��� �߰�
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT)); 
		//Panel�� Layout : FlowLayout
		//FlowLayout�� �⺻�� Center������, Right�� ��ȯ�Ͽ� ��ư�� ��ġ�� �ű�
		p.add(btn);
		
		for(int i = 0; i < count; i++) {
			r[i] = new Racer(args[i+1]); //2.Ŭ���� ����
			add("Center",r[i]); //�ؿ� ���ļ� ������ ����
		}
		//5.��ư �ø���
		add("South",p);
//		add("Center",r);
//		add("Center", r[0]); //������ ��� ���µ��� �ʴ� ������ �̹��� ũ�Ⱑ �۱� ������ FlowLayout�� �ٸ��� �����߽��� �ƴѰ���
//		add("Center", r[1]);
//		add("Center", r[2]);
		
		
		//3.�гο� �ش� ��ü�� �߰��Ͽ� �����ӿ� ���
		Panel p2  = new Panel(new GridLayout(count,1)); //�������� �ϳ� �̻� �ö��� �ʾ� Panel�� �־ �����
		for(int i = 0; i < count; i++) {
			p2.add(r[i]);
			
		}
		add("Center", p2);
		
		//3. ������ â ���� - �� ������ �ؿ� �������°� ����
		setBounds(700,300,600,400);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//�̺�Ʈ
		btn.addActionListener(this);
		
	}
	
	public int getCount() {
		return count;
	}

	//�������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		 //��ư ��Ȱ��ȭ
		 btn.setEnabled(false);
		 
		 //�迭 ���� 
		 Thread[] t = new Thread[count];
		 //������ ����
		 for(int i = 0; i < count; i++) {
			 t[i] = new Thread(r[i]); //racer�� ������� ����� ���� ��
			 t[i].setPriority((int)(Math.random()*10+1)); //�켱���� - � �� ��ü�� ���� ������� ��
			 //������ ���� - ������ ����(�ü��) - run()
			 t[i].start();
		 }//for
	}

	public static void main(String[] args) {
		//String[] args�� ���� ���� �������� �� ���� �̸��� �Է���
		if(args.length < 2) { //�Ű������� ���� //��2�� ��� ���� �������� �ٽ� ����
			System.out.println("Usage : java RunRace count name1, ..."); // ���� : ���� �������� �̸� �Է�
			 															 // Run Configuration ���
			System.exit(0);//������ Ʋ����(�Է°�(�Ű���)�� ����� �Էµ��� ���� ���, ���� ����)
		}
		
		if(Integer.parseInt(args[0]) != args.length -1) { //args.length - 1 �ϴ� ���� : �Ű����� ������ + �ֵ� �̸����� �������׸� ������ �� ������ 1�� �� ����
			System.out.println("�� �������� �̸��� ������ ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		
		new RunRace(args);
	}
}
