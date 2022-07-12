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
    private Long categoryId;

    @ManyToOne(targetEntity = User.class) //단반향
    @JoinColumn(name = "user", updatable = false)
    private User user;

    @Column(length = 10, nullable = false)
    private String code;

    @Builder
    public Category(Long categoryId, User user, String code) {
        this.categoryId = categoryId;
        this.user = user;
        this.code = code;
    }
}
