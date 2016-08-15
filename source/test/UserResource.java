package test;

import java.util.*;
import javax.inject.*;
import kikaha.urouting.api.*;

@Path( "users" )
@Singleton
public class UserResource {

    @Inject UserQueries queries;
  
    @GET
    public Collection<User> retrieveAllUsers(){
        return queries.retrieveUsers();
    }

    @GET
    @Path( "{id}" )
    public User retrieveUserById(
            @PathParam( "id" ) long id ) {
        return queries.retrieveUserById( id );
    }

    @POST
    public void persistUser( User user ){
        queries.insertUserAndRole( user, user.role );
    }
}

