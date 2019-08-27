package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.ServiceInfoPositionVO;
import com.school.entity.ServiceInfoVO;
import com.school.repository.ServiceInfoPositionRepository;
import com.school.repository.ServiceInfoRepository;
import com.school.service.ServiceInfoPositionService;
import com.school.service.ServiceInfoService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ServiceInfoPositionServiceImpl implements ServiceInfoPositionService {

    Logger logger = LoggerFactory.getLogger(ServiceInfoServiceImpl.class);

    @Autowired
    ServiceInfoPositionRepository serviceInfoPositionRepository;


    @Override
    public ApiResult update(ServiceInfoPositionVO serviceInfoPositionVO) {
        if(serviceInfoPositionVO == null){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }
        try {
            //更新
            serviceInfoPositionRepository.update(serviceInfoPositionVO);
        }catch (Exception e){
            logger.error(ServiceInfoPositionServiceImpl.class.getName()+"  Error:{}",e.getMessage());
            ApiResult.error(ApiCode.UNKNOWN_ERROR);
        }

        return ApiResult.ok();
    }
}

