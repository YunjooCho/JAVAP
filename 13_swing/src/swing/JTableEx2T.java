package swing;

import java.awt.Container;
import java.awt.FlowLayout;
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
public class JTableEx2T extends JFrame implements ActionListener {
	//4.��̸���Ʈ ����
	//6.���ͻ���
	private ArrayList<PersonDTO> list;	
	private Vector<String> vector;
	private DefaultTableModel model; //AbstractTableModel ����, AbstractTableModel�� �߻�޼ҵ��� �������̵��� �ʿ�
	private JTable table; 			 //AbstractTableModel ����
	private JButton insertBtn, deleteBtn;
	private int count;
	
	//list - dto�� ��Ƴ���
	//vector - list�� �����ӿ� �ø��� �����Ƿ� vector�� �ű�
	//�׷��Ƿ� ���� list�� �߰� Ȥ�� ���� �̺�Ʈ�� �߻���, ���������� �ݿ��ؾ���(�׷��� �ٸ� �Լ����� ����� �Ҷ� ����� ������ �ݿ��Ǽ� ����)
	
	public JTableEx2T() {
		
		//5.�������Է�
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTO("hong2","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTO("hong3","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTO("conan","�ڳ�","333","010-777-7777"));
		
		//7.Ÿ��Ʋ
		vector = new Vector<String>();
		vector.addElement("���̵�"); 
		//add()�� addelement()�� ���� : 
		//�ϴ� ���� �ΰ��� �� ������ �����մϴ�. �� �޽�� �� ���� ��ü�� ���� sync �� ����ϴ�.
		//�ٸ� addElement �� ���Ϳ��� �ִ� API ���̰� add �� JDK 1.2 �� �߰��� Collection �������̽��� ������ ������ 
		//add �� ���� ���� �Ϲ������� �� ���� �����̶�� �� �� �ְڽ��ϴ�. 
		//������ JDK 1.1 ���� ���ư��� ���ø��� ���� �����̽ö�� addElement �� ���� �� �ۿ� ������.
		//Collection �� add �� ������Ʈ�� �߰� �۾��� ���� ���θ� boolean ���� �����մϴ�(vector �� ��� �׻� true). 
		//addElement �� ���� ���ϰ��� �����ϴ�.
		vector.addElement("�̸�");
		vector.add("��й�ȣ"); //true��ȯ - �� ��������
		vector.add("�ڵ���");  //true��ȯ - �� ��������
		
		
		//8.���̺� ����
		model = new DefaultTableModel(vector, 0) { //AbstractTableModel�� �ٸ� �޼ҵ�(���� ����)
			//0��� 1�� ������ ĭ�� �ϳ� ����, ����������, celleditable�� ����ϱ� ���� �͸���Ŭ���� ����
			@Override
			public boolean isCellEditable(int r, int c) { //row, column
				return (c!=0)? true : false; //������ �� �ִ� ����, 0��° id�� ���� ���� ������ �� ���� ����
											 //0�� �ƴ϶�� ���� ����(true), 0�̸� ���� �Ұ�(false)
			}
		}; 
		table = new JTable(model); //���� �����ϰ� ���̺� ����(?)
		JScrollPane scroll = new JScrollPane(table);//��ũ�տ� ���̺� ����
		
		//9.������ ���̱�
		//��ü�� ����ִ� ��̸���Ʈ�� �����ӿ� ���� �� �����Ƿ� ��̸���Ʈ�� ��ü�� ���Ϳ� �ű� �� �����ӿ� ����
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>(); //�ں����� �ڷ� ���� ����... ��ü, �迭�� ����
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
		
		
		Container c = this.getContentPane(); //�ǳڰ� ��ũ��(���̺��� �پ�����)�� �����̳ʿ� ����
		c.add("South", p);
		c.add("Center",scroll); //���̺��� �پ��ִ� ��ũ���� �����ӿ� ����
		
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
		//���ϰ� : ����ڰ� �Է��� ���ڿ�, ��� ��ư�� ���õǰų� â�� ������ null ����
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		//parameter - parentComponent : the parent Component for the dialog & message : the Object to display
		//ǥ���� ��, ǥ���� �޽���
		if(id == null) {
			return; //���� �޼ҵ带 ��������� ����
		}
		
		if(id.length() == 0) {
			JOptionPane.showMessageDialog(this, "���̵�� �ʼ� �׸��Դϴ�");
			return; //���� �޼ҵ带 ��������� ����
		}
		
		//���ߺ�üũ - ������� ���̵��Դϴ� : 
		 for(int i = 0; i <model.getRowCount() ; i++) {
			 if(id.equals(model.getValueAt(i,0))) { //���� ���̵� �ִ� �κ��� [~~][0]�̹Ƿ� ~~�� i(������ ����ŭ �Ʒ��� �̵�), 0�� ����
				 JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�");
				 return;
			 }
		 }
		 
		 //���̵� �̸�
		 //hong ȫ�浿
		 //conan �ڳ�
		 //angel õ��
		 //hong -> model.getValueAt(0,0)
		 //conan -> model.getValueAt(1,0);
		 //angel -> model.getValueAt(2,0);
		
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		String pwd = JOptionPane.showInputDialog(this, "�н����带 �Է��ϼ���");
		String tel = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���(XXX-XXX-XXXX)");
		
		Vector<String> v = new Vector<String>(); //����Ʈ�� ����ֱ�
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v); //���� �࿡ vector(��ü?)�߰�
		JOptionPane.showMessageDialog(this, "�߰� �Ϸ�");
		
		
		
	}

	//12. �����Լ�
	private void delete() {
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		if(name == null) return;
		for(int i = 0; i < model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))){//1�� �̸��� ����ִ� ��
				model.removeRow(i);
				count++;
				i = -1; //i--;
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
		new JTableEx2T();
		

	}

}
