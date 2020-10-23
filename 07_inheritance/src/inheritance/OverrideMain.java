package inheritance;

class Test{//메뉴판
	int a = 3; //디폴트접근제어자(private바로 위), 필드는 초기값 0을 갖고 있음
	
	public void disp() {
		a += 5; // a = a + 5;
		System.out.println("Test : a = " + a);
	}
}

class Sample extends Test{//메뉴판
	int a = 8; //필드는 오버라이드 개념 없음
	
	@Override
	public void disp() {
		a += 5; // a = a + 5;
		System.out.println("Sample : a = " + a);
	}
}

public class OverrideMain {
	public static void main(String[] args) {
		//생성
		Sample aa = new Sample(); //생성자를 두번 부름(Test기본 생성사 - Sample기본 생성자)
		aa.disp();//Sample클래스의 disp();
		System.out.println("aa : " + aa.a); //자식클래스(Sample) disp()의 a
		System.out.println();
		
		Test bb = new Sample();//다형성 : 부모가 자식클래스를 참조
		bb.disp();//오버라이드가 되었기 때문에 자식메소드(Sample클래스의 disp())가 호출됨
		System.out.println("bb : " + bb.a); 
		//부모클래스(Sample) 필드 a(자식메소드가 호출되어 부모메소드가 실행되지 않은 부모 필드가 호출됨)
		System.out.println();
		
		Test cc = new Test();
		//부모클래스 입장에서는 자식클래스가 무엇인지 얼마나 있는지 알 수 없음
		cc.disp();//그러므로 Test클래스의 메소드가 실행
		System.out.println("cc : " + cc.a); //부모클래스(Test) disp()의 a
		System.out.println();
		
		//Sample dd = bb; -> 형변환 하지 않고는 사용할 수 없음
		//Sample ee = (Sample)cc; -> 형변환하면 문법적으로는 에러가 없으나
		//                           실행 시 에러가 남(instanceof) / 메모리에 아예 잡히지 않음
		
		Sample dd = (Sample)bb; //자식 = (자식)부모
		dd.disp(); //무조건 자식클래스 호출
		System.out.println("dd : " + dd.a);
		System.out.println("bb : " + bb.a);
		//자식클래스(Sample) disp()의 a(43번줄에서 형변환 했기 때문에)
		//bb.a에서 부모클래스 필드가 호출되던 것이 자식클래스 필드호출로 바뀜
		System.out.println();
		
	}
}


//priate < default <  protected      <  public
//클래스       패키지(폴더)   패키지(폴더)       
//      다른패키지 접근X  다른패키지 접근(자식)