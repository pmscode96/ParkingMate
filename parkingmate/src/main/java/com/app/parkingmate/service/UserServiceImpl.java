package com.app.parkingmate.service;

import com.app.parkingmate.domain.VO.UserVO;
import com.app.parkingmate.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

////
//    @Override
//    public Optional<UserVO> getMember(Integer Id) {
////        Optional<UserVO> member = userDAO.findByMember(Id);
////        log.info(member);
//        return userDAO.findByMember(Id);
//    }

    @Override
    public void join(UserVO userVO, Integer Id) {
        if(userVO.getUserProfile() != null){ //카카오 로그인
            Optional<UserVO> foundMember = getKakaoEmail(userVO.getKakaoEmail());
            if(Id != null){
                userVO.setId(Id);
                if(foundMember.isPresent()){
                    delete(foundMember.get().getId());
                }
                updateBySync(userVO);
                return;
            }
//          // 최초 로그인 검사
            if(foundMember.isEmpty()){
                userDAO.save(userVO);
            }else { // 이메일 정보가 있을 경우
                UserVO user = foundMember.get();
                // 카카오회원일 경우 프사 검사
                if(user.getUserProfileName() == null){ // 전달받은 프사경로로 수정
                    //전달받은 카카오 프사로 업데이트
                    updateKakaoProfile(userVO);
                }

            }

        }else{
//            Optional<UserVO> foundEmail = getEmail(userVO.getUserEmail());
//            log.info(foundEmail.toString());
//            if(foundEmail.isPresent()){
//                return;
//            }else{
//                userVO.setUserSnsLoginStatus(0);
//                userDAO.save(userVO);
//            }
            userVO.setUserSnsLoginStatus(0);
            userDAO.save(userVO);
        }
    }



    //    로그인
    public Optional<UserVO> login(UserVO userVO){
        return userDAO.login(userVO);
    }

    //    find-id, find-password
    @Override
    public Optional<UserVO> getEmail(String UserEmail) {
        return userDAO.findByEmail(UserEmail);
    }

    //   카카오 이메일로 조회(login(카카오)부분)
    public Optional<UserVO> getKakaoEmail(String KakaoEmail) {
        return userDAO.findByKakaoEmail(KakaoEmail);
    }

    //    회원정보조회
    public Optional<UserVO> getMember(Integer Id){
        return userDAO.findByMember(Id);
    }

    //    카카오 연동하기
    @Override
    public void updateBySync(UserVO userVO) {
        userDAO.updateBySync(userVO);
    }

    //    회원 삭제
    public void delete(Integer Id){
        userDAO.delete(Id);
    }


    //    전달받은 카카오프사로 업데이트
    @Override
    public void updateKakaoProfile(UserVO userVO) {
        userDAO.updateByKakaoProfile(userVO);
    }
}