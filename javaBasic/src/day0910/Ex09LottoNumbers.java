package day0910;

import java.util.Random;

//로또번호 제작기
public class Ex09LottoNumbers {
	//로또 번호는 1~45까지 6개의 숫자가 필요하니까
	//우리가 미리 상수를 만들어놓자
	
	//하드코딩
	//하드코딩이란 경직된 코딩이란 뜻으로써
	//코딩의 난이도는 낮지만 유지보스는 어려워지는 형태의 코딩을
	//하드코딩이라고 한다
	
	//쉽게 찾기 위해 여기에 입력
	final static int SIZE = 6; //static final도 사용가능
	final static int MAX = 45; //static final도 사용가능
	
	public static void main(String[] args) {
		//로또 번호를 저장할 인트배열을 만들어주자
		int[] lottoNumbers = new int[SIZE];
		
		//난수
		Random random = new Random();
		
		//for문을 통해서 랜덤 숫자를 배열에 차례대로 넣어보자
		for(int i = 0; i < lottoNumbers.length; i++) {
			//랜덤 변수의 nextInt() 메소드는
			//괄호 안의 최대값을 지정해 줄 수 있다.
			//하지만 최대값을 넣어주면
			//0부터 (최대값-1)까지의 숫자가 나오기 때문에
			//만약 1부터 최대값까지를 뽑아내고 싶으면
			//무조건 결과값에 1을 더해주면 된다.
			lottoNumbers[i] = random.nextInt(MAX) + 1; 
			//random.nextInt(MAX)의 범위 : 0 ~ 44
			//0~44에 +1씩 -> 1 ~ 45
		}
		
		//배열에 들어간 값들을 확인해보자
		System.out.println("난수 생성 직후");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//여기까지는 우리가 중복값도 제거가 안되어있고
		//순서도 뒤죽박죽이다
		//따라서 중복값을 제거해주고
		//새로운 값을 넣어주고
		//마지막으로 정렬까지 해주어야 한다
		
		//중복이란?
		//확인하는 두 인덱스가 다르지만
		//해당 인덱스에 저장되어있는 값이 같을 때를 중복이라고 한다.
		
		//예시 : 5 13 2 13 4 8
		// 이 저장되어 있는 인덱스에서
		// 1번째와 3번째의 인덱스는 다르지만
		// 저장된 값이 같으므로 중복이다
		
		// 우리는 이중 for문을 사용해서
		// i번째와 j번째를 비교
		// 만약 i와 j가 다르지만
		// i번째와 j번째의 값이 같다면?
		// 중복이므로
		// i번째에 새로운 값을 넣어준다.
		
		for(int i = 0; i < SIZE; i++) { //for 1
			for(int j = 0; j < SIZE; j++) {//for 1-1
				//i가 0일때
				//j가 0~5까지 검사해서
				//같은 값이 있으면
				//i번째에 새로운 값을 넣어주고
				//i를 -1로 초기화해준다
				//왜냐하면 i를 -1로 초기화해주고 나서
				//실행되는 명령어는 i++이기 때문에
				//i는 0이 된다
				//따라서 처음부터 다시 검사가 된다
				
				//만약 i와 j는 다르지만
				//lottoNumbers[i]와 lottoNumbers[j]가 같으면
				//중복이라고 한다.
				
				//18 23 29 5 45 45
				//i : 0 0 0 0 0 0 1 1 1 1 1 1 2 2 2 2 2
 				//j : 0 1 2 3 4 5 0 1 2 3 4 5 0 1 2 3 4
				//lottoNumbers[i] : 18 18 18 18 18 18 23 23 23 23 23 23 29 29 29 29 29 29
 				//lottoNumbers[j] : 18 23 29 5  45 45 18 23 29 5  45 45 18 23 29 5  45 45
 				//맨 처음은 인덱스가 같으므로 값이 같아도 중복이 아님
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1; //i에 새로운 값을 넣음
					j = -1; //이후 j++이 실행되므로 인덱스에 들어갈수 없는 값 -1을 입력 -> 0으로 초기화하여 처음부터 검사시작 (i는 중복이 검출된 값일 때부터 시작(i = 4)
				}//if문
			}//for j문
		}//for i문
		System.out.println("중복제거 후");
		for(int i = 0; i < lottoNumbers.length; i++) {//for2 중복
			System.out.println(lottoNumbers[i]);
			
		}
		
		//정렬을 해보자
		//정렬의 경우
		//i번째가 i + 1보다 값이 크면?
		//2개의 위치를 바꿔주면 된다
		//바꾸고 나서는 i를 -1로 초기화하면
		//i++ 때문에
		//i는 0부터 다시 검사한다
		
		//18 23 29 5 25 45
		//i   : 0 1 2 
		//i+1 : 1 2 3  
		//lottoNumbers[i]   : 18 23 29 
		//lottoNumbers[i+1] : 23 29 5   ->29와  5의 순서를 바꿈 / 다시 검사 시작
		
		//프로그램적으로 두 변수의 값을 교환하려면 어떻게 해야할까?
		
		//int a = 5;
		//int b = 6;
		//int temp = a;
		//a = b;
		//a가 6이 된다
		//b = temp;
		
		for(int i = 0; i < lottoNumbers.length - 1; i++) { //for 3 정렬
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
				int temp = lottoNumbers[i];
				lottoNumbers[i] = lottoNumbers[i+1];
				lottoNumbers[i+1] = temp;
				i = -1;
		
			}//if			
		}//for
		System.out.println("정렬 후");
		
		for(int i = 0; i < lottoNumbers.length; i++) { //for 4 출력
			System.out.println(lottoNumbers[i]);
		}//for
	}

}
