package class_constructor;

import java.text.DecimalFormat;

public class SalaryDTO {
	//Ŭ������ : SalaryDTO(Data Transfer Object)
	//VO(Value Object)
	//DAO(Database Access Object)
	//Bean : ����
	
	//�ʵ�       : name, position, basePay, benefit, taxRate, tax, salary
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
		
		//�������
		if(total <= 2000000) {
			taxRate = 0.01;
		}else if(total <= 4000000) {
			taxRate = 0.02;
		}else if(total > 4000000){
			taxRate = 0.03;
		}
		
		//���ݰ��
		tax = (int)((basePay + benefit) * taxRate);
		
		//���� ���
		salary = basePay + benefit - tax;
	}
	
	@Override
	public String toString() {//Ŭ���� �ȿ� �����Ƿ� �ʵ� �ٷ� ȣ�� ����
		DecimalFormat df = new DecimalFormat(); //�⺻ 3�ڸ����� ��ǥ
		return name + "\t"
			 + position + "\t"
			 + df.format(basePay) + "��\t"
			 + df.format(benefit) + "��\t"
			 + (int)(taxRate*100) + "%\t"
			 + df.format(tax) + "�� \t"
			 + df.format(salary) + "��";
	}
	
}
