package com.school.service;

import com.school.entity.ServiceInfoVO;
import com.school.util.ApiResult;

import java.util.List;

public interface ServiceInfoService {

    public ApiResult<List<ServiceInfoVO>> getByType(String type);

    public ApiResult update(ServiceInfoVO serviceInfoVO);
}
