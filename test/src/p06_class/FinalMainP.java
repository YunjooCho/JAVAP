package p06_class;

public class FinalMainP {
	public final String FRUIT = "���";
	public final String FRUIT2;
	
	public static final String ANIMAL = "����";
	public static final String ANIMAL2;
	public final String ANIMAL3 = "�����";
	
	public FinalMainP() { //static�� ������� ���� �ʵ忡 ���ؼ��� �����ڷ� �ʱ�ȭ
		FRUIT2 = "����";
		//ANIMAL2 = "�⸰"; - error : ���̳� �ʵ���  ANIMALS2�� �Ҵ��� �� �����ϴ�,
	}
	
	static {
		ANIMAL2 = "�⸰";//static�� ����� ������ �ʱ�ȭ
	}
	
	public static void main(String[] args) {
		final int AGE = 10;
		//AGE++; - error! final�� ����� ��� ���� ���� �� ����
		System.out.println("��� = " + AGE);
		
		final int AGE2;
		AGE2 = 20; //ó�� �ʱ�ȭ
		//AGE2 = 30; - �̹� ���� �Ҵ�Ǿ� �ִ� ����� �� ������ �Ұ���

		FinalMainP fm = new FinalMainP();
		System.out.println("FRUIT = " + fm.FRUIT);
		System.out.println("FRUIT2 = " + fm.FRUIT2);
		
		System.out.println("ANIMAL = " + FinalMainP.ANIMAL);
		System.out.println("ANIMAL2 = " + ANIMAL2);
		System.out.println("ANIMAL3 = " + fm.ANIMAL3);
	}

}
