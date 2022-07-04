package com.dokripgiji.web.controller.dto;


import com.dokripgiji.web.domain.basepoint.BasePoint;
import com.dokripgiji.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BasePointResponseDto {

    private Long addressId;
    private User user;
    private Double longitude;
    private Double latitude;

    @Builder
    public BasePointResponseDto(BasePoint entity) {
        this.addressId = entity.getBasesId();
        this.user = entity.getUser();
        this.longitude = entity.getLongitude();
        this.latitude = entity.getLatitude();
    }
}
