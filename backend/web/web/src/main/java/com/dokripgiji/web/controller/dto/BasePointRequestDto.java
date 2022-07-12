package com.dokripgiji.web.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasePointRequestDto {

    private Long userId;
    private String address;
    private Double baseLongitude;
    private Double baseLatitude;

    @Builder
    public BasePointRequestDto(Long userId, String address, Double baseLongitude, Double baseLatitude) {
        this.userId = userId;
        this.address = address;
        this.baseLongitude = baseLongitude;
        this.baseLatitude = baseLatitude;
    }

}
