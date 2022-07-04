package com.dokripgiji.web.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressRequestDto {

    private Long userId;
    private Double longitude;
    private Double latitude;
    private int n;

    @Builder
    public AddressRequestDto(Long userId, Double longitude, Double latitude, int n) {
        this.userId = userId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.n = n;
    }
}
