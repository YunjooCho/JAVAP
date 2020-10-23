package p13_swing;

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

public class SwingTestP extends JFrame implements ActionListener {
	
	//1.��������
	private JButton newBtn, exitBtn;
	private JTextArea area;
	
	public SwingTestP() {
		newBtn = new JButton("�� ����", new ImageIcon("image/crab.gif"));
		exitBtn = new JButton("����");
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);
		
		JPanel p = new JPanel();
		p.add(newBtn);
		p.add(exitBtn);
		
		Container c = this.getContentPane();
		c.add("North",p);
		c.add("Center",scroll);
		
		//�̺�Ʈ
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		setBounds(700, 100, 300, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(SwingTestP.this, "������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result == 0) System.exit(0);
			}
		});
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newBtn) {
			area.setText("");
		}else if(e.getSource() == exitBtn) {
			int result = JOptionPane.showConfirmDialog(this,"������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == 0) {
				System.exit(0);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new SwingTestP();

	}

}
