package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.UserVO;

import java.util.Optional;

public interface UserService {
//    public Optional<UserVO> getMember(Integer Id);


    public void join(UserVO userVO, Integer Id);


//    find-id,find-password
    public Optional<UserVO> getEmail(String UserEmail);

//  카카오 이메일로 조회(login(카카오)부분)
    public Optional<UserVO> getKakaoEmail(String KakaoEmail);

//    회원정보조회
    public Optional<UserVO> getMember(Integer Id);

//    로그인
    public Optional<UserVO> login(UserVO userVO);

//    카카오 연동하기
    public void updateBySync(UserVO userVO);

//    회원 삭제
    public void delete(Integer Id);

//    전달받은 카카오프사로 업데이트
    public void updateKakaoProfile(UserVO userVO);
}
