package day0916;

public class CarEx03Array {
	final static int SIZE = 3;
	public static void main(String[] args) {
		CarT[] carArray = new CarT[SIZE]; //������ CarTŬ������ ������� �־�� ��
										  //Ŭ������ �迭�� ���� �ƴ϶� Ŭ�������� ���ִ°�
			                              //�׷��Ƿ� �Ʒ� �ʱ�ȭ�� ���� ���� �ڷ����� ���ִ� ��ó�� ������ �� ����
										  //�ǻ��� Ŭ������ ���ִ� ���̰� �� Ŭ���� �ȿ� �Ʒ� ������ ����ִ� ���̴�
		for(int i = 0; i < carArray.length; i++) {
			
			//Ŭ������ �迭�� �迭 ������ �ʱ�ȭ ���Ŀ�
			//�� ��ġ���� �츮�� �����ڸ� ȣ���ؼ� (new)
			//�ش� �ε����� �ʱ�ȭ�� ���־�� �Ѵ�.
			//���� ������ NullPointerException�� �߻��Ѵ�.
			carArray[i] = new CarT();//�迭 �ʱ�ȭ null -> 0
 			carArray[i].setNumber("00�� 000" + i);
			carArray[i].setType("�ҳ�Ÿ");
			carArray[i].setYear(2020);
			carArray[i].setPrice(7000000);
			carArray[i].setColor("�����");
		}
		
		for(int i = 0; i < carArray.length; i++) {
			System.out.println(carArray[i]);
		}
	}

}
