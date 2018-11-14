package com.yein.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getList() {
		System.out.println("요청들어옴");
		List<Todo> todos = mapper.getList();
		System.out.println(todos.get(0).toString());
		return Response.status(200).header("Content-Type", "application/json;charset=UTF-8").entity(todos).build();
	}

	// 삽입
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response insert(Todo todo) {
		if (mapper.read(todo) != null) {
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.toString() + " \n 삽입 실패. 데이터가 이미 존재합니다.").build();
		} else if (todo.getRegDate().after(todo.getExpDate())) {
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.toString() + " \n 삽입 실패. 만료일은 등록일 이후여야 합니다.").build();
		} else {
			mapper.insert(todo);
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.toString() + " \n 삽입 성공").build();
		}
	}

	// 조회
	@POST
	@Path("/read")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response read(Todo todo) {
		if ( mapper.read(todo) == null) {
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.getNo() +"번 데이터  조회 실패. \n데이터가 없습니다.").build();
		} else
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8").entity(todo).build();
	}

	// 수정
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response update(Todo todo) {
		if (mapper.read(todo) == null) {
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.toString() + " \n 수정 실패. 데이터가 없습니다.").build();
		} else {
			mapper.update(todo);
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.toString() + " 수정 성공").build();
		}
	}

	// 삭제
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response delete(Todo todo) {
		if (mapper.read(todo) == null) {
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.getNo() +"번 데이터  삭제 실패.\n 데이터가 없습니다.").build();
		} else {
			mapper.delete(todo);
			return Response.status(200).header("Content-Type", "application/json;charset=UTF-8")
					.entity(todo.getNo() +"번 데이터  삭제 성공").build();
		}
	}
}
