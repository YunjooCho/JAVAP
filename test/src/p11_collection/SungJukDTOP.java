package p11_collection;

import java.text.DecimalFormat;

public class SungJukDTOP {
	//1.필드 선언
	private int no, kor, eng, math, tot;
	private String name;
	private double avg;
	
	//2.캡슐화
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getEng() {
		return eng;
	}	
	
	public void setMath(int math) {
		this.math = math;
	}
	public int getMath() {
		return math;
	}
	
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getTot() {
		return tot;
	}
	
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getAvg() {
		return avg;
	}
	
	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3.;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		return no + "\t"
		 + name + "\t"
		 + kor + "\t"
		 + eng + "\t"
		 + math + "\t"
		 + tot + "\t"
		 + df.format(avg);
	}
	
//	public int compareTO(SungJukDTOP s) {
//		if(this.tot < s.tot) {
//			return 1;
//		}else if(this.tot > s.tot) {
//			return -1;
//		}else {
//			return 0;
//		}
//	}
	
}
