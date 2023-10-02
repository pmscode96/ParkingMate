package com.app.parkingmate.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class CouponDTO {
//    쿠폰 고유 id
//     not null
    private Integer couponId;
//    쿠폰 명
//     not null
    private String couponName;
//    쿠폰 내용
//    3000자
//     not null
    private String couponContent;
//    쿠폰 할인률
//    기본 값 : 10
//     not null
    private Integer couponDiscountPercent;
//    쿠폰 발급 날짜
//    not null
    private Date couponStartDate;
//    쿠폰 종료 날짜
//     not null
    private Date couponEndDate;
//    쿠폰 사용 조건
//    3000자
    private String couponUseCondition;
//    쿠폰 코드
//     not null
//    500자
    private String couponCode;
//    생성 날짜
    private LocalDateTime createDate;
//    업데이트 날짜
    private LocalDateTime updateDate;

//    ================================ FK
//    회원 테이블의 회원 고유 id
//     not null
    private Integer userId;
    //    회원 닉네임
//    not null
    private String userNickName;
    //    회원 이름
//    not null
    private String userName;
    //    회원 패스워드
//    500자
//    not null
    private String userPassword;
    //    회원 이메일
//    500자
//    not null
    private String userEmail;
    //    회원 전화번호
//    not null
    private Integer userPhoneNumber;
    //    회원 상태
//    기본 값 : 이용 중
//    옵션 : 이용 중, 정지, 탈퇴
//    not null
    private String userStatus;
    //    회원 구분
//    기본 값 : 회원
//    옵션 : 회원 ,판매자
//    not null
    private String userClass;
    //    회원 가입 날짜
//    not null
    private Date userStartDate;
    //    회원탈퇴 일수
//    기본 값 : 0
    private Integer userWithdrawalCount;
    //  회원 프로필
//  not null
    private  String userProfile;
    //    SNS 로그인상태
//    기본 값 : 미사용
//    옵션 : 미사용, 카카오 로그인
    private String userSnsLoginStatus;
//    =======================================================================
//    이벤트 테이블의 이벤트 고유 id
//     not null
    private Integer eventId;
    //    이벤트 상태
//    not null
//    기본 값 : 진행 중
//    옵션 : 진행 중, 종료, 예정
    private String eventStatus;
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
}
