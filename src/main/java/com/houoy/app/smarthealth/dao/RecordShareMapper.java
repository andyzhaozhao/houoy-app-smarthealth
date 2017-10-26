package com.houoy.app.smarthealth.dao;

import com.houoy.app.smarthealth.vo.RecordShareVO;
import com.houoy.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author andyzhao
 */
@Mapper
public interface RecordShareMapper extends BaseMapper<RecordShareVO> {
    Integer updatePortraitByPK(RecordShareVO vo);

    RecordShareVO retrievePortrait(String pk_person) throws RuntimeException;
}
