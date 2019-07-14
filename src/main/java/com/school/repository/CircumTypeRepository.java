package com.school.repository;

import com.school.entity.CircumTypeVO;
import com.school.util.BasicRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircumTypeRepository extends BasicRepository<CircumTypeVO> {

    @Query(value = "select * from circum_type",nativeQuery = true)
    public List<CircumTypeVO> getAll();

}
