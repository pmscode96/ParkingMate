package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.CarInfoVO;
import com.app.parkingmate.repository.CarInfoDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarInfoServiceImpl implements CarInfoService {
    private final CarInfoDAO carInfoDAO;

    @Override
    public List<CarInfoVO> bringAllCarInfos(int userId) {
        return carInfoDAO.bringAllCarInfos(userId);
    }

    @Override
    public void save(CarInfoVO carInfoVO) {
        carInfoDAO.save(carInfoVO);
    }

    @Override
    public void delete(int id) {
        carInfoDAO.delete(id);
    }
}
