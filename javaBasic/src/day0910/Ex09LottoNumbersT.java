package day0910;

import java.util.Random;


public class Ex09LottoNumbersT {

	//�ζ� ��ȣ�� 1~45���� 6���� ���ڰ� �ʿ��ϴϱ�
	//�츮�� �̸� ����� ��������
	   
	   
	   final static int SIZE = 6;
	   final static int MAX = 45;
	   public static void main(String[] args) {
	      //�ζ� ��ȣ�� ������ ��Ʈ�迭�� ���������
	      int[] lottoNumbers = new int[SIZE];
	      Random random = new Random();
	      
	      //for���� ���ؼ� ���� ���ڸ� �迭�� ���ʴ�� �־��
	      for(int i = 0; i < lottoNumbers.length; i++) {
	         
	         lottoNumbers[i] = random.nextInt(MAX) + 1;
	      }
	      
	      //�迭�� �������� Ȯ���غ���
	      System.out.println("���� ���� ����");
	      for(int i = 0 ; i < lottoNumbers.length; i++) {
	         System.out.println(lottoNumbers[i]);
	      }
	      
	      
	      //�ߺ�����
	      for(int i = 0; i < SIZE; i++) {
	         for(int j = 0; j < SIZE; j++) {
	  
	            if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
	               lottoNumbers[i] = random.nextInt(MAX) + 1;
	               j = -1;
	            }
	         }
	      }
	      
	      System.out.println("�ߺ����� ��");
	      for(int i = 0; i < lottoNumbers.length; i++) {
	         System.out.println(lottoNumbers[i]);
	      }
	      
	      //����
	     
	      for(int i = 0; i < lottoNumbers.length - 1; i++) {
	         if(lottoNumbers[i] > lottoNumbers[i+1]) {
	            int temp = lottoNumbers[i];
	            lottoNumbers[i] = lottoNumbers[i+1];
	            lottoNumbers[i+1] = temp;
	            i = -1;
	         }
	      }
	      
	      System.out.println("���� ��");
	      
	      for(int i = 0; i < lottoNumbers.length; i++) {
	         System.out.println(lottoNumbers[i]);
	      }
	   }
	}














