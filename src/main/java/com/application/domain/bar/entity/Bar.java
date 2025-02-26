package com.application.domain.bar.entity;

import com.application.common.domain.BaseEntity;
import com.application.domain.region.entity.Region;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Bar extends BaseEntity {

    private String barName;
    private String address;
    private String roadNameAddress;
    private double x;
    private double y;
    private String phone;
    private String url;
    private int placeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
}