package p07_heritance;


public class ChildTestP2 extends SuperTestP2{
	 protected String name;
	 protected int age;
	 
	 public ChildTestP2() {
		 System.out.println("ChildTestP2 기본 생성자");
	 }
	 
	 public ChildTestP2(double weight, double height, String name, int age) {
		 super(weight, height); //부모 생성자 호출, 제일 첫째줄
		 System.out.println("ChildTestP2 생성자");
		 //super(weight, height); - error : Constructor call must be the first statement in a constructor
		 this.name = name;
		 this.age = age;
	 }
	 
	 public void disp() {//오버라이드
		 System.out.println("ChildTestP2클래스의 disp()");
		 System.out.println("몸무게 = " + weight);//super등을 선언하지 않아도 부모클래스에 존재하기 때문에 정상작동
		 System.out.println("키 = " + height);
		 System.out.println("이름 = " + name);
		 System.out.println("나이 = " + age);
		 
	 }
	 
	 
	 public static void main(String[] args) {
			ChildTestP2 aa = new ChildTestP2(75.3, 185.5, "홍길동", 25);
			aa.disp(); //자식클래스인 ChildTest에서 먼저 찾음
			System.out.println();
			
			//자식클래스에 부모클래스와 동일한 이름의 메소드(disp())가 있는 경우, 
			//부모클래스의 메소드는 자식클래스에서 호출할 수 없다.
			//static 안에서는 this, super 사용할 수 없다
			
			System.out.println("-----------------------");
			SuperTestP2 bb = new ChildTestP2(35.8, 156.3, "코난", 13);
			bb.disp();
		}
}
