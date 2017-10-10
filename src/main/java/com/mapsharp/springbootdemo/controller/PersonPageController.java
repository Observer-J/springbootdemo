package com.mapsharp.springbootdemo.controller;


import com.mapsharp.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person")
public class PersonPageController {

    private PersonService personService;

    @Autowired
    public PersonPageController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/personList",method = RequestMethod.GET)
    public ModelAndView personList(ModelAndView modelAndView){
        modelAndView.setViewName("/person/personList");
        return modelAndView;
    }

    @RequestMapping(value = "/personDetail/{personId}",method = RequestMethod.GET)
    public ModelAndView personDetail(ModelAndView modelAndView, @PathVariable String personId){
        modelAndView.setViewName("/person/personDetail");
        modelAndView.addObject("person",personService.getPersonDetail(personId));
        return modelAndView;
    }


}
