package com.houoy.app.smarthealth.dao;

import com.houoy.common.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    //select:单表
    List<Map> retrieveByPK(String pk) throws RuntimeException;

    List<Map> retrieveAll() throws RuntimeException;

    List<UserVO> retrieveAllWithPage(UserVO vo) throws RuntimeException;

    Long retrieveAllCount(UserVO vo) throws RuntimeException;

    Integer saveUserByVO(UserVO vo);

    Integer updateUserByVO(UserVO vo);

    Integer deleteUser(String pk_user);

    Integer deleteUsers(List<String> pk_users);

    Integer updateUserRole(UserVO vo);

    //select:多表关联查询

    //insert 增加

    //update

    //delete
}
