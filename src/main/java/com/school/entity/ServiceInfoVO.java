package com.school.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "service_info")
public class ServiceInfoVO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Embedded
    private List<Map<String,String>> positions;

    @Column(name = "created_time")
    private String createdTime;
}
