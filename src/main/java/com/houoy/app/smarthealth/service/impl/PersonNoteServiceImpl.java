package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.PersonNoteMapper;
import com.houoy.app.smarthealth.service.PersonNoteService;
import com.houoy.app.smarthealth.vo.PersonNoteVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personNoteService")
public class PersonNoteServiceImpl extends BaseServiceImpl<PersonNoteMapper, PersonNoteVO> implements PersonNoteService {

    @Override
    @Autowired
    protected void setService(PersonNoteMapper _mapper) {
        mapper = _mapper;
    }
}
