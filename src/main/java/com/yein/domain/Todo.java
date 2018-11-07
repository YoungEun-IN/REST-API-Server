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

	public String getRegdate() {
		SimpleDateFormat df = new SimpleDateFormat("yy/mm/dd");
		String date = df.format(regDate);
		return date;
	}

	public void setRegDate(String regDate) {
		System.out.println(regDate);
		if (regDate == null) {
			return;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(regDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.regDate = date;
	}

	public String getExpDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String date = df.format(expDate);
		return date;
	}

	public void setExpDate(String expDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(expDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.expDate = date;
		System.out.println(this.expDate);
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", content=" + content + ", regdate=" + regDate + ", expDate="
				+ expDate + "]";
	}
}