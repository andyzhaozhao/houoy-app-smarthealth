package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.PersonService;
import com.houoy.app.smarthealth.vo.PersonVO;
import com.houoy.common.utils.JqueryDataTablesUtil;
import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.RequestResultVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
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
@RequestMapping("/api/person")
public class PersonController {
    private static final Log logger = LogFactory.getLog(PersonController.class);


    @Resource
    private PersonService personService;

    @ResponseBody
    @RequestMapping("/save")
    public RequestResultVO add(@RequestBody PersonVO vo) {
        Integer num = 0;
        RequestResultVO resultVO = new RequestResultVO();
        if (vo != null) {
            if (vo.getPk_person() != null) {//如果前端传递过来pk,则判断为更新操作
                num = personService.updateByVO(vo);
            } else {
                num = personService.saveByVO(vo);
            }

            if (num >= 1) {
                resultVO.setSuccess(true);
                resultVO.setMsg("保存成功");
                resultVO.setResultData(num);
            } else {
                resultVO.setSuccess(false);
                resultVO.setMsg("保存失败");
            }
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("参数不可为null");
        }
        return resultVO;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        Integer num = personService.deleteByPK(pks);
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

    @ResponseBody
    @RequestMapping(value = "retrieve")
    public JquryDataTablesVO<PersonVO> retrieve(PersonVO vo, HttpServletRequest request) {
        vo = (PersonVO) JqueryDataTablesUtil.filterParam(vo, request);
        List<PersonVO> result = personService.retrieveAllWithPage(vo);
        Long count = personService.retrieveAllCount();
        JquryDataTablesVO rtv = JqueryDataTablesUtil.madeJqueryDatatablesVO(count, result);
        return rtv;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public RequestResultVO upload(HttpServletRequest request) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();
        Map aa = request.getParameterMap();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        if (files == null || files.size() <=0) {
            resultVO.setSuccess(false);
            resultVO.setMsg("文件为空");
        }else{
            MultipartFile file = files.get(0);
            // 获取文件名
            String fileName = file.getOriginalFilename();
            PersonVO personVO = new PersonVO();
            personVO.setPk_person(request.getParameter("pk_person"));
            personVO.setPortrait(file.getBytes());
            Integer rs = personService.updatePortraitByPK(personVO);

//            logger.info("上传的文件名为：" + fileName);
//            // 获取文件的后缀名
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            logger.info("上传的后缀名为：" + suffixName);

            resultVO.setSuccess(true);
            resultVO.setMsg("上传成功");
            resultVO.setResultData(rs);
        }

        return resultVO;
    }

    @RequestMapping("/portrait")
    public RequestResultVO portrait(String pk,HttpServletResponse response) throws IOException {
        RequestResultVO rs = personService.retrievePortrait(pk);
        if(rs.getSuccess()){
            byte[] data = ((PersonVO)rs.getResultData()).getPortrait();
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


