package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.PersonFollowService;
import com.houoy.app.smarthealth.vo.RecordVRSportVO;
import com.houoy.app.smarthealth.vo.RelationFollowPersonVO;
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
@RequestMapping("/api/personFollow")
public class PersonFollowController extends BaseController<RelationFollowPersonVO, PersonFollowService> {
    private static final Log logger = LogFactory.getLog(PersonFollowController.class);

    @Override
    @Autowired
    protected void setService(PersonFollowService _service) {
        service = _service;
    }

    @ApiOperation(value = "保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vo", value = "关注信息", required = true, paramType = "body", dataType = "RelationFollowPersonVO")
    })
    @PostMapping("/save")
    public RequestResultVO add(@RequestBody RelationFollowPersonVO vo) {
        return super.add(vo);
    }

    @ApiOperation(value = "根据Pk值删除", notes = "根据Pk值删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pks", value = "关注关系的pk列表", required = true, dataType = "List", paramType = "body")
    })
    @PostMapping("/delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        return super.delete(pks);
    }

    @ApiOperation(value = "分页查询关注关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vo", value = "关注关系信息", required = true, paramType = "body", dataType = "RelationFollowPersonVO")
    })
    @GetMapping(value = "retrieve")
    public JquryDataTablesVO<RelationFollowPersonVO> retrieveJquryDT(RelationFollowPersonVO vo, HttpServletRequest request) {
        return super.retrieveJquryDT(vo, request);
    }

    @ApiOperation(value = "移动端分页查询阅读记录")
    @GetMapping(value = "retrieveMobile")
    public PageResultVO retrieve(RelationFollowPersonVO relationFollowPersonVO, HttpServletRequest request) {
        return super.retrieve(relationFollowPersonVO, request);
    }
}


