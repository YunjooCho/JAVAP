package day0921;

public class Board {
	//필드
	//게시글 번호, 제목, 내용, 작성자
	private int id;
	private String title;
	private String content;
	private String writer;
	
	//자동 겟터&셋터 만들기
	//오른쪽 마우스 - [Source] - [Generate Getters and Setters....] - 만들 필드들을 선택 - [Generate]클릭 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Board) {
			Board b = (Board)o; //객체 o안에 id와 title필드가 없음(필드가 있는 것은 Board의 객체)
								//형변환을 통해 필드가 Object에도 들어있게 함?
			if(id == b.id && title.contentEquals(b.title))
			return true;
		}
				
		return false;
	}//equals메소드
	
}
