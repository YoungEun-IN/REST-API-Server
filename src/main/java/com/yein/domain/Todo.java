package com.yein.domain;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class Todo {
	private int no;
	private String title;
	private String content;
	private Date regDate;
	private String expDate;

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

	public Date getRegdate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd"); 
		Date date = null;
		try {
			date = df.parse(regDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.regDate = date;
	}

	public String getExpDate() {
		return expDate;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", content=" + content + ", regdate=" + regDate + ", expDate="
				+ expDate + "]";
	}
}