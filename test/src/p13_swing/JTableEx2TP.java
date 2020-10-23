package p13_swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



//1.��� �� ����, �ʵ弱��
public class JTableEx2TP extends JFrame implements ActionListener{
	
	private ArrayList<PersonDTOP> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton insertBtn, deleteBtn;
	private int count;
	
	//2.����
	public JTableEx2TP() {
		list = new ArrayList<PersonDTOP>();
		list.add(new PersonDTOP("hong","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTOP("hong2","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTOP("hong3","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTOP("conan","�ڳ�","333","010-777-7777"));
		
		
		//Ÿ��Ʋ(�ʵ��)
		vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("��ȭ��ȣ");
		
		model = new DefaultTableModel(vector,0) {
			public boolean isCellEditable(int row, int column) {
				return (column != 0) ? true : false;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		for(PersonDTOP dto : list) {
			Vector<String> v = new Vector<String>(); 
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			model.addRow(v);
		}
	
		
		insertBtn = new JButton("�߰�");
		deleteBtn = new JButton("����");
		
		JPanel p = new JPanel();
		p.add(insertBtn);
		p.add(deleteBtn);
		
		Container c = this.getContentPane();
		c.add("South",p);
		c.add("Center",scroll);
		
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		 
		setBounds(200, 200, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame ��������
	}
	
	
	
	
	//3.�������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertBtn) {
			insert();
		}else if(e.getSource() == deleteBtn) {
			delete();
		}
		
	}

	
	private void delete() {
		String name = JOptionPane.showInputDialog(this,"������ �̸��� �Է��ϼ���");
		for(int i = 0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);
				count++;
				i = -1;
			}
		}
		if(count == 0) {
			JOptionPane.showMessageDialog(this, "ã�� �̸��� �����ϴ�");
		}else {
			JOptionPane.showMessageDialog(this,"���� �Ϸ�!");
		}
		
	}


	private void insert() {
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		
		//��ҹ�ư �Ǵ� â�� ������ null
		if(id == null) {
			return;
		}
		if(id.length() == 0) {
			JOptionPane.showMessageDialog(this, "���̵�� �ʼ� �׸��Դϴ�");
			return;
		}
		
		for(int i = 0; i < model.getRowCount(); i++) {
			if(id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�");
				return;
			}
		}
		
		String name = JOptionPane.showInputDialog(this,"�̸��� �Է��ϼ���");
		String pwd = JOptionPane.showInputDialog(this,"��й�ȣ�� �Է��ϼ���");
		String tel = JOptionPane.showInputDialog(this,"��ȭ��ȣ�� �Է��ϼ���");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		JOptionPane.showMessageDialog(this,"�߰��Ϸ�");
	}


	public static void main(String[] args) {
		new JTableEx2TP();

	}

}
