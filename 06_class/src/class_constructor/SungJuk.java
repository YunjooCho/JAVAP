package class_constructor;
//ĸ��ȭ
//1�κ� ������
public class SungJuk {
	
	final public int SUBJECT_NUMBER = 3;
	
	//1.�ʵ�� ����
	//���⼭ static�� ���� class�� �ӹ����� ������ class�Ҽ��� �ƴ�
	//�޸𸮿����� �ϳ��� �����⶧����(��ü�� �ϳ��� ����) ���� ���� ���� 3�� ����
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private String grade;
	
	//2.������
	public SungJuk(String name, int kor, int eng, int math) { //SungJukMain��

		this.name = name;//this : Ŭ������
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

	

	//3.���޼ҵ�
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

//�迭  - index(�� ��ȣ)
//	  - ������ �ڷ����� ����

//Ŭ���� - �̸�(������)���� ����
//     - �ٸ� �ڷ����� ��� ���� ����