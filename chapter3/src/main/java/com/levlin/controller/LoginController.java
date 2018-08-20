package com.levlin.controller;

import com.levlin.mapper.UserMapper;
import com.levlin.model.User;
import com.levlin.service.Impl.UserServiceImpl;
import com.levlin.util.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserServiceImpl userService;

    @Autowired
    private UserMapper userDao;

//    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = {"/","home"})
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        User user = userDao.getByUserName("admin");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        model.addAttribute("msg", msg);
        return "home";
    }
    @RequestMapping(value = "/login")
    public String login(){
       return "login";
   }
    @RequestMapping(value = "/roleManage")
//    @PreAuthorize("hasRole('ROLE_MANAGE')")
    public String roleManage(){
        return "role";
    }

}
