package com.dokripgiji.web.controller;

import com.dokripgiji.web.controller.dto.BasePointRequestDto;
import com.dokripgiji.web.controller.dto.BasePointResponseDto;
import com.dokripgiji.web.service.BasePointService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BasePointController {

    private final BasePointService basePointService;

    // 주소 설정 api
    @PostMapping(value = "/basepoint/{userId}")
    public BasePointResponseDto saveBasePoint(@PathVariable Long userId,@RequestBody BasePointRequestDto requestDto){
        return basePointService.saveAddress(requestDto);
    }

    /*
    // 주소 반환 api
    @GetMapping(value = "/basepoint/{userId}")
    public BasePointResponseDto getBasePoint(@PathVariable Long userId){
        return basePointService.getAddress(userId);
    }


     */

    // 주소 변경 api
    @PutMapping(value = "/basepoint/{userId}")
    public BasePointResponseDto updateBasePoint(@PathVariable Long userId, @RequestBody BasePointRequestDto requestDto){
        return basePointService.saveAddress(requestDto);
    }

}


