package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.dao.PersonMapper;
import com.houoy.app.smarthealth.service.PersonService;
import com.houoy.app.smarthealth.vo.PersonVO;
import com.houoy.common.vo.RequestResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 吕召 on 2017/2/14 0014.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;


    @Override
    public List<PersonVO> retrieveAll() {
        return personMapper.retrieveAll();
    }

    @Override
    public List<PersonVO> retrieveByPK(String pk) {
        return null;
    }

    @Override
    public Long retrieveAllCount() throws RuntimeException {
        return personMapper.retrieveAllCount();
    }

    @Override
    public List<PersonVO> retrieveAllWithPage(PersonVO vo) throws RuntimeException {
        return personMapper.retrieveAllWithPage(vo);
    }

    @Override
    public Integer saveByVO(PersonVO vo) {
        return personMapper.saveByVO(vo);
    }

    @Override
    public Integer updateByVO(PersonVO vo) {
        return personMapper.updateByVO(vo);
    }

    @Override
    public Integer deleteByPK(String pk) {
        return personMapper.deleteByPK(pk);
    }

    @Override
    public Integer deleteByPK(List<String> pks) {
        return personMapper.deleteByPKs(pks);
    }

    @Override
    public List<PersonVO> retrieveByParentPK(List<String> pks) {
        return null;
    }

    @Override
    public Integer updatePortraitByPK(PersonVO vo) {
        return personMapper.updatePortraitByPK(vo);
    }

    @Override
    public RequestResultVO retrievePortrait(String pk_person) {
        RequestResultVO resultVO = new RequestResultVO();
        if(pk_person==null){
            resultVO.setSuccess(false);
            resultVO.setMsg("文件为空");
        }else{
            PersonVO rs = personMapper.retrievePortrait(pk_person);
            if(rs!=null){
                resultVO.setSuccess(true);
                resultVO.setResultData(rs);
            }else {
                resultVO.setSuccess(false);
                resultVO.setMsg("没有找到此用户头像");
            }
        }
        return resultVO;
    }
}
