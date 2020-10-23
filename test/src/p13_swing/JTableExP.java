package p13_swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


//2.���̺� �ۼ��� ���� ���ο� Ŭ���� ����, ���
class JTableModelP extends AbstractTableModel{

	Object[][] data = {{"Nari", "����ġ", new Integer(1234), "����ģ��"},
			   {"One", "������", new Integer(1111), "������"},
			   {"two", "������", new Integer(2222), "�Ϳ�����"},
			   {"three","�ƶ�ġ", new Integer(3333), "���Ƹ� ģ��"}}; //Ʃ��
	
	String[] name = {"���̵�", "�̸�","��й�ȣ","����"}; //�ʵ�� ��
	
	
	//3.�������̵�(�ݵ�� �������̵��ؾ� ���̺��� ���� �� ����)
	@Override
	public int getRowCount() {//��, �ʼ��� �Է�
		return data.length;
	}

	@Override
	public int getColumnCount() {//��, �ʼ��� �Է�
		return name.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {//�ʼ��� �Է�
		return data[rowIndex][columnIndex];
	}
	
	
	public String getColumnName(int column) {
		return name[column];
	}
	
	public boolean isCellEditable(int row, int column) {
		return (column != 0)? true : false;
	}
	
	public void setValueAt(Object ob, int row, int column) {
		data[row][column] = ob;
	}
}


public class JTableExP extends JFrame {
	
	//1.Ŭ���� ���, ������ ����
	JTable table;
	JTableModelP model;
	
	public JTableExP() {
		model = new JTableModelP(); //���̺� �ۼ� Ŭ���� ����
		table = new JTable(model); //������ ���� ������ �� ���� �޾ƿ���, ���̺� ������ ���ÿ� ���� �������� ������ �� ����
		add(new JScrollPane(table)); //��ũ���� �����ϸ鼭 ���̺� ����
		
		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableExP();

	}

}
