package method;

public class MethodTest2 {
	public void disp(){//구현(내가 만듦) , 입력, void - 나가는 결과물이 없음
					   //new 필요함
		System.out.println("non-static method");
	}
	
	public static void output() {//구현 
								 //언제든지 사용가능(new 필요없음)
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		//호출
		MethodTest2.output();
		output(); //클래스 메소드(static)로 MethodTest2 구역 안이므로 클래스명 안써도 됨
		System.out.println();
		
		MethodTest2 m = new MethodTest2();
		m.disp();
		//System.out.prinltn(MethodTest2.m);
		//new MethodTest2().disp(); - 1회성이므로 사용안하는게 좋음
	}

}//MethodTest2 구역

//모든 메소드는 반드시 호출한 곳으로 되돌아 와야한다
//(main안 함수 -> static void output()으로 감 -> 메인으로 되돌아옴)
