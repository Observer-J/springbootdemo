package com.mapsharp.springbootdemo.service;


import com.mapsharp.springbootdemo.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersonList();

    Person getPersonDetail(String personId);

    String createNewPerson(Person person);
}
