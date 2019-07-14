package com.school.service;

import com.school.entity.CircumTypeVO;
import com.school.util.ApiResult;

import java.util.List;

public interface CircumTypeService {

    public ApiResult<List<CircumTypeVO>> getAll();
}
