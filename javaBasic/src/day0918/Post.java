package day0918;
//����
//�Խ��� �� ��������
//�Խ��ǿ� �� ����: -�ʵ�
//����
//����
//�ۼ���

import day0921.Board;

//�Խ��ǿ� �ʿ��� ���: -�޼ҵ�
//�ۼ��ϱ�
//��Ϻ���
//��������
//�����ϱ�
//�����ϱ�

//������:
//��ɺ� ������ �� ����濡 
//�÷��ֽø� �˴ϴ�. (�ѹ��� ������ ���� �ø����)

//���)
//1. �迭�� �����Ҵ��� ����ϼ���(=ArrayUtil�� �޼ҵ� ���� ���弼��)
//ArrayUtil Ŭ���� �ȿ� car ���� �����ó�� post �������� �ؼ� �޼ҵ� �����

public class Post {
 //�ʵ� ����
 private String title;
 private String contents;
 private String writer;
 
 //�ʵ忡 ���� ĸ��ȭ(����&����)
 public void setTitle(String title) { //��ü�ʵ�� �Ķ���͸� ����(�Ķ���� ���� ��ü�ʵ忡 ����)
	 this.title = title;
 }
 public String getTitle() { //��ü�ʵ带 ȣ��� ���� �Ѱ���
	 return title;
 }
 
 public void setContents(String contents) {
	 this.contents = contents;
 }
 public String getContents() {
	 return contents;
 }
 
 public void setWriter(String writer) {
	 this.writer = writer;
 }
 public String getWriter() {
	 return writer;
 }
 
 //������(�Ķ���� ���� ������)
 public Post() {
	 title = new String();
	 contents = new String();
	 writer = new String();
 }
 
 //equals
 public boolean equals(Object o) {
		if(o instanceof Post) {
			Post p = (Post)o;
			if(title.equals(p.title))
			return true;
		}
				
		return false;
	}
 
 
 
}
