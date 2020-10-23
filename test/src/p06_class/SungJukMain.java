package p06_class;
/*
Ŭ������ : SungJuk
�ʵ�      : name, kor, eng, math, tot, avg, grade
�޼ҵ�   : ������ 
        calc() - ����, ���, ���� ���
        getName()
        getKor()
        getEng()
        getMath()
        getTot()
        getAvg()
        getGrade()
      
[������]
----------------------------------------------------
�̸�      ����      ����      ����      ����      ���      ����
----------------------------------------------------
ȫ�浿   90      95      100
�ڳ�      100     89      75
��ġ      75      80      48
 */
public class SungJukMain {
	public static void main(String[] args) {
		SungJuk[] ar = new SungJuk[3];
		ar[0] = new SungJuk("ȫ�浿", 90, 95, 100);
		ar[1] = new SungJuk("�ڳ�", 100, 89, 75);
		ar[2] = new SungJuk("��ġ", 75, 80, 48);
		
		
		System.out.println("----------------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("----------------------------------------------------");
		for(int i = 0; i < ar.length; i++) {
			ar[i].calc();
			System.out.println(ar[i].getName() + "\t" 
							  +ar[i].getKor() + "\t" 
							  +ar[i].getEng() + "\t" 
							  +ar[i].getMath() + "\t" 
							  +ar[i].getTot() + "\t" 
							  +String.format("%.2f",ar[i].getAvg())+ "\t" 
							  +ar[i].getGrade());
		}
		
	}
}
