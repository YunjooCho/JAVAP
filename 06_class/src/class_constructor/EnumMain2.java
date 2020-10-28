package class_constructor;

enum EnumColor2{//class와 유사한 구성
	//enum 괄호 안의 데이터는 생성자로 전달된다
	RED("빨강"), GREEN("초록"), BLUE("파랑"), MAGENTA("보라");
	
	private String colorName;
	
	EnumColor2(String colorName) { //enum의 생성자는 private, default만 먹힘
		this.colorName = colorName;
	}
	
	public String getColorName() { //캡슐화
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
