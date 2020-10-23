package model;

import java.util.Calendar;

public class BoardDTO {
	//12.글쓰기 게시판에 들어갈 필드명 선언 / 캡슐화 / equals(오버라이딩)
	private int id;
	private String title;
	private int writerId;
	private String writerName;
	private String content;
	private Calendar writtenDate;
	private Calendar updatedDate;
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
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calendar getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Calendar writtenDate) {
		this.writtenDate = writtenDate;
	}
	public Calendar getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	public boolean equals(Object o) { //글쓴 사람과 로그인한 사람이 같으면 true 반환
		if(o instanceof BoardDTO) {
			BoardDTO b = (BoardDTO) o;
			if(id == b.id) { //
				return true;
			}
		}
		return false;
	}
	
	
}
