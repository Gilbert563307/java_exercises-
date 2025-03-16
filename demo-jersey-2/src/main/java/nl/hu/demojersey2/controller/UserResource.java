package nl.hu.demojersey2.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/users")
public class UserResource {
    @GET
    @Produces("application/json")
    public  String users(){
        return "{ \"name\" : \"John Doe\" }";
    }


    @GET
    @Path("/{id}")
    public String getUserById(@PathParam("id") Long id) {
        return  "{ \"name\" : \"John Doe\" }";
    }
}
