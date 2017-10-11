package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.service.PlaceService;
import com.houoy.app.smarthealth.vo.PlaceVO;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.vo.TreeVO;
import com.houoy.common.web.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 地点管理
 * Created by andyzhao on 2017/5/2.
 */
@RestController
@RequestMapping("/api/place")
public class PlaceController extends BaseController<PlaceVO, PlaceService> {
    private static final Log logger = LogFactory.getLog(PlaceController.class);

    @Override
    @Autowired
    protected void setService(PlaceService _service) {
        service = _service;
    }

    @ResponseBody
    @RequestMapping("/save")
    @Override
    public RequestResultVO add(@RequestBody PlaceVO vo) {
        return super.add(vo);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public RequestResultVO delete(@RequestBody List<String> pks) {
        RequestResultVO resultVO = new RequestResultVO();
        List<PlaceVO> essayTypeVOs = service.retrieveByParentPK(pks);
        if (essayTypeVOs != null && essayTypeVOs.size() > 0) {
            resultVO.setSuccess(false);
            resultVO.setMsg("此目录有子节点无法删除.");
        } else {
            //TODO 有图片无法删除
            Integer num = service.deleteByPK(pks);
            if (num >= 1) {
                resultVO.setSuccess(true);
                resultVO.setMsg("查询成功");
                resultVO.setResultData(num);
            } else {
                resultVO.setSuccess(false);
                resultVO.setMsg("删除失败");
            }
        }
        return resultVO;
    }

    @ResponseBody
    @RequestMapping(value = "retrieve")
    public RequestResultVO retrieve() throws Exception {
        List<PlaceVO> essayTypeVOs = service.retrieveAll();
        TreeVO tree = TreeVO.listToTreeNode(essayTypeVOs);
        RequestResultVO resultVO = new RequestResultVO();
        if (tree != null) {
            resultVO.setSuccess(true);
            resultVO.setMsg("查询成功");
            resultVO.setResultData(tree);
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("数据为空");
        }

        return resultVO;
    }
}






