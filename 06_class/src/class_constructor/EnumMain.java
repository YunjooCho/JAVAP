package class_constructor;

/*
class EnumColor{
	public static final String RED = "����";
	public static final String GREEN = "�ʷ�";
	public static final String BLUE = "�Ķ�";
	public static final String MAGENTA = "����";
}
*/

enum EnumColor{ //������� ����
	RED, GREEN, BLUE, MAGENTA
}

public class EnumMain {
	String colorName;
	EnumColor color;
	
	public static void main(String[] args) {
		System.out.println(EnumColor.RED); //��enumȣ��
		System.out.println();
		
		EnumMain em = new EnumMain();
		em.colorName = "����";
		em.color = EnumColor.RED; //�������� enum��ü ����
		System.out.println(em.colorName + "\t" + em.color);
		
		em.colorName = "����";
		EnumColor VIOLET = EnumColor.MAGENTA; //enum�� ����ó�� ����(������ ����)
		System.out.println(em.colorName + "\t" + VIOLET);
		System.out.println();
		
		for(EnumColor data : EnumColor.values()) {//values() - �迭
			System.out.println(data + "\t"
							 + data.ordinal()+ "\t" //Enum�迭�� �ε��� ���������� ��������
							 + data.valueOf(data + "")); 
							 //�迭 ���� ���� ���ڿ��� ���·� ������(�迭���� ���� ()���� ���� ������ ���ڿ� ���·� ��������)
							 //data�� enumŸ��, valueOf()�� ��ȣ ���� StringŸ���̿��� �ϱ� ������ ""�� ���� ��ȯ��Ŵ
		}
		System.out.println();
	}

}
