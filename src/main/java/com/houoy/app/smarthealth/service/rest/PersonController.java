package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.config.NginxConfig;
import com.houoy.app.smarthealth.service.PersonService;
import com.houoy.app.smarthealth.vo.PersonVO;
import com.houoy.common.utils.SftpUtils;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author andyzhao
 */
@RestController
@RequestMapping("/api/person")
public class PersonController extends BaseController<PersonVO, PersonService> {
    private static final Log logger = LogFactory.getLog(PersonController.class);

    @Autowired
    private NginxConfig nginxConfig;

    @Autowired
    protected void setService(PersonService personService) {
        service = personService;
    }

    @ApiOperation(value = "保存用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vo", value = "用户信息", required = true, paramType = "body", dataType = "PersonVO")
    })
    @PostMapping("/save")
    public RequestResultVO add(@RequestBody PersonVO vo) {
        return super.add(vo);
    }

    @ApiOperation(value = "根据Pk值删除", notes = "根据Pk值删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pks", value = "用户的pk列表", required = true, dataType = "List", paramType = "body")
    })
    @PostMapping("/delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        Integer num = service.deleteByPK(pks);
        RequestResultVO resultVO = new RequestResultVO();
        if (num >= 1) {
            resultVO.setSuccess(true);
            resultVO.setMsg("查询成功");
            resultVO.setResultData(num);
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("保存");
        }

        return resultVO;
    }

    @ApiOperation(value = "分页查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vo", value = "用户信息", required = true, paramType = "body", dataType = "PersonVO")
    })
    @GetMapping(value = "retrieve")
    public JquryDataTablesVO<PersonVO> retrieve(PersonVO vo, HttpServletRequest request) {
        return super.retrieve(vo, request);
    }

    @ApiOperation(value = "移动端分页查询用户信息")
    @GetMapping(value = "retrieveMobile")
    public PageResultVO retrieveMobile(PersonVO personVO, HttpServletRequest request) {
        return super.retrieveMobile(personVO, request);
    }

    @ApiOperation(value = "上传用户头像")
    @PostMapping(value = "/upload", consumes = "multipart/form-data", produces = "application/json")
    public RequestResultVO upload(String pk_person, @RequestParam("file") MultipartFile file) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();

        if (!StringUtils.isEmpty(pk_person) && file != null) {
            String fileName = file.getOriginalFilename();

            PersonVO personVO = new PersonVO();
            personVO.setPk_person(pk_person);
            personVO.setPortraitPath(pk_person + "/" + fileName);
            Integer result = service.updateByVO(personVO);
            if (result > 0) {
                SftpUtils sftpUtils = new SftpUtils(nginxConfig.getUrl(), nginxConfig.getPort(), nginxConfig.getUser()
                        , nginxConfig.getPass());
                sftpUtils.upload(nginxConfig.getPathPerson() + "/" + pk_person, file.getInputStream(), fileName);

                resultVO.setSuccess(true);
                resultVO.setMsg("保存成功");
                resultVO.setResultData(true);
            } else {
                resultVO.setSuccess(false);
                resultVO.setMsg("保存到mysql失败");
            }
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("保存失败");
        }

        return resultVO;
    }
    /*
    @ApiOperation(value = "上传用户头像")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "file", value = "图片数据", required = true, paramType = "file", dataType = "file"),
//            @ApiImplicitParam(name = "pk_person", value = "用户主键", required = true, paramType = "query", dataType = "string")
//    })
    @PostMapping(value = "/upload",consumes = "multipart/form-data",produces = "application/json")
    public RequestResultVO upload(String pk_person, @RequestParam("file") MultipartFile file) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();
//        Map aa = request.getParameterMap();
       // List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        if (file == null) {
            resultVO.setSuccess(false);
            resultVO.setMsg("文件为空");
        } else {
            //MultipartFile file = files.get(0);
            // 获取文件名
            String fileName = file.getOriginalFilename();
            PersonVO personVO = new PersonVO();
            personVO.setPk_person(pk_person);
//            personVO.setPk_person(request.getParameter("pk_person"));
            personVO.setPortrait(file.getBytes());
            Integer rs = service.updatePortraitByPK(personVO);

//            logger.info("上传的文件名为：" + fileName);
//            // 获取文件的后缀名
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            logger.info("上传的后缀名为：" + suffixName);

            resultVO.setSuccess(true);
            resultVO.setMsg("上传成功");
            resultVO.setResultData(rs);
        }

        return resultVO;
    }*/

    @ApiOperation(value = "流式下载用户头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pk", value = "用户信息", required = true, paramType = "query", dataType = "string")
    })
    @GetMapping("/portrait")
    public RequestResultVO portrait(String pk, HttpServletResponse response) throws IOException {
        RequestResultVO rs = service.retrievePortrait(pk);
        if (rs.getSuccess()) {
            byte[] data = ((PersonVO) rs.getResultData()).getPortrait();
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

        return rs;
    }
}









