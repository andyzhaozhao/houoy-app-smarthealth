package com.houoy.app.smarthealth.service;

import com.houoy.app.smarthealth.vo.PlaceVO;
import com.houoy.common.service.BaseService;

import java.util.List;

/**
 * Created by andyzhao on 2017-02-20.
 */
public interface EssayTypeService extends BaseService<PlaceVO> {
    List<PlaceVO> retrieveByParentPK(List<String> pks);
}
