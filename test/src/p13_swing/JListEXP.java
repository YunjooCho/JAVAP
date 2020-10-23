package p13_swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListEXP extends JFrame{
	
	public JListEXP() {
		super("JLIst Test");
		setLayout(new FlowLayout());
		
		//3.���� ����Ʈ�� ����
		String[] listData = {"Hong", "Gil", "Dong", "JAVA", "JSP"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list2 = new JList<String>(model); //�𵨷� Jlist����
		model.addElement("���");
		model.addElement("��");
		model.addElement("����");
		model.addElement("�ٳ���");
		list2.setSelectedIndex(3);
		
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("�౸");
		vListData.add("�߱�");
		vListData.add("��");
		vListData.add("�豸");
		vListData.add("�״Ͻ�");
		vListData.add("����");
		vListData.add("����");
		vListData.add("�±ǵ�");
		vListData.add("����");
		
		class Student{
			String id;
			String name;
			String department;
			public Student(String id, String name, String department) {
				this.id = id;
				this.name = name;
				this.department = department;
			}
			
			@Override
			public String toString() {
				return name;
			}
			
		}
		
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		list4.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		DefaultListModel<Student> model2 = (DefaultListModel<Student>) list4.getModel();
		
		model2.addElement(new Student("100","ȫ�浿", "�����"));
		model2.addElement(new Student("200","�տ���", "�����"));
		model2.addElement(new Student("300","�����", "����"));
		model2.addElement(new Student("400","���Ȱ�", "�濵�а�"));
		
		add(list1);
		add(list2);
		add(scroll);
		add(list4);
		
		//2.������ ����
		setBounds(800, 200, 400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JListEXP();

	}

}
