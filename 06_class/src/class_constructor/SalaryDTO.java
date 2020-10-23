package class_constructor;

import java.text.DecimalFormat;

public class SalaryDTO {
	//클래스명 : SalaryDTO(Data Transfer Object)
	//VO(Value Object)
	//DAO(Database Access Object)
	//Bean : 씨앗
	
	//필드       : name, position, basePay, benefit, taxRate, tax, salary
	private String name;
	private String position;
	private int basePay;
	private int benefit;
	private double taxRate;
	private int tax;
	private int salary;
	
	public SalaryDTO(String name, String position, int basePay, int benefit) {
		this.name = name;
		this.position = position;
		this.basePay = basePay;
		this.benefit = benefit;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getPosition() {
		return position;
	}
	
	
	public int getBasePay() {
		return basePay;
	}
	
	
	public int getBenefit() {
		return benefit;
	}
	
	
	public double getTaxRate() {
		return taxRate;
	}
	
	
	public int getTax() {
		return tax;
	}
	
	
	public int getSalary() {
		return salary;
	}
	
	
	
	public void calc() {
		int total = this.basePay + this.benefit;
		
		//세율계산
		if(total <= 2000000) {
			taxRate = 0.01;
		}else if(total <= 4000000) {
			taxRate = 0.02;
		}else if(total > 4000000){
			taxRate = 0.03;
		}
		
		//세금계산
		tax = (int)((basePay + benefit) * taxRate);
		
		//월급 계산
		salary = basePay + benefit - tax;
	}
	
	@Override
	public String toString() {//클래스 안에 있으므로 필드 바로 호출 가능
		DecimalFormat df = new DecimalFormat(); //기본 3자리마다 쉼표
		return name + "\t"
			 + position + "\t"
			 + df.format(basePay) + "원\t"
			 + df.format(benefit) + "원\t"
			 + (int)(taxRate*100) + "%\t"
			 + df.format(tax) + "원 \t"
			 + df.format(salary) + "원";
	}
	
}
