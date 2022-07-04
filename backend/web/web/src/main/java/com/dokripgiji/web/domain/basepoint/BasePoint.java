package com.dokripgiji.web.domain.basepoint;

import com.dokripgiji.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class BasePoint {

    @Id
    @Column(name = "baseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basesId;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "userId", updatable = false)
    private User user;

    @Column(name = "field",nullable = false)
    private String address;

    @Column(name = "baseLongitude",nullable = false)
    private Double longitude;

    @Column(name = "baseLatitude",nullable = false)
    private Double latitude;

    @Builder
    public BasePoint(Long basesId, User user, String address, Double longitude, Double latitude) {
        this.basesId = basesId;
        this.user = user;
        this.address=address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
