package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


//1.��� �� ����
public class JTableEx2 extends JFrame implements ActionListener {
	//4.��̸���Ʈ ����
	//6.���ͻ���
	private ArrayList<PersonDTO> list;	//������ ����
	private Vector<String> vector;      //�ʵ�� ����
	private DefaultTableModel model; //AbstractTableModel ����, AbstractTableModel�� �߻�޼ҵ��� �������̵��� �ʿ�
	private JTable table; 			 //AbstractTableModel ����
	private JButton insertBtn, deleteBtn;
	private int count = 0;
	
	public JTableEx2() {
		
		//5.�������Է�
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTO("conan","�ڳ�","333","010-777-7777"));
		
		//7.Ÿ��Ʋ
		vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���");
		
		
		//8.
		model = new DefaultTableModel(vector, 0) {//0��� 1�� ������ ĭ�� �ϳ� ����, ����������, celleditable�� ����ϱ� ���� �͸���Ŭ���� ����
			@Override
			public boolean isCellEditable(int r, int c) { //row, column
				return (c!=0)? true : false; //������ �� �ִ� ����, 0��° id�� ���� ���� ������ �� ���� ����
			}
		}; 
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		//9.������ ���̱�
		//��ü�� ����ִ� ��̸���Ʈ�� �����ӿ� ���� �� �����Ƿ� ��̸���Ʈ�� ��ü�� ���Ϳ� �ű� �� �����ӿ� ����
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>(); //�ں����� �ڷ� ���� ����... ��ü?, �Ϸķ� �ڷ� ��?
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			
			model.addRow(v); //������� �����͸� ����
		}
		
		//10.��ư ����
		insertBtn = new JButton("�߰�");
		deleteBtn = new JButton("����");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //������(ǥ��� ���� ����)
		p.add(insertBtn);
		p.add(deleteBtn);
		
		
		Container c = this.getContentPane();
		c.add("South", p);
		c.add("Center",scroll);
		
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		 
		setBounds(200, 200, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame ��������
	}
	
	
	//2. �������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertBtn) { //������Ƿ� �Լ��� ����
			insert();
		}else if(e.getSource() == deleteBtn) {
			delete();
		}
		
	}
	
	//11. �Է��Լ�
	private void insert() {
		
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		if(id == null || id.length() == 0) {
			JOptionPane.showMessageDialog(this, "���̵�� �ʼ� �׸��Դϴ�");
			return; //���� �޼ҵ带 ��������� ����
		}
		
		//���ߺ�üũ - ������� ���̵��Դϴ�
		for(int i = 0; i < list.size(); i++) {
			if(id.equals(list.get(i).getId())) {
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�");
				return;
				//id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
				//���⿡ �̰� ������ ó������ �޽����� �߰� �Է��� �ȵɻ�, �� �������� �Է��� ��������
			}
		}
		
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		String pwd = JOptionPane.showInputDialog(this, "�н����带 �Է��ϼ���");
		String tel = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���(XXX-XXX-XXXX)");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		JOptionPane.showMessageDialog(this, "�߰� �Ϸ�");
		
		
		
	}

	//��12. �����Լ�
	private void delete() {
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
//		Iterator<PersonDTO> it = list.iterator();
//		while(it.hasNext()) {
//			PersonDTO dto = it.next();
//			if(dto.getName().equals(name)) {
//				count++;
//				int index = count;
//				model.removeRow(index);
//				
//				
//			}
//		   	//��2���̻��϶� ������ �ȵ�
			for(int i = 0; i < list.size(); i++) {
				if(name.equals(list.get(i).getName())) {
					//System.out.println("�ֵ�");
					model.removeRow(i);
					count++;
				}
			}
			if(count == 0) {
				JOptionPane.showMessageDialog(this, "���� �̸��Դϴ�");
			}else {
				JOptionPane.showMessageDialog(this, "���� �Ϸ�");
			}
			
			
		
		
		
		
		
		//�����Ϸ�
		//���� �̸��Դϴ�
		//�� �� �ϳ��� ��
		//�����̸��� ������ �Ѵ� �����
		//���̺� �����ϸ� �ε����� �ٲ�(������ �����)
	}


	
	
	
	//3. PersonDTO����
	
	
	public static void main(String[] args) {
		new JTableEx2();
		

	}

}
