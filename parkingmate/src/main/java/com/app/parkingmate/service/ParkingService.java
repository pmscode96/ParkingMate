package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.ParkingVO;

import java.util.List;

public interface ParkingService {
    //    주차장 조회
    public List<ParkingVO> getParking(ParkingVO parkingVO);

}
