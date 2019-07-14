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
@Table(name = "circum_type")
public class CircumTypeVO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;
}
