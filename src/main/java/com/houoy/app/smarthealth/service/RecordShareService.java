package com.houoy.app.smarthealth.service;

import com.houoy.app.smarthealth.vo.RecordShareVO;
import com.houoy.common.service.BaseService;

import java.util.List;

public interface RecordShareService extends BaseService {
    Integer updatePortraitByPK(RecordShareVO vo);

    RecordShareVO retrievePortrait(String pk_person);

    List<RecordShareVO> retrieveAllFollowWithPage(RecordShareVO vo);

    List<RecordShareVO> retrieveAllUnFollowWithPage(RecordShareVO vo);

    Long retrieveAllFollowCount(RecordShareVO vo);

    Long retrieveAllUnFollowCount(RecordShareVO vo);
}
