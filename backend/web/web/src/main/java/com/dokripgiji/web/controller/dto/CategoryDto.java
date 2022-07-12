package com.dokripgiji.web.controller.dto;

import com.dokripgiji.web.domain.user.User;
import lombok.Data;

@Data
public class CategoryDto {

    private Long categoryId;

    private Long userId;

    private String code;
}
