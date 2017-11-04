package com.houoy.app.smarthealth.service.impl;

import com.houoy.app.smarthealth.client.MailClient;
import com.houoy.app.smarthealth.dao.PersonMapper;
import com.houoy.app.smarthealth.service.PersonService;
import com.houoy.app.smarthealth.vo.PersonVO;
import com.houoy.common.mail.MailVO;
import com.houoy.common.service.BaseServiceImpl;
import com.houoy.common.vo.RequestResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by 吕召 on 2017/2/14 0014.
 */
@Service("personService")
public class PersonServiceImpl extends BaseServiceImpl<PersonMapper, PersonVO> implements PersonService {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private PersonMapper personMapper;

    @Override
    @Autowired
    protected void setService(PersonMapper _mapper) {
        mapper = _mapper;
    }

    @Override
    public List<PersonVO> retrieveByPK(String pk) {
        return null;
    }

    @Override
    public Integer updatePortraitByPK(PersonVO vo) {
        return personMapper.updatePortraitByPK(vo);
    }

    @Override
    public RequestResultVO retrievePortrait(String pk_person) {
        RequestResultVO resultVO = new RequestResultVO();
        if (pk_person == null) {
            resultVO.setSuccess(false);
            resultVO.setMsg("文件为空");
        } else {
            PersonVO rs = personMapper.retrievePortrait(pk_person);
            if (rs != null) {
                resultVO.setSuccess(true);
                resultVO.setResultData(rs);
            } else {
                resultVO.setSuccess(false);
                resultVO.setMsg("没有找到此用户头像");
            }
        }
        return resultVO;
    }

    public Boolean forgetPassword(PersonVO personVO) {
        MailVO mailVO = new MailVO();
        String email = personVO.getEmail();
        if (!StringUtils.isEmpty(email)) {
            List<PersonVO> personVOs = personMapper.retrieveAllWithPage(personVO);
            if (personVOs == null || personVOs.size() <= 0) {
                return false;
            } else {
                PersonVO person = personVOs.get(0);
                mailVO.setSubject("忘记密码");
                mailVO.setContent(person.getPassword());
                mailVO.setTo("您的密码是："+person.getEmail());
                Boolean result = mailClient.sendSimpleMail(mailVO);
                return result;
            }
        } else {
            return false;
        }
    }

}
