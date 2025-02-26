package com.application.domain.openHour.model;

import com.application.domain.openHour.entity.OpenHour;
import com.application.domain.openHour.enums.DayOfWeek;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OpenHourResponse {

    private DayOfWeek dayOfWeek;
    private String openingHour;
    private String closingHour;

    public static OpenHourResponse from(OpenHour openHour) {
        return new OpenHourResponse(openHour.getDayOfWeek(), openHour.getOpeningHour(), openHour.getClosingHour());
    }
}
