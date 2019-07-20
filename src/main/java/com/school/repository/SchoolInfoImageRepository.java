package com.school.repository;

import com.school.entity.SchoolInfoImageVO;
import com.school.entity.SchoolInfoVO;
import com.school.util.BasicRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolInfoImageRepository extends BasicRepository<SchoolInfoImageVO> {

    public List<SchoolInfoImageVO> getByPid(@Param("pid") String pid);

    @Query(value = "select * from school_info_image",nativeQuery = true)
    public List<SchoolInfoImageVO> getAll();
}
