package com.school.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "school_info_image")
public class SchoolInfoImageVO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "created_time")
    private Integer createdTime;
}
