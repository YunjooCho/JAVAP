package day0918;
//숙제
//게시판 을 만들어보세요
//게시판에 들어갈 정보: -필드
//제목
//내용
//작성자

import day0921.Board;

//게시판에 필요한 기능: -메소드
//작성하기
//목록보기
//개별보기
//수정하기
//삭제하기

//제출방법:
//기능별 스샷을 찍어서 단톡방에 
//올려주시면 됩니다. (한번에 여러장 묶음 올리기로)

//비고)
//1. 배열의 동적할당을 사용하세요(=ArrayUtil에 메소드 새로 만드세요)
//ArrayUtil 클래스 안에 car 버전 만든거처럼 post 버전으로 해서 메소드 만들기

public class Post {
 //필드 설정
 private String title;
 private String contents;
 private String writer;
 
 //필드에 대한 캡슐화(겟터&셋터)
 public void setTitle(String title) { //객체필드와 파라미터를 연결(파라미터 값을 객체필드에 저장)
	 this.title = title;
 }
 public String getTitle() { //객체필드를 호출된 곳에 넘겨줌
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
 
 //생성자(파라미터 없는 생성자)
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
