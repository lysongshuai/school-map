package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.SchoolInfoImageVO;
import com.school.entity.SchoolInfoVO;
import com.school.repository.SchoolInfoImageRepository;
import com.school.repository.SchoolInfoRepository;
import com.school.service.SchoolInfoService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {

    @Autowired
    SchoolInfoRepository schoolInfoRepository;

    @Autowired
    SchoolInfoImageRepository schoolInfoImageRepository;

    @Override
    public ApiResult<List<SchoolInfoVO>> getByType(String type) {
        if(StringUtils.isNullOrEmpty(type)){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }
        //学校
        List<SchoolInfoVO> schoolInfoList = schoolInfoRepository.getByType(type);
        //风光图集
        List<SchoolInfoImageVO> allImages = schoolInfoImageRepository.getAll();

        schoolInfoList.stream().forEach(schoolInfo ->{
            //存储风光对应的图集
            List<String> images = new ArrayList<String>();
            allImages.stream().forEach(obj ->{
                if(schoolInfo.getId() == obj.getPid()){
                    images.add(obj.getImgUrl());
                }
                schoolInfo.setImages(images);
            });
        });

        return ApiResult.ok(schoolInfoList);
    }
}
