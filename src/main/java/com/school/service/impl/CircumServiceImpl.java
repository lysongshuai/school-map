package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.CircumVO;
import com.school.repository.CircumRepository;
import com.school.service.CircumService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircumServiceImpl implements CircumService {

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
}
