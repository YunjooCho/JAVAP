package class_constructor;
/*
��ü�迭
���� �Ǹŷ� ���ϱ�
���� �����հ赵 ���Ͻÿ�

[������]
-------------------------------------
PUM      JAN      FEB      MAR      TOT
-------------------------------------
���       100       80       75        255
����        30       25       10        xxx
����        25       30       90        xxx
------------------------------------
        xxx      xxx      xxx         
        
*/

//static ����
//�迭? - ������ü�迭(1�κ�)
//FruitŬ������ �����Ͽ� ó��
//main�޼ҵ�� ��¿�
//BufferedReader �ʿ�X
//�����ڸ� ���� ������ �ޱ�
//calcTot()
//display()  - ���ϸ�, 1��, 2��, 3��, �հ�
//output() - 1���� �հ�, 2���� �հ�, 3���� �հ踦 ����ϴ� �޼ҵ�

//class Fruit {
//	     ������
//	   calcTot() - ��� �հ� ���ϴ� �޼ҵ�
//	   display() - ���ϸ�, 1��, 2��, 3��, �հ�
//	   output() - 1���� �հ�, 2���� �հ�, 3���� �հ踦 ����ϴ� �޼ҵ�
//	}


public class FruitMain {
	//1.�ʵ��
	private String product;
	private int jan, feb, mar, tot;
	static int jansum, febsum, marsum;
	final static int SIZE = 3;
	static FruitMain[] arr;
	//��private int price; - ������ �Է¹޾Ƽ� ��굵 �غ���
	
	//2.������
	public FruitMain(String product, int jan, int feb, int mar) {
		this.product = product;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}
	
	//3.�޼ҵ�
	public String getProduct() {
		return product;
	}
	public int getJan() {
		return jan;
	}
	public int getFeb() {
		return feb;
	}
	public int getMar() {
		return mar;
	}
	public int getTot() {
		return tot;
	}
	public int getJanSum() {
		return jansum;
	}
	public int getFebSum() {
		return febsum;
	}
	public int getMarSum() {
		return marsum;
	}
	
	public void calcTot() {
		tot = jan + feb + mar;//this.�� �����Ǿ� ����
	}
	
	public static void output() {
		for(int i = 0; i < SIZE; i++) {
			jansum += arr[i].getJan();
		}
		
		for(int i = 0; i < SIZE; i++) {
			febsum += arr[i].getFeb();
		}
		
		for(int i = 0; i < SIZE; i++) {
			marsum += arr[i].getMar();
		}
	}
	
	
	public void disp() {
		System.out.println("-------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("-------------------------------------");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getProduct() + "\t"
					           + arr[i].getJan() + "\t"
					           + arr[i].getFeb() + "\t"
					           + arr[i].getMar() + "\t"
					           + arr[i].getTot());
		}
	}
	
	public static void main(String[] args) {
		//4.�迭 ����
		arr = new FruitMain[SIZE];
		arr[0] = new FruitMain("���", 100, 80, 75);
		arr[1] = new FruitMain("����", 30, 25, 10);
		arr[2] = new FruitMain("����", 25, 30, 90);
		
		//5.�޼ҵ� ����
		for(int i = 0; i < SIZE; i++) {
			arr[i].calcTot();
		}
		FruitMain.output();
		arr[2].disp();
		System.out.println("-------------------------------------");
		System.out.println("   \t" + jansum + "\t" + febsum + "\t" + marsum);
	}
}
