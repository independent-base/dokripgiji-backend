package com.dokripgiji.web.service;

import com.dokripgiji.web.domain.basepoint.BasePoint;
import com.dokripgiji.web.domain.basepoint.BasePointRepository;
import com.dokripgiji.web.controller.dto.BasePointRequestDto;
import com.dokripgiji.web.controller.dto.BasePointResponseDto;
import com.dokripgiji.web.domain.user.User;
import com.dokripgiji.web.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BasePointService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BasePointRepository addressRepository;

    public BasePointResponseDto buildResponseDto(BasePoint adr){
        return new BasePointResponseDto(adr);
    }

    @Transactional
    public BasePointResponseDto saveAddress(BasePointRequestDto requestDto){

        String address= requestDto.getAddress();
        Double longitude = requestDto.getLongitude();
        Double latitude = requestDto.getLatitude();
        int n = requestDto.getN();

        User user = userRepository.getByUserId(requestDto.getUserId());

        BasePoint basePoint = BasePoint.builder()
                .user(user)
                .address(address)
                .longitude(longitude)
                .latitude(latitude)
                .build();

//        System.out.println(requestDto.getUserId());

        BasePoint responseAddress = addressRepository.save(basePoint);

        return buildResponseDto(responseAddress);
    }

}
