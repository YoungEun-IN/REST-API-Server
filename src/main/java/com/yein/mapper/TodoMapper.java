package com.yein.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yein.domain.Todo;

@Repository
public interface TodoMapper {
    public List<Todo> getList();
	public void insert(Todo todo);
	public Todo read(int no);
	public void update(Todo todo);
	public void delete(int no);
}