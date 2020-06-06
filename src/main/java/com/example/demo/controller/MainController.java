package com.example.demo.controller;

import com.example.demo.model.Authority;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.model.custom.Custom;
import com.example.demo.service.*;
import com.example.demo.utils.MD5Util;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 杜虹池
 * @CreateDate: 2020-04-20
 */
//主页控制器
@Controller
//开启权限认证
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainController {

    private static final Integer ROLE_USER_AUTHORITY_ID = 2;
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";
    private static final String Portrait_Url = "profile.jpeg";


    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ISalaryService salaryService;
    @Autowired
    private IWorksService worksService;
    @Autowired
    private IVehicleOwnerService vehicleOwnerService;


    @GetMapping("/")
    public String boot(){
        return "redirect:/login-allot";
    }

    @GetMapping("/index")
    public ModelAndView index(Model model){
        return new ModelAndView("redirect:/","userModel",model);
    }

    //登录跳转
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 根据用户权限进行分发
     * @param model
     * @return
     */
    @GetMapping("/login-allot")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView loginAllot(Model model){
        User user = userService.getUser();
        model.addAttribute("user",user);
        String authority = user.getAuthorityList().toString();
        if (authority.contains(ROLE_ADMIN)){
            return new ModelAndView("redirect:/adminIndex");
        }
        else {
            return new ModelAndView("redirect:/login");
        }

    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登录失败，账户或密码错误");
        return "/login";
    }

    /*
     * 跳转至管理员首页
     * @param model
     * @return
             */
    @GetMapping("/adminIndex")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView adminIndex(Model model){
        double salaryIncome = salaryService.getSalaryIncome();
        double salaryPayout = salaryService.getSalaryPayOut();
        double balance = salaryIncome - salaryPayout;
        User user = userService.getUser();
        model.addAttribute("user",user);
        model.addAttribute("userCount",userService.getAdminList().size());
        model.addAttribute("categoryCount",categoryService.getCategoryList().size());
        model.addAttribute("worksCount",worksService.getWorksList().size());
        model.addAttribute("vehicleViewCount",vehicleOwnerService.getVehicleOwnerList().size());
        model.addAttribute("salaryIncome",salaryIncome);
        model.addAttribute("salaryPayout",salaryPayout);
        model.addAttribute("balance",balance);
        //商品种类数量图
        List<Category> categories = categoryService.getCategoryList();
        List<Custom> categoryList = new ArrayList<>();
        for (Category category : categories) {
            Custom custom = new Custom();
            custom.setId(category.getCategoryId().toString());
            custom.setName(category.getName());
            custom.setCount(categoryService.getProductByCategoryId(category.getCategoryId()).size());
            categoryList.add(custom);
        }
        model.addAttribute("categoryList",categoryList);
        //用户信息栏展示
        model.addAttribute("adminCount",userService.getAdminList().size());
        model.addAttribute("rootCount",userService.getRootList().size());
        //订单栏数量展示
        model.addAttribute("order1",salaryService.getSalaryByStatus(0));
        model.addAttribute("order2",salaryService.getSalaryByStatus(1));
        model.addAttribute("order3",salaryService.getSalary().size());
        return new ModelAndView("admin/index","userModel",model);

    }


    /**
     * 跳转至注册页面
     * @return
     */
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(User user){
        //创建权限列表
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        //查重避免userId重复
        user.setUserId(UUIDUtil.getUUID());
        //进行密码加密
        user.setPassword(MD5Util.encode(user.getPassword()));
        //设置默认姓名为用户名
        user.setName(user.getUsername());
        //设置默认头像
        user.setPortraitUrl(Portrait_Url);
        //设置注册时间
        user.setRegisterTime(new Date());
        //设置权限
        user.setAuthorities(authorities);
        System.out.println(user.toString());

        userService.insertUser(user);
        return "redirect:/login";
    }
}
