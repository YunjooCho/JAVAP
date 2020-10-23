package day0915;

import java.io.IOException;

public class StudentEx01 {
	public static void main(String[] args) throws IOException {
		//객체를 만들어보자
		
		Student s1 = new Student("김말이", 1, 99, 98, 97);  //파라미터가 있는 생성자
														  //생성자(필드값 초기화), Student클래스는 다른 클래스파일에서 생성함
														  //Student s1 = new Student(); 형태로 기본 사용하고 있지만, 
														  //이번에는 Student파일에 파라미터가 있는 생성자를 만들었기 때문에
									                      //Student클래스에 파라미터가 있는 생성자를 넣으면 에러발생.
														  //파라미터 데이터타입을 보고 생성자를 찾아냄(Student파일)
		s1 = new Student(); //파라미터가 없는 생성자
							//Student s1 = new Student(); 결과, 값이 없어져버림, 파라미터가 있는 생성자의 값이 없어짐
		System.out.printf("이름 : %s, ID : %d, 국어 : %d점, 영어 : %d점, 수학 : %d점\n", s1.getName(), s1.getId(), s1.getKorean(), s1.getEnglish(), s1.getMath());
		//객체의 필드 혹은 메소드를 접근할 때에는
		//접근 연산자 . 을 이욯하면 된다.
		
		s1.setName("조재영"); //()안의 값을 저장 name변수에 저장
		s1.setKorean(100);
		s1.setEnglish(90);
		s1.setMath(91);
		s1.setId(1);
		System.out.printf("이름 : %s, 국어 : %d점, 영어 : %d점, 수학 : %d점\n", s1.getName(), s1.getKorean(), s1.getEnglish(), s1.getMath());
		System.out.printf("%s 학생의 총점 : %d점 평균 : %.2f\n", s1.getName(), s1.calculateSum(), s1.calculateAverage());
		
		Student s2 = new Student("김철수", 2, 90, 90, 90); //파라미터가 있는 생성자(실제로 밑에 set으로 다시 값을 주기때문에 파라미터 없어도됨)
		s2 = new Student();
		s2.setName("김철수");
		s2.setKorean(90);
		s2.setEnglish(90);
		s2.setMath(90);
		s2.setId(2);
		System.out.printf("이름 : %s, 국어 : %d점, 영어 : %d점, 수학 : %d점\n", s2.getName(), s2.getKorean(), s2.getEnglish(), s2.getMath());
		System.out.printf("%s 학생의 총점 : %d점 평균 : %.2f\n", s2.getName(), s2.calculateSum(), s2.calculateAverage());
		//클래스는 Student 하나, 필드값만 바꿔준 것
		
		String str1 = new String();//new String()대신에 null을 넣으면 출력이 되지 않고 에러가 뜸
								   //이 코드는 String str1 = ""; 와 마찬가지로 아무런 값(0)이 없는 스트링 변수로 초기화 한 것이다. 
		                           //다만 좀 더 정석적인 표현이다.
		System.out.println(str1.length());
		
		
		
		
		Student s3 = new Student("abc", 4, 5, 6, 7); //파라미터가 있는 생성자
		Student s4 = new Student("abc", 4, 5, 6, 7);
		
		
		System.out.println();
		System.out.println("-상속&오버라이딩 확인-");
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);
		
		
		System.out.println("s3.equals(s4) : " + s3.equals(s4));
			//이름과 학번이 같으면 같은 데이터라고 정했기 때문에(instanceof) 점수가 틀려도 같다고 나옴
		System.out.println("오버라이딩 전 : false");
		System.out.println("오버라이딩 후 : true");
		
		System.out.println();
		System.out.println("toString() 확인");
		System.out.println(s1);
		System.out.println("s1.getName().matches(\"\\d*\") : " + s1.getName().matches("\\d*"));
		System.out.println("s2.getName().matches(\"\\d*\") : " + s2.getName().matches("\\d*"));
		System.out.println("s1.getName() : " + s1.getName());
		System.out.println("s2.getName() : " + s2.getName());
		//System.out.println("s1.getName().matches(\"\\d*\") : " + s1.getKorean().matches("\\d*")); ->korean은 int형이므로 비교가 안됨
		System.out.println("toString()전 : day0915.Student@4554617c");
		System.out.println("toString()후 : 이름 : 조재영, 학번 : 1, 국어 : 100점, 영어 : 90점, 수학 : 91점");
	
		System.out.println();
		day0910.Ex07Array.main(args);//public이 붙어있으면 호출 가능
		
		
		
	}
}
