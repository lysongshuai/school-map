package com.school.controller;

import com.school.entity.ServiceInfoPositionVO;
import com.school.entity.ServiceInfoVO;
import com.school.service.ServiceInfoPositionService;
import com.school.service.ServiceInfoService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/serviceInfoPosition")
public class ServiceInfoPositionController {

    @Autowired
    ServiceInfoPositionService serviceInfoPositionService;

    @PostMapping(value = "/update")
    public ApiResult update(@RequestBody ServiceInfoPositionVO serviceInfoPositionVO){
        return serviceInfoPositionService.update(serviceInfoPositionVO);
    }
}
