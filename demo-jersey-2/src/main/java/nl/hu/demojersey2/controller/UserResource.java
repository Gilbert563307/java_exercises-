package nl.hu.demojersey2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import nl.hu.demojersey2.model.User;

import java.util.ArrayList;

@Path("/users")
public class UserResource {
    private ArrayList<User> usersList = new ArrayList<>() {{
         add(new User(1, "Lucas"));
         add(new User(2, "Mirko"));
         add(new User(3, "Pim"));
         add(new User(4, "Jos"));
         add(new User(5, "Pim"));
         add(new User(6, "Mirko"));
    }};



    @GET
    @Produces("application/json")
    public  String users(){
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray;
        try {
            jsonArray = objectMapper.writeValueAsString(this.usersList);
            return jsonArray;
        } catch (JsonProcessingException e) {
            return "{'users': [], 'message': \"" + e.getMessage() + "\"}";
        }
    }


    @GET
    @Path("/{id}")
    public String getUserById(@PathParam("id") Long id) {
        for (User user : this.usersList) {
            if (user.getId() == id) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.writeValueAsString(user);
                } catch (Exception e) {
                    return "{'user': {}, 'message': \"" + e.getMessage() + "\"}";
                }
            }
        }
        return "{'user': {}, 'message': ''}";
    }
}
