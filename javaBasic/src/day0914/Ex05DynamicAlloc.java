package day0914;
//배열의 동적할당
//우리가 지금까지 배열을 사용할때
//항상 배열의 크기를 지정하고
//해당 크기로 초기화해서 배열을 사용했다.
//이렇게 미리 크기를 지정해서 배열을 만드는걸 정적할당(static Allocation)이라고 한다.

//그에 반해 배열의 크기를 추가하면 늘어나고 삭제하면 줄어들게 만드는 것을
//동적할당(dynamic Allocation)이라고 한다.

//자바에서 우리가 메소드에 파라미터를 넘겨주면
//메소드에서 해당 파라미터로 넘어온 것들을 수정한다고 하더라도
//실제 파라미터가 호출된 곳에 있는 변수값은 변하지 않는다. ->?????????
//따라서 리턴 타입을 배열로 만들어주어야 한다.
//그래서 메소드에서 수정을 하고 그 파라미터를 리턴해서
//덮어씌우는 형식을 만들어 주어야 한다!

public class Ex05DynamicAlloc {
	// 동적할당을 위한 여러가지 메소드를 만들어보자
	
	//1. 배열의 현재 크기를 확인하는 size()메소드
	static int size(int[] arr) {
		return arr.length;//1차원 배열만
	}
	
