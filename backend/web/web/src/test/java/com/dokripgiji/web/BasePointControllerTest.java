package com.dokripgiji.web;

import com.dokripgiji.web.controller.BasePointController;
import com.dokripgiji.web.domain.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.Map;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BasePointControllerTest {

    @Autowired
    private BasePointController basePointController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void PostTest() throws Exception {

        Map<String, Object> data = new HashMap<>();

        data.put("basesId",1);
        data.put("userId", 1);
        data.put("address","126.299942");
        data.put("longitude",126.299942);
        data.put("latitude",37.111);
        data.put("n",10);

        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println("this.mockMvc = " + mockMvc);

        ResultActions resultActions=mockMvc.perform(post("/base")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isOk());
    }
}
