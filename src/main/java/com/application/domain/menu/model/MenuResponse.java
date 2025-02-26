package com.application.domain.menu.model;

import com.application.domain.menu.entity.Menu;

public record MenuResponse(String name,
                          String imageUrl,
                          String description,
                          String sellPrice) {

    public static MenuResponse from(Menu menu) {
        return new MenuResponse(menu.getName(), menu.getImageUrl(), menu.getDescription(), menu.getSellPrice());
    }
}
