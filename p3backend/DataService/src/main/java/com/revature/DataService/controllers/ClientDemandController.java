package com.revature.DataService.controllers;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.DataService.models.ClientDemand;
import com.revature.DataService.repositories.ClientDemandRepo;

@RestController
public class ClientDemandController
{
    //Cut out the middleman, go straight to the repo!
  
    @Autowired
    ClientDemandRepo clientDemandRepo;
    
    //get all the clientDemand rows in that table
    @GetMapping
    public List<ClientDemand> endpoint1() {
      return clientDemandRepo.findAll();
    } 
    
    //get a clientDemand by clientDemandId
    @CrossOrigin(origins = "*")
    @GetMapping("/clientDemand/{id}")
    public ClientDemand endpoint2(@PathVariable Integer id)
    {
      return clientDemandRepo.findByClientDemandId(id);
    }
    
    //post a new clientDemand. respond with what as posted. null on failure
    //the request json is converted to ClientDemand for us
    @CrossOrigin(origins = "*")
    @PostMapping("/clientDemand")
    public ClientDemand endpoint3(@RequestBody ClientDemand post)
    {
      //may need more stuff in the future. just going to stub this in for now
        
      //create an ClientDemand and put it in the database
      ClientDemand newClientDemand=new ClientDemand(
            post.clientDemandId, //Integer clientDemandId, 
            post.quantity,       //Integer quantity, 
            LocalDate.now(),     //Date deadline, 
            post.clientId        //Integer clientId
          );
      
      newClientDemand=clientDemandRepo.save(newClientDemand);
      
      return newClientDemand;
    }
}
















