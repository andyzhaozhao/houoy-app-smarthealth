package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.RecordVRSportDetailService;
import com.houoy.app.smarthealth.vo.RecordVRSportDetailVO;
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
@RequestMapping("/api/recordVRSportDetail")
public class RecordVRSportDetailController extends BaseController<RecordVRSportDetailVO, RecordVRSportDetailService> {
    private static final Log logger = LogFactory.getLog(RecordVRSportDetailController.class);

    @Autowired
    protected void setService(RecordVRSportDetailService _service) {
        service = _service;
    }

    @ApiOperation(value = "保存运行详细记录")
    @ApiImplicitParam(name = "recordVRSportDetailVO", value = "运动详细记录信息", required = true, paramType = "body", dataType = "RecordVRSportDetailVO")
    @PostMapping("save")
    public RequestResultVO add(@RequestBody RecordVRSportDetailVO recordVRSportDetailVO) {
        return super.add(recordVRSportDetailVO);
    }

    @ApiOperation(value = "根据Pk值删除", notes = "根据Pk值删除")
    @ApiImplicitParam(name = "pks", value = "用户的pk列表", required = true, dataType = "List", paramType = "body")
    @PostMapping("delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        return super.delete(pks);
    }

    @ApiOperation(value = "分页查询运动详细记录")
    @ApiImplicitParam(name = "recordVRSportDetailVO", value = "运动记录信息", required = true, paramType = "body", dataType = "RecordVRSportDetailVO")
    @GetMapping(value = "retrieve")
    public JquryDataTablesVO<RecordVRSportDetailVO> retrieve(RecordVRSportDetailVO recordVRSportDetailVO, HttpServletRequest request) {
        return super.retrieve(recordVRSportDetailVO, request);
    }
}


