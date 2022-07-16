package com.dokripgiji.web.controller;

import com.dokripgiji.web.controller.dto.CategoryDto;
import com.dokripgiji.web.domain.category.Category;
import com.dokripgiji.web.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<String> getCategory(@RequestBody CategoryDto categoryDto){
//        System.out.println("categoryDto = " + categoryDto);

        Category category= categoryService.saveCategory(categoryDto);
//        System.out.println("category = " + category);
        return new ResponseEntity<String>("데이터를 성공적으로 수신하였습니다.", HttpStatus.OK);
    }

}
