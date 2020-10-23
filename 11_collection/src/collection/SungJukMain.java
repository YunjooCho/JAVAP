package collection;

public class SungJukMain {

	public static void main(String[] args) {
		SungJukService service = new SungJukService(); //SungJukService에 정의되어있는 메소드를 호출하기 위해 객체생성
		service.menu(); //SungJukService클래스에 있는 메소드를 호출
		System.out.println("프로그램을 종료합니다");

	}

}
