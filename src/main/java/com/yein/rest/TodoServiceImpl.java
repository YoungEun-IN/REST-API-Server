package com.yein.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yein.mapper.TodoMapper;
import com.yein.domain.Todo;

@Service
@Path("/todo")
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoMapper mapper;

	@Path("/getList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList() {
		List<Todo> todos = mapper.getList();
		return Response.status(200).entity(todos).build();
	}

	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(Todo todo) {
		mapper.insert(todo);
		return Response.status(200).entity(todo + "insert success").build();
	}

	@Path("/read/{no}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("no") int no) throws NotFoundException {
		Todo todo = mapper.read(no);
		return Response.status(200).entity(todo).build();
	}

	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Todo todo) {
		mapper.update(todo);
		return Response.status(200).entity(todo + "update success").build();
	}

	@Path("/delete/{no}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("no") int no) {
		mapper.delete(no);
		return Response.status(200).entity("todo number" + no + "delete success").build();
	}
}
