package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class EventVO {
//    이벤트 고유 id
//    not null
    private Integer id;
//    이벤트 상태
//    not null

//    기본 값 : 0
//    옵션 : 0 - 진행 중, 1- 종료,  2 - 예정
    private Integer eventStatus;

//    이벤트 제목
//    not null
    private String eventTitle;
//    이벤트 내용
//    3000자
//    not null
    private String eventContent;
//    이벤트 시작 날짜
//    not null
    private Date eventStartDate;
//    이벤트 종료 날짜
//    기본 값 : 9999-12-31
//    not null
    private Date eventEndDate;
//    생성 날짜
    private LocalDateTime createDate;
//    업데이트 날짜
    private LocalDateTime updateDate;


}
