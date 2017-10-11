package com.houoy.app.smarthealth.service;

import com.houoy.common.vo.SuperVO;
import com.houoy.common.vo.UserVO;

import java.util.List;

public interface LoginService {
    List<SuperVO> retrieveAllWithPage(SuperVO vo) throws RuntimeException;

    Integer retrieveAllCount() throws RuntimeException;

    List<UserVO> retrieveByCodeAndPwd(String code, String password) throws RuntimeException;
}
