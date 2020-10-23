package p06_class;



enum EnumColor2{
	
	RED("»¡°­"), GREEN("ÃÊ·Ï"), BLUE("ÆÄ¶û"), MAGENTA("º¸¶ó");
	
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
