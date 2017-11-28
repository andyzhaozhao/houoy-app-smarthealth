package com.houoy.app.smarthealth.service.impl;


import com.houoy.app.smarthealth.dao.RoleMapper;
import com.houoy.app.smarthealth.service.RoleService;
import com.houoy.app.smarthealth.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author andyzhao
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<RoleVO> retrieveAllWithPage(RoleVO vo) throws RuntimeException {
        List<RoleVO> datas = roleMapper.retrieveAllWithPage(vo);
        return datas;
    }

    public Integer retrieveAllCount(RoleVO vo) throws RuntimeException {
        return roleMapper.retrieveAllCount(vo);
    }

    public Integer saveRoleByVO(RoleVO vo) {
        return roleMapper.saveRoleByVO(vo);
    }

    public Integer updateRoleByVO(RoleVO vo) {
        return roleMapper.updateRoleByVO(vo);
    }

    public Integer deleteRoles(List<String> pk_roles) {
        return roleMapper.deleteRoles(pk_roles);
    }
}
