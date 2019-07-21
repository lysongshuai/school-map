package com.school.repository;

import com.school.entity.ServiceInfoPositionVO;
import com.school.util.BasicRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceInfoPositionRepository extends BasicRepository<ServiceInfoPositionVO> {

    public List<ServiceInfoPositionVO> getByPid(@Param("pid") String pid);

    @Query(value = "select * from service_info_position",nativeQuery = true)
    public List<ServiceInfoPositionVO> getAll();

    @Modifying
    @Query(value = "delete from service_info_position where pid = :pid",nativeQuery = true)
    public int delByPid(@Param("pid") Integer pid);

}


