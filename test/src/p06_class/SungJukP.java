package p06_class;

public class SungJukP {
	//1.필드명 선언
	private int kor, eng, math, tot;
	private double avg;
	private String name, grade;
	
	//2.생성자
	public SungJukP(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;	
	}
	
	
	//3.메소드
	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3.0;
		
		switch((int)avg / 10){
			case 10:
			case  9: grade = "A";
			         break;
			case  8: grade = "B";
				     break;
			case  7: grade = "C";
					 break;
			case  6: grade = "D";
			         break;
			default : grade = "F";
		}
		
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
