package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.SitePositionVO;
import com.school.repository.SitePositionRepository;
import com.school.service.SitePositionService;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SitePositionServiceImpl implements SitePositionService {

    @Autowired
    private SitePositionRepository sitePositionRepository;

    @Override
    public ApiResult<SitePositionVO> getByName(String name) {

        if(StringUtils.isNullOrEmpty(name)){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }
      SitePositionVO resultData  =  sitePositionRepository.getFirstByNameLike("%"+name+"%");

      if(resultData == null){
          return ApiResult.error(ApiCode.NOT_FOUND);
      }
      return ApiResult.ok(resultData);
    }

    @Override
    public ApiResult<List<SitePositionVO>> getAll() {
        List<SitePositionVO> resultData =  sitePositionRepository.getAll();
        if(resultData.size() == 0){
            return ApiResult.error(ApiCode.UNKNOWN_ERROR);
        }
        return ApiResult.ok(resultData);
    }
}
