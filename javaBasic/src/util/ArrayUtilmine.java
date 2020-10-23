package util;

import day0915.Student;
import day0916.CarT;

//배열 관련 메소드를 모아둔 클래스
public class ArrayUtilmine {
	//3시까지
	//여기에 우리가 동적할당에서 사용했던 메소드들(indexOf, contains 등등)을
	//Student[]과 Car[]에 사용될 수 있게 만드세요.
    //모든 메소드는 static메소드여야만 한다.
	
	//1.size - 배열 크기를 확인하는 메소드
	
	//1-1.Car[]
	public static int size(CarT[] carArray) {
		return carArray.length;
	}
	
	//1-2.Student[]
	public static int size(Student[] studentArray) {
		return studentArray.length;
	}
	
	
	
	//2.add - 배열에 새로운 요소(여기서는 객체)를 추가(마지막 배열에 추가)하는 메소드
	//2-1.CarT[]
	public static CarT[] add(CarT[] carArray, CarT c) {
		//현재 배열을 임시 배열에 복사한다.
		int size = carArray.length;
		CarT[] temp = new CarT[size];
		//temp배열의 내용을 carArray배열에 복사
		for(int i = 0; i < size; i++) {
			temp[i] = carArray[i];
		}
		//carArray배열의 크기 증가
		carArray = new CarT[size + 1];
		for(int i = 0; i < size; i++) { 
			carArray[i]=temp[i];
		}
		//배열의 가장 마지막 칸에 c 추가
		carArray[size] = c;
		return carArray;//배열 전체를 반환
	}
	
	//2-2.Student[]
	public static Student[] add(Student[] studentArray, Student s) {
		//현재 배열을 임시 배열에 복사한다.
		int size = studentArray.length;
		Student[] temp = new Student[size];
		for(int i = 0; i < size; i++) {
			temp[i] = studentArray[i];
		}
		
		//studentArray의 크기를 1 늘린다.
		studentArray = new Student [size + 1]; //size인 이유 : temp에 size크기 만큼의 배열값이 들어가 있기 때문에
		//studentArray에 temp의 값을 복사한다
		for(int i = 0; i < size; i++) {
			studentArray[i] = temp[i];
		}
		studentArray[size] = s;
		
		return studentArray;
	}
	
    
	
	//3.contains - 배열에 해당 요소가 존재하는지 체크하는 메소드
	//3-1.Car[]
	public static boolean contains(CarT[] carArray, CarT c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {//주소값이므로 객체 필드비교용인 '=='는 쓸 수 없음
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
	
	
	//4.indexOf - 배열에 해당 요소가 몇번 인덱스에 존재하는지 체크
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
	
	
	//5.removeByIndex - 배열에 해당 인덱스를 삭제하는 메소드
	//5-1.Car[]
	public static CarT[] removeByIndex(CarT[] carArray, int index) {
		//유효성 검증
		if(index < 0 || index >= carArray.length) {
			return carArray;
		}
		
		//임시배열에 현재 배열 복사
		CarT[] temp = new CarT[carArray.length];
		
		for(int i = 0; i < carArray.length; i++) {
			temp[i] = carArray[i];
		}
		
		//원본 배열의 크기 축소
		carArray = new CarT[carArray.length - 1];
		
		//index의 위치에 따른 잘라내기 실행
		if(index == 0 ) {
			//1.인덱스가 0일 때
			for(int i = 1; i < temp.length; i++) {//carArray.length는 변경이 되었기 때문에 쓰면 안됨
				carArray[i-1] = temp[i];
			}
		}else if(index ==  temp.length - 1){
			//2.인덱스가 제일 마지막일 때
			for(int i = 0; i < temp.length - 1; i++) {
				carArray[i] = temp[i];
			}
		}else {
			//3.인덱스가 중간일 때
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
		//먼저 제거하기 전에 해당 인덱스가 처리가능한 index인지부터 체크한다
		//만약 불가능한 인덱스라면 배열을 그대로 리턴해주면 된다.
		//인덱스가 가능한 범위 : 0 ~ student.length-1
		//index는 삭제할 배열의 인덱스를 가리킴
		// index의 유효성 검증
		if(index < 0 || index >= studentArray.length) {
			return studentArray;
		}
		
		// 임시배열에 현재 배열 복사
		Student[] temp = new Student[studentArray.length];
		for(int i = 0; i < studentArray.length; i++) {
			temp[i] = studentArray[i];
		}
		
		// 원본 배열의 크기 축소
		studentArray = new Student[studentArray.length-1];
		
		 //index의 위치에 따른 잘라내기 실행
		if(index == 0){
			 //1. 인덱스가 제일 앞일때
			for(int i = 1; i < temp.length;i++) {
				studentArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			 //2. 인덱스가 제일 마지막일때
			for(int i = 0; i < studentArray.length - 1; i++) {
				studentArray[i] = temp[i];
			}
		}else {
			 //3. 인덱스가 중간일때
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
	
	//6.removeByelement - 파라미터로 넘어온 element객체를 삭제하여 리턴
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
