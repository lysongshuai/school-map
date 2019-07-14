package com.school.service.impl;

import com.school.entity.CircumTypeVO;
import com.school.repository.CircumTypeRepository;
import com.school.service.CircumTypeService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircumTypeServiceImpl implements CircumTypeService {

    @Autowired
    CircumTypeRepository circumTypeRepository;

    @Override
    public ApiResult<List<CircumTypeVO>> getAll() {

        List<CircumTypeVO> resultData  =  circumTypeRepository.getAll();
        if(resultData == null || resultData.size() == 0){
            return ApiResult.error(ApiCode.UNKNOWN_ERROR);
        }
        return ApiResult.ok(resultData);
    }
}
