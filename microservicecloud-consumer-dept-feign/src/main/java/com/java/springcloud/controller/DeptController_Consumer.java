package com.java.springcloud.controller;

import com.java.springcloud.entities.Dept;
import com.java.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController_Consumer {
    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept) {
        return service.addDept(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return service.findAll();
    }
}
