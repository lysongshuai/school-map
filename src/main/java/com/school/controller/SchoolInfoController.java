package com.school.controller;

import com.school.entity.SchoolInfoVO;
import com.school.service.SchoolInfoService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schoolInfo")
public class SchoolInfoController {

    @Autowired
    SchoolInfoService schoolInfoService;

    @GetMapping(value = "/getByType")
    public ApiResult<List<SchoolInfoVO>> getByType(String type){
        return schoolInfoService.getByType(type);
    }
}
