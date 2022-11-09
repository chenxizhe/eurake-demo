package com.example.eurakeclientconsume.controller;

import com.example.eurakeclientconsume.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class ConsumerHandler {
    @Autowired
    private RestTemplate restTemplate;
    private String rest_url_prefix = "http://provider";


    @GetMapping("/findAll")
    public Collection findAll(){
        return restTemplate.getForEntity(rest_url_prefix+"/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection findAll2(){
        return restTemplate.getForObject(rest_url_prefix+"/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return restTemplate.getForEntity(rest_url_prefix+"/student/findById/{id}",Student.class,id).getBody();
    }

    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id") long id){
        return restTemplate.getForObject(rest_url_prefix+"/student/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity(rest_url_prefix+"/student/save",student,null).getBody();
    }

    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject(rest_url_prefix+"/student/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put(rest_url_prefix+"/student/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete(rest_url_prefix+"/student/deleteById/{id}",id);
    }
}
