package ru.grigan.spring.mvc_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.grigan.spring.mvc_hibernate_aop.entity.Employee;
import ru.grigan.spring.mvc_hibernate_aop.service.EmployeeService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("allEmps", employees);
        return "all-employees";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }
}
