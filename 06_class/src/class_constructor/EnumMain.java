package class_constructor;

/*
class EnumColor{
	public static final String RED = "빨강";
	public static final String GREEN = "초록";
	public static final String BLUE = "파랑";
	public static final String MAGENTA = "보라";
}
*/

enum EnumColor{ //상수들의 나열
	RED, GREEN, BLUE, MAGENTA
}

public class EnumMain {
	String colorName;
	EnumColor color;
	
	public static void main(String[] args) {
		System.out.println(EnumColor.RED); //▶enum호출
		System.out.println();
		
		EnumMain em = new EnumMain();
		em.colorName = "빨강";
		em.color = EnumColor.RED; //▶변수에 enum객체 대입
		System.out.println(em.colorName + "\t" + em.color);
		
		em.colorName = "보라";
		EnumColor VIOLET = EnumColor.MAGENTA; //enum이 변수처럼 사용됨(변수에 대입)
		System.out.println(em.colorName + "\t" + VIOLET);
		System.out.println();
		
		for(EnumColor data : EnumColor.values()) {//values() - 배열
			System.out.println(data + "\t"
							 + data.ordinal()+ "\t" //Enum배열의 인덱스 순차적으로 가져오기
							 + data.valueOf(data + "")); 
							 //배열 안의 값을 문자열의 형태로 가져옴(배열안의 값이 ()안의 값과 같으면 문자열 형태로 가져오기)
							 //data는 enum타입, valueOf()의 괄호 안은 String타입이여야 하기 때문에 ""로 강제 변환시킴
		}
		System.out.println();
	}

}
