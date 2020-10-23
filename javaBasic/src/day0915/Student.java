package day0915;



public class Student {
	//학생의 필드를 만들어보자
	//필드는 변수처럼
	//우리가 데이터타입 필드이름을 선언해주면 된다.
	
	//학생의 이름
	private String name; //필드 //private이 붙는 순간, StudentEx01.java에서는 접근할 수 없게 됨
	//name에 대한 셋터
	public void setName(String name) {
		this.name = name;//s1, s2가 this가 됨
	}
	//name에 대한 겟터
	public String getName() {
		return name;
	}
		
	//학생의 국어점수
	private int korean;  //필드
	//korean에 대한 셋터
	public void setKorean(int korean) {
		this.korean = korean;
	}
	//korean에 대한 겟터
	public int getKorean() {
		return korean;
	}
	
    //학생의 영어점수
	private int english; //필드
	//english에 대한 셋터
	public void setEnglish(int english) {
		this.english = english;
	}
	//english에 대한 겟터
	public int getEnglish() {
		return english;
	}
	
	//학생의 수학점수
	private int math;    //필드
	//수학점수에 대한 셋터
	public void setMath(int math) {
		this.math = math;
	}
	public int getMath() {
		return math;
	}
	
	//학생의 관리번호
	private int id;      //필드
	//관리번호에 대한 셋터
	public void setId(int id) {
		this.id = id;
	}
	//관리번호에 대한 겟터
	public int getId() {
		return id;
	}


	//메소드를 만들어보자
	//1. 총점을 구하는 메소드
	public int calculateSum() { //위에 변수로 객체 선언이 되어있기 때문에 파라미터가 필요없음, ()가 빈칸
		return korean + english + math;//파라미터를 넣지 않는 대신 여기서 값을 끌어옴
	}
	
	//2. 평균을 구하는 메소드
	public double calculateAverage() {
		return calculateSum() / 3.0;
	}
	
	//파라미터가 있는 생성자(객체 초기화)-생성자명은 클래스명과 동일
	public Student(String name, int id, int korean, int english, int math) {//()안에 들어있는 것들은 파라미터
		//같은 이름이 있을 때
		//파라미터는  필드보다 호출 우선순위가 높다
		//따라서 같은 이름으로 존재할 때 필드를 호출할 때에는
		//명확하게 "해당 객체의 필드"라고 지정해주어야 한다
		//이럴때에는 this.필드로 지정할 수 있다(this가 없을 땐 31번의 ()안 파라미터를 가지고 온것임)
		//즉 this란 이 메소드를 실행하는 클래스의 객체 자신을 가리키게 된다(s1,s2)
		System.out.println();
		System.out.println("파라미터가 있는 생성자");
		this.name = name;
		this.id = id;
		this.korean = korean;
		this.english = english;
		this.math = math;
			
		//name = "abc"; //필드의 name이 아닌 파라미터의 name
		
	}
	
	//파라미터가 없는 생성자
	public Student() {
		
		
		id = -1; //초기화
		korean = -1;//초기화
		english = -1;//초기화
		math = -1;//초기화
		
		name = new String(); //String생성자로 초기화, 아무것도 표기안됨
		//▶ 확인차 내가 입력 name = "가야금";
		
		//System.out.println("파라미터가 없는 생성자 내의 메소드(calculateSum): " + calculateSum()); //생성자 초기화 후 그 생성자가 있는 클래스 내 매소드를 불러올수 있다
	}
	//static keyword는 해당 필드 혹은 메소드를
	//객체생성 없이 곧장 호출할 수 있게 만들어준다.
	//다만 이 스태틱이란 키워드는 해당 메소드를
	//프로그램 실행영역에 강제로 포함시키는 것이기 때문에
	//만약 해당 메소드가 내부에서 다른 메소드나 필드를 사용하게 된다면
	//그 다른 메소드나 필드도 마찬가지로 스태틱을 붙여서
	//실행 역역에 포함시켜주어야 한다.
	//대표적인 예 : Integer.parseInt(br.readLine()); -parseInt메소드, new사용 안함
	
	//equals() 메소드 구현
	//java.lang.Object를 상속받았기 때문에 생기는 문제
	//StudentEx01에서 같은 값을 넣어도 객체비교시(s2.equals(s3)) false가 나오는 문제 해결을 위해 오버라이딩 실시
	public boolean equals(Object obj) { //같은 패키지의 Ex01Class.java참조
		//파라미터로 넘어온 객체가 이 equals메소드를 실행하는 객체와 같은지 비교하려면
		//1. obj가 이 Student 클래스의 객체인지 확인한다
		//2. obj가 Student 클래스의 객체가 맞다면
		//   필드 중 몇몇 정보를 비교해서 같을 때에만
		//   return true 해준다.
		
		//1. obj가 Student클래스객체인지 확인할때에는
		//	 instanceof 클래스이름 이란 코드로 확인 가능하다
		//   instanceof : 해당 클래스의 객체인지 아닌지를 확인하는 예약문
		if(obj instanceof Student) {
			//obj가 CarT 클래스의 객체이므로
			//obj를 카로 형변환 시켜줄 수 있다.
			Student st = (Student)obj; //필드가 없으므로 클래스를 CarT로 바꿔줌(형변환)
			                           //아직 부모클래스이므로 자식클래스에 맞게 오버라이딩
			if(name.equals(st.name) && id == st.id){ //필드와 
				return true;
			}
		}
		return false;
		
	}
	public String toString() { //오버라이딩, 객체 자체에 값은 존재하지만 이상한 형태로 출력
		                       //객체의 필드내용을 스트링({}안의 양식)으로 바꿔줌
		
		return "이름 : "+ name
				+", 학번 : " + id 
				+", 국어 : " + korean + "점"
				+", 영어 : " + english + "점"
				+", 수학 : " + math + "점";
	
	}
	
}
