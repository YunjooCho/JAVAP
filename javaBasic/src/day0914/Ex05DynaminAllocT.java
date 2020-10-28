package day0914;

public class Ex05DynaminAllocT {
	
	   // 동적할당을 위한 여러가지 메소드를 만들어보자

	   // 1. 배열의 현재 크기를 확인하는 size() 메소드
	   static int size(int[] arr) {
	      return arr.length;
	   }
	   
	   // 2. 배열에 새로운 요소를 추가하는 메소드
	   static int[] add(int[] arr, int element) {
	      //우리가 파라미터로 받은 element를 
	      //arr에 추가할것인데
	      //무조건 arr의 가장 맨뒤에 붙여줄 것이다.
	      //하지만 우리가 arr에 크기를 유동적으로 변경을 해야하기 때문에
	      //1. arr을 임시 배열에 복사하고
	      //2. 현재크기+1의 크기로 초기화하고
	      //3. 임시 배열에 복사해놓은 값들을 복사하고
	      //4. 맨 마지막 위치에 element를 추가해서
	      //5. arr을 return 해주어야 한다.
	      
	      //임시 배열을 선언해보자
	      //임시 배열의 크기는 파라미터로 넘어온 arr의 크기와 같다.
	      int size = arr.length;
	      
	      int[] temp = new int[size];
	      
	      //임시 배열에 현재 arr의 값들을 차례대로 복사해주자
	      for(int i = 0; i < size; i++) {
	         temp[i] = arr[i];
	      }
	      
	      // 현재 배열을 현재 크기 + 1로 초기화해준다.
	      // new 를 만나는 순간
	      // 기존에 배열에 들어가 있던 모든 값들은
	      // 다 사라진다
	      // 현재 arr은 기본형 데이터타입인 int의 배열이기 때문에
	      // 모든 인덱스가 0으로 초기화된다.
	      
	      // 따라서 배열의 현재 내용을 유지를 한채 크기를 늘리기 위해서는
	      // 현재 배열의 내용을 임시 배열에 저장하고
	      // 크기를 늘리고
	      // 임시 배열의 값들을 다시 복사해와야 한다.
	      arr = new int[size+1];
	      
	      // 현재 배열의 임시 배열의 값을 차례대로 복사해주자
	      for(int i = 0; i < size; i++) {
	         arr[i] = temp[i];
	      }
	      
	      // int[] arr = new int[4]
	      // 해당 배열의 가장 마지막 index 번호는 몇번인가?
	      // 3
	      // 현재 크기는?
	      // 4
	      
	      // arr의 크기를 1 늘리면
	      // 새로운 크기는?
	      // 5
	      // 늘어난 배열의 가장 마지막 인덱스 번호는?
	      // 4
	      
	      // arr의 가장 마지막 index를 element로 초기화해주자
	      // arr이 처음 파라미터로 넘어올때 
	      // 가장 마지막 인덱스는 현재 크기 - 1이다.
	      // 즉 size - 1이다.
	      // 하지만 이제는 크기가 1 늘어났으므로
	      // 가장 마지막 인덱스는 size가 된다.
	      
	      arr[size] = element;
	      
	      
	      return arr;
	   }
	   
	   //파라미터로 넘어온 배열에 파라미터로 넘어온 값이 존재하는지 체크하는 contains 메소드
	   static boolean contains(int[] arr, int element) {
	      //for문을 이용해서
	      //arr의 각 인덱스와 element를 비교해서 같으면 return true를 한다.
	      for(int i = 0; i < arr.length; i++) {
	         if(arr[i] == element) {
	            //i번째 인덱스와 element의 값이 같으므로 
	            //return true 해준다.
	            return true;
	         }
	      }
	      
	      return false;
	   }
	   
	   //파라미터로 넘어온 배열에 파라미터로 넘어온 값이 몇번 인덱스에 있는지 확인해주는 indexOf메소드
	   static int indexOf(int[] arr, int element) {//default접근자, package접근자
	      //여기서 여러분들이 한가지 고민해볼 것은
	      //만약 element가 arr에 존재하지 않는다면
	      //우리가 어떤 값을 리턴해주어야 할까?
	      //인덱스는 무조건 0부터 arr의 크기 - 1이기 때문에
	      //양의 정수로 우리가 존재하지 않는다는 표시해주기 힘들다.
	      //따라서 음의 정수중에서 가장 간단한 "-1"을 리턴해서
	      //만약 배열에 해당 엘리멘트가 존재하지 않으면 
	      //인덱스는 -1을 리턴해주면 된다.
	      
	      //for문을 돌려서 
	      //만약 i번째 인덱스 값이 element와 같으면
	      //i를 리턴해주면 된다.
	      for(int i = 0; i < arr.length; i++) {
	         if(arr[i] == element) {
	            return i;
	         }
	      }
	      
	      
	      return -1;
	   }
	   
