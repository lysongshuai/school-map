package com.school.service;

import com.school.entity.SchoolInfoVO;
import com.school.util.ApiResult;

import java.util.List;

public interface SchoolInfoService {

    public ApiResult<List<SchoolInfoVO>> getByType(String type);
}
