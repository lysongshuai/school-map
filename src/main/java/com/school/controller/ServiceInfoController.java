package com.school.controller;

import com.school.entity.ServiceInfoVO;
import com.school.service.ServiceInfoService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/serviceInfo")
public class ServiceInfoController  {

    @Autowired
    ServiceInfoService serviceInfoService;

    @GetMapping(value = "/getByType")
    public ApiResult<List<ServiceInfoVO>> getByType(String type){
        return serviceInfoService.getByType(type);
    }
}
