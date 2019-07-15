package com.school.repository;

import com.school.entity.SchoolInfoVO;
import com.school.util.BasicRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolInfoRepository extends BasicRepository<SchoolInfoVO> {

    public List<SchoolInfoVO> getByType(@Param("type") String type);
}
