package com.school.repository;

import com.school.entity.QuanJingVO;
import com.school.util.BasicRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuanJingRepository extends BasicRepository<QuanJingVO> {

    @Query(value = "select * from quanjing",nativeQuery = true)
    public List<QuanJingVO> getAll();
}
