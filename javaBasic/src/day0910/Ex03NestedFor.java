package day0910;

public class Ex03NestedFor {

	public static void main(String[] args) {
		for(int i = 0; i <= 5; i++) {
			//i의 현재값: 0
			//i <= 5 : true
			for(int j = 10; j <= 12; j++) {
				//j의 현재값 : 10 , 11 , 12 , 13
				//j <= 12 : true , true , true , false
				System.out.println("i : " + i + ", j : " + j);
			}
			System.out.println("i for 문 종료");
		}

	}

}
