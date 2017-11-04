package com.houoy.app.smarthealth.service.rest;

import com.houoy.app.smarthealth.config.WebSecurityConfig;
import com.houoy.app.smarthealth.service.LoginService;
import com.houoy.app.smarthealth.service.PersonService;
import com.houoy.app.smarthealth.vo.PersonVO;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author andyzhao
 *         spring boot
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
    private static final Log logger = LogFactory.getLog(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private PersonService personService;

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

    @ApiOperation(value = "手机系统用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userVO", value = "用户信息", required = true, paramType = "body", dataType = "UserVO")
    })
    @PostMapping("/signinSystemMobile")
    public RequestResultVO signinSystemMobile(@RequestBody UserVO userVO) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();

        String user_password = userVO.getUser_password();
        String user_code = userVO.getUser_code();
        String user_mobile = userVO.getMobile();
        String user_email = userVO.getEmail();
        if (StringUtils.isEmpty(user_password)) {
            resultVO.setSuccess(false);
            resultVO.setMsg("请输入密码");
        }
        List<UserVO> users = null;
        if (!StringUtils.isEmpty(user_mobile)) {
            users = loginService.retrieveByMobileAndPwd(user_mobile, user_password);
        } else if (!StringUtils.isEmpty(user_email)) {
            users = loginService.retrieveByEmailAndPwd(user_email, user_password);
        } else if (!StringUtils.isEmpty(user_code)) {
            users = loginService.retrieveByCodeAndPwd(user_code, user_password);
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("请输入手机号/邮箱/用户编码");
        }

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
            resultVO.setMsg("登录失败，找不到用户，请检查用户名和密码");
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

    @ApiOperation(value = "手机社交用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "personVO", value = "社交用户信息", required = true, paramType = "body", dataType = "PersonVO")
    })
    @PostMapping("/signinMobile")
    public RequestResultVO signinMobile(@RequestBody PersonVO personVO) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();

        String user_password = personVO.getPassword();
        String user_code = personVO.getPerson_code();
        String user_mobile = personVO.getMobile();
        String user_email = personVO.getEmail();

        if (StringUtils.isEmpty(user_password)) {
            resultVO.setSuccess(false);
            resultVO.setMsg("请输入密码");
        }

        List<PersonVO> users = null;
        if (!StringUtils.isEmpty(user_mobile) || !StringUtils.isEmpty(user_email) || !StringUtils.isEmpty(user_code)) {
            users = personService.retrieveAllWithPage(personVO);
        } else {
            resultVO.setSuccess(false);
            resultVO.setMsg("请输入手机号/邮箱/用户编码");
        }

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
            resultVO.setMsg("登录失败，找不到用户，请检查用户名和密码");
        }
        return resultVO;
    }

    @ApiOperation(value = "忘记密码")
    @PostMapping("/forgetPassword")
    public RequestResultVO forgetPassword(String email) throws IOException {
        RequestResultVO resultVO = new RequestResultVO();
        if (StringUtils.isEmpty(email)) {
            resultVO.setSuccess(false);
            resultVO.setMsg("参数不可以为空，请输入邮箱或者手机号");
        } else {
            PersonVO personVO = new PersonVO();
            personVO.setEmail(email);
//            personVO.setMobile(mobile);
            Boolean result = personService.forgetPassword(personVO);
            resultVO.setSuccess(result);
            if (result) {
                resultVO.setMsg("密码已经发送到用户邮箱，请查收");
            } else {
                resultVO.setMsg("密码发送到用户邮箱失败");
            }
        }

        return resultVO;
    }
}