	//2. 배열에 새로운 요소를 추가하는 메소드
	static int[] add(int[] arr, int element) {
		//우리가 파라미터로 받은 element를
		//arr에 추가할 것인데
		//무조건 arr의 가장 맨 뒤에 붙여줄 것이다.
		//하지만 우리가 arr의 크기를 유동적으로 변경해야 하기 때문에
		//1. arr을 임시 배열에 복사하고
		//2. 현재크기 + 1의 크기로 초기화하고 ->추가할 데이터가 들어갈 배열공간 생성
		//3. 임시 배열에 복사해 놓은 값들을 복사하고 ->원래 부분은 초기화되므로 다른 곳에 저장
		//4. 맨 마지막 위치에 element를 추가해서
		//5. arr을 return 해주어야 한다
		
		//임시배열을 선언
		//임시배열의 크기는 파라미터로 넘어온 arr의 크기와 같다.(같은 내용을 복사해서 옮겨야하므로)
		int size = arr.length;
		
		int[] temp = new int[size];
		
		//임시배열에 현재 arr의 값들을 차례대로 복사해주자
		for(int i = 0; i < arr.length; i++) { //arr.length 대신 size도 가능
			temp[i] = arr[i];
		}
		
		//현재 배열을 현재 크기 + 1로 초기화해준다.
		//new를 만나는 순간
		//기존의 배열에 들어가 있던 모든 값들은
		//다 사라진다
		//현재 arr은 기본형 데이터타입인 int의 배열이기 때문에
		//모든 인덱스가 0으로 초기화된다
		
		//따라서 배열의 현재 내용을 유지한 채 크기를 늘리기 위해서는
		//현재 배열의 내용을 임시 배열에 저장하고
		//크기를 늘리고
		//임시 배열의 값들을 다시 복사해와야 한다.
		arr = new int[size+1]; //element를 추가하기 위해 새로운 칸(?)을 생성 -> 기존에 있던 내용이 날라감(0으로 초기화)
		
		//현재 배열에 임시 배열의 값을 차례대로 복사해주자
		for(int i = 0; i < size; i++) {
			arr[i] = temp[i];
		}
		
		
		//arr의 가장 마지막 index를 element로 초기화해주자
		//arr이 처음 파라미터로 넘어올때
		//가장 마지막 인덱스는 현재 크기 -1이다.
		//즉 size - 1이다.
		//하지만 이제는 크기가 1 늘어났으므로
		//가장 마지막 인덱스는 size가 된다
		
		//int[] arr = new int[4]
		//해당 배열의 가장 마지막 index 번호는 몇번인가?
		//3
		//현재 크기는?
		//4
		
		//arr의 크기를 1늘리면
		//새로운 크기는?
		//5
		//마지막 인덱스 번호?
		//4
		
		arr[size] = element;//size ->배열의 가장 마지막 칸(?, 이제는 크기가 아닌 인덱스 번호가 됨)에 데이터를 넣어줌
		
		return arr;
	}
	//파라미터로 넘어온 배열(int[]arr)에 파라미터로 넘어온 값(int element)이 존재하는 체크하는 contains메소드
	static boolean contains(int[] arr, int element) {
		//for문을 이용해서
		//arr의 각 인덱스와  element를 비교해서 같으면 return true를 한다.
		for(int i = 0; i < arr.length;i++) {
			if(arr[i] == element) {
				//i번째 인덱스와 element의 값이 같으므로
				//return true 해준다.
				return true; //여기서 return을 만나면 for문,if문 상관없이 바로 빠져나옴
			}
		}
		
		return false;
	}
	
	
	//파라미터로 넘어온 배열(int[] arr)에 파라미터로 넘어온 값(int element)이 몇번 인덱스에 있는지 확인해주는 indexOf메소드
	static int indexOf(int[] arr, int element) {
		//여기서 에러
		//만약 element가 arr에 존재하지 않는다면
		//우리가 어떤 값을 리턴해주어야 할까?
		//인덱스는 무조건 0부터 arr크기 -1이기 때문에
		//양의 정수로 우리가 존재하지 않는다는 표시를 해주기가 힘들다.
		//따라서 음의 정수중에 가장 간단한 "-1"을 리턴해서
		//반약 배열에 해당 엘리멘트가 존재하지 않으면
		//인덱스는 -1을 리턴해주면 된다.(int형이므로 false대신 -1리턴?)
		
		//for문을 돌려서
		//만약 i번째 인덱스 값이 element와 같으면
		//i를 리턴해주면 된다.
		for(int i = 0; i < arr.length;i++) {
			if(arr[i] == element) {
				return i;
			}
		}
		return -1;//해당 값(int element)이 존재하지 않음을 의미
	}//indexOf
	
	
	public static void main(String[] args) {
		int[] arr2 = new int[5];
		arr2[0] = 10;
		System.out.println("arr2.length: " + arr2.length);
		arr2[1] = 20;
		System.out.println("arr2.length: " + arr2.length);
		arr2[2] = 30;
		System.out.println("arr2.length: " + arr2.length);
		
		
		int[] arr =  new int[0];//0으로 초기화
		
		System.out.println("arr의 현재크기 : " + size(arr));
		
		arr = add(arr,10);
		System.out.println("arr의 현재크기 : " + size(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr = add(arr, 5);
		System.out.println("arr의 현재크기 : " + size(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr = add(arr,4);
		System.out.println("arr의 현재크기 : " + size(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//우리가 arr을 add 메소드의 결과값으로 덮어씌울때마다
		//arr의 값이 유지가 되면서 늘어나는 것을 확인 할 수 있다
		
		//contains 메소드를 실행한 결과값
		System.out.println("============contains()==============");
		//arr에 5가 존재합니까?
		System.out.println("contains(arr,5): " + contains(arr,5));
		//arr에 25가 존재합니까?
		System.out.println("contains(arr,25): " + contains(arr,25));
		
		System.out.println("============indexOf()==============");
		//arr에서 5의 인덱스는 얼마입니까?
		System.out.println("indexOf(arr,5): " + indexOf(arr,5));
		//arr에서 25의 인덱스는 얼마입니까?
		System.out.println("indexOf(arr,25): " + indexOf(arr,25));
		
      arr = add(arr, 5);
      arr = add(arr, 4);
      arr = add(arr, 12);
      arr = add(arr, 51);
      //remove전 arr 내용 출력
      System.out.println("remove 전 arr 내용 출력");
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByIndex(arr, 0) 이후
      System.out.println("removeByIndex(arr, 0) 실행");
      arr = removeByIndex(arr, 0);
      for(int i = 0; i < arr.length; i++) {
	         System.out.printf("arr[%d]: %d\n", i, arr[i]);
	      }
      
      //removeByIndex(arr, 5) 이후
      System.out.println("removeByIndex(arr, 5) 실행");
      arr = removeByIndex(arr, 5);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByIndex(arr, 2) 이후
      System.out.println("removeByIndex(arr, 2) 실행");
      arr = removeByIndex(arr, 2);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByIndex(arr, 9999) 이후
      System.out.println("removeByIndex(arr, 9999) 실행");
      arr = removeByIndex(arr, 9999);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByElement()(있으면 삭제) 실행전에 배열에 다시 요소를 몇개 더 추가하자
      arr = add(arr, 281);
      arr = add(arr, 144);
      arr = add(arr, 82);
      System.out.println("add() 실행");
      for(int i = 0; i < arr.length; i++) {
    	  System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      System.out.println("removeByElement(arr,5) 실행");
      arr = removeByElement(arr,5);
      for(int i = 0; i < arr.length; i++) {
    	  System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      System.out.println("removeByElement(arr, 82) 실행");
      arr = removeByElement(arr, 82);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      System.out.println("removeByElement(arr, 12) 실행");
      arr = removeByElement(arr, 12);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      System.out.println("removeByElement(arr, 123456) 실행");
      arr = removeByElement(arr, 123456);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
   }

      

	
	
	//배열에서 element를 삭제하는 메소드 removeByIndex
	//우리가 배열에 요소(배열안에 들어있는 각각의 값)를 추가하면 크기가 늘어난다
	//우리가 배열에 요소를 삭제하면? 크기가 줄어들어야 한다!
	
	static int[] removeByIndex(int[] arr, int index) {
		//먼저 제거하기 전에 해당 인덱스가
		//가능한 index인지부터 체크한다
		//만약 불가능한 인덱스라면 arr을 그대로 리턴해주면 된다.
		
		//인덱스가 가능한 범위는 몇부터 몇인가? 0 ~ arr.lenth-1
		if(index < 0 || index >= arr.length) {
			return arr;
		}
		
		//배열의 값을 임시 보관할 temp를 만들어주자
		//temp의 크기는 얼마인가?
		int[] temp = new int[arr.length];
		
		//임시 배열에 현재 값을 저장하자
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		
		//arr을 새로 초기화해주자
		//이때 arr의 크기는 얼마인가?
		arr = new int[arr.length - 1]; // 1인덱스가 0일때 가장 앞에 있는 인덱스를 제외하고 복사
		
		//만약 해당 인덱스가 존재하면
		//우리는 3가지 경우에 놓인다.
		//1. 인덱스가 0일때
		//	 인덱스가 0이면 우리는 새로 만든 arr에 temp의 1번부터 끝까지 복사해주면 된다!
		//	 즉 가장 앞에 있는 인덱스를 제외하고 복사하면 된다
		if(index == 0) {
			for(int i = 1; i < temp.length; i++) {
	            //하지만 여기서 한가지 주의해야할 것은
	            //temp의 1번째 값을
	            //arr의 0번째 칸에 넣고
	            //한칸씩 땡겨와야 한다는 것이다.
	            arr[i-1] = temp[i];
	         }
		 }else if(index == temp.length - 1) {
			//2. 인덱스가 가장 마지막일때
			//이때는 temp의 0번부터 temp.length - 2까지를 
			//arr에 복사해주면 된다
			//인덱스가 -1이고 거기서 해당 인덱스 값을 없애기 위해 또 -1을 함
			for(int i = 0; i < temp.length - 1; i++) {
				arr[i] = temp[i];
			}
			
		}else{
			//3. 인덱스가 중간일 때
			//index가 가운데 일 경우 이때는 우리가 temp에서 0부터 index전까지 복사
			//그리고 인덱스는 건너뛰고 index 후부터 끝까지 복사
			//이렇게 만들어주어야 한다.
			for(int i = 0; i < temp.length;i++) {
				if(i < index) {
					//0~index이전까지 복사
					arr[i] = temp[i];
				}else if(i > index){
					//인덱스 다음부터 끝까지 복사
					//temp = [0,1,2,3,4,5,6,7] //크기 8
					//index = 3
					//arr = [0,1,2,4,5,6] // 크기 7
					arr[i-1] = temp[i];//에러 발생 안함
					//arr[i] = temp[i+1]은 에러발생
					//ArrayIndexOutOfBoundsException(배열 인덱스가 범위를 벗어남)
					//에러발생 원인 : 조건식에 temp.length라고 되어있어 7까지 감
					//arr은 [7]이 존재하지 않으므로 에러발생
					
					   //<선생님 주석>
					   //temp = [1,2,3,4,5,6,7]
		               //index = 5
		               //arr = [0,1,2,3,4,6,7]
		               //arr[i] = temp[i+1]; // 이렇게 작성하게 되면  ArrayIndexOutOfBoundsException - 배열 인덱스가 범위를 벗어남 에러가 발생하게 된다.
		               //그 이유는 위의 예시로
		               //temp.length의 크기가 8일때
		               //i 의 최대값은 7 이므로
		               //arr[7] = temp[8]이 되므로
		               // temp의 크기가 8이면 인덱스가 0~7 까지 존재하기 떄문에 temp[8] 은 배열의 인덱스 범위를 벗어난 것이 됨. 그래서 에러 발생.
		               // arr[7] 또한 위에서 사이즈를 1줄여 놓았으므로 크기가 7 이기 때문에 두 값 모두 에러가 발생되는 값을 가지게 되는것임.
				}//i = index인 경우는 아무처리 안함(arr배열에 옮기지 않음)
			}
			
		}
		return arr;
	}//removeByIndex
	
	//파라미터로 넘어온 element를 배열에서 삭제하여 리턴해주는 removeByElement()
	static int[] removeByElement(int[] arr, int element) {
		//이 메소드는 우리가 기존에 만들어놨던 메소드를 재활용하면 매우 쉽게 만들어 줄 수 있다.
//		int index = indexOf(arr,element);
//		arr = removeByIndex(arr,index);
//		return arr;
		return removeByIndex(arr, indexOf(arr, element));
	}
}
