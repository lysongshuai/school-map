package com.school.repository;

import com.school.entity.SitePositionVO;
import com.school.util.BasicRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SitePositionRepository extends BasicRepository<SitePositionVO> {

    public SitePositionVO getFirstByNameLike(@Param("name") String name);

    @Query(value = "select * from site_position order by id desc",nativeQuery = true)
    public List<SitePositionVO> getAll();
}