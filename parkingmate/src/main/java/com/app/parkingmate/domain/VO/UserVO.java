package com.app.parkingmate.domain.VO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class UserVO implements Serializable{
//    회원 고유 id
//    not null

//    private Integer UserId;
    private Integer Id;

//    회원 닉네임
//    not null
    private String UserNickName;
//    회원 이름
//    not null
    private String UserName;
//    회원 패스워드
//    500자
//    not null
    private String UserPassword;
//    회원 이메일
//    500자
//    not null
    private String UserEmail;
//    회원 전화번호
//    not null
    private String UserPhoneNumber;
//    회원 상태
//    기본 값 : 0
//    옵션 : 0 - 이용 중, 1 - 정지, 2 - 탈퇴
//    not null
    private Integer UserStatus;
//    회원 구분
//    기본 값 : 0
//    옵션 : 0 - 회원 ,1 - 판매자
//    not null
    private Integer UserClass;
//    회원 가입 날짜
//    not null
    private Date UserStartDate;
//    회원탈퇴 일수
//    기본 값 : 0
    private Integer UserWithdrawalCount;
//  회원 프로필
//  not null
    private  String UserProfile;
//    SNS 로그인상태
//    기본 값 : 0
//    옵션 : 0 - 미사용, 1 - 카카오 로그인
    private Integer UserSnsLoginStatus;
//    생성 날짜
    private LocalDateTime CreateDate;
//    업데이트 날짜
    private LocalDateTime UpdateDate;

    private String KakaoEmail;

    private String UserProfileName;

    private String UserProfilePath;

    private String UserPasswordCheck;

}
