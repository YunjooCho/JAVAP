package variable;

public class NumberTest {

	public static void main(String[] args) {
		System.out.print("�ȳ��ϼ���\n");
		System.out.println(25+36);
		System.out.println("25+36");
		System.out.println("25+36 = " + 25+36);
		System.out.println("25+36 = " + (25+36));
		System.out.println("25/36 = " + (25/36));
		System.out.println("25/36 = " + (25.0/36));
		System.out.printf("25/36 = %.2f\n", (25.0/36));
		System.out.printf("25/36 = %.1f\n", (25.0/36));
		System.out.printf("%d / %d = %.1f\n", 25, 36, (25.0/36));
		System.out.println("25/36 = " + String.format("%.2f", (25.0/36)));
		System.out.println();
		
		System.out.println('A' + 3);
		System.out.println('A' + 32);
		System.out.println((char)('A' + 32)); 
		//����ȯ(���� -> ����), Ŭ���������� ����ȯ�� �Ͼ
		System.out.println();
		
		
		System.out.println(2+5);
		
		System.out.println('2'+'5'); //����� : 50 + 52 = 103
		System.out.println('2'- 48 + '5' - 48 ); //���ڸ� ���ڷ� ��ȯ, 7
		//System.out.println((char)'2'+'5');
		
		System.out.println("2"+"5"); 
		System.out.println(Integer.parseInt("2")+Integer.parseInt("5"));
		//���ڿ��� ���� 7�� ��ȯ, Integer Ŭ����
		
		System.out.println("25.3" + "45.6");
		System.out.println(Double.parseDouble("25.3") + Double.parseDouble("45.6")); 
		//���ڿ��� �Ǽ�(����X)�� ��ȯ, Double Ŭ����
		
	}

}

//����
//2, -5, 100

//���ڿ�(JAVA)
//"car", "25" 
//->""���, ���� �ȵ�
//->�ڵ��� ��ȣ�� ���� ���
//��Python������ ''�Ǵ� ""�� ���

//���ڿ��� +�� ����(����x)
//���ڿ��� ���ڸ� ���ϸ� �켱������ ���� ������ �ǹ̷� �޾Ƶ���
//������ �ϰ� ������ ���� ������ ��ȣ�Է�
//���� �ִ� ���� ������ ������ ������� ����
//������ �Ǽ��϶� �����ϴ� �ٸ� ���ڸ� �Ǽ��� ��ȯ : �ڵ� ĳ��Ʈ

//printf()
//������ ���� ���Ѵ� : %d ��decimal
//�Ǽ��� ���� ���Ѵ� : %f
//���� �� ����          : %c
//���� ��                 : %s
//%��ü�ڸ���.�Ҽ������ڸ���f
//ex)25.3 -> %4.1f : 000.0 �����ڸ�, �Ҽ��� 1�ڸ�
//ex)%.2f : ��ü�ڸ��� ���x, �Ҽ��� �ڸ� 1������ ���
//�Ҽ� �ڸ� �� ������ �ݿø� ��

//��ASCII(�ܿ��)
//'A' = 65;
//��A�� -> ��a�� : ��A�� + 32
//��a�� -> ��A�� : ��a�� - 32
// 0  -> ��0�� : 0 + 48
//��0�� ->  0  : ��0�� - 48

//�ع��ڿ��� ���ڷ� �ٲٱ�
//��2�� -> Integer.parseInt() -> 2

//�ڹٰ� �����ϴ� Ŭ������ jre���� Ȯ�ΰ���
//�⺻���� ������ ������ String���� ��ü�� ������ Ȯ�� ����
//C:\Program Files\Java\jre1.8.0_261\lib rt.jar(JAVA�� ��������)

//Overload : �Լ��� �̸��� ������ ���� �ΰ��� ���� 
//			  ex)String.fomat : StringŬ������ format �޼ҵ� 