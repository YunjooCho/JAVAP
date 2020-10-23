package p13_swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MsPaintT extends JFrame implements ActionListener {
	
	//1.�ʵ弱��
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private String[] color;
	private JButton draw;
	
	
	
	public MsPaintT() {
		
		//3.������Ʈ ����
		x1L = new JLabel("X1");
		y1L = new JLabel("Y1");
		x2L = new JLabel("X2");
		y2L = new JLabel("Y2");
		z1L = new JLabel("Z1");
		z2L = new JLabel("Z2");
		
		x1T = new JTextField(4);
		y1T = new JTextField(4);
		x2T = new JTextField(4);
		y2T = new JTextField(4);
		z1T = new JTextField(4);
		z2T = new JTextField(4);
		fill = new JCheckBox("ä���");
		
		line = new JRadioButton("��");
		circle = new JRadioButton("��");
		rect = new JRadioButton("�簢��",true); //true - �⺻������ ����
		roundRect = new JRadioButton("�ձ� �簢��");
		pen = new JRadioButton("����");
		
		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		
		color = new String[] {"����","�ʷ�","�Ķ�","����","�ϴ�"};
		combo = new JComboBox<String>(color);
		draw = new JButton("�׸���");
		
		
		JPanel p1 = new JPanel();
		p1.add(x1L);
		p1.add(x1T);
		p1.add(y1L);
		p1.add(y1T);
		p1.add(x2L);
		p1.add(x2T);
		p1.add(y2L);
		p1.add(y2T);
		p1.add(z1L);
		p1.add(z1T);
		p1.add(z2L);
		p1.add(z2T);
		
		JPanel p2 = new JPanel();
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);
		
		
		Container c = this.getContentPane();
		c.add("North", p1);
		c.add("South", p2);
		
		//2.������ ����
		setBounds(700, 300, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MsPaintT();
		
	}

}
