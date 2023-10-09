package com.app.parkingmate.repository;

import com.app.parkingmate.domain.VO.CarInfoVO;
import com.app.parkingmate.mapper.CarInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CarInfoDAO {
    private final CarInfoMapper carInfoMapper;

    public List<CarInfoVO> bringAllCarInfos(int userId){return carInfoMapper.selectAll(userId);}

    public void save(CarInfoVO carInfoVO){carInfoMapper.insert(carInfoVO);}

    public void delete(int id){carInfoMapper.delete(id);}
}
