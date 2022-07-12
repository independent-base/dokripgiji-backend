package com.dokripgiji.web.domain.basepoint;

import com.dokripgiji.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "BasePoint")
public class BasePoint {

    @Id
    @Column(name = "baseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basesId;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "user", updatable = false)
    private User user;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double baseLongitude;

    @Column(nullable = false)
    private Double baseLatitude;

    @Builder
    public BasePoint(Long basesId, User user, String address, Double baseLongitude, Double baseLatitude) {
        this.basesId = basesId;
        this.user = user;
        this.address=address;
        this.baseLongitude = baseLongitude;
        this.baseLatitude = baseLatitude;
    }
}
