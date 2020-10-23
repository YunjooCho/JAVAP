package io;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreForm extends JFrame implements ActionListener {
	
	//1.�ʵ弱��
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputB, printB, searchB, rankB, saveB, loadB;
	private DefaultTableModel model;
	private JTable table;
	private Score score;
	
	
	//2.������
	public ScoreForm() {
		
		hakL = new JLabel("�й�");
		nameL = new JLabel("�̸�");
		korL = new JLabel("����");
		engL = new JLabel("����");
		mathL = new JLabel("����");
	
		hakT = new JTextField(21);
		nameT = new JTextField(21);
		korT = new JTextField(21);
		engT = new JTextField(21);
		mathT = new JTextField(21);
		
		inputB = new JButton("�Է�");
		printB = new JButton("���");
		searchB = new JButton("�й����");
		rankB = new JButton("����");
		saveB = new JButton("��������");
		loadB = new JButton("�����б�");
		
		
		Vector<String> attribute = new Vector<String>();
		attribute.add("�й�");
		attribute.add("�̸�");
		attribute.add("����");
		attribute.add("����");
		attribute.add("����");
		attribute.add("����");
		attribute.add("���");
		
		model = new DefaultTableModel(attribute, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column != 0) return true; //�й��� ������ �� ���� ��
				else return false;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		score = new ScoreImpl(); //�ڽ�Ŭ������ ����
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,38));
		p1.add(hakL);
		p1.add(hakT);
	
		p1.add(nameL);
		p1.add(nameT);
		
		p1.add(korL);
		p1.add(korT);
		
		p1.add(engL);
		p1.add(engT);
	
		p1.add(mathL);
		p1.add(mathT);
		
		
		JPanel p3 = new JPanel(new GridLayout());
		p3.add(p1);
		p3.add(scroll);
		
		
		JPanel p2 = new JPanel(new GridLayout(1,6,5,1));
		p2.add(inputB);
		p2.add(printB);
		p2.add(searchB);
		p2.add(rankB);
		p2.add(saveB);
		p2.add(loadB);
				
		
		Container container = this.getContentPane();
		container.add("Center", p3);
		container.add("South", p2);
		
		
		
		
		//<������ Ǯ��>
		//JPanel p1 = new JPanel();
		//p1.add(hakL); p1.add(hakT);
		//JPanel p2 = new JPanel();
		//p2.add(
		
		
		
		
		setBounds(800,300, 600, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//���⼭ �̺�Ʈ ȣ���ص� ��
	}
	
	//�̺�Ʈ ó�� �޼ҵ�
	public void event() { 
		inputB.addActionListener(this);
		printB.addActionListener(this);
		searchB.addActionListener(this);
		rankB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputB) {
			//������
			String hak = hakT.getText();
			String name = nameT.getText();
			int kor = Integer.parseInt(korT.getText().trim());
			int eng = Integer.parseInt(engT.getText().trim());
			int math = Integer.parseInt(mathT.getText().trim());
			
			//ScoreDTO�� �����ϱ�
			ScoreDTO dto = new ScoreDTO();
			dto.setHak(hak);
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMath(math);
			
			//����, ��� ���
			dto.calc();
			
			//������ ����(������) - ��ü ����
			score.input(dto);
			
			
			JOptionPane.showMessageDialog(this, "��� �Ϸ�");
			
			//�ʱ�ȭ
			hakT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
			
		}else if(e.getSource() == printB) {
			score.print(model); //list�� �׸��� ��� ������ JTable�� �Ѹ���
		}else if(e.getSource() == searchB) {
			score.search(model);
		}else if(e.getSource() == rankB) {
			score.tot_desc();//�������� ��������
			score.print(model);
		}else if(e.getSource() == saveB) { 
			score.save();
		}else if(e.getSource() == loadB) {
			score.load();
			score.print(model);
			
		}
		
	}
	
	
}
