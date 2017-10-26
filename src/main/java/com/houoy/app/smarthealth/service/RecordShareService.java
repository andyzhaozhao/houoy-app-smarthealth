package com.houoy.app.smarthealth.service;

import com.houoy.app.smarthealth.vo.RecordShareVO;
import com.houoy.common.service.BaseService;

public interface RecordShareService extends BaseService {
    Integer updatePortraitByPK(RecordShareVO vo);

    RecordShareVO retrievePortrait(String pk_person);
}