	   public static void main(String[] args) {
	      int[] arr2 = new int[5];
	      arr2[0] = 10;
	      System.out.println("arr2.length: "+arr2.length);
	      arr2[1] = 20;
	      System.out.println("arr2.length: "+arr2.length);
	      arr2[2] = 30;
	      System.out.println("arr2.length: "+arr2.length);
	      
	      
	      int[] arr = new int[0];
	      
	      System.out.println("arr의 현재크기: "+size(arr));
	      
	      arr = add(arr, 10);
	      System.out.println("arr의 현재크기: "+size(arr));
	      for(int i = 0; i < arr.length; i++) {
	         System.out.println(arr[i]);
	      }
	      
	      arr = add(arr, 5);
	      System.out.println("arr의 현재크기: "+size(arr));
	      for(int i = 0; i < arr.length; i++) {
	         System.out.println(arr[i]);
	      }
	      
	      arr = add(arr,4);
	      System.out.println("arr의 현재크기: "+size(arr));
	      for(int i = 0; i < arr.length; i++) {
	         System.out.println(arr[i]);
	      }
	      
	      //우리가 arr을 add 메소드의 결과값으로 덮어씌울대마다
	      //arr의 값이 유지가 되면서 늘어나는 것을 확인할 수 있다!
	      
	      //contains 메소드를 실행한 결과값
	      System.out.println("===========contains()=============");
	      //arr에 5가 존재합니까?
	      System.out.println("contains(arr, 5): "+contains(arr, 5));
	      //arr에 25가 존재합니까?
	      System.out.println("contains(arr, 25): "+contains(arr, 25));
	      
	      System.out.println("===========indexOf()=============");
	      //arr 에서 5의 인덱스는 얼마입니까?
	      System.out.println("indexOf(arr, 5): " + indexOf(arr, 5));
	      //arr 에서 25의 인덱스는 얼마입니까?
	      System.out.println("indexOf(arr, 25): " + indexOf(arr, 25));
	      
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
	   }
	   
	   // 배열에서 해당 인덱스의 요소를 삭제하는 메소드 removeByIndex
	   // 자 우리가 배열에 요소를 추가하니깐 크기가 늘어났다.
	   // 그렇다면 우리가 배열에 요소를 삭제하면? 크기가 줄어야 한다!
	   
	   static int[] removeByIndex(int[] arr, int index) {
	      //먼저 제거하기 전에 해당 인덱스가
	      //가능한 index인지 부터 체크한다.
	      //만약 불가능한 인덱스라면 arr을 그대로 리턴해주면 된다.
	      
	      //인덱스가 가능한 범위는 몇부터 몇인가? 0부터 arr.length - 1
	      if(index < 0 || index >= arr.length) {
	         return arr;
	      }
	      
	      //배열의 값을 임시 보관할 temp를 만들어주자
	      //temp의 크기는 얼마인가?
	      int[] temp = new int[arr.length];
	      
	      //임시 배열에 현재 값을 for문을 이용해서 복사해주자
	      for(int i = 0; i < arr.length; i++) {
	         temp[i] = arr[i];
	      }
	      
	      // arr을 새로 초기화해주자
	      // 이때 arr의 크기는 얼마인가?
	      arr = new int[arr.length - 1];
	      
	      //만약 해당 인덱스가 존재하면
	      //우리는 3가지 경우에 놓인다.
	      //1. 인덱스가 0일때
	      //   인덱스가 0이면 우리는 새로 만든 arr에 temp의 1번부터 끝까지 복사해주면 된다!
	      //   즉 가장 앞에 인덱스를 제외하고 복사하면 된다.
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
	         //arr에 복사해주면 된다.
	         for(int i = 0; i < temp.length - 1; i++) { //temp.length - 1  : 끝배열도 옮기지 않을거라서 
	        	                                        //마지막 배열(temp.length-1)보다 더 작은 값만 for문으로 확인
	            arr[i] = temp[i];
	         }
	      }else {
	         //3. 인덱스가 중간일때
	         for(int i = 0; i < temp.length; i++) {
	            if(i < index) {
	               //0~index이전까지 복사
	               arr[i] = temp[i];
	            }else if(i > index){
	               //인덱스 다음부터 끝까지 복사
	               //temp = [0, 1, 2, 3, 4, 5, 6, 7]
	               //index = 5
	               //arr = [0, 1, 2, 3, 4, 6, 7]
	            
	               arr[i - 1] = temp[i];
	               
	            }
	         }
	      }
	      
	      return arr;
	      
	   }


}
