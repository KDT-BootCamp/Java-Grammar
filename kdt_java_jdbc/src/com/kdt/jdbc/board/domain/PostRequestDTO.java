package com.kdt.jdbc.board.domain;

public class PostRequestDTO {
	private Integer id;
	private String title;
	private String content;
	private String writer;
	/*
	CREATE TABLE `tb_post` (
		    `id`            bigint(20)    NOT NULL AUTO_INCREMENT COMMENT 'PK',
		    `title`         varchar(100)  NOT NULL COMMENT '제목',
		    `content`       varchar(3000) NOT NULL COMMENT '내용',
		    `writer`        varchar(20)   NOT NULL COMMENT '작성자',
		    `view_cnt`      int(11)       default 0 COMMENT '조회 수',
		    `notice_yn`     tinyint(1)    NOT NULL COMMENT '공지글 여부',
		    `delete_yn`     tinyint(1)    NOT NULL COMMENT '삭제 여부',
		    `created_date`  datetime      NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
		    `modified_date` datetime               DEFAULT NULL COMMENT '최종 수정일시',
		    PRIMARY KEY (`id`)
		) COMMENT '게시글';
	*/
	
	public PostRequestDTO() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PostRequestDTO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
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

	@Override
	public String toString() {
		return "PostRequestDTO [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
}
