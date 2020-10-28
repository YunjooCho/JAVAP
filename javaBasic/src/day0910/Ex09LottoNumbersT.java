package day0910;

import java.util.Random;


public class Ex09LottoNumbersT {

	//로또 번호는 1~45까지 6개의 숫자가 필요하니깐
	//우리가 미리 상수를 만들어놓자
	   
	   
	   final static int SIZE = 6;
	   final static int MAX = 45;
	   public static void main(String[] args) {
	      //로또 번호를 저장할 인트배열을 만들어주자
	      int[] lottoNumbers = new int[SIZE];
	      Random random = new Random();
	      
	      //for문을 통해서 랜덤 숫자를 배열에 차례대로 넣어보자
	      for(int i = 0; i < lottoNumbers.length; i++) {
	         
	         lottoNumbers[i] = random.nextInt(MAX) + 1;
	      }
	      
	      //배열에 들어간값들을 확인해보자
	      System.out.println("난수 생성 직후");
	      for(int i = 0 ; i < lottoNumbers.length; i++) {
	         System.out.println(lottoNumbers[i]);
	      }
	      
	      
	      //중복제거
	      for(int i = 0; i < SIZE; i++) {
	         for(int j = 0; j < SIZE; j++) {
	  
	            if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
	               lottoNumbers[i] = random.nextInt(MAX) + 1;
	               j = -1;
	            }
	         }
	      }
	      
	      System.out.println("중복제거 후");
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














