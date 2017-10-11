package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.config.WebSecurityConfig;
import com.houoy.app.smarthealth.service.LoginService;
import com.houoy.common.exception.AppLoginException;
import com.houoy.common.vo.RequestResultVO;
import com.houoy.common.vo.SessionRootUserVO;
import com.houoy.common.vo.UserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author andyzhao
 *         spring boot
 */
//@RestController("/api/login/")
@RestController
@RequestMapping("/api/login")
public class LoginController {
    private static final Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userVO", value = "用户信息", required = true, paramType = "body", dataType = "UserVO")
    })
    @PostMapping("/signin")
    public RequestResultVO signin(HttpServletRequest request, @RequestBody UserVO userVO) throws IOException {
        String user_code = userVO.getUser_code();
        String password = userVO.getUser_password();

        RequestResultVO resultVO = new RequestResultVO();
        List<UserVO> users = loginService.retrieveByCodeAndPwd(user_code, password);
//        List<UserVO> users = new ArrayList<>();
//        UserVO u = new UserVO();
//        u.setUser_name("admin");
//        u.setUser_code("admin");
//        u.setUser_password("1");
//        users.add(u);

        if (users != null && users.size() > 0) {
            if (users.size() > 1) {
                throw new AppLoginException("系统内部错误，找到多个用户");
            } else {
                HttpSession httpSession = request.getSession();
                SessionRootUserVO sessionRootUserVO = new SessionRootUserVO();
                sessionRootUserVO.setUser(users.get(0));
                httpSession.setAttribute(WebSecurityConfig.Default_Session_Key, sessionRootUserVO);
                resultVO.setSuccess(true);
                resultVO.setMsg("查询成功");
                resultVO.setResultData(users.get(0));
            }
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("登录失败，请检查用户名和密码");
        }

        return resultVO;
    }

 /*   @RequestMapping("/getSession")
    public Object getSession(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession(false);
        String sessionID = session.getId();
        Object mes = session.getAttribute(WebSecurityConfig.Default_Session_Key);
        System.out.println(session.isNew());
        Object a = session.getAttributeNames();
        return mes;
    }*/

    @ApiOperation(value = "手机登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userVO", value = "用户信息", required = true, paramType = "body", dataType = "UserVO")
    })
    @PostMapping("/signinMobile")
    public RequestResultVO signinMobile(HttpServletRequest request, @RequestBody UserVO userVO) throws IOException {
        String user_code = request.getParameter(UserVO.USERCODE);
        String password = request.getParameter(UserVO.PASSWORD);
        RequestResultVO resultVO = new RequestResultVO();

        if (user_code == null || user_code.trim().equals("") || password == null || password.trim().equals("")) {
            resultVO.setSuccess(false);
            resultVO.setMsg("登录失败，请检查用户名和密码");
        } else {
            List<UserVO> users = loginService.retrieveByCodeAndPwd(user_code, password);
            if (users != null && users.size() > 0) {
                if (users.size() > 1) {
                    throw new AppLoginException("系统内容不错误，找到多个用户");
                } else {
                    resultVO.setSuccess(true);
                    resultVO.setMsg("查询成功");
                    resultVO.setResultData(users.get(0));
                }
            } else {
                resultVO.setSuccess(false);
                resultVO.setMsg("登录失败，请检查用户名和密码");
            }
        }

        return resultVO;
    }

    @ApiOperation(value = "登出接口")
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.Default_Session_Key);
        return "redirect:/login";
    }
}

