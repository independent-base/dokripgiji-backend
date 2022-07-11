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
    private Double longitude;
    private Double latitude;
    private int n;

    @Builder
    public BasePointRequestDto(Long userId, String address,Double longitude, Double latitude, int n) {
        this.userId = userId;
        this.address= address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.n = n;
    }
}
