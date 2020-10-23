package day0910P;

import java.util.Random;

//로또번호 제작기
//로또 번호는 1~45까지 6개의 숫자가 필요하니까
//우리가 미리 상수를 만들어놓자

public class Ex09LottoNumbersP {
	final static int SIZE = 6;
	final static int MAX = 45;
	public static void main(String[] args) {
		int[] lottoNumbers = new int[SIZE];
		
		//난수
		Random random = new Random();
		for(int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = random.nextInt(MAX) + 1;
		}
		System.out.println("난수 생성 직후");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//중복제거
		for(int i = 0; i < lottoNumbers.length; i++) {
			for(int j = 0; j < lottoNumbers.length; j++) {
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1; //i에 새로운 값을 넣음
					j = -1;
				}
			}
		}
		System.out.println("중복 제거 후");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//정렬
		for(int i = 0; i < lottoNumbers.length - 1; i++) {
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
				int temp = lottoNumbers[i];
				lottoNumbers[i] = lottoNumbers[i+1];
				lottoNumbers[i+1] = temp;
				i = -1;
			}
		}
		System.out.println("정렬 후");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
	}

}
