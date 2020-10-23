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
		
		//3.관리 리스트를 생성
		String[] listData = {"Hong", "Gil", "Dong", "JAVA", "JSP"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list2 = new JList<String>(model); //모델로 Jlist관리
		model.addElement("사과");
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		list2.setSelectedIndex(3);
		
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("축구");
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("육상");
		vListData.add("태권도");
		vListData.add("유도");
		
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
		
		model2.addElement(new Student("100","홍길동", "전산과"));
		model2.addElement(new Student("200","손오공", "건축과"));
		model2.addElement(new Student("300","사오정", "토목과"));
		model2.addElement(new Student("400","저팔계", "경영학과"));
		
		add(list1);
		add(list2);
		add(scroll);
		add(list4);
		
		//2.프레임 생성
		setBounds(800, 200, 400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JListEXP();

	}

}
