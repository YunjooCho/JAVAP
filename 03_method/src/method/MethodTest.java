package method;


/*
 10���� 250�� 2����, 8����, 16������ ��ȯ �Ͻÿ�
  ��) Integer�� �޼ҵ带 �̿��Ͽ� ���Ͻÿ�
 */
public class MethodTest {

	public static void main(String[] args) {
		int dec = 250;
		String binary = Integer.toBinaryString(dec);//2���� 
		String octal = Integer.toOctalString(dec);  //8����
		String hexa = Integer.toHexString(dec);     //16����
		
		System.out.println("2���� = " + binary);
		System.out.println("8���� = " + octal);
		System.out.println("16���� = " + hexa);

	}

}
