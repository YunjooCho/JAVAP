package util;
// 배열 관련 메소드를 모아둔 클래스
//여기에 우리가 동적할당에서 사용했던 메소드들(indexOf, contains 등등)을
//Student[]과 Car[]에 사용될 수 있게 만드세요.
//모든 메소드는 static메소드여야만 한다.

import day0915.Student;
import day0916.CarT;
import day0918.Post;
import day0921.Board;

public class ArrayUtil {
	//3시까지
	//여기에 우리가 동적할당에서 사용했던 메소드들(indexOf, contains 등등)을
	//Student[]과 Car[]에 사용될 수 있게 만드세요.
	//모든 메소드는 static 메소드여야만 한다.
	
	//1. 해당 배열의 크기를 확인하는 size()메소드
	//   A. Car[] 버젼
	public static int size(CarT[] carArray) {
		return carArray.length;
	}
	//   B. Student[] 버젼
	public static int size(Student[] studentArray) {
		return studentArray.length;
	}
	
	//  C. Post[] 버전
	public static int size(Post[] postArray) {
		return postArray.length;
	}
	
	//  D. Board[] 버전
	public static int size(Board[] boardArray) {
		return boardArray.length;
	}
	
	
	
	//2. 배열의 새로운 요소를 추가하는 메소드 add()메소드 - 여기서 새로운 요소란 객체를 의미, 추가될 객체는 마지막 인덱스에 추가
	//   A. Car[] 버젼
	public static CarT[] add(CarT[] carArray, CarT c) {
		//현재 배열을 임시 배열에 복사한다.
		int size = carArray.length;
		CarT[] temp = new CarT[size];
		for(int i = 0; i < size; i++) {
			temp[i] = carArray[i];
		}
		//carArray 크기 증가
		carArray = new CarT[size+1];
		//temp의 내용을 carArray에 복사
		for(int i = 0; i < size; i++) {
			carArray[i] = temp[i];
		}
		//carArray의 가장 마지막 칸에 c 추가
		carArray[size] = c;
		return carArray;
	}
	
	//   B. Student[] 버젼
	public static Student[] add(Student[] studentArray, Student s) {
		//현재 배열을 임시 배열에 복사한다.
		int size = studentArray.length;
		Student[] temp = new Student[size];
		for(int i = 0; i < size; i++) {
			temp[i] = studentArray[i];
		}
		//studentArray 의 크기를 1 늘린다.
		studentArray = new Student[size+1];
		//studentArray에 temp의 값을 복사한다.
		for(int i = 0; i < size; i++) {
			studentArray[i] = temp[i];
		}
		//studentArray의 가장 마지막 칸에 s 추가
		studentArray[size] = s;//size인 이유 : Array의 크기가 size+1로 증가했기 때문에 size가 
		 					   //가장 마지막 인덱스가 됨, 마지막 인덱스에 추가 객체를 저장
		
		return studentArray;
	}
	
	//   C.Post[] 버전
	public static Post[] add(Post[] postArray, Post p) {
		//현재 배열을 임시 배열에 복사한다
		int size = postArray.length;
		Post[] temp = new Post[size];
		for(int i = 0; i < size; i++) {
			temp[i] = postArray[i];
		}
		
		//배열의 크기를 1증가(증가와 동시에 초기화됨)
		postArray = new Post[size + 1];
		
		//studentArray에 temp의 값 복사
		for(int i = 0; i < size; i++) { //임시 배열의 크기에 맞춰 작성
			postArray[i] = temp[i];
		}
		
		postArray[size] = p; //postArray의 크기가 size+1로 증가했기 때문에 size가 
							 //가장 마지막 인덱스가 됨, 마지막 인덱스에 추가 객체를 저장
		
		return postArray;
	}
	
