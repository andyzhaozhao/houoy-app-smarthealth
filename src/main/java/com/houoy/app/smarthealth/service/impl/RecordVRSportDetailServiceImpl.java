package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.RecordVRSportDetailMapper;
import com.houoy.app.smarthealth.service.RecordVRSportDetailService;
import com.houoy.app.smarthealth.vo.RecordVRSportDetailVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recordVRSportDetailService")
public class RecordVRSportDetailServiceImpl extends BaseServiceImpl<RecordVRSportDetailMapper, RecordVRSportDetailVO>
        implements RecordVRSportDetailService {

    @Override
    @Autowired
    protected void setService(RecordVRSportDetailMapper _mapper) {
        mapper = _mapper;
    }
}
