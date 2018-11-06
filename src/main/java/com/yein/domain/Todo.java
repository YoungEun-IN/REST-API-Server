package com.yein.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Todo {
	private int no;
	private String title;
	private String content;
	private Date regDate;
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

	public Date getRegdate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyy-mm-dd"); 
		Date date = null;
		try {
			date = df.parse(regDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.regDate = date;
	}

	public Date getExpDate() {
		return expDate;
	}
	
	public void setExpDate(String expDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyy-mm-dd"); 
		Date date = null;
		try {
			date = df.parse(expDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.expDate = date;
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", content=" + content + ", regdate=" + regDate + ", expDate="
				+ expDate + "]";
	}
}