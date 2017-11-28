package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.RecordShareService;
import com.houoy.app.smarthealth.vo.RecordShareVO;
import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.PageResultVO;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.web.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

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

        List<RecordShareVO> result = null;
        Long count = null;
        if(StringUtils.isNotEmpty(recordShareVO.getHas_follow())) {
            switch (recordShareVO.getHas_follow()) {
                case "0":
                    result = service.retrieveAllUnFollowWithPage(recordShareVO);
                    count = service.retrieveAllUnFollowCount(recordShareVO);
                    break;
                case "1":
                    result = service.retrieveAllFollowWithPage(recordShareVO);
                    count = service.retrieveAllFollowCount(recordShareVO);
                    break;
            }
        }

        PageResultVO pageResultVO = new PageResultVO();
        pageResultVO.setSuccess(Boolean.valueOf(true));
        pageResultVO.setMsg("查询成功");
        pageResultVO.setResultData(result);
        pageResultVO.setStart(recordShareVO.getStart());
        pageResultVO.setLength(recordShareVO.getLength());
        pageResultVO.setOrderColumnName(recordShareVO.getOrderColumnName());
        pageResultVO.setOrderDir(recordShareVO.getOrderDir());
        pageResultVO.setTotal(count + "");
        return pageResultVO;
    }

    @ApiOperation(value = "上传分享内容图标")
    @PostMapping("/upload")
    public RequestResultVO upload(HttpServletRequest request) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();
        Map aa = request.getParameterMap();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        if (files == null || files.size() <= 0) {
            resultVO.setSuccess(false);
            resultVO.setMsg("文件为空");
        } else {
            MultipartFile file = files.get(0);
            // 获取文件名
            String fileName = file.getOriginalFilename();
            RecordShareVO recordShareVO = new RecordShareVO();
            recordShareVO.setPk_person(request.getParameter("pk_person"));
            recordShareVO.setRecord_share_img(file.getBytes());
            Integer rs = service.updatePortraitByPK(recordShareVO);

            resultVO.setSuccess(true);
            resultVO.setMsg("上传成功");
            resultVO.setResultData(rs);
        }

        return resultVO;
    }

    @ApiOperation(value = "获取分享内容图标")
    @ApiImplicitParam(name = "pk_record_essay", value = "分享内容pk", required = true, paramType = "query", dataType = "string")
    @GetMapping("/portrait")
    public RequestResultVO portrait(String pk_record_essay, HttpServletResponse response) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();
        if (pk_record_essay == null) {
            resultVO.setSuccess(false);
            resultVO.setMsg("文件为空");
        } else {
            RecordShareVO rs = service.retrievePortrait(pk_record_essay);
            if (rs != null) {
                resultVO.setSuccess(true);
                resultVO.setResultData(rs);
            } else {
                resultVO.setSuccess(false);
                resultVO.setMsg("没有找到此用户头像");
            }
        }

        if (resultVO.getSuccess()) {
            byte[] data = ((RecordShareVO) resultVO.getResultData()).getRecord_share_img();
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputSream = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(data);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf, 0, 1024)) != -1) {
                outputSream.write(buf, 0, len);
            }
            outputSream.close();
        }

        return resultVO;
    }
}


