package p06_class;



enum EnumColor2{
	
	RED("빨강"), GREEN("초록"), BLUE("파랑"), MAGENTA("보라");
	
	private String colorName;
	
	private EnumColor2(String colorName) {
		this.colorName = colorName;
	}
	
	public String getColorName() {
		return colorName;
	}
	
}
	
public class EnumMain2P {	
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
