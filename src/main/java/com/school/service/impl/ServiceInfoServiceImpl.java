package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.ServiceInfoVO;
import com.school.repository.ServiceInfoRepository;
import com.school.service.ServiceInfoService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInfoServiceImpl implements ServiceInfoService {

    @Autowired
    ServiceInfoRepository serviceInfoRepository;

    @Override
    public ApiResult<List<ServiceInfoVO>> getByType(String type) {
        if(StringUtils.isNullOrEmpty(type)){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }

        List<ServiceInfoVO> serviceInfoList = serviceInfoRepository.getByType(type);
        return ApiResult.ok(serviceInfoList);
    }
}

