package class_constructor;

public class ThisTest {
	private String name; //기본값 : 0
	private int age;//기본값 : null

	 public ThisTest() {
		 System.out.println("default 생성자");
		 System.out.println("this = " + this); //클래스의 주소
		 System.out.println();
	 }
	
	 public ThisTest(String name) {
		 System.out.println("ThisTest(String name)");
		 System.out.println("this = " + this); //클래스의 주소
		 this.name = name; // 클래스의 name = 메소드 파라미터의 name;
		 System.out.println();
	 }
	 
	 public ThisTest(int age) {
		 this("코난"); //ThisTest(String name) 생성자를 호출, 맨 윗줄만 가능
		 System.out.println("ThisTest(int age)");
		 System.out.println("this = " + this); //클래스의 주소
		 this.age = age; // 클래스의 name = 메소드 파라미터의 name;
		 System.out.println();
		 
	 }
	 
	public static void main(String[] args) {
		ThisTest aa = new ThisTest();//필드를 사용하기 위해서 생성자가 필요, 기본 생성자(생성자 작성안해도 생김)
		System.out.println("객체aa = " + aa);
		System.out.println("이름 = " + aa.name + "    나이 = " + aa.age);
		System.out.println();
		
		ThisTest bb = new ThisTest("홍길동");
		System.out.println("객체bb = " + bb);
		System.out.println("이름 = " + bb.name + "    나이 = " + bb.age);
		System.out.println();
		
		ThisTest cc = new ThisTest(25);
		System.out.println("객체cc = " + cc);
		System.out.println("이름 = " + cc.name + "    나이 = " + cc.age);
		System.out.println();
		
	}

}
