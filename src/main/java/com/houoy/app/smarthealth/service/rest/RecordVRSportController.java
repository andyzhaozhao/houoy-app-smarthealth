package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.RecordVRSportService;
import com.houoy.app.smarthealth.vo.RecordVRSportVO;
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
@RequestMapping("/api/recordVRSport")
public class RecordVRSportController extends BaseController<RecordVRSportVO, RecordVRSportService> {
    private static final Log logger = LogFactory.getLog(RecordVRSportController.class);

    @Autowired
    protected void setService(RecordVRSportService _service) {
        service = _service;
    }

    @ApiOperation(value = "保存运行记录")
    @ApiImplicitParam(name = "recordVRSportVO", value = "运动记录信息", required = true, paramType = "body", dataType = "RecordVRSportVO")
    @PostMapping("save")
    public RequestResultVO add(@RequestBody RecordVRSportVO recordVRSportVO) {
        return super.add(recordVRSportVO);
    }

    @ApiOperation(value = "根据Pk值删除", notes = "根据Pk值删除")
    @ApiImplicitParam(name = "pks", value = "用户的pk列表", required = true, dataType = "List", paramType = "body")
    @PostMapping("delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        return super.delete(pks);
    }

    @ApiOperation(value = "分页查询运动记录")
    @ApiImplicitParam(name = "recordVRSportVO", value = "运动记录信息", required = true, paramType = "body", dataType = "RecordVRSportVO")
    @GetMapping(value = "retrieve")
    public JquryDataTablesVO<RecordVRSportVO> retrieveJquryDT(RecordVRSportVO recordVRSportVO, HttpServletRequest request) {
        return super.retrieveJquryDT(recordVRSportVO, request);
    }

    @ApiOperation(value = "移动端分页查询阅读记录")
    @GetMapping(value = "retrieveMobile")
    public PageResultVO retrieve(RecordVRSportVO recordVRSportVO, HttpServletRequest request) {
        return super.retrieve(recordVRSportVO, request);
    }
}


