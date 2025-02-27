package com.application.domain.bar.model.response;

import com.application.domain.bar.entity.Bar;
import com.application.domain.barImage.entity.BarImage;
import com.application.domain.barImage.model.BarImageResponse;
import com.application.domain.menu.entity.Menu;
import com.application.domain.menu.model.MenuResponse;

import java.util.List;

public record BarSearchResponse(BarResponse bar,
                                List<MenuResponse> menus,
                                BarImageResponse barImage) {

    public static BarSearchResponse from(Bar bar, List<Menu> menus, BarImage barImage) {
        return new BarSearchResponse(BarResponse.from(bar),
                menus.stream().map(MenuResponse::from).toList(),
                BarImageResponse.from(barImage)
                );
    }

}
