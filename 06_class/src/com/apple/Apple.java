package com.apple;

import com.zoo.Zoo;//Zoo클래스의 위치를 알려줌

public class Apple {
	public static void main(String[] args) {
		 System.out.println("빨간 사과");
		 
		 //Zoo클래스의  tiger()메소드 호출
		 Zoo zoo = new Zoo(); //tiger()가 static이면 생성안해도 됨
		 zoo.tiger();//접근 제한자 - public : 다른 패키지라 얘만 접근 가능
		 //zoo.giraffe(); //error!접근 제한자 - protected
		 //zoo.elephant(); //error!접근 제한자 - default
		 //zoo.lion(); //error!접근 제한자 - private
	}
}
