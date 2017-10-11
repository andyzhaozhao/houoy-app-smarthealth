package com.houoy.app.smarthealth.dao;


import com.houoy.app.smarthealth.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author andyzhao
 */
@Mapper
public interface RoleMapper {
    //select:单表
    List<Map> retrieveByPK(String pk) throws RuntimeException;

    List<Map> retrieveAll() throws RuntimeException;

    List<RoleVO> retrieveAllWithPage(RoleVO vo) throws RuntimeException;

    Integer retrieveAllCount() throws RuntimeException;

    Integer saveRoleByVO(RoleVO vo);

    Integer updateRoleByVO(RoleVO vo);

    Integer deleteRole(String pk_role);

    Integer deleteRoles(List<String> pk_roles);


    //select:多表关联查询

    //insert 增加

    //update

    //delete
}
