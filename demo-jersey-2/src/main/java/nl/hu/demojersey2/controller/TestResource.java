package nl.hu.demojersey2.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;



@Path("/test")
public class TestResource {
    @GET
    public String test() {
        return "UserResource is working!";
    }
}