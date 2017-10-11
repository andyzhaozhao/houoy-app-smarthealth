package com.houoy.app.smarthealth.service;

import com.houoy.common.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> retrieveAllWithPage(UserVO vo) throws RuntimeException;

    Long retrieveAllCount() throws RuntimeException;

    Integer saveUserByVO(UserVO vo);

    Integer updateUserByVO(UserVO vo);

    Integer deleteUsers(List<String> pk_users);

    Boolean updateUserRole(UserVO vo);
}
