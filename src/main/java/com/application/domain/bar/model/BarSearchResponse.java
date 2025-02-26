package com.application.domain.bar.model;

import com.application.domain.menu.model.MenuResponse;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BarSearchResponse {

    private BarResponse barResponse;
    private List<MenuResponse> menuResponses;
}
