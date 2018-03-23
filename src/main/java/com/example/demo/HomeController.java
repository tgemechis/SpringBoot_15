package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("555-12-1234");

        Laptop lapTop = new Laptop();
        lapTop.setBrand("Dell");
        lapTop.setModel("Latitude XL");

        employee.setLaptop(lapTop);

        employeeRepository.save(employee);

        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

    }






