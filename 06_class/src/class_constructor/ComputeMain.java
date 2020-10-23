package class_constructor;
/*
x�� y�� ���� �޾Ƽ� ��,��,��,���� ���Ͻÿ�

Ŭ������ : Compute
�ʵ�      : x, y, sum, sub, mul, div
�޼ҵ�   : �����ڸ� ���ؼ� �����͸� ����
        calc() - ��, ��, ��, ���� ���
        getX()
        getY()
        getSum()
        getSub()
        getMul()
        getDiv()
        
[������]
X      Y      SUM      SUB      MUL      DIV
320    258
256	   125
452    365
 */
public class ComputeMain {

	public static void main(String[] args) {
		//��ü�迭
//		Compute[] ar = new Compute[3]; //���⼭ new�� Compute��� Ŭ������ ������ ���� �ƴ�,
//

	    //�迭1
		//�� 3���� �迭�� ������ ���̴�.
//		ar[0] = new Compute(320,258);
//		ar[1] = new Compute(256,125);
//		ar[2] = new Compute(452,365);
		
		//�迭2
//		Compute[] ar = {new Compute(320, 258), new Compute(256,125), new Compute(452,365)};
		//�迭3
		Compute[] ar = new Compute[]{new Compute(320,258),
                                     new Compute(256, 125),
                                     new Compute(452, 365)};
		//���� ������ ������ ���� �ƴ�(�����Ҵ�)
		//���� �濡 �߰� �Ǵ� ���� ��̸���Ʈ, �׳� �迭�� ���Ӱ� �迭�� �����ϴ� ��
		
		System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV\t");
		/*
		for(int i = 0; i < ar.length; i++) {
			ar[i].calc();
			
			System.out.println(ar[i].getX() + "\t" 
					+ar[i].getY() + "\t"
					+ar[i].getSum() + "\t"
					+ar[i].getSub() + "\t"
					+ar[i].getMul() + "\t"
					+String.format("%.2f", ar[i].getDiv()));
		}//for
		*/
//		ar[0].calc();
//		ar[1].calc();
//		ar[2].calc();
		
		for(Compute data : ar) { //length�� �Ƚᵵ �迭�� ũ�⸸ŭ for���� ����.
			data.calc();
			System.out.println(data.getX() + "\t" 
					+data.getY() + "\t"
					+data.getSum() + "\t"
					+data.getSub() + "\t"
					+data.getMul() + "\t"
					+String.format("%.2f", data.getDiv()));
		}
	}

}


//Compute c = new Compute(320, 258);//�ٸ� ��Ű���� ������ import�� �ʿ�
//c.calc();
//System.out.println(c.getX() + "\t" 
//				+c.getY() + "\t"
//				+c.getSum() + "\t"
//				+c.getSub() + "\t"
//				+ c.getMul() + "\t"
//				+String.format("%.2f", c.getDiv()));
//
//Compute bb = new Compute(256, 125);//�ٸ� ��Ű���� ������ import�� �ʿ�
//bb.calc();
//System.out.println(bb.getX() + "\t" 
//				+bb.getY() + "\t"
//				+bb.getSum() + "\t"
//				+bb.getSub() + "\t"
//				+bb.getMul() + "\t"
//				+String.format("%.2f", bb.getDiv()));
//
//Compute cc = new Compute(452, 365);//�ٸ� ��Ű���� ������ import�� �ʿ�
//cc.calc();
//System.out.println(cc.getX() + "\t" 
//				+cc.getY() + "\t"
//				+cc.getSum() + "\t"
//				+cc.getSub() + "\t"
//				+cc.getMul() + "\t"
//				+String.format("%.2f", cc.getDiv()));
//
