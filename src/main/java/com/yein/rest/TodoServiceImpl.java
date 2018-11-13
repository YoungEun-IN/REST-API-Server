package com.yein.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yein.domain.Todo;
import com.yein.mapper.TodoMapper;

@Service
@Path("/todo")
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoMapper mapper;

	// 목록조회
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getList() {
		List<Todo> todos = mapper.getList();
		System.out.println(todos.toString());
		return Response.status(200).
				header("Content-Type", "application/json;charset=UTF-8")
				.entity(todos + " list success").build();
	}

	// 삽입
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response insert(Todo todo) {
		mapper.insert(todo);
		return Response.status(200)
				.header("Content-Type", "application/json;charset=UTF-8")
				.entity(todo.toString() + " insert success").build();
	}

	// 조회
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response read(Todo todo) throws NotFoundException {
		mapper.read(todo);
		return Response.status(200)
				.header("Content-Type", "application/json;charset=UTF-8")
				.entity(todo).build();
	}

	// 수정
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response update(Todo todo) {
		mapper.update(todo);
		return Response.status(200)
				.header("Content-Type", "application/json;charset=UTF-8")
				.entity(todo.toString() + " update success").build();
	}

	// 삭제
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response delete(Todo todo) {
		mapper.delete(todo);
		return Response.status(200)
				.header("Content-Type", "application/json;charset=UTF-8")
				.entity(todo.toString() + " delete success").build();
	}
}
