package com.mapsharp.springbootdemo.repositores;


import com.mapsharp.springbootdemo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
}
