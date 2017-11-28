package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.RecordShareMapper;
import com.houoy.app.smarthealth.service.RecordShareService;
import com.houoy.app.smarthealth.vo.RecordShareVO;
import com.houoy.common.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recordShareService")
public class RecordShareServiceImpl extends BaseServiceImpl<RecordShareMapper, RecordShareVO> implements RecordShareService {

    @Override
    @Autowired
    protected void setService(RecordShareMapper _mapper) {
        mapper = _mapper;
    }

    @Override
    public Integer updatePortraitByPK(RecordShareVO vo) {
        return mapper.updatePortraitByPK(vo);
    }

    @Override
    public RecordShareVO retrievePortrait(String pk_person) {
        RecordShareVO rs = mapper.retrievePortrait(pk_person);
        return rs;
    }

    @Override
    public List<RecordShareVO> retrieveAllFollowWithPage(RecordShareVO vo) {
        List<RecordShareVO> rs = mapper.retrieveAllFollowWithPage(vo);
        return rs;
    }

    @Override
    public List<RecordShareVO> retrieveAllUnFollowWithPage(RecordShareVO vo) {
        List<RecordShareVO> rs = mapper.retrieveAllUnFollowWithPage(vo);
        return rs;
    }

    @Override
    public Long retrieveAllFollowCount(RecordShareVO vo) {
        return this.mapper.retrieveAllFollowCount(vo);
    }

    @Override
    public Long retrieveAllUnFollowCount(RecordShareVO vo) {
        return this.mapper.retrieveAllUnFollowCount(vo);
    }
}
