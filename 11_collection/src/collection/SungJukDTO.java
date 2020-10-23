package collection;

import java.text.DecimalFormat;

/*
�������� ���α׷�

1. ��ȣ, �̸�, ����, ����, ���������� �Է��Ͽ� ������ ����� ���Ͻÿ�
2. �� ��ɿ� ���� 3���� Ŭ������ ������ �ۼ��Ͻÿ�
     SungJukDTO.java - 1�κ�
     SungJukService.java
     SungJukMain.java - ȣ�⸸, ����� �ۼ��� ���� �̻� ����, �Է��� ���ʿ�
3.����� �Ҽ����� 3°�ڸ����� ���
  �Ҽ����� �ڸ����� 0�̸� ������� �ʴ´�
  92.000 �� 92�� ����Ͻÿ�
4. ��ȣ�� �ߺ������ʰ� �Է��Ѵ�
5. �̸��� �ߺ��Ǿ ��(�ߺ� �Ǵ� ��� ������ȣ�� �Ҵ��, �Ȱ��� �̸��� �Է��غ���)

menu()
*****************
   1. �Է�  //�����
   2. ���
   3. �˻�
   4. ����  //�����
   5. ����  //���� ������̶� �� ����
   6. ��
*****************
   ��ȣ : 8
1~6�߿� �����ϼ���

insertArticle()
��ȣ �Է� :
�̸� �Է� :
���� �Է� :
���� �Է� :
���� �Է� :

printArticle()
��ȣ          �̸�         ����        ����          ����         ����           ���
15      ȫ�浿        90      92      91      xxx      xx.xxx
30      ��ġ           85      92      100     xxx      xx.xxx

searchArticle()
�˻� �� �̸� �Է� : �ڳ�
ã���� �ϴ� �̸��� �����ϴ�

�˻� �� �̸� �Է� : ȫ�浿
��ȣ   �̸�   ����   ����   ����   ����   ���
15      ȫ�浿   90      92      91      xxx      xx.xxx
16      ȫ�浿   89      45      78      xxx      xx.xxx

deleteArticle() - �Ȱ��� �̸��� ������ �ش� �̸��� ��� ����
���� �� �̸� �Է� : ȫ�浿
�����͸� �����Ͽ����ϴ�

sortArticle()
1. �̸����� ��������
2. �������� ��������
3. �����޴�
 ��ȣ �Է� : 

*/
public class SungJukDTO implements Comparable<SungJukDTO>{
	//1.�ʵ� ����
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	//2.ĸ��ȭ
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	

	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getEng() {
		return eng;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	public int getMath() {
		return math;
	}
	
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getTot() {
		return tot;
	}
	
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getAvg() {
		return avg;
	}
	
	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3.0; //avg = tot / 3.; ->�̰͵� ��밡��
	}
	
	//printerArticle���� ��½� ���
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.###");
		return no + "\t"
			 + name + "\t"
			 + kor + "\t"
			 + eng + "\t"
			 + math + "\t"
			 + tot + "\t"
			 + df.format(avg);
	}
	
	
	//sort�Լ��� �ҷ��� ���, ���� ū�� ������ �������� �˷��ָ� sort�� ����
	public int compareTo(SungJukDTO s) { //Comparator, �ʵ忡 ����� ���� �Ķ����(��� �� ��?), ��������
		if(this.tot < s.tot) {
			return 1;
		}else if(this.tot > s.tot) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
