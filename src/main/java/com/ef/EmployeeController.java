package com.ef;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/hello")
	public String sayHello(ModelMap model) {
		model.addAttribute("msg", "Hello Developer Welcome to mvc");
		return "hello";
	}

	@RequestMapping("/signUpPage")
	public String redirectToViewPage1(Model model) {
		model.addAttribute("command", new Employee());
		return "viewPage1";
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String registerEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("Employee= " + employee.getId() + " and " + employee.getName());
		employeeDao.saveEmployee(employee);
		return "redirect:/viewEmployees";
	}

	@RequestMapping("/viewEmployees")
	public String viewEmployees(Model model) {
		List<Employee> employeelist = employeeDao.findAllEmployeesByResultSetExtractor();
		model.addAttribute("emplist", employeelist);
		return "viewEmployees";
	}

	@RequestMapping("/loginUpPage")
	public String redirectToViewPage2(ModelMap model) {
		return "viewPage2";
	}

	@RequestMapping("/viewRecordsPage")
	public String redirectToViewPage3(ModelMap model) {
		return "viewPage3";
	}

	@RequestMapping(value = "/editemp/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable int id, Model model) {
		System.out.println("testing= " + id);
		Employee myEmployee = employeeDao.getEmployeeById(id);
		model.addAttribute("command", myEmployee);
		return "employeeEditPage";
	}

	@RequestMapping(value = "/editEmployeeSave", method = RequestMethod.GET)
	public String editEmployeeSave(@ModelAttribute("employee") Employee employee) {
		employeeDao.updateEmployee(employee);
		return "redirect:/viewemp";// will redirect to viewemp request mapping
	}
}
