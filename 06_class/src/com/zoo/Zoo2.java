package com.zoo;

public class Zoo2 {
	public static void main(String[] args) {
		 Zoo zoo = new Zoo(); //tiger()�� static�̸� �������ص� ��
		 zoo.tiger();//���� ������ - public : �ٸ� ��Ű���� �길 ���� ����
		 zoo.giraffe(); //���� ������ - protected
		 zoo.elephant(); //���� ������ - default
		 //zoo.lion(); //error!���� ������ - private ���� Ŭ������ �ƴ�
	}
}
