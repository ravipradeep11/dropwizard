package com.howtodoinjava.rest.controller;
 
import com.howtodoinjava.rest.representations.MoneyTransferRequest;
import com.howtodoinjava.rest.service.IWalletTransferService;
import com.howtodoinjava.rest.service.MyWalletTransferService;
import io.dropwizard.auth.Auth;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.howtodoinjava.rest.basicauth.User;
import com.howtodoinjava.rest.dao.EmployeeDB;
import com.howtodoinjava.rest.representations.Employee;
import org.omg.IOP.TransactionService;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRESTController {
 
    private final Validator validator;

    private final IWalletTransferService walletTransferService=new MyWalletTransferService();

    public EmployeeRESTController(Validator validator) {
        this.validator = validator;
    }

    @GET
    @Path("/balance")
    public Response getBalance(@QueryParam("id") Integer id) {

        return Response.ok(walletTransferService.getBalance(id)).build();
    }

    @POST
    @Path("/transfer")
    public Response getEmployeeById(MoneyTransferRequest moneyTransferRequest) {

        //Employee employee = EmployeeDB.getEmployee(2);
        walletTransferService.transferMoney(moneyTransferRequest.getFromAccount(),moneyTransferRequest.getAmount(),moneyTransferRequest.getToAccount());

            return Response.ok(walletTransferService.getBalance(moneyTransferRequest.getFromAccount())).build();
    }


}