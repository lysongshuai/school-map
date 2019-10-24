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
@Table(name = "site_position")
public class SitePositionVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "center")
    private String center;

    @Column(name = "created_time")
    private String createdTime;
}
