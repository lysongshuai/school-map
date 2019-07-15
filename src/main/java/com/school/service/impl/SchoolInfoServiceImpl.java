package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.SchoolInfoVO;
import com.school.repository.SchoolInfoRepository;
import com.school.service.SchoolInfoService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {

    @Autowired
    SchoolInfoRepository schoolInfoRepository;

    @Override
    public ApiResult<List<SchoolInfoVO>> getByType(String type) {
        if(StringUtils.isNullOrEmpty(type)){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }

        List<SchoolInfoVO> schoolInfoList = schoolInfoRepository.getByType(type);
        return ApiResult.ok(schoolInfoList);
    }
}
