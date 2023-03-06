package com.java.springcloud.service;

import com.java.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "dept/get/{id}",method = RequestMethod.GET)
    Dept findById(Long id);

    @RequestMapping(value = "dept/list",method = RequestMethod.GET)
    List<Dept> findAll();

    @RequestMapping(value = "dept/add",method = RequestMethod.POST)
    boolean addDept(Dept dept);

}
