package swing;

//ctrl + shift + f : ����
//alt + ���Ʒ� : ������ �κ��� ������

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//�׸��� Ʋ�� ��������(ī���� ���� ����)

//class DrCanvas extends Canvas{    //���� Ŭ���� ����
//	public void paint(Graphics g) {
//		g.drawRect(10, 0, 560, 180);
//		
//		
//	}
//}


//������ ����(������Ʈ(������) ���� �� ��ġ)&�̺�Ʈ �߻�
//�����Ҷ��� Ʋ�� ���ΰ� �̺�Ʈ � ������ �ǽ��غ���
public class MsPaintT extends JFrame implements ActionListener {

	//1.�ʵ� ����
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvasT canvas;
	private String[] colorlist;
	private ArrayList<ShapeDTO> list;
	
	//private List<ShapeDTO> list = new ArrayList<ShapeDTO>(); - �θ�� �����ص� ����(�̰ɷ� �����ϴ� ���� ����)
	//Object ob = new String("���"); - ����� ������
	//������������ ���� ���� List�� ���� ��
	//������ ��Ʈ�� ������(?) ���� �־ ������ ������ ������, �������� ��κ� ���� ����ϰ� ����
	


	public MsPaintT() {
		super("�׸� �׸���");
		//3.�ʵ带 ���� ǥ�õ����� ����
		x1L = new JLabel("X1"); //���� : ȭ�鿡 ���ڸ� ǥ��
		y1L = new JLabel("Y1");
		x2L = new JLabel("X2");
		y2L = new JLabel("Y2");
		z1L = new JLabel("Z1");
		z2L = new JLabel("Z2");
		x1T = new JTextField("0",4);//���ڿ�("  ")�� �ƴ� ����(4)�� �Է��ؼ� ĭ�� ���� �� ����, �⺻������ "0"�� ��
		y1T = new JTextField("0",4);
		x2T = new JTextField("0",4);
		y2T = new JTextField("0",4);
		z1T = new JTextField("0",4);
		z2T = new JTextField("0",4);
		fill = new JCheckBox("ä���");
		
		JPanel p = new JPanel();
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
		
		
		//4.�Ʒ��κ� ����
		JPanel p2 = new JPanel();
		line = new JRadioButton("��");
		circle = new JRadioButton("��");
		rect = new JRadioButton("�簢��", true); //true : default������ ����� �簢���� ���õǾ�����
		roundRect = new JRadioButton("�ձٻ簢��");
		pen = new JRadioButton("����");
		
		ButtonGroup group = new ButtonGroup(); //������ư �� �ߺ������� �ƴ� �ѹ��� �ϳ��� ���õǰ� �ϱ� ����  group�� ������
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		colorlist = new String[] {"����","�ʷ�","�Ķ�","����","�ϴ�"};
		combo = new JComboBox<String>(colorlist);
		draw = new JButton("�׸���");
		
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);
		
		canvas = new DrCanvasT(this); //DrCanvasT�� �ּҰ��� �� �� ����(�������� canvas)
									  //this�� MsPaint�� ����Ŵ
		
		
		//��� ������Ʈ�� contentPane�� �ٿ��� ��
		Container c = this.getContentPane();	
		c.add("North",p);
		c.add("South",p2);
		c.add("Center",canvas);
		
