package com.yein.rest;

import javax.ws.rs.core.Response;

import com.yein.domain.Todo;

public interface TodoService {
	Response getList();
	Response insert(Todo shop);
	Response read(long shopNo);
	Response update(Todo shop);
	Response delete(long shopNo);
}
