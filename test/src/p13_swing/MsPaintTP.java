package p13_swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MsPaintTP extends JFrame implements ActionListener {
	
	//1.필드선언
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private String[] color;
	private JButton draw;
	private ArrayList<ShapeDTOP> list;
	private DrCanvasP canvas;
	
	
	
	public MsPaintTP() {
		super("그림 그리기");
		//3.컴포넌트 생성
		x1L = new JLabel("X1");
		y1L = new JLabel("Y1");
		x2L = new JLabel("X2");
		y2L = new JLabel("Y2");
		z1L = new JLabel("Z1");
		z2L = new JLabel("Z2");
		
		x1T = new JTextField("0", 4);
		y1T = new JTextField("0", 4);
		x2T = new JTextField("0", 4);
		y2T = new JTextField("0", 4);
		z1T = new JTextField("50", 4);
		z2T = new JTextField("50", 4);
		fill = new JCheckBox("채우기");
		
		line = new JRadioButton("선");
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형",true); //true - 기본값으로 설정
		roundRect = new JRadioButton("둥근 사각형");
		pen = new JRadioButton("연필");
		
		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		
		color = new String[] {"빨강","초록","파랑","보라","하늘"};
		combo = new JComboBox<String>(color);
		draw = new JButton("그리기");
		
		
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
		p1.add(fill);
		
		JPanel p2 = new JPanel();
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);
		
		canvas = new DrCanvasP(this);
		
		Container c = this.getContentPane();
		c.add("North", p1);
		c.add("South", p2);
		c.add("Center",canvas);
		
		//이벤트
		draw.addActionListener(this);
		
		list =  new ArrayList<ShapeDTOP>();
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX() + "");
				y1T.setText(e.getY() + "");
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(x2T.getText().equals("0") && y2T.getText().equals("0")) return;
				ShapeDTOP dto = new ShapeDTOP();
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));
				
				if(fill.isSelected()) dto.setFill(true);
				else dto.setFill(false);
				
				if(line.isSelected()) dto.setShape(Figure.LINE);
				else if(circle.isSelected()) dto.setShape(Figure.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Figure.RECT);
				else if(roundRect.isSelected()) dto.setShape(Figure.ROUND_RECT);
				
				dto.setColor(combo.getSelectedIndex());
				list.add(dto);
				System.out.println("list의 개수 : " + list.size());
			}
		});
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");
				canvas.repaint();
				
				//펜기능
				if(pen.isSelected()) {
					ShapeDTOP dto = new ShapeDTOP();
					
					dto.setX1(Integer.parseInt(x1T.getText()));
					dto.setY1(Integer.parseInt(y1T.getText()));
					dto.setX2(Integer.parseInt(x2T.getText()));
					dto.setY2(Integer.parseInt(y2T.getText()));
					dto.setZ1(Integer.parseInt(z1T.getText()));
					dto.setZ2(Integer.parseInt(z2T.getText()));
					
					if(fill.isSelected()) dto.setFill(true);
					else dto.setFill(false);
					
					dto.setShape(Figure.PEN); 
					
					dto.setColor(combo.getSelectedIndex());
					
					list.add(dto);
					
					x1T.setText(x2T.getText());
					y1T.setText(y2T.getText());
				}
			}
		});
		
		
		//2.프레임 생성
		setBounds(700, 300, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
	}

	public String[] getColorlist() {
		return color;
	}



	public void setColorlist(String[] color) {
		this.color = color;
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
	
	public ArrayList<ShapeDTOP> getList(){
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == draw) {
			canvas.repaint();
		}
		
	}
	
	public static void main(String[] args) {
		new MsPaintTP();
	}

}
