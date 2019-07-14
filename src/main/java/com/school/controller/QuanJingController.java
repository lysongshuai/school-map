package com.school.controller;

import com.alibaba.fastjson.JSONArray;
import com.school.entity.QuanJingVO;
import com.school.service.QuanJingService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/quanjing")
public class QuanJingController {

    @Autowired
    QuanJingService quanJingService;

    @GetMapping(value = "/getAll")
    public ApiResult<List<QuanJingVO>> getAll(){
        return quanJingService.getAll();
    }

}
