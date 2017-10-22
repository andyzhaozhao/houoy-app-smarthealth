package com.houoy.app.smarthealth.controller;

import com.houoy.app.smarthealth.service.CoinRechargeService;
import com.houoy.app.smarthealth.vo.CoinRechargeVO;
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
@RequestMapping("/api/coinRecharge")
public class CoinRechargeController extends BaseController<CoinRechargeVO, CoinRechargeService> {
    private static final Log logger = LogFactory.getLog(CoinRechargeController.class);

    @Override
    @Autowired
    protected void setService(CoinRechargeService _service) {
        service = _service;
    }

    @ResponseBody
    @RequestMapping("/save")
    @Override
    public RequestResultVO add(@RequestBody CoinRechargeVO vo) {
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
    public JquryDataTablesVO<CoinRechargeVO> retrieve(CoinRechargeVO vo, HttpServletRequest request) {
        return super.retrieve(vo, request);
    }
}


