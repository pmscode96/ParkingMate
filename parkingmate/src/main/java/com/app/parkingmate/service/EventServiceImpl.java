package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.EventVO;
import com.app.parkingmate.repository.EventDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventDAO eventDAO;
    @Override
    public void create(EventVO eventVO) {
        eventDAO.save(eventVO);
    }


    @Override
    public List<EventVO> list() {
        return eventDAO.list();
    }

    @Override
    public Optional<EventVO> detail(Integer id) {
        return eventDAO.selectByEventId(id);
    }

    @Override
    public void update(EventVO eventVO) {
        eventDAO.update(eventVO);
    }

    @Override
    public void updateStatus(EventVO eventVO) {
        eventDAO.updateStatus(eventVO);
    }
}
