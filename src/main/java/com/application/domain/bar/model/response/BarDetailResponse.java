package com.application.domain.bar.model.response;

import com.application.domain.bar.entity.Bar;
import com.application.domain.barImage.entity.BarImage;
import com.application.domain.barImage.model.BarImageResponse;
import com.application.domain.menu.entity.Menu;
import com.application.domain.menu.model.MenuResponse;
import com.application.domain.openHour.entity.OpenHour;
import com.application.domain.openHour.model.OpenHourResponse;

import java.util.List;

public record BarDetailResponse(BarResponse barResponse,
                                List<MenuResponse> menuResponses,
                                List<OpenHourResponse> hourResponses,
                                List<BarImageResponse> barImageResponses) {

    public static BarDetailResponse from(Bar bar, List<Menu> menus, List<OpenHour> openHours, List<BarImage> barImages) {
        BarResponse barResponse = BarResponse.from(bar);
        List<MenuResponse> menuResponses = menus.stream().map(MenuResponse::from).toList();
        List<OpenHourResponse> openHourResponses = openHours.stream().map(OpenHourResponse::from).toList();
        List<BarImageResponse> barImageResponses = barImages.stream().map(BarImageResponse::from).toList();

        return new BarDetailResponse(barResponse, menuResponses, openHourResponses, barImageResponses);
    }

    public static BarDetailResponse from(BarResponse barResponse,
                                         List<MenuResponse> menuResponses,
                                         List<OpenHourResponse> openHourResponses,
                                         List<BarImageResponse> barImageResponses) {

        return new BarDetailResponse(barResponse, menuResponses, openHourResponses, barImageResponses);
    }
}
