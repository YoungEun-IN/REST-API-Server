package com.yein.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yein.domain.Todo;

@Repository
public interface TodoMapper {
    public List<Todo> getList();
	public void insert(Todo todo);
	public Todo read(Todo todo);
	public void update(Todo todo);
	public void delete(Todo todo);
}