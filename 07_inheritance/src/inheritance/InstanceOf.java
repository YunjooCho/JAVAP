package inheritance;

class AA{} //부모클래스

class BB extends AA{} //자식클래스

public class InstanceOf {
	public static void main(String[] args) {
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB();
		
		//AA aa3 = new AA();
		AA aa3 = aa; //AA aa3 = new AA()와 AA aa3 = aa는 다른 문장, 같은 AA클래스
		if(aa instanceof AA) System.out.println("1.TRUE");
		else System.out.println("1. FALSE");
		//aa - AA, aa3 - AA
		
		AA aa4 = bb; //부모는 자식클래스를 참조할 수 있음(자식 클래스안에 부모 클래스가 존재)
		if(bb instanceof AA) System.out.println("2.TRUE"); 
		//bb를 따라가면 AA클래스가 있는가?(AA는 bb로 형변환이 가능한가?)
		else System.out.println("2.FALSE");
		//aa4 - AA, bb - BB
		
		BB bb2 = (BB)aa2; //'자식 = 부모' 직접 받을수 없으므로 '자식 = (자식)부모' 로 다운캐스팅
		if(aa2 instanceof BB)System.out.println("3.TRUE");
		else System.out.println("3.FALSE");
		//bb2 - BB, aa2 - AA -> (BB)
		
		//BB bb3 = (BB)aa3;//error!aa3의 메모리에 AA클래스만 있고 BB클래스(bb3)는 없음
		if(aa3 instanceof BB) System.out.println("4.TRUE");
		else System.out.println("4.FALSE");
		//aa3 - AA -> (BB), bb3 - BB
	}
}

//<instanceof 로 확인하는 것>
//aa가 가리키는 곳에 클래스 AA가 있느냐??
//aa가 AA 형변환(Casting) 되느냐??
//aa의 주소값을 aa3이 받을 수 있느냐??

