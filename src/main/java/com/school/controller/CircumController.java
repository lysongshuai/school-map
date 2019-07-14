package com.school.controller;

import com.school.entity.CircumVO;
import com.school.service.CircumService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/circum")
public class CircumController {

    @Autowired
    CircumService circumService;

    @GetMapping(value = "/getByTypeId")
    public ApiResult<List<CircumVO>> getByTypeId(String typeId){
        return circumService.getByTypeId(typeId);
    }
}
