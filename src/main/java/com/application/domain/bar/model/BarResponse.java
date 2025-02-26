package com.application.domain.bar.model;

import com.application.domain.bar.entity.Bar;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BarResponse {

    private Long barId;
    private String barName;
    private String address;
    private String roadNameAddress;
    private double x;
    private double y;
    private String phone;
    private String url;

    public static BarResponse from(Bar bar) {
        return new BarResponse(bar.getId(), bar.getBarName(), bar.getAddress(),
                bar.getRoadNameAddress(), bar.getX(), bar.getY(), bar.getPhone(), bar.getUrl());
    }
}
