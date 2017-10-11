package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.PersonNoteService;
import com.houoy.app.smarthealth.vo.PersonNoteVO;
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
@RequestMapping("/api/note")
public class PersonNoteController extends BaseController<PersonNoteVO, PersonNoteService> {
    private static final Log logger = LogFactory.getLog(PersonNoteController.class);

    @Override
    @Autowired
    protected void setService(PersonNoteService _service) {
        service = _service;
    }

    @ResponseBody
    @RequestMapping("/save")
    @Override
    public RequestResultVO add(@RequestBody PersonNoteVO vo) {
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
    public JquryDataTablesVO<PersonNoteVO> retrieve(PersonNoteVO vo, HttpServletRequest request) {
        return super.retrieve(vo, request);
    }
}


