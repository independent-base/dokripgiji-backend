package com.dokripgiji.web.service;

import com.dokripgiji.web.controller.dto.CategoryDto;
import com.dokripgiji.web.domain.category.Category;
import com.dokripgiji.web.domain.category.CategoryRepository;
import com.dokripgiji.web.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    public final CategoryRepository categoryRepository;

    public void saveCategory(CategoryDto categoryDto){
        User user=categoryDto.getUser();
        String code= categoryDto.getCode();

        Category category=Category.builder()
                .user(user)
                .code(code)
                .build();

        categoryRepository.save(category);
    }
}
