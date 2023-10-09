package com.app.parkingmate.mapper;

import com.app.parkingmate.domain.VO.CarInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarInfoMapper {
//    정보 입력

    public List<CarInfoVO> selectAll(int userId);

    public void insert(CarInfoVO carInfoVO);

    public void delete(int Id);
}
