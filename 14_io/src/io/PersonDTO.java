package io;

import java.io.Serializable;

public class PersonDTO implements Serializable { //Serializable안 한 경우 : Exception in thread "main" java.io.NotSerializableException
												 //추상메소드가 없음
	
	//1.필드 선언
	private String name;
	private int age;
	private double height;
	
	//2.생성자
	public PersonDTO(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}

	
	//3.getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}
	
	

}
