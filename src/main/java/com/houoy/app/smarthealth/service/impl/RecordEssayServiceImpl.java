package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.RecordEssayMapper;
import com.houoy.app.smarthealth.service.RecordEssayService;
import com.houoy.app.smarthealth.vo.RecordEssayVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recordEssayService")
public class RecordEssayServiceImpl extends BaseServiceImpl<RecordEssayMapper, RecordEssayVO> implements RecordEssayService {

    @Override
    @Autowired
    protected void setService(RecordEssayMapper _mapper) {
        mapper = _mapper;
    }
}
