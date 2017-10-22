package com.houoy.app.smarthealth.controller;

import com.houoy.app.smarthealth.service.UserService;
import com.houoy.common.utils.JqueryDataTablesUtil;
import com.houoy.common.vo.JquryDataTablesVO;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.vo.UserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author andyzhao
 */
@RestController
@RequestMapping("/root/base/user")
public class UserController {
    private static final Log logger = LogFactory.getLog(UserController.class);

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/save")
    public RequestResultVO add(@RequestBody UserVO userVO) {
        Integer num = 0;
        RequestResultVO resultVO = new RequestResultVO();
        if (userVO != null) {
            if (userVO.getPk_user() != null) {//如果前端传递过来pk,则判断为更新操作
                num = userService.updateUserByVO(userVO);
            } else {
                num = userService.saveUserByVO(userVO);
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
    public RequestResultVO delete(@RequestBody List<String> pk_users) {
        Integer num = userService.deleteUsers(pk_users);
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
    public JquryDataTablesVO<UserVO> retrieve(UserVO vo, HttpServletRequest request) {

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderColumnName = request.getParameter("columns[" + orderColumnIndex + "][data]");
        String orderDir = request.getParameter("order[0][dir]");
        vo.setOrderColumnName(orderColumnName);
        vo.setOrderDir(orderDir);

        List<UserVO> result = userService.retrieveAllWithPage(vo);
        Long count = userService.retrieveAllCount();
        JquryDataTablesVO rtv = JqueryDataTablesUtil.madeJqueryDatatablesVO(count, result);
        return rtv;
    }

    @ResponseBody
    @RequestMapping(value = "updateUserRole")
    public RequestResultVO updateUserRole(UserVO vo, HttpServletRequest request) {

        String pk_user = request.getParameter("pk_user");
        String pk_role = request.getParameter("pk_role");

        vo.setPk_user(pk_user);
        vo.setPk_role(pk_role);

        boolean isSuccess = userService.updateUserRole(vo);
        RequestResultVO resultVO = new RequestResultVO();
        resultVO.setSuccess(isSuccess);
        return resultVO;
    }


}


