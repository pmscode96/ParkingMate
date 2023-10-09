package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.CarInfoVO;

import java.util.List;

public interface CarInfoService {

    public List<CarInfoVO> bringAllCarInfos(int userId);
    public void save(CarInfoVO carInfoVO);

    public void delete(int id);

}
