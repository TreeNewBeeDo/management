package com.example.demo.controller;

import com.example.demo.model.Cars;
import com.example.demo.model.Works;
import com.example.demo.service.IWorksService;
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
 * <p> 业务controller
 * Date 2020/4/29
 */
@RequestMapping("/work")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WorksController {

    @Autowired
    private IWorksService worksService;

    @Autowired
    private UserService userService;

    /**
     * 获得列表
     * @param model
     * @return
     */
    @RequestMapping("/worklist")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getWorksList(Model model){
        List<Works> worksList = worksService.getWorksList();
        model.addAttribute("user",userService.getUser());
        model.addAttribute("worksList",worksList);
//        System.out.println(worksList.size());
        return new ModelAndView("/works/works");
    }

    /**
     * 获取详细信息
     * @param model
     * @param workId
     * @return
     */
    @RequestMapping("/workdetail")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getWorksDetail(Model model, Integer workId){
        model.addAttribute("user",userService.getUser());
        model.addAttribute("work",worksService.findWorkById(workId));
        return new ModelAndView("/works/worksDetail");
    }

    /**
     *
     * @param model
     * @param flag
     * @param works
     * @return
     */
    @RequestMapping("/addwork")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView addWorks(Model model, String flag, Works works){
        model.addAttribute("user",userService.getUser());
        works.setStatus(1);
        works.setCreateTime(new Date());
        works.setCreateBy(userService.getUser().getUsername());
        if (flag.equals("1")){
            return new ModelAndView("/works/addWorks");
        }else {
            worksService.addWork(works);
            return new ModelAndView("redirect:/work/worklist");
        }
    }

    /**
     * 修改
     * @param model
     * @param flag
     * @param works
     * @return
     */
    @RequestMapping("/modifiwork")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView modifiWorks(Model model, String flag, Works works){
        model.addAttribute("user",userService.getUser());
        works.setUpdateTime(new Date());
        works.setUpdateBy(userService.getUser().getUsername());
        if (flag.equals("1")){
            Works works1 = worksService.findWorkById(works.getWorkId());
            model.addAttribute("work",works1);
            return new ModelAndView("/works/modifiWorks");
        }else {
            worksService.modifiWork(works);
            return new ModelAndView("redirect:/work/worklist");
        }
    }

    /**
     * 删除
     * @param workId
     * @param model
     * @return
     */
    @RequestMapping("/deletework")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView removeWorks(Integer workId, Model model){
        model.addAttribute("user",userService.getUser());
        Works works = worksService.findWorkById(workId);
        works.setStatus(0);
        worksService.modifiWork(works);
        model.addAttribute("work",works);
        return new ModelAndView("/works/works");
    }
}
