package com.yein.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@XmlRootElement(name="todo")
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
	
	@XmlElement
	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}
	
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	
	@XmlElement
	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	@XmlElement
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getExpDate() {
		return expDate;
	}
	
	@XmlElement
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "Todo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + sdf.format(regDate) + ", expDate="
				+ sdf.format(expDate) + "]";
	}
}