		//�̺�Ʈ
		draw.addActionListener(this);
		
		
		list = new ArrayList<ShapeDTO>();
		//mousePressed(~~) - x1, y1 ��ǥ
		//mouseDragged(~~) - x2, y2 ��ǥ	
		canvas.addMouseListener(new MouseAdapter() { //MouseListener �޼ҵ� 5��
													 //MouseAdapter�� �߻�Ŭ���� - �͸��� Ŭ������ Ȱ��
													 //MouseListener���� �巡�װ� ����
			@Override
			public void mousePressed(MouseEvent e) { 
				x1T.setText(e.getX() + ""); //java���� �����ϴ� �޼ҵ� - getX(), getY(), setText()(���� ����� �ƴ�)
				y1T.setText(e.getY() + "");
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
			    //���콺�� �����ٰ� �巡�� ���ϸ� �׸��� �ȱ׷�����
				//�ٵ� ���콺���� ���� ���� list�� ShapeDTO�� ����
				//x2T�� y2T�� �ٲ��� ����
				//�ܼ� Ŭ�������� ��̸���Ʈ�� �߰� �Ǵ� �� ����
			 	if(x2T.getText().equals("0") && y2T.getText().equals("0")) return;
			 	
			 	//<������ Ǯ��>
			 	//System.out.println(e.getX() + e.getY());
			 	//int x1 = Integer.parseInt(x1T.getText());
			 	//int y1 = Integer.parseInt(y1T.getText());
			 	//if(x1 == e.getX() && y1 == e.getY()) return;
			 	//x1T.Text�� ������ �� ������ ��ǥ, e.getX�� �巡���� �� ���콺�� ����Ű�� �ִ� ��ǥ�̹Ƿ�
			 	//�巡��(�̵�)�ߴٸ� �� ��ǥ�� �޶���Ѵ�.
			 	//�巡�� ���� �ʾҴٸ� �� ��ǥ�� ���� �׷��Ƿ� ���� if���� �����ϸ� �巡�� �ߴ��� ���� �ʾҴ��� �� �� �ִ�.
			 	
				//�̹� ����Ǿ� �ִ� ��(�׸� ��)�� ShapeDTO��ü�� �Ѱ���
			 	//�١١١١�for�� �ʿ� ���� -> for���� �Է��� ��� ��ü�� �߰��ȵ� - ���� : ���� ��ü�� �Է����� �ʾҴµ� 
			 	//     					   ���ǽĿ� i < list.size() (�� : 0)�� �־ �۵����� ����
				//�׸� ���� ������ �޼ҵ带 �̿��Ͽ� ����
				ShapeDTO dto = new ShapeDTO();
				//��ǥ
				dto.setX1(Integer.parseInt(x1T.getText())); //x1T.getText()�� StringŸ���̹Ƿ� int������ ����ȯ
															//dto.setX1()�� int��
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));
				
				//ä���
				if(fill.isSelected()) dto.setFill(true);
				else dto.setFill(false);
				//dto.setFill(fill.isSelected());
				
				//����
				if(line.isSelected()) dto.setShape(Figure.LINE);
				else if(circle.isSelected()) dto.setShape(Figure.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Figure.RECT);
				else if(roundRect.isSelected()) dto.setShape(Figure.ROUND_RECT);
				//���� dragg�� ���� : else if(pen.isSelected() == true) dto.setShape(Figure.PEN);
				
				//��
				dto.setColor(combo.getSelectedIndex());
				list.add(dto);
				System.out.println("list�� ���� : " + list.size());
			}
		});
		
		canvas.addMouseMotionListener(new MouseAdapter() {//MouseMotionListener�� MouseAdapter ����� �� ����
			@Override
			public void mouseDragged(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");
				canvas.repaint(); //�ܻ��� ���� repaint() ���� �� update()ȣ�� -> update()�� paint()ȣ��
				
				//�١١١١��� ��� - ���� ���콺�� ������ �����Ƿ� release�� �ƴ� dragg���� �����Ѵ�
				if(pen.isSelected()) {
					ShapeDTO dto = new ShapeDTO(); //�׸��� ������ ��ü�ʹ� ���ʿ��� �Ǵٸ� ��ü ����
					
					//��ǥ(release����� ����)
					dto.setX1(Integer.parseInt(x1T.getText())); 
					dto.setY1(Integer.parseInt(y1T.getText()));
					dto.setX2(Integer.parseInt(x2T.getText()));
					dto.setY2(Integer.parseInt(y2T.getText()));
					dto.setZ1(Integer.parseInt(z1T.getText()));
					dto.setZ2(Integer.parseInt(z2T.getText()));
					
					//ä���(release����� ����)
					if(fill.isSelected() == true) dto.setFill(true);
					else dto.setFill(false);
					
					//���� - pen�� ���⼭ ����, ������ ����� release���� ����
					dto.setShape(Figure.PEN); 
					
					//��(release����� ����)
					dto.setColor(combo.getSelectedIndex());
					
					//������ ��ü�� ��̸���Ʈ�� �߰�
					list.add(dto);
					
					//x2, y2�� ��ǥ���� x1, y1���� �Ѱ���
					//������ ��ǥ���� �ٽ� ������ǥ������ �Ѱ������ν� ����ؼ� �׸��� �׷����� ��
					x1T.setText(x2T.getText()); 
					y1T.setText(y2T.getText());
					
				}//if
			}//mouseDragg
		});
		
		//can.setBackground(Color.WHITE);
		
		//2.������ ����
		setBounds(700,300,600,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public String[] getColorlist() {
		return colorlist;
	}



	public void setColorlist(String[] colorlist) {
		this.colorlist = colorlist;
	}

	

	public JTextField getX1T() {
		return x1T;
	}


	public JTextField getY1T() {
		return y1T;
	}


	public JTextField getX2T() {
		return x2T;
	}


	public JTextField getY2T() {
		return y2T;
	}


	public JTextField getZ1T() {
		return z1T;
	}


	public JTextField getZ2T() {
		return z2T;
	}


	public JCheckBox getFill() {
		return fill;
	}


	public JRadioButton getLine() {
		return line;
	}


	public JRadioButton getCircle() {
		return circle;
	}


	public JRadioButton getRect() {
		return rect;
	}


	public JRadioButton getRoundRect() {
		return roundRect;
	}


	public JRadioButton getPen() {
		return pen;
	}


	public JComboBox<String> getCombo() {
		return combo;
	}
	
	public ArrayList<ShapeDTO> getList(){
		return list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == draw) {
			canvas.repaint();
		}
		
	}
	
	public static void main(String[] args) {
		new MsPaintT();
		
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