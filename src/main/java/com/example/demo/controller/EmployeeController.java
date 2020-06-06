package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Grade;
import com.example.demo.model.GradeView;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IGradeService;
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
 * <p> 员工管理
 * Date 2020/4/25
 */
@Controller
@RequestMapping("/employee")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EmployeeController {


    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private IGradeService gradeService;


    /**
     * 获取员工信息列表
     * @param model
     * @return
     */
    @RequestMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getEmployeeList(Model model){
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("user",userService.getUser());
        return new ModelAndView("/employee/employee");
    }

    /**
     * 员工详细信息
     * @param model
     * @param employeeId
     * @return
     */
    @RequestMapping("/detailpage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getEmoloyeeDetailById(Model model, Integer employeeId){
        model.addAttribute("employee",employeeService.findByEmployeeId(employeeId));
        model.addAttribute("user",userService.getUser());
        return new ModelAndView("/employee/employeeDetail");
    }

    /**
     * 添加员工
     * @param employee
     * @param flag
     * @param model
     * @return
     */
    @RequestMapping("/addemployee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addEmployee(Employee employee, String flag, Model model) {
        model.addAttribute("user",userService.getUser());
        employee.setUpdateTime(new Date());
        employee.setUpdateBy(userService.getUser().getUsername());
        employee.setCreateTime(new Date());
        employee.setCreateBy(userService.getUser().getUsername());
        if (flag.equals("1")){
            return new ModelAndView("employee/addEmployee");
        }else {
            employeeService.addEmployee(employee);
            return new ModelAndView("redirect:/employee/list");
        }
    }

    /**
     * 员工信息修改
     * @param employee
     * @param flag
     * @param model
     * @return
     */
    @RequestMapping("/modifiemployee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView modifiEmployee(Employee employee, String flag, Model model){
        model.addAttribute("user",userService.getUser());
        employee.setUpdateTime(new Date());
        employee.setUpdateBy(userService.getUser().getUsername());
        if (flag.equals("1")){
            Employee employee1 = employeeService.findByEmployeeId(employee.getEmployeeId());
            model.addAttribute("employee",employee1);
            return new ModelAndView("employee/modifEmployee");
        }else {
            employeeService.modifiEmployee(employee);
            return new ModelAndView("redirect:/employee/list");
        }
    }

    /**
     * 将员工转入不活跃名单
     * @param employeeId
     * @param model
     * @return
     */
    @RequestMapping("/deleteemployee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView removeEmployee(Integer employeeId, Model model){
        Employee employee = employeeService.findByEmployeeId(employeeId);
        employee.setStatus(0);
        employeeService.modifiEmployee(employee);
        model.addAttribute("user",userService.getUser());
        return new ModelAndView("redirect:/employee/list");
    }

    /**
     * 获取员工评价列表
     * @param model
     * @return
     */
    @RequestMapping("/gradelist")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getGradeList(Model model){
        List<GradeView> gradeViewList = gradeService.getGradeList();
//        model.addAttribute("employee",employeeService.findByEmployeeId())
        model.addAttribute("gradeViewList",gradeViewList);
//        System.out.println(gradeViewList.size());
        model.addAttribute("user",userService.getUser());
        return new ModelAndView("/employee/employeeGrade");
    }

    /**
     * 添加
     * @param grade
     * @param model
     * @param flag
     * @return
     */
    @RequestMapping("/addgrade")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addGrade(Grade grade, Model model, String flag){
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("user",userService.getUser());
        grade.setUpdateTime(new Date());
        grade.setUpdateBy(userService.getUser().getUsername());
        grade.setCreateBy(userService.getUser().getUsername());
        grade.setCreateTime(new Date());
        if (flag.equals("1")){
            return new ModelAndView("employee/addGrade");
        }else {
            gradeService.addGrade(grade);
            return new ModelAndView("redirect:/employee/gradelist");
        }
    }

    /**
     * 员工评价详细
     * @param model
     * @param gradeId
     * @return
     */
    @RequestMapping("/gradedetailpage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView gradeDetailById(Model model, Integer gradeId){
        model.addAttribute("user",userService.getUser());
        model.addAttribute("gradeView",gradeService.findGradeById(gradeId));
//        System.out.println(gradeService.findGradeById(gradeId).getUpdateTime());
        return new ModelAndView("/employee/gradeDetail");
    }

    /**
     * 员工评价修改
     * @param grade
     * @param flag
     * @param model
     * @return
     */
    @RequestMapping("modifigrade")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView modifiGrade(Grade grade, String flag, Model model){
        model.addAttribute("user",userService.getUser());
        grade.setUpdateBy(userService.getUser().getUsername());
        grade.setUpdateTime(new Date());
        if (flag.equals("1")){
            GradeView gradeView = gradeService.findGradeById(grade.getGradeId());
            model.addAttribute("gradeView",gradeView);
            return new ModelAndView("/employee/modifiGrade");
        }else {
            gradeService.modifiGrade(grade);
            return new ModelAndView("redirect:/employee/gradelist");
        }
    }

    /**
     * 删除
     * @param model
     * @param gradeId
     * @return
     */
    @RequestMapping("/deletegrade")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView removeGradeById(Model model, Integer gradeId){
        model.addAttribute("user",userService.getUser());
        model.addAttribute("grade",gradeService.removeGradeById(gradeId));
        return new ModelAndView("redirect:/employee/gradelist");
    }

}
