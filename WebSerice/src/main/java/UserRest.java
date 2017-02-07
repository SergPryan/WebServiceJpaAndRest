import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/users")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRest {

	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	@Context
	private UriInfo  uriInfo;
	
	@PUT
	public Response create(User user){
		em.persist(user);
		 URI bookUri = uriInfo.getAbsolutePathBuilder().build();
		  return Response.created(bookUri).build();
	}
	
	@POST
	public Response update(User user){
		if (user == null){
			throw new BadRequestException();
		}
		em.merge(user);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id){
		User user = em.find(User.class, id);
		if (user==null) {
			throw new NotFoundException();
		}
		em.remove(user);
		return Response.noContent().build();
	}
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") String id){
		User user = em.find(User.class, id);
		if (user==null) {
			throw new NotFoundException();
		}
		return Response.ok(user).build();
	}
	
	@GET
	public Response getAll(){
		 TypedQuery<User> query = em.createNamedQuery("FIND_ALL", User.class);
		    List<User> list = query.getResultList();
		    return Response.ok(list).build();
	}
	
}
