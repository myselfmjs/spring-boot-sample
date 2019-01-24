package spring.boot.sample.sample.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.boot.sample.sample.entity.Employee;
import spring.boot.sample.sample.service.EmployeeService;

import java.util.List;

/**
 * Thymeleaf模版测试Controller
 */
@Controller
@RequestMapping("thyme")
public class ThymeLeafController{

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value ="name", method = RequestMethod.GET)
   public String thymeHtml(Model model){
       String name = "thymeleaf";
        List<Employee> list = employeeService.findAll();

       model.addAttribute("name",name);
       model.addAttribute("list",list);

       return "hello";
   }

}
