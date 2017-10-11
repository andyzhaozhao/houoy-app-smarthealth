package com.houoy.app.smarthealth.dao;

import com.houoy.app.smarthealth.vo.PersonVO;
import com.houoy.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author andyzhao
 */
@Mapper
public interface PersonMapper extends BaseMapper<PersonVO> {
    Integer updatePortraitByPK(PersonVO vo);

    PersonVO retrievePortrait(String pk_person) throws RuntimeException;
}
