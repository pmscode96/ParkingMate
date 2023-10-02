package com.app.parkingmate.repository;

import com.app.parkingmate.domain.DTO.ParkingDTO;
import com.app.parkingmate.domain.VO.ParkingVO;
import com.app.parkingmate.mapper.ParkingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ParkingDAO {
    private final ParkingMapper parkingMapper;

    //    주차장 조회
    public List<ParkingVO> findByParking(ParkingVO parkingVO){

        return  parkingMapper.select(parkingVO);
    }
}
