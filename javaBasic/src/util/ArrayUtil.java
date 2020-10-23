package util;
// �迭 ���� �޼ҵ带 ��Ƶ� Ŭ����
//���⿡ �츮�� �����Ҵ翡�� ����ߴ� �޼ҵ��(indexOf, contains ���)��
//Student[]�� Car[]�� ���� �� �ְ� ���弼��.
//��� �޼ҵ�� static�޼ҵ忩�߸� �Ѵ�.

import day0915.Student;
import day0916.CarT;
import day0918.Post;
import day0921.Board;

public class ArrayUtil {
	//3�ñ���
	//���⿡ �츮�� �����Ҵ翡�� ����ߴ� �޼ҵ��(indexOf, contains ���)��
	//Student[]�� Car[]�� ���� �� �ְ� ���弼��.
	//��� �޼ҵ�� static �޼ҵ忩�߸� �Ѵ�.
	
	//1. �ش� �迭�� ũ�⸦ Ȯ���ϴ� size()�޼ҵ�
	//   A. Car[] ����
	public static int size(CarT[] carArray) {
		return carArray.length;
	}
	//   B. Student[] ����
	public static int size(Student[] studentArray) {
		return studentArray.length;
	}
	
	//  C. Post[] ����
	public static int size(Post[] postArray) {
		return postArray.length;
	}
	
	//  D. Board[] ����
	public static int size(Board[] boardArray) {
		return boardArray.length;
	}
	
	
	
