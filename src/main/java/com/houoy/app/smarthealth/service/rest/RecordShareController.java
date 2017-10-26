package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.RecordShareService;
import com.houoy.app.smarthealth.vo.RecordShareVO;
import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.PageResultVO;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.web.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author andyzhao
 */
@RestController
@RequestMapping("/api/recordShare")
public class RecordShareController extends BaseController<RecordShareVO, RecordShareService> {
    private static final Log logger = LogFactory.getLog(RecordShareController.class);

    @Autowired
    protected void setService(RecordShareService _service) {
        service = _service;
    }

    @ApiOperation(value = "保存用户分享记录")
    @ApiImplicitParam(name = "recordShareVO", value = "运动记录信息", required = true, paramType = "body", dataType = "RecordShareVO")
    @PostMapping("/save")
    public RequestResultVO add(@RequestBody RecordShareVO recordShareVO) {
        return super.add(recordShareVO);
    }

    @ApiOperation(value = "根据Pk值删除", notes = "根据Pk值删除")
    @ApiImplicitParam(name = "pks", value = "用户的pk列表", required = true, dataType = "List", paramType = "body")
    @PostMapping("/delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        return super.delete(pks);
    }

    @ApiOperation(value = "分页查询用户分享记录")
    @ApiImplicitParam(name = "recordShareVO", value = "用户分享记录信息", required = true, paramType = "body", dataType = "RecordShareVO")
    @GetMapping(value = "retrieve")
    public JquryDataTablesVO<RecordShareVO> retrieve(RecordShareVO recordShareVO, HttpServletRequest request) {
        return super.retrieve(recordShareVO, request);
    }

    @ApiOperation(value = "移动端分页查询阅读记录")
    @GetMapping(value = "retrieveMobile")
    public PageResultVO retrieveMobile(RecordShareVO recordShareVO, HttpServletRequest request) {
        return super.retrieveMobile(recordShareVO, request);
    }
}


