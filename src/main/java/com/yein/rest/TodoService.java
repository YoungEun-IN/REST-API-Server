package com.yein.rest;

import javax.ws.rs.core.Response;

import com.yein.domain.Todo;

public interface TodoService {
	Response getList();
	Response insert(Todo todo);
	Response read(int no);
	Response update(int no, Todo todo);
	Response delete(int no);
}