	//  D.Board[] 버전
	public static Board[] add(Board[] boardArray, Board b) {
		//현재 배열을 임시 배열에 복사한다
		int size = boardArray.length;
		Board[] temp = new Board[size];
		for(int i = 0; i < size; i++) {
			temp[i] = boardArray[i];
		}
		
		//배열의 크기를 1증가(증가와 동시에 초기화됨)
		boardArray = new Board[size + 1];
		
		//studentArray에 temp의 값 복사
		for(int i = 0; i < size; i++) { //임시 배열의 크기에 맞춰 작성
			boardArray[i] = temp[i];
		}
		
		boardArray[size] = b; //postArray의 크기가 size+1로 증가했기 때문에 size가 
							 //가장 마지막 인덱스가 됨, 마지막 인덱스에 추가 객체를 저장
		
		return boardArray;
	}
	
	
	//3. 배열에 해당 요소가 존재하는지 체크하는 contains메소드
	//   A. Car[] 배열 버젼
	public static boolean contains(CarT[] carArray, CarT c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {//'=='는 주소값이 비교되므로  쓸 수 없음(항상 false가 나옴)
				return true;
			}
		}
		return false;
	}
	
	//   B. Student[] 배열 버젼
	public static boolean contains(Student[] studentArray, Student s) {
		for(int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	//   C. Post[] 배열 버전
	public static boolean contains(Post[] postArray, Post p) {
		for(int i = 0; i < postArray.length; i++) {
			if(postArray[i].equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	//  D. Board[] 배열 버전
	public static boolean contains(Board[] boardArray, Board b) {
		for(int i = 0; i < boardArray.length; i++) {
			if(boardArray[i].equals(b)) {
				return true;
			}
		}
		return false;
	}
	
	
	//4. 배열에 해당 요소가 몇번 인덱스에 존재하는지 체크하는 indexOf 메소드
	//   A. Car[] 버젼
	public static int indexOf(CarT[] carArray, CarT c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {
				return i;
			}
		}
		return -1;
	}
	//   B. Student[] 버젼
	public static int indexOf(Student[] studentArray, Student s) {
		for(int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].equals(s)) {
				return i;
			}
		}
		
		return -1;
	}
	//   C. Post[] 버전
	public static int indexOf(Post[] postArray, Post p) { //숫자를 돌려주
		for(int i = 0; i < postArray.length; i++) {
			if(postArray[i].equals(p)) {
				return i;
			}
		}
		return -1;
	}
	//  D. Board[] 버전
	public static int indexOf(Board[] boardArray, Board b) { //숫자를 돌려주
		for(int i = 0; i < boardArray.length; i++) {
			if(boardArray[i].equals(b)) {
				return i;
			}
		}
		return -1;
	}
	
	//5. 배열에 해당 인덱스를 삭제하는 removeByIndex 메소드
	//   A. Car[] 버젼
	public static CarT[] removeByIndex(CarT[] carArray, int index) {
		
		// index의 유효성 검증- 파라미터로 받은 index가 유효한지 확인
		if(index < 0 || index >= carArray.length) {
			return carArray; //처리 없이 배열을 그대로 돌려줌
		}
		
		// 임시배열에 현재 배열 복사
		CarT[] temp = new CarT[carArray.length];
		
		for(int i = 0; i < carArray.length; i++) {
			temp[i] = carArray[i];
		}
				
		// 원본 배열의 크기 축소
		carArray = new CarT[carArray.length - 1];
		
		//index의 위치에 따른 잘라내기 실행
		if(index == 0) {
			//1. 인덱스가 제일 앞일때
			for(int i = 1; i < temp.length; i++) {
				carArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			//2. 인덱스가 제일 마지막일때
			for(int i = 0; i < temp.length - 1; i++) {
				carArray[i] = temp[i];
			}
		}else {
			//3. 인덱스가 중간일때
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
	
	//   B. Student[] 버젼
	public static Student[] removeByIndex(Student[] studentArray, int index) {
		
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
		studentArray = new Student[studentArray.length - 1];
		
		//index의 위치에 따른 잘라내기 실행
		if(index == 0) {
			//1. 인덱스가 제일 앞일때
			for(int i = 1; i < temp.length; i++) {
				studentArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			//2. 인덱스가 제일 마지막일때
			for(int i = 0; i < temp.length - 1; i++) {
				studentArray[i] = temp[i];
			}
		}else {
			//3. 인덱스가 중간일때
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
	//   C.Post[] 버전
	public static Post[] removeByIndex(Post[] postArray, int index) {
		//index의 유효성 검증
		if(index < 0 || index >= postArray.length) {
			return postArray;
		}
		
		//임시 배열에 현재 배열 복사
		int size = postArray.length; 
		Post[] temp = new Post[size];
		for(int i = 0; i < size; i++) {
			temp[i] = postArray[i];
		}
		
		//원본 배열의 크기를 1축소
		postArray = new Post[size - 1];
		
		//임시 배열을 원본 배열에 복사(위치에 따른 잘라내기 실행)
		if(index == 0) {
			//1. 삭제할 인덱스가 제일 앞일 때
			for(int i = 1; i < temp.length; i++) {
				postArray[i-1]= temp[i]; // postArray[0]=temp[1]~postArray[size-2]=temp[temp.length-2]
			}
		}else if(index == temp.length - 1) {
			//★★★★2. 삭제할 인덱스가 제일 마지막 일때
			for(int i = 0; i < temp.length - 1; i++) {
				postArray[i] = temp[i];
			}
		}else {
			//★★★★3. 삭제할 인덱스가 중간일 때
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
	
	//  D.Board[] 버전
	public static Board[] removeByIndex(Board[] boardArray, int index) {
		//index의 유효성 검증
		if(index < 0 || index >= boardArray.length) {
			return boardArray;
		}
		
		//임시 배열에 현재 배열 복사
		int size = boardArray.length; 
		Board[] temp = new Board[size];
		for(int i = 0; i < size; i++) {
			temp[i] = boardArray[i];
		}
		
		//원본 배열의 크기를 1축소
		boardArray = new Board[size - 1];
		
		//임시 배열을 원본 배열에 복사(위치에 따른 잘라내기 실행)
		if(index == 0) {
			//1. 삭제할 인덱스가 제일 앞일 때
			for(int i = 1; i < temp.length; i++) {
				boardArray[i-1]= temp[i]; // postArray[0]=temp[1]~postArray[size-2]=temp[temp.length-2]
			}
		}else if(index == temp.length - 1) {
			//★★★★2. 삭제할 인덱스가 제일 마지막 일때
			for(int i = 0; i < temp.length - 1; i++) {
				boardArray[i] = temp[i];
			}
		}else {
			//★★★★3. 삭제할 인덱스가 중간일 때
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
	
	//6. 배열에서 파라미터로 넘어온 객체를 삭제하는 removeByElement 메소드
	//   A. Student[] 버젼
	public static Student[] removeByElement(Student[] studentArray, Student s) {
		return removeByIndex(studentArray, indexOf(studentArray, s));
	}
	//   B. Car[] 버젼
	public static CarT[] removeByElement(CarT[] carArray, CarT c) {
		return removeByIndex(carArray, indexOf(carArray, c));
	}
	
	//   C. Post[] 버전
	public static Post[] removeByElement(Post[] postArray, Post p) {
		return removeByIndex(postArray,indexOf(postArray,p));
	}
	
	//  D. Board[] 버전
	public static Board[] removeByElement(Board[] boardArray, Board b) {
		return removeByIndex(boardArray,indexOf(boardArray,b));
	}
}

















