package customer.com.br.controller;

import customer.com.br.dto.CustomerDto;
import customer.com.br.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> findAllCustomer(){

        return customerService.findAllCustomers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto findCustomerById(@PathParam("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @POST
    @Transactional
    public Response saveCustomer(CustomerDto customerDto){
        try {
            customerService.createNewCustomer((customerDto));
            return Response.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }

    }
    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeCustomer(@PathParam("id") Long id, CustomerDto customerDto){
        try {
            customerService.changeCustomer(id,customerDto);
            return Response.accepted().build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id") Long id){
        try {
            customerService.deleteCustomer(id);
            return Response.accepted().build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
