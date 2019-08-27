package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.CircumVO;
import com.school.repository.CircumRepository;
import com.school.service.CircumService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircumServiceImpl implements CircumService {

    Logger logger = LoggerFactory.getLogger(CircumServiceImpl.class);

    @Autowired
    CircumRepository circumRepository;

    @Override
    public ApiResult<List<CircumVO>> getByTypeId(String typeId) {

        if(StringUtils.isNullOrEmpty(typeId)){
          return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }

        List<CircumVO> circumVO = circumRepository.getByTypeId(typeId);
        return ApiResult.ok(circumVO);
    }

    @Override
    public ApiResult addCircum(CircumVO circumVO) {
        if(circumVO == null){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }
        try{
            this.circumRepository.save(circumVO);
        }catch (Exception e){
            logger.error("Error:{}",e.getMessage());
            return ApiResult.error(ApiCode.UNKNOWN_ERROR);
        }
        return ApiResult.ok();
    }
}
