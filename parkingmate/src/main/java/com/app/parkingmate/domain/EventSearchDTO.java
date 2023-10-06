package com.app.parkingmate.domain;

import com.app.parkingmate.domain.VO.EventVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class EventSearchDTO {
    private List<EventVO> freeEvents;
    private int freeEventsTotalCount;
}
