package com.houoy.app.smarthealth.controller;

import com.houoy.app.smarthealth.service.PersonFollowService;
import com.houoy.app.smarthealth.vo.RelationFollowPersonVO;
import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.web.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author andyzhao
 */
@RestController
@RequestMapping("/api/follow")
public class PersonFollowController extends BaseController<RelationFollowPersonVO, PersonFollowService> {
    private static final Log logger = LogFactory.getLog(PersonFollowController.class);

    @Override
    @Autowired
    protected void setService(PersonFollowService _service) {
        service = _service;
    }

    @ResponseBody
    @RequestMapping("/save")
    @Override
    public RequestResultVO add(@RequestBody RelationFollowPersonVO vo) {
        return super.add(vo);
    }

    @ResponseBody
    @RequestMapping("/delete")
    @Override
    public RequestResultVO delete(@RequestBody List<String> pks) {
        return super.delete(pks);
    }

    @ResponseBody
    @RequestMapping(value = "retrieve")
    @Override
    public JquryDataTablesVO<RelationFollowPersonVO> retrieve(RelationFollowPersonVO vo, HttpServletRequest request) {
        return super.retrieve(vo, request);
    }
}


