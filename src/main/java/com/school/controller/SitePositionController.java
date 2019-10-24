package com.school.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.school.entity.SitePositionVO;
import com.school.service.SitePositionService;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/sitePosition")
public class SitePositionController {

    @Autowired
    private SitePositionService sitePositionService;

    @GetMapping(value = "/getByName")
    public ApiResult<SitePositionVO> getByName(String name) throws Exception{
        return sitePositionService.getByName(name);
    }

    @GetMapping(value = "/getAll")
    public ApiResult<List<SitePositionVO>> getAll() throws Exception{
        return sitePositionService.getAll();
    }

    @PostMapping(value = "/add")
    public ApiResult add(@RequestBody SitePositionVO sitePositionVO) throws Exception{
        return sitePositionService.add(sitePositionVO);
    }

    @PostMapping(value = "/update")
    public ApiResult update(@RequestBody SitePositionVO sitePositionVO) throws Exception{
        return sitePositionService.update(sitePositionVO);
    }

    @PostMapping(value = "/delete")
    public ApiResult delete(Integer id) throws Exception{
        return sitePositionService.delete(id);
    }

}
