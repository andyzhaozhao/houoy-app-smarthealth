package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.PlaceMapper;
import com.houoy.app.smarthealth.service.EssayTypeService;
import com.houoy.app.smarthealth.vo.PlaceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andyzhao on 2017/2/14 0014.
 */
@Service("essayTypeService")
public class EssayTypeServiceImpl implements EssayTypeService {

    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public List<PlaceVO> retrieveAll() {
        return placeMapper.retrieveAll();
    }

    @Override
    public List<PlaceVO> retrieveByPK(String pk) {
        return null;
    }

    @Override
    public Long retrieveAllCount(PlaceVO vo) throws RuntimeException {
        return placeMapper.retrieveAllCount(vo);
    }

    @Override
    public List<PlaceVO> retrieveAllWithPage(PlaceVO vo) throws RuntimeException {
        return placeMapper.retrieveAllWithPage(vo);
    }


    @Override
    public Integer saveByVO(PlaceVO vo) {
        return placeMapper.saveByVO(vo);
    }

    @Override
    public Integer updateByVO(PlaceVO vo) {
        return placeMapper.updateByVO(vo);
    }

    @Override
    public Integer deleteByPK(String pk) {
        return placeMapper.deleteByPK(pk);
    }

    @Override
    public Integer deleteByPK(List<String> pks) {
        return placeMapper.deleteByPKs(pks);
    }


    @Override
    public List<PlaceVO> retrieveByParentPK(List<String> pks) {
        return placeMapper.retrieveByParentPK(pks);
    }
}
