package com.application.domain.menu.model;

import com.application.domain.menu.entity.Menu;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuResponse {
    private String name;
    private String imageUrl;
    private String description;
    private String sellPrice;

    public static MenuResponse from(Menu menu) {
        return new MenuResponse(menu.getName(), menu.getImageUrl(), menu.getDescription(), menu.getSellPrice());
    }
}
