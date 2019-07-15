package com.school.repository;

import com.school.entity.ServiceInfoVO;
import com.school.util.BasicRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceInfoRepository extends BasicRepository<ServiceInfoVO> {

    public List<ServiceInfoVO> getByType(@Param("type") String type);
}
