package br.inatel.dm110.api;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public interface HelloService {

	@GET
	@Path("/say/{name}")
	@Produces(MediaType.TEXT_HTML)
	String sayHello(@PathParam("name") String name);

	@POST
	@Path("/message")
	@Produces(MediaType.APPLICATION_JSON)
	MessageTO message(@FormParam("first") String first, @FormParam("last") String last);

	@POST
	@Path("/storeMessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int storeNewMessage(MessageTO message);

	@GET
	@Path("/messageList")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MessageTO> getMessages();
	
	/**
	 * CALCULATOR EXERCISE - SLIDE-30/32 (DM100-Aula1_19554.pdf)
	 */
	@GET
	@Path("/calc/sum/{val1}/{val2}")
	@Produces(MediaType.TEXT_HTML)
	String calcSum(@PathParam("val1") int val1, @PathParam("val2") int val2);
	
	@GET
	@Path("/calc/sub/{val1}/{val2}")
	@Produces(MediaType.TEXT_HTML)
	String calcSub(@PathParam("val1") int val1, @PathParam("val2") int val2);
	
	@GET
	@Path("/calc/mul/{val1}/{val2}")
	@Produces(MediaType.TEXT_HTML)
	String calcMul(@PathParam("val1") int val1, @PathParam("val2") int val2);
	
	@GET
	@Path("/calc/div/{val1}/{val2}")
	@Produces(MediaType.TEXT_HTML)
	String calcDiv(@PathParam("val1") int val1, @PathParam("val2") int val2);
	

}
