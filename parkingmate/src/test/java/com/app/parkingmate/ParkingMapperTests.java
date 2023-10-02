package com.app.parkingmate;

import com.app.parkingmate.domain.DTO.ParkingDTO;
import com.app.parkingmate.domain.VO.ParkingVO;
import com.app.parkingmate.mapper.ParkingMapper;
import com.app.parkingmate.repository.ParkingDAO;
import com.app.parkingmate.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class ParkingMapperTests {
    @Autowired
    private ParkingMapper parkingMapper;

    @Autowired
    private ParkingService parkingService;

    @Test
    public void selectTest(){

    }
}
