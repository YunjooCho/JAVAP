package inheritance;

class Test{//�޴���
	int a = 3; //����Ʈ����������(private�ٷ� ��), �ʵ�� �ʱⰪ 0�� ���� ����
	
	public void disp() {
		a += 5; // a = a + 5;
		System.out.println("Test : a = " + a);
	}
}

class Sample extends Test{//�޴���
	int a = 8; //�ʵ�� �������̵� ���� ����
	
	@Override
	public void disp() {
		a += 5; // a = a + 5;
		System.out.println("Sample : a = " + a);
	}
}

public class OverrideMain {
	public static void main(String[] args) {
		//����
		Sample aa = new Sample(); //�����ڸ� �ι� �θ�(Test�⺻ ������ - Sample�⺻ ������)
		aa.disp();//SampleŬ������ disp();
		System.out.println("aa : " + aa.a); //�ڽ�Ŭ����(Sample) disp()�� a
		System.out.println();
		
		Test bb = new Sample();//������ : �θ� �ڽ�Ŭ������ ����
		bb.disp();//�������̵尡 �Ǿ��� ������ �ڽĸ޼ҵ�(SampleŬ������ disp())�� ȣ���
		System.out.println("bb : " + bb.a); 
		//�θ�Ŭ����(Sample) �ʵ� a(�ڽĸ޼ҵ尡 ȣ��Ǿ� �θ�޼ҵ尡 ������� ���� �θ� �ʵ尡 ȣ���)
		System.out.println();
		
		Test cc = new Test();
		//�θ�Ŭ���� ���忡���� �ڽ�Ŭ������ �������� �󸶳� �ִ��� �� �� ����
		cc.disp();//�׷��Ƿ� TestŬ������ �޼ҵ尡 ����
		System.out.println("cc : " + cc.a); //�θ�Ŭ����(Test) disp()�� a
		System.out.println();
		
		//Sample dd = bb; -> ����ȯ ���� �ʰ�� ����� �� ����
		//Sample ee = (Sample)cc; -> ����ȯ�ϸ� ���������δ� ������ ������
		//                           ���� �� ������ ��(instanceof) / �޸𸮿� �ƿ� ������ ����
		
		Sample dd = (Sample)bb; //�ڽ� = (�ڽ�)�θ�
		dd.disp(); //������ �ڽ�Ŭ���� ȣ��
		System.out.println("dd : " + dd.a);
		System.out.println("bb : " + bb.a);
		//�ڽ�Ŭ����(Sample) disp()�� a(43���ٿ��� ����ȯ �߱� ������)
		//bb.a���� �θ�Ŭ���� �ʵ尡 ȣ��Ǵ� ���� �ڽ�Ŭ���� �ʵ�ȣ��� �ٲ�
		System.out.println();
		
	}
}


//priate < default <  protected      <  public
//Ŭ����       ��Ű��(����)   ��Ű��(����)       
//      �ٸ���Ű�� ����X  �ٸ���Ű�� ����(�ڽ�)