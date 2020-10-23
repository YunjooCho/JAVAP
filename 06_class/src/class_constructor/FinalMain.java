package class_constructor;

public class FinalMain {
	public final String FRUIT = "���"; //���ڿ� ���ͷ�, �������� �޸� ����
	public final String FRUIT2; //�������� �޸� ����
	
	public static final String ANIMAL = "����";//final�� private �Ⱦ�(�������� �� �� �ְ� �ؾ���)
						                      //public static final ���¸� ���� ���� ��� -static������ �޸� ����
	public static final String ANIMAL2;//static������ �޸� ����
	
	static {//static�ʱ�ȭ ���� (static�� ����Ǹ� �� ���������� �ʱ�ȭ �� �� ����)
		ANIMAL2 = "�⸰";
		//FRUIT2 = "��"; -error : Cannot make a static reference to the non-static field FRUIT2
	}
	
	public FinalMain() {
		FRUIT2 = "����"; //static�� �������� ������ �����ڷ� �ʱ�ȭ�� ����
	}
	
	public static void main(String[] args) {
		final int AGE = 10;
		//AGE++; - error : final�� ����� ����� �� ���� ������ �� ����. 
		System.out.println("��� = " + AGE);
		
		final int AGE2;
		AGE2 = 20; //ó�� �ʱ�ȭ
		//AGE2 = 30; - error : The final local variable AGE2 may already have been assigned
		//���̳� ������ ���� AGE2(���)�� �̹� ���� �Ҵ�Ǿ� �ֽ��ϴ�. - �̹� ���� �Ҵ�Ǿ� �ִ� ����� �� ������ �Ұ���(�ʱ�ȭ �� ������ �Ұ���)
		
		FinalMain fm = new FinalMain();//�������� �޸� ����
		System.out.println("FRUIT = " + fm.FRUIT);
		System.out.println("FRUIT2 = " + fm.FRUIT2);
		
		System.out.println("ANIMAL = " + FinalMain.ANIMAL);
		System.out.println("ANMIMAL2 = " + ANIMAL2); 
		//static�� ����Ǿ� ������ �ڱ� �ڽ��� �����̶� Ŭ�������� �� ���� ����
		//static�� ����Ǿ� ���� ������ �տ� ��ü���� �־��־�� ��(���������� �ҷ���)
		//main�޼ҵ� �ȿ����� static�� �ʱ�ȭ�� �̷���� �� ����
	}
	
	
}//class FinalMain
