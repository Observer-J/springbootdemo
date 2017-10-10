package com.mapsharp.springbootdemo.service.impl;


import com.mapsharp.springbootdemo.domain.Person;
import com.mapsharp.springbootdemo.repositores.PersonRepository;
import com.mapsharp.springbootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonDetail(String personId) {

        return personRepository.getOne(personId);
    }

    @Override
    public String createNewPerson(Person person) {
        Person newPerson =  personRepository.save(person);
        return newPerson.getPersonId();
    }
}
