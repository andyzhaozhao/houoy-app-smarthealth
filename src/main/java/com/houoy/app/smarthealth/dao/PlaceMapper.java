package com.houoy.app.smarthealth.dao;

import com.houoy.app.smarthealth.vo.PlaceVO;
import com.houoy.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author andyzhao
 */
@Mapper
public interface PlaceMapper extends BaseMapper<PlaceVO> {
    List<PlaceVO> retrieveByParentPK(List<String> pks);
}
