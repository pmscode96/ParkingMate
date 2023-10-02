package com.app.parkingmate.mapper;

import com.app.parkingmate.domain.VO.ParkingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ParkingMapper {
    //    주차장 조회
    public List<ParkingVO> select(ParkingVO parkingVO);
}
