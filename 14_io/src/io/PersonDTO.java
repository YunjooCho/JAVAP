package io;

import java.io.Serializable;

public class PersonDTO implements Serializable { //Serializable�� �� ��� : Exception in thread "main" java.io.NotSerializableException
												 //�߻�޼ҵ尡 ����
	
	//1.�ʵ� ����
	private String name;
	private int age;
	private double height;
	
	//2.������
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
