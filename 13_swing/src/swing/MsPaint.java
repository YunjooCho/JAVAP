package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//�׸��� Ʋ�� ��������(ī���� ���� ����)


public class MsPaint extends JFrame {
	
	//2.�ʵ弱��
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private String[] color;
	private JButton draw;
	private DrCanvas can;
	
	public MsPaint() {
		super("�̴� �׸���");
		
		//3.�ʵ忡 ����� ���� ����
		JPanel p = new JPanel();
		x1L = new JLabel("X1");
		y1L = new JLabel("Y1");
		x2L = new JLabel("X2");
		y2L = new JLabel("Y2");
		z1L = new JLabel("Z1");
		z2L = new JLabel("Z2");
		x1T = new JTextField("           ");
		y1T = new JTextField("           ");
		x2T = new JTextField("           ");
		y2T = new JTextField("           ");
		z1T = new JTextField("           ");
		z2T = new JTextField("           ");
		
		fill = new JCheckBox("ä���");
		
		
		p.add(x1L);
		p.add(x1T);
		p.add(y1L);
		p.add(y1T);
		p.add(x2L);
		p.add(x2T);
		p.add(y2L);
		p.add(y2T);
		p.add(z1L);
		p.add(z1T);
		p.add(z2L);
		p.add(z2T);
		p.add(fill);
		add("North",p);
		
		
		JPanel p2 = new JPanel();
		line = new JRadioButton("��");
		circle = new JRadioButton("��");
		rect = new JRadioButton("�簢��");
		roundRect = new JRadioButton("�ձٻ簢��");
		pen= new JRadioButton("��");
		color = new String[]{"����","�ʷ�","�Ķ�","����","�ϴ�"}; 
		combo = new JComboBox<String>(color);
		draw = new JButton("�׸���");
		
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);
		add("South",p2);
		
		can = new DrCanvas();
		add("Center",can);
		
		
		
		//1.������ �����
		setBounds(800, 300, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	public static void main(String[] args) {
		new MsPaint();
	}

	
}

class DrCanvas extends Canvas{ //������ ���� ĵ������ ����
	public DrCanvas() {
		this.setBackground(new Color(255,255,255));	
	}
	
	@Override
	public void paint(Graphics g) { 
		g.drawRect(10, 0, 465, 185);
		
	}

}

//checkbox
//jcombobox
//���Ϳ� �׸��׸� ���� - Canvas

//1. JOptionPane.showMessageDialog(this, "������� ���̵� �Դϴ�");
//
//2. delete()
//
//3. �׸��� - Ʋ �� �ۼ��ϼ���
//Project : 13_swing
//
//Class   : MsPaint.java
//
//private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
//private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
//private JCheckBox fill;
//private JRadioButton line, circle, rect, roundRect, pen;
//private JComboBox<String> combo;
//private JButton draw;
//private DrCanvas can;
//������ ���� �ʿ� X