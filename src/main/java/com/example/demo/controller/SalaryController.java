package com.example.demo.controller;

import com.example.demo.service.ISalaryService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/4/29
 */
@RequestMapping("/salary")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SalaryController {

    @Autowired
    private ISalaryService salaryService;

    @Autowired
    private UserService userService;

    /**
     * 获取所有账单
     * @param model
     * @return
     */
    @RequestMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getSalaryList(Model model){
        List<Salary> salaryList = salaryService.getSalary();
        model.addAttribute("user",userService.getUser());
        model.addAttribute("salaryList",salaryList);
        return new ModelAndView("/salary/salary");
    }

//    /**
//     * 获取支出账单
//     * @param model
//     * @return
//     */
//    @RequestMapping("/salarylist")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
//    public ModelAndView getSalaryPayList(Model model){
//        List<Salary> salaryList = salaryService.getSalary();
//        model.addAttribute("user",userService);
//        model.addAttribute("salaryList",salaryList);
//        return new ModelAndView("/salary/salary");
//    }
    /**
     *
     * @param salaryId
     * @param model
     * @return
     */
    @RequestMapping("/salarydetail")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getSalaryDetail(Integer salaryId, Model model){
        Salary salary = salaryService.findSalaryById(salaryId);
        model.addAttribute("user",userService.getUser());
        model.addAttribute("salary",salary);
        return new ModelAndView("/salary/salaryDetail");
    }

    /**
     *
     * @param salary
     * @param flag
     * @param model
     * @return
     */
    @RequestMapping("/addsalary")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView addSalary(Salary salary,String flag,  Model model){
        salary.setCreateTime(new Date());
        salary.setCreateBy(userService.getUser().getUsername());
        if (flag.equals("1")){
            model.addAttribute("user",userService.getUser());
            return new ModelAndView("/salary/addSalary");
        }else {
            salaryService.addSalary(salary);
            return new ModelAndView("redirect:/salary/list");
        }
    }

    /**
     *
     * @param salary
     * @param flag
     * @param model
     * @return
     */
    @RequestMapping("/modifisalary")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView modifiSalary(Salary salary, String flag, Model model){
        salary.setUpdateBy(userService.getUser().getUsername());
        salary.setUpdateTime(new Date());
        model.addAttribute("user",userService.getUser());
        if (flag.equals("1")){
            Salary salary1 = salaryService.findSalaryById(salary.getSalaryId());
            model.addAttribute("salary",salary1);
            return new ModelAndView("/salary/modifiSalary");
        }else {
            salaryService.modifiSalary(salary);
            return new ModelAndView("redirect:/salary/list");
        }
    }

    /**
     *
     * @param salaryId
     * @param model
     * @return
     */
    @RequestMapping("/deletesalary")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView removeSalaryById(Integer salaryId, Model model){
        model.addAttribute("user",userService.getUser());
        salaryService.removeSalary(salaryId);
        return new ModelAndView("/salary/salary");
    }
}
