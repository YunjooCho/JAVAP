package class_constructor;

enum EnumColor2{//class�� ������ ����
	//enum ��ȣ ���� �����ʹ� �����ڷ� ���޵ȴ�
	RED("����"), GREEN("�ʷ�"), BLUE("�Ķ�"), MAGENTA("����");
	
	private String colorName;
	
	EnumColor2(String colorName) { //enum�� �����ڴ� private, default�� ����
		this.colorName = colorName;
	}
	
	public String getColorName() { //ĸ��ȭ
		return colorName;
	}
}

public class EnumMain2 {

	public static void main(String[] args) {
		System.out.println(EnumColor2.RED);
		
		for(EnumColor2 data : EnumColor2.values()) {
			System.out.println(data + "\t"
							+ data.ordinal() + "\t"
							+ data.valueOf(data + "") + "\t"
							+ data.getColorName());
		}
		
	}

}
