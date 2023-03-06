package com.java.springcloud.controller;

import com.java.springcloud.entities.Dept;
import com.java.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id) {
        return deptService.findById(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("*******"+list);
        List<ServiceInstance> serviceList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : serviceList) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"
            +element.getPort()+"\t"+element.getUri());
        }
        return this.client;
    }
}
