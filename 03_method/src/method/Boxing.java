package method;

public class Boxing {

	public static void main(String[] args) {
		int a = 25;
		double b = (double)a / 3; //��������ȯ / �ڵ�����ȯ, Casting, Cast����
		
		
		int c = 5;
		Integer d = c; 
		// Integer ��ü = int �⺻�� ->JDK 5.0 �̻���� ��������(AutoBoxing)
		//�´� ����(AutoBoxing �ȵǴ� ���) : Integer d = new Integer(c);
		
		Integer e = 5;
		int f = e; //JDK 5.0 �̻�, unAutoBoxing
		//�⺻�� = ��ü��
		//int f = e.intValue();
	}

}
