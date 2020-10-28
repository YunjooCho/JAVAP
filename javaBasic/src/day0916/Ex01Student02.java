package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//학생의 정보를 관리하는 프로그램을 작성하세요
//작동방식은  CarEx02.java를 참조

import day0915.Student;

public class Ex01Student02 {
	public static void main(String[] args) throws IOException {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	Student student = new Student();
	
	while(true) {
		System.out.println("=======================");
		System.out.println("학생 관리 프로그램");
		System.out.println("1. 입력     2. 출력    3. 종료");
		int choice = Integer.parseInt(bufferedReader.readLine());
		if(choice == 1) {
			
			//학생 정보 입력
			 System.out.print("이름: ");
			 student.setName(bufferedReader.readLine());
			 System.out.print("학번: ");
			 student.setId(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("국어점수: ");
			 student.setKorean(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("영어점수: ");
			 student.setEnglish(Integer.parseInt(bufferedReader.readLine()));
			 System.out.print("수학점수: ");
			 student.setMath(Integer.parseInt(bufferedReader.readLine()));
			 
		}else if(choice == 2) {
			//학생 정보 출력
			if(student.getName().equals("")) { //student.getName().isEmpty(); ->true/false
				System.out.println("아직 입력된 정보가 없습니다");
			}else {
				System.out.printf("이름: %s, 학번: %d\n", student.getName(), student.getId());
				System.out.printf("국어: %d, 영어: %d, 수학: %d",student.getKorean(),student.getEnglish(),student.getMath());
				System.out.printf("총점: %d, 평균: %.2f\n", student.calculateSum(), student.calculateAverage());
			}
		}else if(choice == 3) {
			System.out.println("사용해주셔서 감사합니다");
			break;
		}else {
			System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해 주세요");
		}
	}//메뉴 while
	
	}
}
