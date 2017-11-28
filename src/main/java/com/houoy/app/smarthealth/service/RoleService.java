package com.houoy.app.smarthealth.service;

import com.houoy.app.smarthealth.vo.RoleVO;

import java.util.List;

public interface RoleService {
    List<RoleVO> retrieveAllWithPage(RoleVO vo) throws RuntimeException;

    Integer retrieveAllCount(RoleVO vo) throws RuntimeException;

    Integer saveRoleByVO(RoleVO vo);

    Integer updateRoleByVO(RoleVO vo);

    Integer deleteRoles(List<String> pk_roles);
}
