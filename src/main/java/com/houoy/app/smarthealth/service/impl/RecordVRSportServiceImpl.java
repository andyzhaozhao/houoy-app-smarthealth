package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.RecordVRSportMapper;
import com.houoy.app.smarthealth.service.RecordVRSportService;
import com.houoy.app.smarthealth.vo.RecordVRSportVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recordVRSportService")
public class RecordVRSportServiceImpl extends BaseServiceImpl<RecordVRSportMapper, RecordVRSportVO> implements RecordVRSportService {

    @Override
    @Autowired
    protected void setService(RecordVRSportMapper _mapper) {
        mapper = _mapper;
    }
}
