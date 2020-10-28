package com.zoo;

public class Zoo2 {
	public static void main(String[] args) {
		 Zoo zoo = new Zoo(); //tiger()가 static이면 생성안해도 됨
		 zoo.tiger();//접근 제한자 - public : 다른 패키지라 얘만 접근 가능
		 zoo.giraffe(); //접근 제한자 - protected
		 zoo.elephant(); //접근 제한자 - default
		 //zoo.lion(); //error!접근 제한자 - private 같은 클래스가 아님
	}
}
