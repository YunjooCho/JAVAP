package p07_heritance;

class AA{} //부모클래스

class BB extends AA{} //자식클래스


public class instanceOfP {
	public static void main(String[] args) {
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB();
		
		AA aa3 = aa; //생성된 aa3객체에 aa의 주소값을 대입?
		if(aa instanceof AA){
			System.out.println("1.TRUE");
		}else {
			System.out.println("1.FALSE");
		}
		
		AA aa4 = bb; //부모(AA)는 자식클래스(BB)를 참조할 수 있다.
		if(bb instanceof AA) {
			System.out.println("2.TRUE");
		}else {
			System.out.println("2.FALSE");
		}
		
		BB bb2 = (BB)aa2;
		if(aa2 instanceof BB) {
			System.out.println("3.TRUE");
		}else {
			System.out.println("3.FALSE");
		}
		
		if(aa3 instanceof BB) {
			System.out.println("4.TRUE");
		}else {
			System.out.println("4.FALSE");
		}

	}

}
