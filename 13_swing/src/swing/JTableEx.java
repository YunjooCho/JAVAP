package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


//2. ���̺� �ۼ��� ���� ���ο� Ŭ���� ����, ���
class JTableModel extends AbstractTableModel{ //AbastracTableModel�� �߻�Ŭ����(�뵵 : ���̺� �ۼ�)
	Object[][] data = {{"Nari", "����ġ", new Integer(1234), "����ģ��"},
					   {"One", "������", new Integer(1111), "������"},
					   {"two", "������", new Integer(2222), "�Ϳ�����"},
					   {"three","�ƶ�ġ", new Integer(3333), "���Ƹ� ģ��"}}; //Ʃ��
					   
	String[] name = {"���̵�", "�̸�","��й�ȣ","����"}; //�ʵ�� ��
			
	
	//3.�������̵�(�ݵ�� �������̵��ؾ� ���̺��� ������ �� ����)
	@Override
	public int getRowCount() { //��, �ʼ��� {}���� �Է��ؾ� ��
		return data.length; // ���κ��� Ʃ���� ����
	}

	@Override
	public int getColumnCount() { //��, �ʼ��� {}���� �Է��ؾ� ��
		return name.length; //���̵�, �̸�, ��й�ȣ �� ��
	}

	@Override
	public Object getValueAt(int r, int c) {//�ʼ��� {}���� �Է��ؾ� ��  //row, column
		
		return data[r][c];
	}
	
	@Override
	public String getColumnName(int c) {//column�� ������ŭ(�迭), �Ӽ��� ��������
		return name[c];
	}
	
	@Override
	public boolean isCellEditable(int r, int c) { //row, column
		return (c!=0)? true : false; //������ �� �ִ� ����, 0��°(id)�� ���� ���� ������ �� ���� ����
	}
	
	@Override
	public void setValueAt(Object ob, int r, int c) { //���ϴ� ��ġ�� �����͸� �����ü� ����(2���� �迭�� ��ĭ�� ���� ������)
													  //����, ���� �� ���������� ������ �� ����
		data[r][c] = ob;
	}
	
}


//1.Ŭ���� ���, ������ ����
public class JTableEx extends JFrame {

	JTable table;
	JTableModel model;
	
	
	public JTableEx() {
		model = new JTableModel(); //��ܿ� ���� ���̺� �ۼ� Ŭ������ ����
		table = new JTable(model); //������ ���� ������ �� ���� �޾ƿ��� or ���̺������ ���ÿ� ���� �������� ������ �� ���� (����� ����)
		add(new JScrollPane(table)); //�Ʊ�� ��ũ���� ����, �� �� ��ũ���� ����
									 //������ ��ũ���� �����ϸ鼭 ���̺� ����-
		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();

	}

}
