package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo {//Safari�� �ڽ�Ŭ���� Zoo�� �θ�Ŭ����

	public static void main(String[] args) {
		 Zoo zoo = new Zoo(); //tiger()�� static�̸� �������ص� ��
		 zoo.tiger();//���� ������ - public : �ٸ� ��Ű���� �길 ���� ����
		 //zoo.giraffe(); //error!���� ������ - protected : �θ�� �ڽĸ޼ҵ忡 ���� ��
		 //zoo.elephant(); //error!���� ������ - default
		 //zoo.lion(); //error!���� ������ - private
		 //Zoo zoo = new Safari()�� private���� �ȵ�
		 
		 Safari safari = new Safari();
		 safari.tiger();
		 safari.giraffe();
		 //safari.elephant();//error!���� ������ - default
		 //safari.lion();//error!���� ������ - private

	}

}
