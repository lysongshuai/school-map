package com.school.service.impl;

import com.school.entity.QuanJingVO;
import com.school.repository.QuanJingRepository;
import com.school.service.QuanJingService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuanJingServiceImpl implements QuanJingService {

    @Autowired
    QuanJingRepository quanJingRepository;

    @Override
    public ApiResult<List<QuanJingVO>> getAll() {
       List<QuanJingVO> resultData  =  quanJingRepository.getAll();
       if(resultData == null || resultData.size() == 0){
           return ApiResult.error(ApiCode.UNKNOWN_ERROR);
       }
       return ApiResult.ok(resultData);
    }
}
