package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.RecordShareMapper;
import com.houoy.app.smarthealth.service.RecordShareService;
import com.houoy.app.smarthealth.vo.RecordShareVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recordShareService")
public class RecordShareServiceImpl extends BaseServiceImpl<RecordShareMapper, RecordShareVO> implements RecordShareService {

    @Override
    @Autowired
    protected void setService(RecordShareMapper _mapper) {
        mapper = _mapper;
    }
}
