package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

//�׸��� ����
//1.���
public class JListEx extends JFrame {

	public JListEx() {
		
		//1. Ÿ��Ʋ
		super("JList Test");
		setLayout(new FlowLayout()); //���ʺ��� �ϳ��� ����Ʈ �߰� 
		
		//3.���� ����Ʈ�� ����
		//String�迭�� ����Ʈ�� �߰�
		String[] listData = {"Hong", "Gil", "Dong", "JAVA","JSP"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1); //[1]�� �׸��� ����
		
//=============================================================================================
		
		//model�� Jlist����
		DefaultListModel<String> model = new DefaultListModel<String>(); //model�� �Է�
		JList<String> list2 = new JList<String>(model); //�𵨷� JList����
		model.addElement("���");
		model.addElement("��");
		model.addElement("����");
		model.addElement("�ٳ���");
		list2.setSelectedIndex(1);
		
//=============================================================================================
		
		//vector, scroll ���
		Vector<String> vListData = new Vector<String>(); //Jlist�� Vector�� ����
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3); //scroll�� Jlist(Vector�� ����)�� ����
		vListData.add("�౸");
		vListData.add("�߱�");
		vListData.add("��");
		vListData.add("�豸");
		vListData.add("�״Ͻ�");
		vListData.add("����");
		vListData.add("����");
		vListData.add("�±ǵ�");
		vListData.add("����");
		list3.setSelectedIndex(1);
		
//=============================================================================================
		
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
	    //����Ʈ�� ����鼭 �𵨻���, �𵨰��� getModel�� ���� ������(����Ʈ2���� ���������� ����)
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		//SINGLE_SELECTION : �ϳ��� ���� / �ƴϸ� �¸��� ���õ�
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		//DefaultListModel�� �ڽ�Ŭ����
		//�θ�Ŭ������ JList�� ����ִ� ���� �ڽ�Ŭ������ �ű�(����ȯ) 
		model2.addElement(new Student("100","ȫ�浿", "�����"));
		model2.addElement(new Student("200","�տ���", "�����"));
		model2.addElement(new Student("300","�����", "����"));
		model2.addElement(new Student("400","���Ȱ�", "�濵�а�")); //�ּҰ��� �����Ƿ�  toString�������̵� �ʿ�
		                                                        
		

		//�����ӿ� ���̱�
		add(list1);
		add(list2);
		add(scroll); //��ũ�� ���� list�� ���̱� ������ ������ �Ǵ� ��ũ���� �ҷ���� ��
		add(list4);
		
		
		//2. ������ ����
		setBounds(800, 200, 400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JListEx();

	}

}


//model : ���ΰ���
//Jlist : ���