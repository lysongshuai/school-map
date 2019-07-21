package com.school.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "service_info_position")
public class ServiceInfoPositionVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "title")
    private String title;

    @Column(name = "center")
    private String center;

    @Column(name = "created_time")
    private String createdTime;
}
