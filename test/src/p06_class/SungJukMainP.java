package p06_class;



/*
클래스명 : SungJuk
필드      : name, kor, eng, math, tot, avg, grade
메소드   : 생성자 
        calc() - 총점, 평균, 학점 계산
        getName()
        getKor()
        getEng()
        getMath()
        getTot()
        getAvg()
        getGrade()
      
[실행결과]
----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동   90      95      100
코난      100     89      75
또치      75      80      48
 */
public class SungJukMainP {
	public static void main(String[] args) {
		SungJuk[] ar = new SungJuk[]{new SungJuk("홍길동", 90, 95, 100),
				 new SungJuk("코난", 100, 89, 75),
				 new SungJuk("또치", 75, 80, 48)};;
		
		 System.out.println("----------------------------------------------------");
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
			System.out.println("----------------------------------------------------");
			for(int i = 0; i < ar.length; i++) {
				ar[i].calc();
				System.out.println(ar[i].getName()+ "\t" 
								   + ar[i].getKor() + "\t" 
								   + ar[i].getEng() + "\t" 
								   + ar[i].getMath() + "\t" 
								   + ar[i].getTot() + "\t" 
								   + String.format("%.2f", ar[i].getAvg()) + "\t"
						                   + ar[i].getGrade());		 
			}//for
	}

}
