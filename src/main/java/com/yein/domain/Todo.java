package com.yein.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@XmlRootElement
@Component
public class Todo {
	private int no;
	private String title;
	private String content;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date regDate = new Date(System.currentTimeMillis());
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date expDate;

	public Todo() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", expDate="
				+ expDate + "]";
	}
}