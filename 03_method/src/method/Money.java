package method;


/*
  �ݾ�(money)�� 5679���϶� ������ ���� ����Ͻÿ�
  (/, % �����ڷ� Ǯ��)
 
 [������]
  �ݾ� : 5679��
  õ�� : 5��
  ��� : 6��
  �ʿ� : 7��
  �Ͽ� : 9��
 */
public class Money {

	public static void main(String[] args) {
      int money = 5679;
      
      System.out.println("[������]");
      System.out.println("�ݾ� : " + money + "��");
      System.out.println("õ�� : " + (money / 1000) + "��");
      System.out.println("��� : " + (money % 1000 / 100) + "��");
      System.out.println("�ʿ� : " + (money % 1000 % 100 / 10) + "��");
      System.out.println("�Ͽ� : " + (money % 1000 % 100 % 10) + "��");
      
      //<�ٸ�Ǯ��>
      //int thousand = money / 1000;
      //int thousand_mod = money % 1000;
      //int hundred = thousand_mod / 100;
      //int hundred_mod = thousand_mod % 100;
      //int ten = hundred_mod / 10;
      //int one = hundred_mod % 10;
      
      //System.out.println("�ݾ� : " + money + "��");
      //System.out.println("õ�� : " + thousand + "��");
      //System.out.println("��� : " + hundred + "��");
      //System.out.println("�ʿ� : " + ten + "��");
      //System.out.println("�Ͽ� : " + one + "��");
      
      

	}

}
