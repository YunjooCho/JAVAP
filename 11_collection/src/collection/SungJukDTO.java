package collection;

import java.text.DecimalFormat;

/*
성적관리 프로그램

1. 번호, 이름, 국어, 영어, 수학점수를 입력하여 총점과 평균을 구하시오
2. 각 기능에 따라 3개의 클래스로 나누어 작성하시오
     SungJukDTO.java - 1인분
     SungJukService.java
     SungJukMain.java - 호출만, 여기는 작성한 내용 이상 수정, 입력이 불필요
3.평균은 소수이하 3째자리까지 출력
  소수이하 자리값이 0이면 출력하지 않는다
  92.000 → 92로 출력하시오
4. 번호는 중복되지않게 입력한다
5. 이름은 중복되어도 됨(중복 되는 경우 다음번호가 할당됨, 똑같은 이름을 입력해보기)

menu()
*****************
   1. 입력  //어려움
   2. 출력
   3. 검색
   4. 삭제  //어려움
   5. 정렬  //내일 강사님이랑 할 예정
   6. 끝
*****************
   번호 : 8
1~6중에 선택하세요

insertArticle()
번호 입력 :
이름 입력 :
국어 입력 :
영어 입력 :
수학 입력 :

printArticle()
번호          이름         국어        영어          수학         총점           평균
15      홍길동        90      92      91      xxx      xx.xxx
30      또치           85      92      100     xxx      xx.xxx

searchArticle()
검색 할 이름 입력 : 코난
찾고자 하는 이름이 없습니다

검색 할 이름 입력 : 홍길동
번호   이름   국어   영어   수학   총점   평균
15      홍길동   90      92      91      xxx      xx.xxx
16      홍길동   89      45      78      xxx      xx.xxx

deleteArticle() - 똑같은 이름이 있으면 해당 이름을 모두 삭제
삭제 할 이름 입력 : 홍길동
데이터를 삭제하였습니다

sortArticle()
1. 이름으로 오름차순
2. 총점으로 내림차순
3. 이전메뉴
 번호 입력 : 

*/
public class SungJukDTO implements Comparable<SungJukDTO>{
	//1.필드 선언
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
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
		avg = tot / 3.0; //avg = tot / 3.; ->이것도 사용가능
	}
	
	//printerArticle에서 출력시 사용
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.###");
		return no + "\t"
			 + name + "\t"
			 + kor + "\t"
			 + eng + "\t"
			 + math + "\t"
			 + tot + "\t"
			 + df.format(avg);
	}
	
	
	//sort함수가 불러서 사용, 누가 큰지 작은지 기준점을 알려주면 sort가 정렬
	public int compareTo(SungJukDTO s) { //Comparator, 필드에 저장된 값과 파라미터(어디서 온 값?), 내림차순
		if(this.tot < s.tot) {
			return 1;
		}else if(this.tot > s.tot) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