	//2. �迭�� ���ο� ��Ҹ� �߰��ϴ� �޼ҵ� add()�޼ҵ� - ���⼭ ���ο� ��Ҷ� ��ü�� �ǹ�, �߰��� ��ü�� ������ �ε����� �߰�
	//   A. Car[] ����
	public static CarT[] add(CarT[] carArray, CarT c) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�.
		int size = carArray.length;
		CarT[] temp = new CarT[size];
		for(int i = 0; i < size; i++) {
			temp[i] = carArray[i];
		}
		//carArray ũ�� ����
		carArray = new CarT[size+1];
		//temp�� ������ carArray�� ����
		for(int i = 0; i < size; i++) {
			carArray[i] = temp[i];
		}
		//carArray�� ���� ������ ĭ�� c �߰�
		carArray[size] = c;
		return carArray;
	}
	
	//   B. Student[] ����
	public static Student[] add(Student[] studentArray, Student s) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�.
		int size = studentArray.length;
		Student[] temp = new Student[size];
		for(int i = 0; i < size; i++) {
			temp[i] = studentArray[i];
		}
		//studentArray �� ũ�⸦ 1 �ø���.
		studentArray = new Student[size+1];
		//studentArray�� temp�� ���� �����Ѵ�.
		for(int i = 0; i < size; i++) {
			studentArray[i] = temp[i];
		}
		//studentArray�� ���� ������ ĭ�� s �߰�
		studentArray[size] = s;//size�� ���� : Array�� ũ�Ⱑ size+1�� �����߱� ������ size�� 
		 					   //���� ������ �ε����� ��, ������ �ε����� �߰� ��ü�� ����
		
		return studentArray;
	}
	
	//   C.Post[] ����
	public static Post[] add(Post[] postArray, Post p) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�
		int size = postArray.length;
		Post[] temp = new Post[size];
		for(int i = 0; i < size; i++) {
			temp[i] = postArray[i];
		}
		
		//�迭�� ũ�⸦ 1����(������ ���ÿ� �ʱ�ȭ��)
		postArray = new Post[size + 1];
		
		//studentArray�� temp�� �� ����
		for(int i = 0; i < size; i++) { //�ӽ� �迭�� ũ�⿡ ���� �ۼ�
			postArray[i] = temp[i];
		}
		
		postArray[size] = p; //postArray�� ũ�Ⱑ size+1�� �����߱� ������ size�� 
							 //���� ������ �ε����� ��, ������ �ε����� �߰� ��ü�� ����
		
		return postArray;
	}
	
	//  D.Board[] ����
	public static Board[] add(Board[] boardArray, Board b) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�
		int size = boardArray.length;
		Board[] temp = new Board[size];
		for(int i = 0; i < size; i++) {
			temp[i] = boardArray[i];
		}
		
		//�迭�� ũ�⸦ 1����(������ ���ÿ� �ʱ�ȭ��)
		boardArray = new Board[size + 1];
		
		//studentArray�� temp�� �� ����
		for(int i = 0; i < size; i++) { //�ӽ� �迭�� ũ�⿡ ���� �ۼ�
			boardArray[i] = temp[i];
		}
		
		boardArray[size] = b; //postArray�� ũ�Ⱑ size+1�� �����߱� ������ size�� 
							 //���� ������ �ε����� ��, ������ �ε����� �߰� ��ü�� ����
		
		return boardArray;
	}
	
	
	//3. �迭�� �ش� ��Ұ� �����ϴ��� üũ�ϴ� contains�޼ҵ�
	//   A. Car[] �迭 ����
	public static boolean contains(CarT[] carArray, CarT c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {//'=='�� �ּҰ��� �񱳵ǹǷ�  �� �� ����(�׻� false�� ����)
				return true;
			}
		}
		return false;
	}
	
	//   B. Student[] �迭 ����
	public static boolean contains(Student[] studentArray, Student s) {
		for(int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	//   C. Post[] �迭 ����
	public static boolean contains(Post[] postArray, Post p) {
		for(int i = 0; i < postArray.length; i++) {
			if(postArray[i].equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	//  D. Board[] �迭 ����
	public static boolean contains(Board[] boardArray, Board b) {
		for(int i = 0; i < boardArray.length; i++) {
			if(boardArray[i].equals(b)) {
				return true;
			}
		}
		return false;
	}
	
	
	//4. �迭�� �ش� ��Ұ� ��� �ε����� �����ϴ��� üũ�ϴ� indexOf �޼ҵ�
	//   A. Car[] ����
	public static int indexOf(CarT[] carArray, CarT c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {
				return i;
			}
		}
		return -1;
	}
	//   B. Student[] ����
	public static int indexOf(Student[] studentArray, Student s) {
		for(int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].equals(s)) {
				return i;
			}
		}
		
		return -1;
	}
	//   C. Post[] ����
	public static int indexOf(Post[] postArray, Post p) { //���ڸ� ������
		for(int i = 0; i < postArray.length; i++) {
			if(postArray[i].equals(p)) {
				return i;
			}
		}
		return -1;
	}
	//  D. Board[] ����
	public static int indexOf(Board[] boardArray, Board b) { //���ڸ� ������
		for(int i = 0; i < boardArray.length; i++) {
			if(boardArray[i].equals(b)) {
				return i;
			}
		}
		return -1;
	}
	
	//5. �迭�� �ش� �ε����� �����ϴ� removeByIndex �޼ҵ�
	//   A. Car[] ����
	public static CarT[] removeByIndex(CarT[] carArray, int index) {
		
		// index�� ��ȿ�� ����- �Ķ���ͷ� ���� index�� ��ȿ���� Ȯ��
		if(index < 0 || index >= carArray.length) {
			return carArray; //ó�� ���� �迭�� �״�� ������
		}
		
		// �ӽù迭�� ���� �迭 ����
		CarT[] temp = new CarT[carArray.length];
		
		for(int i = 0; i < carArray.length; i++) {
			temp[i] = carArray[i];
		}
				
		// ���� �迭�� ũ�� ���
		carArray = new CarT[carArray.length - 1];
		
		//index�� ��ġ�� ���� �߶󳻱� ����
		if(index == 0) {
			//1. �ε����� ���� ���϶�
			for(int i = 1; i < temp.length; i++) {
				carArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			//2. �ε����� ���� �������϶�
			for(int i = 0; i < temp.length - 1; i++) {
				carArray[i] = temp[i];
			}
		}else {
			//3. �ε����� �߰��϶�
			for(int i = 0; i < temp.length; i++) {
				if(i < index) {
					carArray[i] = temp[i];
				}else if(i > index){
					carArray[i - 1] = temp[i];
				}
			}
		}
		return carArray;
	}
	
	//   B. Student[] ����
	public static Student[] removeByIndex(Student[] studentArray, int index) {
		
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
		studentArray = new Student[studentArray.length - 1];
		
		//index�� ��ġ�� ���� �߶󳻱� ����
		if(index == 0) {
			//1. �ε����� ���� ���϶�
			for(int i = 1; i < temp.length; i++) {
				studentArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			//2. �ε����� ���� �������϶�
			for(int i = 0; i < temp.length - 1; i++) {
				studentArray[i] = temp[i];
			}
		}else {
			//3. �ε����� �߰��϶�
			for(int i = 0; i < temp.length; i++) {
				if(i < index) {
					studentArray[i] = temp[i];
				}else if(i > index){
					studentArray[i - 1] = temp[i];
				}
			}
		}
		return studentArray;
	}
	//   C.Post[] ����
	public static Post[] removeByIndex(Post[] postArray, int index) {
		//index�� ��ȿ�� ����
		if(index < 0 || index >= postArray.length) {
			return postArray;
		}
		
		//�ӽ� �迭�� ���� �迭 ����
		int size = postArray.length; 
		Post[] temp = new Post[size];
		for(int i = 0; i < size; i++) {
			temp[i] = postArray[i];
		}
		
		//���� �迭�� ũ�⸦ 1���
		postArray = new Post[size - 1];
		
		//�ӽ� �迭�� ���� �迭�� ����(��ġ�� ���� �߶󳻱� ����)
		if(index == 0) {
			//1. ������ �ε����� ���� ���� ��
			for(int i = 1; i < temp.length; i++) {
				postArray[i-1]= temp[i]; // postArray[0]=temp[1]~postArray[size-2]=temp[temp.length-2]
			}
		}else if(index == temp.length - 1) {
			//�ڡڡڡ�2. ������ �ε����� ���� ������ �϶�
			for(int i = 0; i < temp.length - 1; i++) {
				postArray[i] = temp[i];
			}
		}else {
			//�ڡڡڡ�3. ������ �ε����� �߰��� ��
			for(int i = 0; i < temp.length;i++) {
				if(i < index) {
					postArray[i] = temp[i];
				}else if(i > index) {
					postArray[i-1] = temp[i];
				}
			}
		}
		return postArray;
	}
	
	//  D.Board[] ����
	public static Board[] removeByIndex(Board[] boardArray, int index) {
		//index�� ��ȿ�� ����
		if(index < 0 || index >= boardArray.length) {
			return boardArray;
		}
		
		//�ӽ� �迭�� ���� �迭 ����
		int size = boardArray.length; 
		Board[] temp = new Board[size];
		for(int i = 0; i < size; i++) {
			temp[i] = boardArray[i];
		}
		
		//���� �迭�� ũ�⸦ 1���
		boardArray = new Board[size - 1];
		
		//�ӽ� �迭�� ���� �迭�� ����(��ġ�� ���� �߶󳻱� ����)
		if(index == 0) {
			//1. ������ �ε����� ���� ���� ��
			for(int i = 1; i < temp.length; i++) {
				boardArray[i-1]= temp[i]; // postArray[0]=temp[1]~postArray[size-2]=temp[temp.length-2]
			}
		}else if(index == temp.length - 1) {
			//�ڡڡڡ�2. ������ �ε����� ���� ������ �϶�
			for(int i = 0; i < temp.length - 1; i++) {
				boardArray[i] = temp[i];
			}
		}else {
			//�ڡڡڡ�3. ������ �ε����� �߰��� ��
			for(int i = 0; i < temp.length;i++) {
				if(i < index) {
					boardArray[i] = temp[i];
				}else if(i > index) {
					boardArray[i-1] = temp[i];
				}
			}
		}
		return boardArray;
	}
	
	//6. �迭���� �Ķ���ͷ� �Ѿ�� ��ü�� �����ϴ� removeByElement �޼ҵ�
	//   A. Student[] ����
	public static Student[] removeByElement(Student[] studentArray, Student s) {
		return removeByIndex(studentArray, indexOf(studentArray, s));
	}
	//   B. Car[] ����
	public static CarT[] removeByElement(CarT[] carArray, CarT c) {
		return removeByIndex(carArray, indexOf(carArray, c));
	}
	
	//   C. Post[] ����
	public static Post[] removeByElement(Post[] postArray, Post p) {
		return removeByIndex(postArray,indexOf(postArray,p));
	}
	
	//  D. Board[] ����
	public static Board[] removeByElement(Board[] boardArray, Board b) {
		return removeByIndex(boardArray,indexOf(boardArray,b));
	}
}

















