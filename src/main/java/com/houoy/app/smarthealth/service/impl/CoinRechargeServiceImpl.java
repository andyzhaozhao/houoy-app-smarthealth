package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.CoinRechargeMapper;
import com.houoy.app.smarthealth.service.CoinRechargeService;
import com.houoy.app.smarthealth.vo.CoinRechargeVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("coinRechargeService")
public class CoinRechargeServiceImpl extends BaseServiceImpl<CoinRechargeMapper, CoinRechargeVO> implements CoinRechargeService {

    @Override
    @Autowired
    protected void setService(CoinRechargeMapper _mapper) {
        mapper = _mapper;
    }
}
