package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.HobbyMapper;
import com.houoy.app.smarthealth.service.HobbyService;
import com.houoy.app.smarthealth.vo.HobbyVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hobbyService")
public class HobbyServiceImpl extends BaseServiceImpl<HobbyMapper,HobbyVO> implements HobbyService {

    @Override
    @Autowired
    protected void setService(HobbyMapper _mapper) {
        mapper = _mapper;
    }
}
