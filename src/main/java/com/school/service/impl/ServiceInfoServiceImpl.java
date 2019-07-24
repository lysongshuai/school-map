package com.school.service.impl;

import com.mysql.jdbc.StringUtils;
import com.school.entity.ServiceInfoPositionVO;
import com.school.entity.ServiceInfoVO;
import com.school.repository.ServiceInfoPositionRepository;
import com.school.repository.ServiceInfoRepository;
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
public class ServiceInfoServiceImpl implements ServiceInfoService {

    Logger logger = LoggerFactory.getLogger(ServiceInfoServiceImpl.class);

    @Autowired
    ServiceInfoRepository serviceInfoRepository;

    @Autowired
    ServiceInfoPositionRepository serviceInfoPositionRepository;

    @Override
    public ApiResult<List<ServiceInfoVO>> getByType(String type) {
        if(StringUtils.isNullOrEmpty(type)){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }
        //服务中心
        List<ServiceInfoVO> serviceInfoList = serviceInfoRepository.getByType(type);
        //坐标位置
        List<ServiceInfoPositionVO> allPosition = serviceInfoPositionRepository.getAll();

        serviceInfoList.stream().forEach(serviceInfoVO -> {
            //服务对应的建筑位置
            List<Map<String,String>> positions = new ArrayList<Map<String,String>>();
            allPosition.stream().forEach(obj ->{
                if(serviceInfoVO.getId() == obj.getPid()){
                    Map<String,String> map = new HashMap<String,String>();
                    map.put("id",obj.getId().toString());
                    map.put("title",obj.getTitle());
                    map.put("center",obj.getCenter());
                    positions.add(map);
                }
            });
            serviceInfoVO.setPositions(positions);
        });
        return ApiResult.ok(serviceInfoList);
    }

    @Override
    public ApiResult update(ServiceInfoVO serviceInfoVO) {
        if(serviceInfoVO == null){
            return ApiResult.error(ApiCode.PARAMETER_ERROR);
        }
        try{
            //更新
            serviceInfoRepository.update(serviceInfoVO);
        }catch (Exception e){
            logger.error(ServiceInfoServiceImpl.class.getName()+"  Error:{}",e.getMessage());
            ApiResult.error(ApiCode.UNKNOWN_ERROR);
        }
        return ApiResult.ok();
    }
}

