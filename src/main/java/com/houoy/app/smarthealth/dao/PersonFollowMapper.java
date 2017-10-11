package com.houoy.app.smarthealth.dao;

import com.houoy.app.smarthealth.vo.RelationFollowPersonVO;
import com.houoy.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author andyzhao
 */
@Mapper
public interface PersonFollowMapper extends BaseMapper<RelationFollowPersonVO> {
}
