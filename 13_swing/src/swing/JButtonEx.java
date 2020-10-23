package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

//ī�� ������ ����
public class JButtonEx extends JFrame {
	//1.�ʵ弱��
	private Icon icon1 = new ImageIcon("image/jindo.jpg");
	private Icon icon2 = new ImageIcon("image/liver.jpg");
	private Icon icon3 = new ImageIcon("image/poodle.jpg");
	private Icon icon4 = new ImageIcon("image/shizu.jpg");
	
	private JRadioButton[] jb = new JRadioButton[4]; //�������� �׸� �� �ϳ��� ������ �� �ֵ��� �ϱ� ���� ��ư
	private ButtonGroup bg = new ButtonGroup();		 //ButtonGroup ��ư�� ������ �����ֱ� ���� ��
	
	//�ڴ��ϰ�ü, 4�� �̻��� �迭��ü�ε� �������� ������� ��ġ�Ǵ� ������ Ȯ��
	public JButtonEx() {
		super("Test");//������ â �̸�ǥ��
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i = 0; i < jb.length; i++) {
			jb[i] = new JRadioButton(i + 1 + "�� ��ư" , icon1); //�⺻ȭ������ icon1�� ��
			con.add(jb[i]); 
			jb[i].setToolTipText(i + 1 + "��° ��ư�̴�. ����....");
			jb[i].setMnemonic(i+49);//����Ű
			jb[i].setRolloverIcon(icon2); //���Ʒ��� �Ҷ� ��µǴ� �׸� liver
			jb[i].setPressedIcon(icon3);  //������ ��µǴ� �׸�          poodle
			jb[i].setSelectedIcon(icon4); //����(�Ǿ� �ִ� ���¿��� Ŭ��)�ϸ� ��µǴ� �׸� shizu
			bg.add(jb[i]);
		}
		
		pack();//â�� ũ�⸦ �˸°� �����ִ�(���⼭�� ������ ����� �°� �����ص�) �޼ҵ�
			   //setBouns���
		setVisible(true); //�������� �ִµ�(setVisible) ũ�⸦ ������ ���� �ͻ�, ũ��� ÷���� ������ ũ�⿡ ���� �ڵ����� ������ - ũ�Ⱑ ����ȭ �� ��
	}
	
	
	public static void main(String[] args) {
		new JButtonEx();

	}

}


//���� ��ü?������?�� ���� ������ ���
//���̸���Ʈ�� ���

//Tooltip : ���콺 ���ٴ�� �޽���ǳ�� ������ �ߴ°�
//Mnemonic : ����Ű
//