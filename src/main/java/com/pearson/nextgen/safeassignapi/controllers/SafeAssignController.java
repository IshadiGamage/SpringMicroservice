package com.pearson.nextgen.safeassignapi.controllers;


import com.pearson.nextgen.safeassignapi.models.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="/person", description = "Person Profile",produces="application/json")
@RequestMapping("/person")
public class SafeAssignController {

    @ApiOperation(value="get Person",response=Person.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Person Details Retrieved",response = Person.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Person not found")
    })

    @RequestMapping(value="/getPerson",method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<Person> getCustomer(){
        Person person = new Person();
        person.setName("Ishadi");
        person.setId(1234);
        person.setAddress("Col");
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/postPerson", method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<Person> postPerson(){
        Person person = new Person();
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

}
