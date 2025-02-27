package com.application.domain.bar.model.response;

import com.application.domain.barImage.model.BarImageResponse;
import com.application.domain.menu.model.MenuResponse;

import java.util.List;

public record BarSearchResponse(BarResponse barResponse,
                                List<MenuResponse> menuResponses,
                                BarImageResponse barImageResponse) {

}
