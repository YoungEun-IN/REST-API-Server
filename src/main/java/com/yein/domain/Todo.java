package com.yein.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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

	public Date getExpDate() {
		return expDate;
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
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", expDate="
				+ expDate + "]";
	}
}