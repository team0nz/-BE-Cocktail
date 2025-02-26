package com.application.domain.bar.model;

import com.application.domain.menu.model.MenuResponse;

import java.util.List;

public record BarSearchResponse(BarResponse barResponse,
                                List<MenuResponse> menuResponses) {

}
