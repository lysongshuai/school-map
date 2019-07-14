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
@Table(name = "circum")
public class CircumVO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_id")
    private String typeId;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "img_url")
    private String ImgUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "created_time")
    private String createdTime;
}
