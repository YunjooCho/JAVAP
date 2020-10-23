package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo {//Safari가 자식클래스 Zoo가 부모클래스

	public static void main(String[] args) {
		 Zoo zoo = new Zoo(); //tiger()가 static이면 생성안해도 됨
		 zoo.tiger();//접근 제한자 - public : 다른 패키지라 얘만 접근 가능
		 //zoo.giraffe(); //error!접근 제한자 - protected : 부모는 자식메소드에 대해 모름
		 //zoo.elephant(); //error!접근 제한자 - default
		 //zoo.lion(); //error!접근 제한자 - private
		 //Zoo zoo = new Safari()도 private참조 안됨
		 
		 Safari safari = new Safari();
		 safari.tiger();
		 safari.giraffe();
		 //safari.elephant();//error!접근 제한자 - default
		 //safari.lion();//error!접근 제한자 - private

	}

}
