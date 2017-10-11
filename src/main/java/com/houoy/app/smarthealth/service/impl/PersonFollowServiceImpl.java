package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.PersonFollowMapper;
import com.houoy.app.smarthealth.service.PersonFollowService;
import com.houoy.app.smarthealth.vo.RelationFollowPersonVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personFollowService")
public class PersonFollowServiceImpl extends BaseServiceImpl<PersonFollowMapper, RelationFollowPersonVO> implements PersonFollowService
{

    @Override
    @Autowired
    protected void setService(PersonFollowMapper _mapper) {
        mapper = _mapper;
    }
}
