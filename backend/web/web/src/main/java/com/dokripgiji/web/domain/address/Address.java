package com.dokripgiji.web.domain.address;

import com.dokripgiji.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "userId", updatable = false)
    private User user;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    @Column
    private int n;

    @Builder
    public Address(Long addressId, User user, Double longitude, Double latitude, int n) {
        this.addressId = addressId;
        this.user = user;
        this.longitude = longitude;
        this.latitude = latitude;
        this.n = n;
    }
}
