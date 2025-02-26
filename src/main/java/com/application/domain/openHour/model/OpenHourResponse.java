package com.application.domain.openHour.model;

import com.application.domain.openHour.entity.OpenHour;
import com.application.domain.openHour.enums.DayOfWeek;

public record OpenHourResponse(DayOfWeek dayOfWeek,
                               String openingHour,
                               String closingHour) {

    public static OpenHourResponse from(OpenHour openHour) {
        return new OpenHourResponse(openHour.getDayOfWeek(), openHour.getOpeningHour(), openHour.getClosingHour());
    }
}
