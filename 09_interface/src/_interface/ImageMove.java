package _interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ImageMove extends Frame implements ActionListener, KeyListener, WindowListener{
	//2-1.��ư�����
	private Button returnBtn, leftBtn, upBtn, downBtn, rightBtn;
	private int x = 100, y = 100;
	
	public void init() {
		
		//2-2.��ư �����
		returnBtn = new Button("�ʱ�ȭ");
		leftBtn = new Button("����");
		upBtn = new Button("����");
		downBtn = new Button("�Ʒ���");
		rightBtn = new Button("������");
		
		Panel p = new Panel();
		p.add(returnBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		
		this.add("North", p); //this���� ����, �ǳ��� �����ӿ� �߰�(�߰��� ��ġ, �ǳڰ�ü)
		
		returnBtn.setFocusable(false); //��Ŀ�� ���ִ� �޼ҵ�
		                               //Ű����� �Է��ϴµ� �־ ��ư�� ��Ŀ���� ������������ Ű����� �������� ���ϱ� ������
		leftBtn.setFocusable(false);
		upBtn.setFocusable(false);
		downBtn.setFocusable(false);
		rightBtn.setFocusable(false);
		
		//1.������ ����
		setBounds(300, 100, 500, 500);
		setVisible(true);
		setResizable(false); //âũ�� ���� �Ұ�
				
		
		//�̺�Ʈ (2-3.��ư��)
		returnBtn.addActionListener(this);//�ش� ��� ������ ��ġ.�̺�Ʈ��(�����ΰ� �ۼ��� ��ġ)
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		this.addWindowListener(this);
		
		this.addKeyListener(this);

	}
	
	public void paint(Graphics g) {//paint�޼ҵ�� ����ȭ�� ��(�����ٰ� �ٽ� �׸�)
		//�̹��� �ҷ����� - ToolkitŬ����(�߻�Ŭ����) - �ڽ�Ŭ������ �����Ƿ� �޼ҵ�� ����
		Image img = Toolkit.getDefaultToolkit().getImage("puppy.jpg");
		//Toolkit t = Toolkit.getDefaultToolkit();
		//Image img = t.getImage("puppy.jpg");
		
		
		//�̹��� �׸���
		g.drawImage(img, x, y, this);//this�κ� : ��� �׸��� �׸��� ǥ��
	}
	

	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("x : " + x + " y : " + y);
		if(e.getSource() == returnBtn) { //returnBtn�� ���ȴ°�
			this.x = 100;
			this.y = 100;
		}else if(e.getSource() == leftBtn) {
			this.x = x -= 10;
			if(x == -130) {
				this.x = 490;
			}
		}else if(e.getSource() == upBtn) {
			this.y = y -= 10;
			if(y == -90) {
				this.y = 480;
			}
		}else if(e.getSource() == downBtn) {
			this.y = y += 10;
			if(y == 500) { //�ڼ�ġ �����ϱ�
				this.y = 0;
			}
		}else if(e.getSource() == rightBtn) {
			this.x = x += 10;
			if(x == 500) { //�ڼ�ġ �����ϱ�
				this.x = 0;
			}
		}
		repaint(); //���� ����(�������)�� ���߾� �Ź� ���� �׸�
	}
	
	
	//WindowListener
	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); //���α׷� ���� ����
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	
	//KeyListener
	//Ű���� �׼�(��:if(Ű���� == KeyEvent.VK_ESCAPE / int esc -> 27 : ���ڸ� �ܿ�� ���⿡ ������ ���ȭ)
	@Override
	public void keyPressed(KeyEvent k) {
		//if(k.getKeyCode() == 27)
		if(k.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}else if(k.getKeyCode() == KeyEvent.VK_LEFT) {
			this.x -= 10;
			if(x < -130) {
				this.x = 490;
			}
			repaint();
		}else if(k.getKeyCode() == KeyEvent.VK_UP) {
			this.y -= 10;
			if(y < -90) {
				this.y = 480;
			}
			repaint();
		}else if(k.getKeyCode() == KeyEvent.VK_DOWN) { 
			this.y += 10;
			if(y > 500) { //�ڼ�ġ �����ϱ�
				this.y = 0;
			}
			repaint();
		}else if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.x += 10;
			if(x > 500) { //�ڼ�ġ �����ϱ�
				this.x = 0;
			}
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {}

	@Override
	public void keyTyped(KeyEvent k) {}

	
	//main�޼ҵ�
		public static void main(String[] args) {
			new ImageMove().init();
		}

}


//1. Frame â ���� (o)
//2. North ���⿡ ��ư 5�� �����(o)
//3. Frame(â)�� 100, 100�� ��ġ�� �̹��� �׸���(o)
//4. �̺�Ʈ - �ݴ��ʿ��� �ٽ� ��Ÿ���°� �� ���� �ȵ� -> �ذ���

//interface
//1.implements(��� �߻�޼ҵ� Override) - ArrayList(Collection�������̽� �������̵�)

//Ŭ���� ����
//1.new
//2.�޼ҵ