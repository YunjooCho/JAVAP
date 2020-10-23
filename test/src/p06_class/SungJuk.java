package p06_class;
/*
Ŭ������ : SungJuk
�ʵ�      : name, kor, eng, math, tot, avg, grade
�޼ҵ�   : ������ 
        calc() - ����, ���, ���� ���
        getName()
        getKor()
        getEng()
        getMath()
        getTot()
        getAvg()
        getGrade()
*/
public class SungJuk {

	//1.�ʵ�� ����
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private char grade;
	final static int SUBJECT_NUMBER = 3;
	
	//2.������
	public SungJuk(String name, int kor, int eng, int math) {
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	//3.��� �޼ҵ�
	public void calc() {
		
		tot = kor + eng + math;
		avg = tot / (double)SUBJECT_NUMBER;
		
		switch((int)avg / 10){
		case 10 : 
		case 9 : grade = 'A';
			     break;
		case 8 : grade = 'B';
			     break;
		case 7 : grade = 'C';
			     break;
		case 6 : grade = 'D';
			     break;
		default : grade = 'F';
			     break;
		}
		
	}
	
	
	//4.�����͸� �������� �޼ҵ�
	
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
	
	public char getGrade(){
		return grade;
	}
}
