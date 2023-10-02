package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class DibsVO {
//    찜 고유 id
//     not null
    private Integer ChoiceId;
//    찜 카테고리
//    도시
//    도시 : (시), (구) 카테고리
//    500자
    private  String DibsCategory;
//   찜 기간
    private Integer DibsPeriod;
//    재판매 요청
//    기본 값 : 0
//   1 - Ture : 해당 찜 재판매 요청
//   0 - False : 해당 찜 재판매 요청 x
//     not null
    private Integer ReSaleRequest;
//    생성 날짜
    private Date CreateDate;
//    업데이트 날짜
    private Date UpdateDate;

//    =========================================== FK
//    회원 테이블의 회원 id
//     not null
    private Integer UserId;
//    주차장 테이블의 주차장 id
//     not null
    private Integer ParkingId;
}
