package com.school.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.school.entity.SitePositionVO;
import com.school.service.SitePositionService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/sitePosition")
public class SitePositionController {

    @Autowired
    private SitePositionService sitePositionService;

    @GetMapping(value = "/getByName")
    public ApiResult<SitePositionVO> getByName(String name){
        return sitePositionService.getByName(name);
    }

    @GetMapping(value = "/getAll")
    public ApiResult<List<SitePositionVO>> getAll(){
        return sitePositionService.getAll();
    }

}
