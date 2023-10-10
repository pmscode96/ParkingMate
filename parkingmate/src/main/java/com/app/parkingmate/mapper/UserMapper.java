package com.app.parkingmate.mapper;

import com.app.parkingmate.domain.VO.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    public void insert(UserVO userVO);


//    find-id, find-password할때 조회쿼리
    public Optional<UserVO> select(String UserEmail);
    
//    카카오 이메일로 조회(login(카카오)부분)
    public Optional<UserVO> kakaoSelect(String KakaoEmail);

//    회원정보조회
    public Optional<UserVO> selectMember(Integer Id);

//    전달받은 카카오프사로 업데이트
    public void updateKaKaoProfile(UserVO userVO);

//    로그인
    public Optional<UserVO> selectLogin(UserVO userVO);

//    카카오 연동하기
    public void updateBySync(UserVO userVO);

//    개인정보 변경 부문
    public void updateUser(UserVO userVO);

//    프로필 사진 업데이트
    public void updateProfileImg(UserVO userVO);

    // 프로필 사진 삭제(카카오톡 프로필 사진은 그대로 유지됨)
    public void updateToDeleteProfileImg(Integer id);

//    회원 삭제
    public void delete(Integer Id);

//    회원 정보 조회
//    public Optional<UserVO> select(Integer Id);

//    회원 전체 선택
    public List<UserVO> selectAll();
}
