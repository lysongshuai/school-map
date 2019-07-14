package com.school.service;

import com.school.entity.SitePositionVO;
import com.school.util.ApiResult;

import java.util.List;

public interface SitePositionService {

    public ApiResult<SitePositionVO> getByName(String name);

    public ApiResult<List<SitePositionVO>> getAll();
}
