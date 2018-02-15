package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.RecordEssayService;
import com.houoy.app.smarthealth.vo.RecordEssayVO;
import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.PageResultVO;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.web.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@RequestMapping("/api/recordEssay")
public class RecordEssayController extends BaseController<RecordEssayVO, RecordEssayService> {
    private static final Log logger = LogFactory.getLog(RecordEssayController.class);

    @Autowired
    protected void setService(RecordEssayService _service) {
        service = _service;
    }

    @ApiOperation(value = "保存阅读记录")
    @ApiImplicitParam(name = "recordEssayVO", value = "阅读记录信息", required = true, paramType = "body", dataType = "RecordEssayVO")
    @PostMapping("save")
    public RequestResultVO add(@RequestBody RecordEssayVO recordEssayVO) {
        return super.add(recordEssayVO);
    }

    @ApiOperation(value = "根据Pk值删除", notes = "根据Pk值删除")
    @ApiImplicitParam(name = "pks", value = "用户的pk列表", required = true, dataType = "List", paramType = "body")
    @PostMapping("delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        return super.delete(pks);
    }

    @ApiOperation(value = "分页查询阅读记录")
    @ApiImplicitParam(name = "recordEssayVO", value = "阅读记录信息", required = true, paramType = "body", dataType = "RecordEssayVO")
    @GetMapping(value = "retrieve")
    public JquryDataTablesVO<RecordEssayVO> retrieveJquryDT(RecordEssayVO recordEssayVO, HttpServletRequest request) {
        return super.retrieveJquryDT(recordEssayVO, request);
    }

    @ApiOperation(value = "移动端分页查询阅读记录")
    @GetMapping(value = "retrieveMobile")
    public PageResultVO retrieve(RecordEssayVO recordEssayVO, HttpServletRequest request) {
        return super.retrieve(recordEssayVO, request);
    }
}


