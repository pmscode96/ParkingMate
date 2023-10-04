package com.app.parkingmate.mapper;

import com.app.parkingmate.domain.VO.EventVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EventMapper {
//    이벤트 작성
    public void insert(EventVO eventVO);

//    이벤트 수정
    public void update(EventVO eventVO);

//    이벤트 status 수정
    public void updateStatus(Integer id);

//    이벤트 list
    public List<EventVO> selectAll();

//    이벤트 detail
    public Optional<EventVO> select(Integer id);


}
