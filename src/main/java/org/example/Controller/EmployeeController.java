package org.example.Controller;
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.example.model.Employee;
import org.example.service.EmployeeService;

@Controller
public class EmployeeController {
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home(Locale locale, Model model) {
//        System.out.println("Home Page Requested, locale = " + locale);
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//        String formattedDate = dateFormat.format(date);
//        model.addAttribute("serverTime", formattedDate);
//        return "index";
//    }
//
//    @RequestMapping(value = "/employee", method = RequestMethod.POST)
//    public String user(@Validated Employee user, Model model) {
//        System.out.println("User Page Requested");
//        model.addAttribute("userName", user.getUserName());
//        return "employee";


        private static final Logger logger = Logger
                .getLogger(EmployeeController.class);

    public EmployeeController() {
            System.out.println("EmployeeController()");
        }

        @Autowired
        private EmployeeService employeeService;

        @RequestMapping(value = "/")
        public ModelAndView listEmployee(ModelAndView model) throws IOException {
            List<Employee> listEmployee = employeeService.getAllEmployees();
            model.addObject("listEmployee", listEmployee);
            model.setViewName("home");
            return model;
        }

        @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
        public ModelAndView newContact(ModelAndView model) {
            Employee employee = new Employee();
            model.addObject("employee", employee);
            model.setViewName("EmployeeForm");
            return model;
        }

        @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
        public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
            if (employee.getId() == 0) { // if employee id is 0 then creating the
                // employee other updating the employee
                employeeService.addEmployee(employee);
            } else {
                employeeService.updateEmployee(employee);
            }
            return new ModelAndView("redirect:/");
        }

        @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
        public ModelAndView deleteEmployee(HttpServletRequest request) {
            int employeeId = Integer.parseInt(request.getParameter("id"));
            employeeService.deleteEmployee(employeeId);
            return new ModelAndView("redirect:/");
        }

        @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
        public ModelAndView editContact(HttpServletRequest request) {
            int employeeId = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeService.getEmployee(employeeId);
            ModelAndView model = new ModelAndView("EmployeeForm");
            model.addObject("employee", employee);

            return model;


    }
}
