package com.school.service;

import com.school.entity.CircumVO;
import com.school.util.ApiResult;

import java.util.List;

public interface CircumService {

    public ApiResult<List<CircumVO>> getByTypeId(String typeId);
}
