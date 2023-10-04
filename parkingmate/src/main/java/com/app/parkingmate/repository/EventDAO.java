package com.app.parkingmate.repository;

import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EventDAO {
    private final EventMapper eventMapper;

//    이벤트 작성
    public void save(EventVO eventVO){eventMapper.insert(eventVO);}

//    이벤트 리스트
    public List<EventVO> list(){return eventMapper.selectAll();}

//    이벤트 디테일
    public Optional<EventVO> selectByEventId(Integer id){return eventMapper.select(id);}


//    이벤트 수정
    public void update(EventVO eventVO){eventMapper.update(eventVO);}

//    이벤트 status 수정
    public void updateStatus(EventVO eventVO){eventMapper.update(eventVO);}
}
