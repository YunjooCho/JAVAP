package class_constructor;
//캡슐화
//1인분 데이터
public class SungJuk {
	
	final public int SUBJECT_NUMBER = 3;
	
	//1.필드명 선언
	//여기서 static을 쓰면 class에 머물러는 있지만 class소속이 아님
	//메모리영역이 하나만 잡히기때문에(객체가 하나만 있음) 값이 같은 것이 3번 나옴
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private String grade;
	
	//2.생성자
	public SungJuk(String name, int kor, int eng, int math) { //SungJukMain용

		this.name = name;//this : 클래스꺼
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public SungJuk() {
		name = new String();
		kor = 0;
		eng = 0;
		math = 0;
		tot = 0;
		avg = 0;
		grade = new String();
	}

	

	//3.계산메소드
	public void calc() {
		
		tot = kor + eng + math;
		avg = tot / (double)SUBJECT_NUMBER;
		
		switch((int)avg / 10) {
		case 10 :
		case 9 : grade = "A";
				 break;
		case 8 : grade = "B";
		 		 break;
		case 7 : grade = "C";
		 	     break;
		case 6 : grade = "D";
		 	     break;
		default : grade = "F";
		         break;
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public int getTot() {
		return tot;
	}
	
	public double getAvg() {
		return avg;
	}
	
	public String getGrade() {
		return grade;
	}
	
	
	}

//배열  - index(방 번호)
//	  - 동일한 자료형의 모임

//클래스 - 이름(변수명)으로 관리
//     - 다른 자료형을 묶어서 관리 가능