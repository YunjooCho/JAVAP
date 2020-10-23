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


//������ : FruitŬ���� ����
//       get�޼ҵ� ��� ����
//       ����� �迭�� �ƴ� 1�κ�

class Fruit{
	//1.�ʵ��
		private String product;
		private int jan, feb, mar, tot;
		private static int jansum, febsum, marsum;
		final static int SIZE = 3;
		static FruitMainT[] arr;
		//�� �ʵ带 String[] product, int[] jan ������ ���� ���� 1�κ��� �ƴ�
		//��private int price; - ������ �Է¹޾Ƽ� ��굵 �غ���
		
		//2.������
		public Fruit(String product, int jan, int feb, int mar) {
			this.product = product;
			this.jan = jan;
			this.feb = feb;
			this.mar = mar;
		}
		
		//3.�޼ҵ�
//		public String getProduct() {
//			return product;
//		}
//		public int getJan() {
//			return jan;
//		}
//		public int getFeb() {
//			return feb;
//		}
//		public int getMar() {
//			return mar;
//		}
//		public int getTot() {
//			return tot;
//		}
//		public int getJanSum() {
//			return jansum;
//		}
//		public int getFebSum() {
//			return febsum;
//		}
//		public int getMarSum() {
//			return marsum;
//		}
		
		public void calcTot() {
			tot = jan + feb + mar;//this.�� �����Ǿ� ����
			
			jansum += jan;
			febsum += feb;
			marsum += mar;
		}
		
		public void disp() {
			
			System.out.println(product + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
			
//			for(int i = 0; i < arr.length; i++) {
//				System.out.println(arr[i].getProduct() + "\t"
//						           + arr[i].getJan() + "\t"
//						           + arr[i].getFeb() + "\t"
//						           + arr[i].getMar() + "\t"
//						           + arr[i].getTot());
//			}
		}
		
		public static void outPut() {
			System.out.println("\t" + jansum + "\t" + febsum + "\t" + marsum);
		}//outPut()�� ���� ���� ���� : disp()�� main���� �ݺ��ǹǷ� ���� �и���
	
}


public class FruitMainT {
	
	
	public static void main(String[] args) {
		//4.�迭 ����
		Fruit[] ar = new Fruit[3];
		ar[0] = new Fruit("���", 100, 80, 75);
		ar[1] = new Fruit("����", 30, 25, 10);
		ar[2] = new Fruit("����", 25, 30, 90);
		
		
		System.out.println("-------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("-------------------------------------");
		for(Fruit f : ar) {
			f.calcTot();
			f.disp();
		System.out.println("-------------------------------------");
		Fruit.outPut();
		}
		
		
	}
}
