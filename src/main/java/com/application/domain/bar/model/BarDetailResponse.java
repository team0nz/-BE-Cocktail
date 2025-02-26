package com.application.domain.bar.model;

import com.application.domain.bar.entity.Bar;
import com.application.domain.menu.entity.Menu;
import com.application.domain.menu.model.MenuResponse;
import com.application.domain.openHour.entity.OpenHour;
import com.application.domain.openHour.model.OpenHourResponse;

import java.util.List;

public record BarDetailResponse(BarResponse barResponse,
                                List<MenuResponse> menuResponses,
                                List<OpenHourResponse> hourResponses) {

    public static BarDetailResponse from(Bar bar, List<Menu> menus, List<OpenHour> openHours) {
        BarResponse barResponse = BarResponse.from(bar);
        List<MenuResponse> menuResponses = menus.stream().map(MenuResponse::from).toList();
        List<OpenHourResponse> openHourResponses = openHours.stream().map(OpenHourResponse::from).toList();

        return new BarDetailResponse(barResponse, menuResponses, openHourResponses);
    }

    public static BarDetailResponse from(BarResponse barResponse,
                                         List<MenuResponse> menuResponses,
                                         List<OpenHourResponse> openHourResponses) {

        return new BarDetailResponse(barResponse, menuResponses, openHourResponses);
    }
}
