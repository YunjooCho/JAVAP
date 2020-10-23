package util;

import day0915.Student;
import day0916.CarT;

//�迭 ���� �޼ҵ带 ��Ƶ� Ŭ����
public class ArrayUtilmine {
	//3�ñ���
	//���⿡ �츮�� �����Ҵ翡�� ����ߴ� �޼ҵ��(indexOf, contains ���)��
	//Student[]�� Car[]�� ���� �� �ְ� ���弼��.
    //��� �޼ҵ�� static�޼ҵ忩�߸� �Ѵ�.
	
	//1.size - �迭 ũ�⸦ Ȯ���ϴ� �޼ҵ�
	
	//1-1.Car[]
	public static int size(CarT[] carArray) {
		return carArray.length;
	}
	
	//1-2.Student[]
	public static int size(Student[] studentArray) {
		return studentArray.length;
	}
	
	
	
	//2.add - �迭�� ���ο� ���(���⼭�� ��ü)�� �߰�(������ �迭�� �߰�)�ϴ� �޼ҵ�
	//2-1.CarT[]
	public static CarT[] add(CarT[] carArray, CarT c) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�.
		int size = carArray.length;
		CarT[] temp = new CarT[size];
		//temp�迭�� ������ carArray�迭�� ����
		for(int i = 0; i < size; i++) {
			temp[i] = carArray[i];
		}
		//carArray�迭�� ũ�� ����
		carArray = new CarT[size + 1];
		for(int i = 0; i < size; i++) { 
			carArray[i]=temp[i];
		}
		//�迭�� ���� ������ ĭ�� c �߰�
		carArray[size] = c;
		return carArray;//�迭 ��ü�� ��ȯ
	}
	
	//2-2.Student[]
	public static Student[] add(Student[] studentArray, Student s) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�.
		int size = studentArray.length;
		Student[] temp = new Student[size];
		for(int i = 0; i < size; i++) {
			temp[i] = studentArray[i];
		}
		
		//studentArray�� ũ�⸦ 1 �ø���.
		studentArray = new Student [size + 1]; //size�� ���� : temp�� sizeũ�� ��ŭ�� �迭���� �� �ֱ� ������
		//studentArray�� temp�� ���� �����Ѵ�
		for(int i = 0; i < size; i++) {
			studentArray[i] = temp[i];
		}
		studentArray[size] = s;
		
		return studentArray;
	}
	
    
	
	//3.contains - �迭�� �ش� ��Ұ� �����ϴ��� üũ�ϴ� �޼ҵ�
	//3-1.Car[]
	public static boolean contains(CarT[] carArray, CarT c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {//�ּҰ��̹Ƿ� ��ü �ʵ�񱳿��� '=='�� �� �� ����
				return true;
			}
		}
		return false;
	}
		
	//3-2.Student[]
	public static boolean contains(Student[] studentArray, Student s) {
		for(int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	
	//4.indexOf - �迭�� �ش� ��Ұ� ��� �ε����� �����ϴ��� üũ
	//4-1.Car[]
	public static int indexOf(CarT[] carArray, CarT c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {
				return i;
			}
		}
		return -1;
	}
	//4-2.Student[]
	public static int indexOf(Student[] studentArray, Student s) {
		for(int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}
	
	
	//5.removeByIndex - �迭�� �ش� �ε����� �����ϴ� �޼ҵ�
	//5-1.Car[]
	public static CarT[] removeByIndex(CarT[] carArray, int index) {
		//��ȿ�� ����
		if(index < 0 || index >= carArray.length) {
			return carArray;
		}
		
		//�ӽù迭�� ���� �迭 ����
		CarT[] temp = new CarT[carArray.length];
		
		for(int i = 0; i < carArray.length; i++) {
			temp[i] = carArray[i];
		}
		
		//���� �迭�� ũ�� ���
		carArray = new CarT[carArray.length - 1];
		
		//index�� ��ġ�� ���� �߶󳻱� ����
		if(index == 0 ) {
			//1.�ε����� 0�� ��
			for(int i = 1; i < temp.length; i++) {//carArray.length�� ������ �Ǿ��� ������ ���� �ȵ�
				carArray[i-1] = temp[i];
			}
		}else if(index ==  temp.length - 1){
			//2.�ε����� ���� �������� ��
			for(int i = 0; i < temp.length - 1; i++) {
				carArray[i] = temp[i];
			}
		}else {
			//3.�ε����� �߰��� ��
			for(int i = 0; i < temp.length;i++) {
				if(i < index) {
					carArray[i] = temp[i];
				}else if(i > index) {
					carArray[i-1] = temp[i];
				}
			}
			
		}
		return carArray;
	}
	
	//5-2.Student[]
	public static Student[] removeByIndex(Student[] studentArray, int index) {
		//���� �����ϱ� ���� �ش� �ε����� ó�������� index�������� üũ�Ѵ�
		//���� �Ұ����� �ε������ �迭�� �״�� �������ָ� �ȴ�.
		//�ε����� ������ ���� : 0 ~ student.length-1
		//index�� ������ �迭�� �ε����� ����Ŵ
		// index�� ��ȿ�� ����
		if(index < 0 || index >= studentArray.length) {
			return studentArray;
		}
		
		// �ӽù迭�� ���� �迭 ����
		Student[] temp = new Student[studentArray.length];
		for(int i = 0; i < studentArray.length; i++) {
			temp[i] = studentArray[i];
		}
		
		// ���� �迭�� ũ�� ���
		studentArray = new Student[studentArray.length-1];
		
		 //index�� ��ġ�� ���� �߶󳻱� ����
		if(index == 0){
			 //1. �ε����� ���� ���϶�
			for(int i = 1; i < temp.length;i++) {
				studentArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			 //2. �ε����� ���� �������϶�
			for(int i = 0; i < studentArray.length - 1; i++) {
				studentArray[i] = temp[i];
			}
		}else {
			 //3. �ε����� �߰��϶�
			for(int i = 0; i < temp.length; i++) {
				if(i < index) {
					studentArray[i] = temp[i];
				}else if(i > index) {
					studentArray[i-1] = temp[i];
				}
			}
		}
		return studentArray;
		
	}
	
	//6.removeByelement - �Ķ���ͷ� �Ѿ�� element��ü�� �����Ͽ� ����
	//6-1.Student[]
	public static Student[] removeByelement(Student[] studentArray, Student s) {
		//int index = indexOf(studentArray, s);
		//studentArray = removeByIndex(studentArray, index);
		return studentArray = removeByIndex(studentArray, indexOf(studentArray,s));
	}
	//6-2.Car[]
	public static CarT[] removeByelement(CarT[] carArray, CarT c) {
		//int indext = indexOf(carArray, c);
		//carArray = removeByIndex(carArray, index);
		return removeByIndex(carArray, indexOf(carArray,c));
	}
}
