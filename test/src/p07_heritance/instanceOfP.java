package p07_heritance;

class AA{} //�θ�Ŭ����

class BB extends AA{} //�ڽ�Ŭ����


public class instanceOfP {
	public static void main(String[] args) {
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB();
		
		AA aa3 = aa; //������ aa3��ü�� aa�� �ּҰ��� ����?
		if(aa instanceof AA){
			System.out.println("1.TRUE");
		}else {
			System.out.println("1.FALSE");
		}
		
		AA aa4 = bb; //�θ�(AA)�� �ڽ�Ŭ����(BB)�� ������ �� �ִ�.
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
