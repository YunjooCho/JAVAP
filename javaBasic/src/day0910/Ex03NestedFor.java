package day0910;

public class Ex03NestedFor {

	public static void main(String[] args) {
		for(int i = 0; i <= 5; i++) {
			//i�� ���簪: 0
			//i <= 5 : true
			for(int j = 10; j <= 12; j++) {
				//j�� ���簪 : 10 , 11 , 12 , 13
				//j <= 12 : true , true , true , false
				System.out.println("i : " + i + ", j : " + j);
			}
			System.out.println("i for �� ����");
		}

	}

}
