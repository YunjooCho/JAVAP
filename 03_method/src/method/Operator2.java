package method;

public class Operator2 {

	public static void main(String[] args) {
		boolean a = 25 > 36;
		System.out.println("a = " + a); // a = false
		System.out.println("!a = " + !a); // !a = true
		System.out.println();
		
		String b = "apple"; //바로 literal생성이 가능(String만 가능)
							//b는 apple이 있는 '주소'를 갖고 있는 것임 
							//(apple이라는 데이터를 갖고 있는 것이 아님)
		String c = new String("apple"); // 메모리 생성
		
		String result = b == c ? "같다" : "다르다"; //비교하는 내용은 주소값 
												 //예)b의 주소값은 100번지, c의 주소값은 300번지(사진 참조)
		System.out.println("b == c : " + result);
		result = b != c ? "참" : "거짓"; 
		System.out.println("b != c : " + result);
		System.out.println();
		
		
		//주소가 아닌 값을 비교(equals함수) - JAVA에서만 사용
		//※JAVAScript에서는 ==를 사용
		result = b.equals(c) ? "같다" : "다르다"; //문자열(데이터값)을 비교
		System.out.println("b.equlas(c) : " + result);
		result = !b.equals(c) ? "참" : "거짓"; 
		System.out.println("!b.equlas(c) : " + result);
		
		
	}

}
