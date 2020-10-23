package inheritance;

class AA{} //�θ�Ŭ����

class BB extends AA{} //�ڽ�Ŭ����

public class InstanceOf {
	public static void main(String[] args) {
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB();
		
		//AA aa3 = new AA();
		AA aa3 = aa; //AA aa3 = new AA()�� AA aa3 = aa�� �ٸ� ����, ���� AAŬ����
		if(aa instanceof AA) System.out.println("1.TRUE");
		else System.out.println("1. FALSE");
		//aa - AA, aa3 - AA
		
		AA aa4 = bb; //�θ�� �ڽ�Ŭ������ ������ �� ����(�ڽ� Ŭ�����ȿ� �θ� Ŭ������ ����)
		if(bb instanceof AA) System.out.println("2.TRUE"); 
		//bb�� ���󰡸� AAŬ������ �ִ°�?(AA�� bb�� ����ȯ�� �����Ѱ�?)
		else System.out.println("2.FALSE");
		//aa4 - AA, bb - BB
		
		BB bb2 = (BB)aa2; //'�ڽ� = �θ�' ���� ������ �����Ƿ� '�ڽ� = (�ڽ�)�θ�' �� �ٿ�ĳ����
		if(aa2 instanceof BB)System.out.println("3.TRUE");
		else System.out.println("3.FALSE");
		//bb2 - BB, aa2 - AA -> (BB)
		
		//BB bb3 = (BB)aa3;//error!aa3�� �޸𸮿� AAŬ������ �ְ� BBŬ����(bb3)�� ����
		if(aa3 instanceof BB) System.out.println("4.TRUE");
		else System.out.println("4.FALSE");
		//aa3 - AA -> (BB), bb3 - BB
	}
}

//<instanceof �� Ȯ���ϴ� ��>
//aa�� ����Ű�� ���� Ŭ���� AA�� �ִ���??
//aa�� AA ����ȯ(Casting) �Ǵ���??
//aa�� �ּҰ��� aa3�� ���� �� �ִ���??

