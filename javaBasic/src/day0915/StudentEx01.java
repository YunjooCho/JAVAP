package day0915;

import java.io.IOException;

public class StudentEx01 {
	public static void main(String[] args) throws IOException {
		//��ü�� ������
		
		Student s1 = new Student("�踻��", 1, 99, 98, 97);  //�Ķ���Ͱ� �ִ� ������
														  //������(�ʵ尪 �ʱ�ȭ), StudentŬ������ �ٸ� Ŭ�������Ͽ��� ������
														  //Student s1 = new Student(); ���·� �⺻ ����ϰ� ������, 
														  //�̹����� Student���Ͽ� �Ķ���Ͱ� �ִ� �����ڸ� ������� ������
									                      //StudentŬ������ �Ķ���Ͱ� �ִ� �����ڸ� ������ �����߻�.
														  //�Ķ���� ������Ÿ���� ���� �����ڸ� ã�Ƴ�(Student����)
		s1 = new Student(); //�Ķ���Ͱ� ���� ������
							//Student s1 = new Student(); ���, ���� ����������, �Ķ���Ͱ� �ִ� �������� ���� ������
		System.out.printf("�̸� : %s, ID : %d, ���� : %d��, ���� : %d��, ���� : %d��\n", s1.getName(), s1.getId(), s1.getKorean(), s1.getEnglish(), s1.getMath());
		//��ü�� �ʵ� Ȥ�� �޼ҵ带 ������ ������
		//���� ������ . �� �̟G�ϸ� �ȴ�.
		
		s1.setName("���翵"); //()���� ���� ���� name������ ����
		s1.setKorean(100);
		s1.setEnglish(90);
		s1.setMath(91);
		s1.setId(1);
		System.out.printf("�̸� : %s, ���� : %d��, ���� : %d��, ���� : %d��\n", s1.getName(), s1.getKorean(), s1.getEnglish(), s1.getMath());
		System.out.printf("%s �л��� ���� : %d�� ��� : %.2f\n", s1.getName(), s1.calculateSum(), s1.calculateAverage());
		
		Student s2 = new Student("��ö��", 2, 90, 90, 90); //�Ķ���Ͱ� �ִ� ������(������ �ؿ� set���� �ٽ� ���� �ֱ⶧���� �Ķ���� �����)
		s2 = new Student();
		s2.setName("��ö��");
		s2.setKorean(90);
		s2.setEnglish(90);
		s2.setMath(90);
		s2.setId(2);
		System.out.printf("�̸� : %s, ���� : %d��, ���� : %d��, ���� : %d��\n", s2.getName(), s2.getKorean(), s2.getEnglish(), s2.getMath());
		System.out.printf("%s �л��� ���� : %d�� ��� : %.2f\n", s2.getName(), s2.calculateSum(), s2.calculateAverage());
		//Ŭ������ Student �ϳ�, �ʵ尪�� �ٲ��� ��
		
		String str1 = new String();//new String()��ſ� null�� ������ ����� ���� �ʰ� ������ ��
								   //�� �ڵ�� String str1 = ""; �� ���������� �ƹ��� ��(0)�� ���� ��Ʈ�� ������ �ʱ�ȭ �� ���̴�. 
		                           //�ٸ� �� �� �������� ǥ���̴�.
		System.out.println(str1.length());
		
		
		
		
		Student s3 = new Student("abc", 4, 5, 6, 7); //�Ķ���Ͱ� �ִ� ������
		Student s4 = new Student("abc", 4, 5, 6, 7);
		
		
		System.out.println();
		System.out.println("-���&�������̵� Ȯ��-");
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);
		
		
		System.out.println("s3.equals(s4) : " + s3.equals(s4));
			//�̸��� �й��� ������ ���� �����Ͷ�� ���߱� ������(instanceof) ������ Ʋ���� ���ٰ� ����
		System.out.println("�������̵� �� : false");
		System.out.println("�������̵� �� : true");
		
		System.out.println();
		System.out.println("toString() Ȯ��");
		System.out.println(s1);
		System.out.println("s1.getName().matches(\"\\d*\") : " + s1.getName().matches("\\d*"));
		System.out.println("s2.getName().matches(\"\\d*\") : " + s2.getName().matches("\\d*"));
		System.out.println("s1.getName() : " + s1.getName());
		System.out.println("s2.getName() : " + s2.getName());
		//System.out.println("s1.getName().matches(\"\\d*\") : " + s1.getKorean().matches("\\d*")); ->korean�� int���̹Ƿ� �񱳰� �ȵ�
		System.out.println("toString()�� : day0915.Student@4554617c");
		System.out.println("toString()�� : �̸� : ���翵, �й� : 1, ���� : 100��, ���� : 90��, ���� : 91��");
	
		System.out.println();
		day0910.Ex07Array.main(args);//public�� �پ������� ȣ�� ����
		
		
		
	}
}
