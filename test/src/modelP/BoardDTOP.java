package modelP;

import java.util.Calendar;

public class BoardDTOP {
	//12.글쓰기 게시판에 들어갈 필드명 / 캡슐화  / 오버라이딩
	private int id;
	private String title;
	private int writerId;
	private String writerName;
	private String content;
	private Calendar writtenDate;
	private Calendar updateDate;
	
	
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
	public Calendar getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}
	
	
	public boolean equals(Object o) {
		if(o instanceof BoardDTOP) {
			BoardDTOP b = (BoardDTOP)o;
			if(id == b.id) {
				return true;
			}
		}
		return false;
	}
	
}
