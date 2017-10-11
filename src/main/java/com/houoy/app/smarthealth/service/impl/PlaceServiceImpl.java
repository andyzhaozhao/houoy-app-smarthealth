package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.PlaceMapper;
import com.houoy.app.smarthealth.service.PlaceService;
import com.houoy.app.smarthealth.vo.PlaceVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("placeService")
public class PlaceServiceImpl extends BaseServiceImpl<PlaceMapper, PlaceVO> implements PlaceService {

    @Override
    @Autowired
    protected void setService(PlaceMapper _mapper) {
        mapper = _mapper;
    }
}
