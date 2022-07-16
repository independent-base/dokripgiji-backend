package com.dokripgiji.web;

import com.dokripgiji.web.controller.CategoryController;
import com.dokripgiji.web.domain.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void GetTest() throws Exception {

        Map<String, Object> data = new HashMap<>();

        data.put("categoryId",1);
        data.put("userId", 1);
        data.put("code","126.299942");

        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println("this.mockMvc = " + mockMvc);

        ResultActions resultActions=mockMvc.perform(get("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isOk());
    }
}
