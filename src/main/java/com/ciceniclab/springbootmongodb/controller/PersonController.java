package com.ciceniclab.springbootmongodb.controller;

import com.ciceniclab.springbootmongodb.collection.Person;
import com.ciceniclab.springbootmongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public String savePerson(@RequestBody Person person){
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getPersonStartWith(@RequestParam("name") String name){
        return personService.getPersonStartWith(name);
    }

    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam Integer minAge, @RequestParam Integer maxAge){
        return personService.getByPersonAge(minAge, maxAge);
    }


    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id){
        personService.delete(id);
    }
}
