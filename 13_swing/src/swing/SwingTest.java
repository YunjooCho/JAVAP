package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Swing�� �̿��Ͽ� â �����
public class SwingTest extends JFrame implements ActionListener { //�θ� Frame�̶� Frame�� ��ɵ� ������ ����
	private JButton newBtn, exitBtn;
	private JTextArea area; //TextField�� �� ��, ���� ���� �߻���ų�� TextArea
	
	public SwingTest() {
		//newBtn = new JButton("���� �����");
		//JButton�� ������ Icon�� �������̽�
		//Icon�������̽��� ������ Ŭ���� : ImageIcon
		//ImageIcon�� ���� ����
		newBtn = new JButton("������", new ImageIcon("image/crab.gif"));
		exitBtn = new JButton("����");
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area); //��ũ�ѿ� TextArea�� �ٿ� �����ӿ� �÷���
		
		JPanel p = new JPanel();
		p.add(newBtn);
		p.add(exitBtn);
		
		
		Container c = this.getContentPane(); //��� ȭ���� �޶����� ���� �ƴ����� ���������� �����̳ʿ� �ѹ� ����־� Component���� ��ȣ
		c.add("North", p); //�ڡڡڡ������̳� ���� ���� ã�ƺ���(�ΰ�)
		//add("Center", area);
		c.add("Center", scroll); 
		
		//�̺�Ʈ
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		//this.addWindowListener(this);
		
		setBounds(700, 100, 300, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // swing������ �Ʒ� �ڵ尡 �ƴ� �� �޼ҵ带 �̿��Ͽ� â�� �����Ŵ
		           								       // ���߿� ä�ÿ��� ���濡�Ե� ���Ḧ �˸��� WindowLister���
													   // ���⸦ DO_NOTHING_ON_CLOSE�� �ٲ����μ� 56������ �ڵ尡 ���� - WindowListener���� ������ ��
													   // �� �κ��� ������ �� â�� ����� �� ó�� �������� ����� â�� ������ ���̴�(����Ʈ���� HIDE��)
													   // ���� �̺κ��� �ٲ����� ������ ���� ����� ���� �ƴ�
		
		//swing���� �Ʒ� �ڵ带 �Է����� �ʾƵ� x�� ������ â�� �����µ� ����� ���� �ƴ� â�� ���� ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(SwingTest.this, "������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				                                           //���⼭ this�� ������ �͸�Ŭ������ ����Ű�Ƿ�, SwingTest.�� �־� �־�� error�� ���� �ʴ´�
				if(result == 0) System.exit(0); //0�� ��
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newBtn) {
			//area.setText(" "); - swing�� �ʿ����
			area.setText("");
			
		}else if(e.getSource() == exitBtn) {
			//System.exit(0);
			int result = JOptionPane.showConfirmDialog(this, "������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); //this -> JFRAME
													  //�͸�Ŭ������ �����Ƿ� ���⼭�� this�� �ᵵ ��
			//���Ǹ� ���ϴ� �޼ҵ�
			/*
			Parameters:
				parentComponent - determines the Frame in which the dialog is displayed; if null, or if the parentComponent has no Frame, a default Frame is used.
				��� ���� �����ϴ���(�����ϴ� ���)
				message - the Object to display
				�޽���
				title - the title string for the dialog
				��ȭ������ Ÿ��Ʋ
				optionType - an integer designating the options available on the dialog: YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION
				��ư ����
				messageType - an integer designating the kind of message this is; primarily used to determine the icon from the pluggable Look and Feel: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE
				ǥ���� ������
				Returns: - �������� return��
				an integer indicating the option selected by the user
				
		   */
			if(result == 0) {
				System.exit(0);
			}
			
		}
	}
	
	public static void main(String[] args) {
		new SwingTest();
	}

}

//awt�� �����ϱ� ���� ��κ� J��� �ձ��ڸ� �߰�
//Ȯ����Ű���� �ʿ��ϱ� ������ javax���
//Frame�� Component�� ��ȣ���� �ʰ� �ٷ� �ø�
//JFrame�� ���� �ȿ� Component�� ���� - Component��ȣ 


//setDefaultCloseOperation
//DO_NOTHING_ON_CLOSE (defined in WindowConstants)
// : Don't do anything; require the program to handle the operation in the windowClosing method of a registered WindowListener object.
//HIDE_ON_CLOSE (defined in WindowConstants) - â�� ����
// : Automatically hide the frame after invoking any registered WindowListener objects.
//DISPOSE_ON_CLOSE (defined in WindowConstants) - ����ó��(���� ��)
// : Automatically hide and dispose the frame after invoking any registered WindowListener objects.
//EXIT_ON_CLOSE (defined in JFrame) - ���� ����
// : Exit the application using the System exit method. Use this only in applications.
