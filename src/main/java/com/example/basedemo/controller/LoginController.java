package com.example.basedemo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.basedemo.dao.TnUserInfoDao;
import com.example.basedemo.entity.po.TnUserInfoPo;
import com.example.basedemo.error.BusinessException;
import com.example.basedemo.error.EmBusinssError;
import com.example.basedemo.jwt.JWTService;
import com.example.basedemo.service.TnUserInfoService;
import com.example.basedemo.utils.CommonreturnType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import sun.awt.EmbeddedFrame;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author Chkl
 * @create 2020/4/25
 * @since 1.0.0
 */
@RestController
public class LoginController extends BaseController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private TnUserInfoService tnUserInfoService;

    @ApiIgnore
    @GetMapping("/toLogin")
    public CommonreturnType toLogin() throws BusinessException {
        throw new BusinessException(EmBusinssError.LOGINOUTTIME);
    }


    @ApiOperation("登录")
    @PostMapping("/login")
    public CommonreturnType login(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "password") String password,
                                  HttpServletRequest request) throws BusinessException, UnsupportedEncodingException {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new BusinessException(EmBusinssError.USER_Login_Fail);
        }
        TnUserInfoPo userInfo = tnUserInfoService.
                getOne(Wrappers.<TnUserInfoPo>lambdaQuery().
                        eq(TnUserInfoPo::getUserName, username).
                        eq(TnUserInfoPo::getPassword, password));
        if (userInfo == null) {
            throw new BusinessException(EmBusinssError.USER_Login_Fail);
        }

        Map<String, String> user = new HashMap<String, String>() {
            {
                put("username", userInfo.getUserName());
                put("userCode", userInfo.getUserCode());
                put("chineseName", userInfo.getChineseName());
                put("unitCode", userInfo.getUnitCode());
            }
        };

        String token = jwtService.createToken(user, 1);
        ServletContext context = request.getServletContext();
        context.setAttribute(token, token);
        return CommonreturnType.create(token);
    }


    @ApiOperation("退出登录")
    @GetMapping("/logout")
    public CommonreturnType logout(String token, HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        context.removeAttribute(token);
        return CommonreturnType.create("logout");
    }


}