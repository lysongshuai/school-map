package com.school.controller;

import com.school.entity.CircumTypeVO;
import com.school.service.CircumTypeService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/circumType")
public class CircumTypeController {

    @Autowired
    CircumTypeService circumTypeService;

    @GetMapping(value = "/getAll")
    public ApiResult<List<CircumTypeVO>> getAll(){
        return circumTypeService.getAll();
    }
}
