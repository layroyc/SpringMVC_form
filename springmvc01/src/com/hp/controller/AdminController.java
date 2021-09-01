package com.hp.controller;

import com.hp.bean.AdminInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    //注册
    //注册成功后，如果是单体项目------就要跳转到登录页面，这个跳转是后台的 转发，重定向，总之是
    /*
    *       后台负责 跳转，携带数据的跳转页面的
    *  如果是  新型的项目，即前后端分离的，那么 后台 只负责  返回给前端json数据，
    *  跳转是前端来处理的， 前端根据后台返回code代码，进行跳转，
    *  如果前端负责跳转，他会起一个好听的名字，叫做路由!
    *
    * */

    // 什么是前后端分离即:项目 上的分离和数据上的分离
    //项目上的分离: 前端一 个项目， 后台一 一个项目     2  项目  他们的认证是 token/jwt+redis
    //数据上的分离: 还是一 个项目， 只不过前后端用json来交互数据。
    //很少在用jstl/ el表达式来写项目。他们的认证 是  session

    //layui  在ssm  框架的使用，其实就是数据上的分离，也可以是 项目上的分离
    //那么 他就是json 交互的， 那么 后台只需要  给他 返回json数据就可以了

    //以前 在servlet中，  resp.getWriter().print(new JSONObject.toString(map)).输出json
    //现在  用mvc框架的，高级了  使用注解  @ResponseBody

    /*
    * 以前收参数   req.getParamter("adminName")
    * adminName:12345
    * adminPwd
    * adminPwdR
    * */

    //第一种收参方式：  数据类型接收参数
    @RequestMapping("/reg") //layui 版本的
    @ResponseBody   //这个注解就是  返回前端的json数据
    public Map reg(String adminName, String adminPwd, String adminPwdR, String adminTime, String adminSex, String adminCity, String open, ArrayList<String> hobby){
        System.out.println("adminName = " + adminName);
        System.out.println("adminTime = " + adminTime);
        System.out.println("性别 = " + adminSex);
        System.out.println("就业城市 = " + adminCity);
        System.out.println("是否专升本 = " + open);
        System.out.println("hobby = " + hobby);

        Map codeMap = new HashMap();
        if(!adminPwd.equals(adminPwdR)){
            codeMap.put("code","4001");
            codeMap.put("msg","你输入的重复密码与密码不一致，请重新输入");
            return codeMap;
        }
        if(adminName.length()<=0){
            codeMap.put("code","4002");
            codeMap.put("msg","adminName表单未填写完整");
            return codeMap;
        }
        if(adminPwd.length()<=0){
            codeMap.put("code","4002");
            codeMap.put("msg","adminPwd表单未填写完整");
            return codeMap;
        }
        codeMap.put("code",0);
        codeMap.put("msg","注册成功");
        return codeMap;
    }

    //传统版本   不返回json  跳转使用转发或者重定向
    @RequestMapping("/regForm")
    public String regForm(String adminName,String adminPwd){
        System.out.println("adminName = " + adminName);
        System.out.println("adminPwd = " + adminPwd);
        //注册成功跳转到登录页
        return "loginForm";
    }

    //第二种收参方式   叫做实体类收参数
    @RequestMapping("/regByBean")
    @ResponseBody
    public Map regByBean(AdminInfo adminInfo){
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","注册成功");
        return codeMap;
    }
}
