package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

//항목의 나열
//1.상속
public class JListEx extends JFrame {

	public JListEx() {
		
		//1. 타이틀
		super("JList Test");
		setLayout(new FlowLayout()); //왼쪽부터 하나씩 리스트 추가 
		
		//3.관리 리스트들 생성
		//String배열을 리스트에 추가
		String[] listData = {"Hong", "Gil", "Dong", "JAVA","JSP"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1); //[1]의 항목을 선택
		
//=============================================================================================
		
		//model로 Jlist관리
		DefaultListModel<String> model = new DefaultListModel<String>(); //model에 입력
		JList<String> list2 = new JList<String>(model); //모델로 JList관리
		model.addElement("사과");
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		list2.setSelectedIndex(1);
		
//=============================================================================================
		
		//vector, scroll 사용
		Vector<String> vListData = new Vector<String>(); //Jlist에 Vector를 붙임
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3); //scroll에 Jlist(Vector가 붙은)를 붙임
		vListData.add("축구");
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("육상");
		vListData.add("태권도");
		vListData.add("유도");
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
	    //리스트를 만들면서 모델생성, 모델값은 getModel을 통해 가져옴(리스트2번은 순차적으로 진행)
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		//SINGLE_SELECTION : 하나만 선택 / 아니면 좌르륵 선택됨
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		//DefaultListModel이 자식클래스
		//부모클래스인 JList에 담겨있던 모델을 자식클래스로 옮김(형변환) 
		model2.addElement(new Student("100","홍길동", "전산과"));
		model2.addElement(new Student("200","손오공", "건축과"));
		model2.addElement(new Student("300","사오정", "토목과"));
		model2.addElement(new Student("400","저팔계", "경영학과")); //주소값이 잡히므로  toString오버라이딩 필요
		                                                        
		

		//프레임에 붙이기
		add(list1);
		add(list2);
		add(scroll); //스크롤 위에 list를 붙이기 때문에 바탕이 되는 스크롤을 불러줘야 함
		add(list4);
		
		
		//2. 프레임 생성
		setBounds(800, 200, 400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JListEx();

	}

}


//model : 내부관리
//Jlist : 출력