package com.school.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "school_info")
public class SchoolInfoVO {

    @Id
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "center")
    private String center;

    @Embedded
    private List<String> images;

    @Column(name = "created_time")
    private String createdTime;
}
