package com.houoy.app.smarthealth.service;

import com.houoy.app.smarthealth.vo.PersonVO;
import com.houoy.common.service.BaseService;
import com.houoy.common.vo.RequestResultVO;

public interface PersonService extends BaseService<PersonVO> {
    Integer updatePortraitByPK(PersonVO vo);

    RequestResultVO retrievePortrait(String pk_person);
}
