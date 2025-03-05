package nl.hu.demojersey2;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import nl.hu.demojersey2.model.Company;
import nl.hu.demojersey2.model.Order;


@Path("/orders")
public class OrderResource {
    @GET
    @Produces("application/json")
    public String orders() {

        Company company = Company.getCompany();
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Order order : company.getAllOrders()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", order.getId());
            job.add("customer", order.getCustomerName());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();
    }

    //// URI: /api/orders/3
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getOrderInfo(@PathParam("id") int id) {
        Company company = Company.getCompany();
        Order order = company.getOrderById(id);
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("id", order.getId());
        job.add("customer", order.getCustomerName());

        return job.build().toString();
    }

    // URI: /api/orders/subpath
    @GET
    @Path("/subpath")
    @Produces("application/json")

    public String subpathMethod() {
        return "";
    }

}