package com.mapsharp.springbootdemo.controller;


import com.mapsharp.springbootdemo.common.ResultBean;
import com.mapsharp.springbootdemo.domain.Person;
import com.mapsharp.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/personList",method = RequestMethod.POST)
    public ResultBean<List<Person>> personList(){
        return new ResultBean(personService.getPersonList());
    }

    @RequestMapping(value = "/personDetail/{personId}",method = RequestMethod.POST)
    public ResultBean<Person> personList(@PathVariable String personId){

        return new ResultBean<>(personService.getPersonDetail(personId));
    }

    @RequestMapping(value = "/newPerson",method = RequestMethod.POST)
    public ResultBean<String> newPerson(@RequestBody Person person){
        return new ResultBean<>(personService.createNewPerson(person));
    }
}
