package com.application.domain.barImage.model;

import com.application.domain.barImage.entity.BarImage;

public record BarImageResponse(Long id,
                               String imageUrl) {

    public static BarImageResponse from(BarImage image) {
        return new BarImageResponse(image.getId(), image.getImageUrl());
    }
}
