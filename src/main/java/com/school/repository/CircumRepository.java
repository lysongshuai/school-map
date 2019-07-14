package com.school.repository;

import com.school.entity.CircumVO;
import com.school.util.BasicRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircumRepository extends BasicRepository<CircumVO> {

    public List<CircumVO> getByTypeId(@Param("typeId") String typeId);
}
