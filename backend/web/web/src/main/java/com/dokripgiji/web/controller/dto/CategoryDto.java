package com.dokripgiji.web.controller.dto;

import com.dokripgiji.web.domain.user.User;
import lombok.Data;

@Data
public class CategoryDto {

    private Long category_id;

    private User user;

    private String code;
}
