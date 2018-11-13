package com.yein.rest;

import javax.ws.rs.core.Response;

import com.yein.domain.Todo;

public interface TodoService {
	Response getList();
	Response insert(Todo todo);
	Response read(Todo todo);
	Response update(Todo todo);
	Response delete(Todo todo);
}
