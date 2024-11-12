package com.kdt.jdbc.board.domain;

public class PostResponseDTO {
	private Integer id;
	private String title, content, writer;
	private Integer view_cnt ;
	private Integer notice_yn, delete_yn;
	
	public PostResponseDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(Integer view_cnt) {
		this.view_cnt = view_cnt;
	}

	public Integer getNotice_yn() {
		return notice_yn;
	}

	public void setNotice_yn(Integer notice_yn) {
		this.notice_yn = notice_yn;
	}

	public Integer getDelete_yn() {
		return delete_yn;
	}

	public void setDelete_yn(Integer delete_yn) {
		this.delete_yn = delete_yn;
	}

	@Override
	public String toString() {
		return "PostResponseDTO [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", view_cnt=" + view_cnt + ", notice_yn=" + notice_yn + ", delete_yn=" + delete_yn + "]";
	}
	
	
}
