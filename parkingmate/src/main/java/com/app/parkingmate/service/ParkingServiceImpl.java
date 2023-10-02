package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.ParkingVO;
import com.app.parkingmate.repository.ParkingDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParkingServiceImpl implements ParkingService {
    private final ParkingDAO parkingDAO;

    @Override
    public List<ParkingVO> getParking(ParkingVO parkingVO) {

        return parkingDAO.findByParking(parkingVO);
    }
}
