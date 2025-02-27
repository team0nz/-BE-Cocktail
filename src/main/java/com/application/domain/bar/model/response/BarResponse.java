package com.application.domain.bar.model.response;

import com.application.domain.bar.entity.Bar;

public record BarResponse(Long barId,
                          String barName,
                          String address,
                          String roadNameAddress,
                          double x,
                          double y,
                          String phone,
                          String url) {

    public static BarResponse from(Bar bar) {
        return new BarResponse(bar.getId(), bar.getBarName(), bar.getAddress(),
                bar.getRoadNameAddress(), bar.getX(), bar.getY(), bar.getPhone(), bar.getUrl());
    }
}
