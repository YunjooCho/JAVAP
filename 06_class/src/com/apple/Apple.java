package com.apple;

import com.zoo.Zoo;//ZooŬ������ ��ġ�� �˷���

public class Apple {
	public static void main(String[] args) {
		 System.out.println("���� ���");
		 
		 //ZooŬ������  tiger()�޼ҵ� ȣ��
		 Zoo zoo = new Zoo(); //tiger()�� static�̸� �������ص� ��
		 zoo.tiger();//���� ������ - public : �ٸ� ��Ű���� �길 ���� ����
		 //zoo.giraffe(); //error!���� ������ - protected
		 //zoo.elephant(); //error!���� ������ - default
		 //zoo.lion(); //error!���� ������ - private
	}
}
