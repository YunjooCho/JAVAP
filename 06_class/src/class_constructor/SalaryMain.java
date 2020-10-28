package class_constructor;

import java.text.DecimalFormat;

/*
직원들의 월급을 계산하는 프로그램을 작성하시오
객체 배열로 작성하시오

클래스명 : SalaryDTO
필드       : name, position, basePay, benefit, taxRate, tax, salary
생성자    : 데이터를 입력
calc() - 계산
getName()
getPosition()

세금 = (기본급 + 수당) * 세율;
월급 = 기본급 + 수당 - 세금;

세율은 200만원 이하 : 1%(0.01), 
     400만원 이하 : 2%(0.02), 
     400만원 초과 : 3%(0.03)으로 설정한다.

[실행결과]
이름      직급      기본급               수당      세율      세금      월급
홍길동   부장      5000000      200000
유재석   과장      3500000      150000
박명수   사원      1800000      100000
 */
public class SalaryMain {
	public static void main(String[] args) {
		//객체배열 생성
		SalaryDTO[] ar = new SalaryDTO[]{new SalaryDTO("홍길동", "부장", 5000000, 200000),
									 	 new SalaryDTO("유재석", "과장", 3500000, 150000),
									 	 new SalaryDTO("박명수", "사원", 1800000, 100000)}; 
		
		//메소드 호출 - 계산 메소드
		//main()메소드에서 출력하시오
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("이름\t직급\t기본급\t\t수당\t\t세율\t세금\t\t월급");
		System.out.println("-----------------------------------------------------------------------------------");
		for(SalaryDTO dto : ar) { //for(int i = 0; i < ar.length; i++)
			dto.calc(); //ar[i].calc()
//			System.out.println(ar[i].getName() + "\t" 
//						      +ar[i].getPosition() + "\t"
//						      +df.format(ar[i].getBasePay()) + "원\t" 
//						      +df.format(ar[i].getBenefit()) + "원\t"
//						      +(int)(ar[i].getTaxRate()*100) + "%\t "
//						      +df.format(ar[i].getTax()) + "원\t" 
//						      +df.format(ar[i].getSalary()) + "원");
			System.out.println(dto); //SalaryDTO.java에서 toString오버라이딩을 했기 때문에
							 		 //객체를 출력하는 것 만으로도 위와 같은 내용이 출력가능
		}

	}

}
