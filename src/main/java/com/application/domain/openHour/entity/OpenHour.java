package com.application.domain.openHour.entity;

import com.application.common.domain.BaseEntity;
import com.application.domain.bar.entity.Bar;
import com.application.domain.openHour.enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OpenHour extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "bar_id")
    private Bar bar;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    @Column(nullable = false)
    private String openingHour;
    @Column(nullable = false)
    private String closingHour;
    @Column(nullable = false)
    private Boolean isClosed;

    public static OpenHour of(Bar bar, DayOfWeek dayOfWeek, String openingHour, String closingHour, Boolean isClosed) {
        return new OpenHour(bar, dayOfWeek, openingHour, closingHour, isClosed);
    }
}
