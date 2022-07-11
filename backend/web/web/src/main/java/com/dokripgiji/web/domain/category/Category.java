package com.dokripgiji.web.domain.category;

import com.dokripgiji.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "user", updatable = false)
    private User user;

    @Column(length = 10, nullable = false)
    private String code;

    @Builder
    public Category(Long category_id, User user, String code) {
        this.category_id = category_id;
        this.user = user;
        this.code = code;
    }
}
