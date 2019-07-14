package com.school.service;

import com.school.entity.QuanJingVO;
import com.school.util.ApiResult;

import java.util.List;

public interface QuanJingService  {

    public ApiResult<List<QuanJingVO>> getAll();
}
