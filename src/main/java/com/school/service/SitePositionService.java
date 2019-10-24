package com.school.service;

import com.school.entity.SitePositionVO;
import com.school.util.ApiResult;

import java.util.List;

public interface SitePositionService {

    public ApiResult<SitePositionVO> getByName(String name) throws Exception;

    public ApiResult<List<SitePositionVO>> getAll() throws Exception;

    public ApiResult add(SitePositionVO sitePositionVO) throws Exception;

    public ApiResult update(SitePositionVO sitePositionVO) throws Exception;

    public ApiResult delete(Integer id) throws Exception;
}
